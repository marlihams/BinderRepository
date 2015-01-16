package com.utc.daoImpl;

import static com.utc.daoImpl.DAOUtility.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.utc.beans.Auteur;
import com.utc.beans.Book;
import com.utc.beans.Notes;
import com.utc.beans.User;
import com.utc.dao.AuteurDao;
import com.utc.dao.BookDao;
import com.utc.exceptions.DAOException;
import com.utc.factory.DAOFactory;
public class BookDaoImpl implements BookDao {
	
	private static final String SQL_SELECT_BY_ISBN = "SELECT b.bookId,b.isbn, b.title,b.genre,a.name FROM projetJEE.book b,projetJEE.auteur a where b.isbn=? and a.auteurId=b.fkauteur;";
	private static final String SQL_SELECT_BY_TITLE = "SELECT b.bookId,b.isbn, b.title,b.genre,a.name FROM projetJEE.book b,projetJEE.auteur a where b.title=? and a.auteurId=b.fkauteur;";
	private static final String SQL_SELECT_BY_ID ="SELECT bookId,isbn, title,genre FROM projetJEE.book b,projetJEE.auteur a where b.bookId=? and a.auteurId=b.fkauteur;";
	private static final String SQL_INSERT = "INSERT INTO projetJEE.book (`isbn`, `title`, `fkauteur`, `genre`) VALUES (?,?, ?, ?);";
	private static final String SQL_DELETE_BY_ISBN="DELETE FROM bookLu USING book INNER JOIN bookLu ON book.bookId = bookLu.fkbookId  WHERE book.isbn=?;";
	private static final String SQL_UPDATE="update  projetJEE.book  set isbn=? ,title=?, genre=? where `bookId`=?;";
	private static final String SQL_SELECT_ALL = "SELECT bookId,isbn, title,genre FROM projetJEE.book;";
	private static final String SQL_SELECT_ALL_BY_AUTEUR = "SELECT b.bookId,b.isbn, b.title,b.genre,a.name FROM projetJEE.book b,projetJEE.auteur a where a.name=? and a.auteurId=b.fkauteur;";
	private static final String SQL_SELECT_BOOK_LU="select b.bookId, b.title,b.genre,b.isbn,a.name from projetJEE.user u, projetJEE.book b, projetJEE.bookLu bl , auteur a where bl.fkuserId=? and bl.fkuserId=u.userId  and bl.fkbookId=b.bookId and b.fkauteur=a.auteurId;"; 
	private static final String SQL_BOOK_NOTE="select b.title,b.isbn, a.name, n.qlwriting,n.intsubject,n.dend,n.dauteur,n.recommend,n.completed from user u,book b, notes n,auteur a where n.fkuserId=? and n.fkuserId=u.userId  and n.fkbookId=b.bookId and b.fkauteur=a.auteurId;";
	private static final String SQL_UPDATE_BOOK_NOTE="update  projetJEE.notes n,projetJEE.book b set n.qlwriting=? ,n.intsubject=?, n.dend=? ,n.dauteur=? ,n.recommend=? ,n.completed=? where n.fkBookId=b.bookId and b.isbn=?;";
	private DAOFactory daoFactory;
	
	public BookDaoImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}
	
	@Override
	public Book create(Book book) throws DAOException {
		// add a new book
		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet autogeneratedResultSet = null;
		AuteurDao auteurDAO =daoFactory.getAuteurDao();
		Auteur auteur =null;
		auteur=auteurDAO.findAuteurByIdOrAuteurName("name", book.getAuteur());
		if (auteur==null){
			auteur=new Auteur();
			auteur.setName(book.getAuteur());
			auteur=auteurDAO.create(auteur);
		}
		try {
			connexion = daoFactory.getConnection();
			
			preparedStatement =initializePreparedStatement (connexion,
					SQL_INSERT, true,book.getISBN(), book.getTitle(),auteur.getAuteurId(),
					book.getGenre());
			int status = preparedStatement.executeUpdate();
			if (status == 0) {
				throw new DAOException(
						"Database insertion failure. No line inserted.");
			}
			autogeneratedResultSet = preparedStatement.getGeneratedKeys();
			if (autogeneratedResultSet.next()) {
				book.setBookId(autogeneratedResultSet.getLong(1));
			} else {
				throw new DAOException(
						"Database insertion failure. No auto generated id returned.");
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			silentCloses(preparedStatement, connexion, autogeneratedResultSet);
		}
		System.out.println("your book is added ");
		return book;
	}

	

	@Override
	public List<Book> findBookByIdOrNameOrISBNorAuthor(String action,String bookIdorNameorISBNorAuthor)throws DAOException{
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	Book book = null;
	String requete=null;
	List<Book> books= new LinkedList<Book>();
	boolean bool=false;
		switch (action){
		
		case "id":
			requete=SQL_SELECT_BY_ID  ;
			bool=true;
			
			break;
		case "isbn":
			requete=SQL_SELECT_BY_ISBN ;
			break;
		case "title":
			requete=SQL_SELECT_BY_TITLE  ;
			break;
		default:
			requete= SQL_SELECT_ALL_BY_AUTEUR  ;
			break;
	}
		
		
		try {
			connection = daoFactory.getConnection();
			preparedStatement = initializePreparedStatement(connection,
					 requete, false,bool?Integer.parseInt(bookIdorNameorISBNorAuthor):bookIdorNameorISBNorAuthor);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				
				book = mapBook(resultSet);
			
				books.add(book);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			silentCloses(preparedStatement, connection, resultSet);
		}
 
		return books;
	}

	@Override
	public boolean delete(Book book) throws DAOException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
	boolean succes=false;
		
		try {
			connection = daoFactory.getConnection();
			preparedStatement = initializePreparedStatement(connection,
					SQL_DELETE_BY_ISBN,false,book.getISBN());
			int status = preparedStatement.executeUpdate();
		
				if (status == 0) {
					throw new DAOException(
							"Database delete book failed . No line modified .");
				}
				else{
					succes=true;
				}
		} catch (SQLException e) {
				throw new DAOException(e);
		} 
		finally {
			silentCloses(preparedStatement, connection);
		}
	
		return succes;
	}

	@Override
	public boolean update(Book book) throws DAOException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
	boolean succes=false;
		
		try {
			connection = daoFactory.getConnection();
			preparedStatement = initializePreparedStatement(connection,
					SQL_UPDATE,false,book.getISBN(),book.getTitle(),book.getGenre(),book.getBookId());
			int status = preparedStatement.executeUpdate();
				if (status == 0) {
					throw new DAOException(
							"Database update book failed . No line modified .");
				}
				else{
					succes=true;
				}
		} catch (SQLException e) {
				throw new DAOException(e);
		} 
		finally {
			silentCloses(preparedStatement, connection);
		}
	
		return succes;
		
	}
	public boolean update(Notes note) throws DAOException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
	boolean succes=false;

		try {
			connection = daoFactory.getConnection();
			preparedStatement = initializePreparedStatement(connection,
					SQL_UPDATE_BOOK_NOTE,false,note.getqWriting(),note.getiSubject(),note.getdEnd(),note.getdAuteur(),note.getRecommend(),note.getCompleted(),note.getIsbn());
			int status = preparedStatement.executeUpdate();
				if (status == 0) {
					throw new DAOException(
							"Database update book failed . No line modified .");
				}
				else{
					succes=true;
				}
		} catch (SQLException e) {
				throw new DAOException(e);
		} 
		finally {
			silentCloses(preparedStatement, connection);
		}
	
		return succes;
	}


	@Override
	public List<Book> takeAllBooks() throws DAOException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Book book= null;
		List<Book> books= new LinkedList<Book>();
		try {
			connection = daoFactory.getConnection();
			preparedStatement = initializePreparedStatement(connection,
					 SQL_SELECT_ALL, false);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				book = mapBook(resultSet);
				books.add(book);
			}
		} catch (SQLException e){
			throw new DAOException(e);
		} finally {
			silentCloses(preparedStatement, connection, resultSet);
		}

		return books;
	}
	
	
	@Override
	public List<Book> findBookLu(int userId) throws DAOException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Book book= null;
		List<Book> books= new LinkedList<Book>();
		try {
			connection = daoFactory.getConnection();
			preparedStatement = initializePreparedStatement(connection,
					 SQL_SELECT_BOOK_LU, false,userId);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				book = mapBook(resultSet);
				
				books.add(book);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			silentCloses(preparedStatement, connection, resultSet);
		}

		return books;
	}



	@Override
	public List<Notes> findLastNotes(int userId) throws DAOException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Notes note= null;
		List<Notes> notes= new LinkedList<Notes>();
		try {
			connection = daoFactory.getConnection();
			preparedStatement = initializePreparedStatement(connection,
					SQL_BOOK_NOTE , false,userId);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				note = mapNote(resultSet);
				notes.add(note);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			silentCloses(preparedStatement, connection, resultSet);
		}
		return notes;
	}
	public static Book mapBook(ResultSet resultSet) throws SQLException {
		Book book = new Book();
		book.setBookId(resultSet.getLong("bookId"));
		book.setISBN(resultSet.getString("isbn"));
		book.setTitle(resultSet.getString("title"));
		book.setGenre(resultSet.getString("genre"));
		book.setAuteur(resultSet.getString("name"));
		
		return book;
	}
	public static Notes mapNote(ResultSet resultSet) throws SQLException {
		Notes note = new Notes();

		note.setBooktitle(resultSet.getString("title"));
		note.setAuteur(resultSet.getString("name"));
		note.setIsbn(resultSet.getString("isbn"));
		
		note.setqWriting(resultSet.getInt("qlwriting"));
		note.setiSubject(resultSet.getInt("intsubject"));
		note.setdEnd(resultSet.getInt("dend"));
		note.setdAuteur(resultSet.getInt("dauteur"));
		note.setRecommend(resultSet.getInt("recommend"));
		note.setCompleted(resultSet.getInt("completed"));
		
		return note;
		
	}


	

}
