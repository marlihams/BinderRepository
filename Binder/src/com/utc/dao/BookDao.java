package com.utc.dao;
import java.util.List;

import com.utc.beans.Auteur;
import com.utc.beans.Book;
import com.utc.beans.Notes;
import com.utc.exceptions.DAOException;

public interface BookDao {
	Book create(Book book) throws DAOException;
	List<Book> findBookByIdOrNameOrISBNorAuthor(String action,String bookIdorNameorISBNorAuthor) throws DAOException;
	boolean delete(Book book) throws DAOException;
	boolean update (Book book) throws DAOException;
	public boolean update(Notes note)  throws DAOException;
	List<Notes> findLastNotes(int userId) throws DAOException;
	List<Book> takeAllBooks() throws DAOException;	
	List<Book> findBookLu(int userId)  throws DAOException ;
	
}
