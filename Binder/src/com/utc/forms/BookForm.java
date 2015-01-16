package com.utc.forms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utc.beans.Book;
import com.utc.beans.Notes;
import com.utc.dao.*;
import com.utc.exceptions.DAOException;

public class BookForm {
	public static String ADD_BOOK="addbook";
	public static String FIELD_TITLE="title";
	public static String FIELD_AUTHOR="author";
	public static String FIELD_GENRE="genre";
	public static String FIELD_ISBN="isbn";
	public static String FIELD_QWRITING="qWriting";
	public static String FIELD_ISUBJECT="iSubject";
	public static String FIELD_DEND="dEnd";
	public static String FIELD_DAUTEUR="dAuteur";
	public static String FIELD_RECOMMEND="recommend";
	public static String FIELD_COMPLETED="completed";
	public static String ACTION="action";
	
	public static final String EVALUATION= "evaluation";
	
	private BookDao bookDao;

	public BookForm(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	private String result;
	private Map<String, String> errors = new HashMap<String, String>();

	public String getResult() {
		return result;
	}

	public Map<String, String> getErrors() {
		return errors;
	}

	
	private Book manageBook(HttpServletRequest request,Book book) {
		String title = getFieldValue(request,FIELD_TITLE);
		String genre  = getFieldValue(request,FIELD_GENRE );
		String  author= getFieldValue(request,FIELD_AUTHOR );
		
			try {
				validateChamp(title);
				book.setTitle(title);
			} catch (Exception e) {
				setError(FIELD_TITLE,FIELD_TITLE + e.getMessage());
			}
			
			try {
				validateChamp(genre);
				book.setGenre(genre);
				
			} catch (Exception e) {
				setError(FIELD_GENRE,FIELD_GENRE + e.getMessage());
			}
		
			try {
				validateChamp(author);
				book.setAuteur(author);		
			} catch (Exception e) {
				setError(FIELD_AUTHOR,FIELD_AUTHOR + e.getMessage());
			}
			
		System.out.println("manageBook");
			return book;
	}
	
	private void   addBook(HttpServletRequest request,Book book) {
		String  isbn = getFieldValue(request,FIELD_ISBN );
		manageBook(request,book);
		try{
			manageISBN(isbn);
			book.setISBN(isbn);
		}catch(Exception e ){
			setError(FIELD_ISBN,e.getMessage());
			
		}
			try{
				
			if (errors.isEmpty()){
			 book=bookDao.create(book);
			
				result = "adding successfull.";
			} else {
				result = "adding failure.";
		
			}
		}catch (DAOException e) {
			result = "adding failure : an error has occured. Please try again in a few seconds.";
			e.printStackTrace();
		}
		
	}
	private void manageISBN(String isbn) throws Exception {
		if(isbn!=null){
			try{
			 	validateISBN(isbn);
				}
			catch (Exception e){
				throw e;
			}
			} 
		else{
			try {
				validateChamp(isbn);
			} catch (Exception e) {
				
				setError(FIELD_ISBN,FIELD_ISBN + e.getMessage());
				throw e;
			}
			
		}
	}

	private void validateISBN(String isbn) throws Exception {
		String action="ISBN";
			 if (!bookDao.findBookByIdOrNameOrISBNorAuthor(action,isbn).isEmpty()) {
				throw new Exception("This isbn has been used before so go the userProfile and look for it  ");
			}
	}

	private void validateChamp(String champ) throws Exception {
		String error="  of the Book cant not be empty";
		
			if (champ==null){
				throw new Exception(error);
		}
	}

	private void setError(String field, String message) {
		errors.put(field, message);
	}

	private static String getFieldValue(HttpServletRequest request,String nameField) {
		String value = request.getParameter(nameField);
		if (value == null || value.trim().length() == 0) {
			return null;
		} else {
			return value.trim();
		}
	}
	
	private void deleteBook(HttpServletRequest request){
		
		String  isbn = getFieldValue(request,FIELD_ISBN );
		Book book=new Book();
		book.setISBN(isbn);
		
		try{
			
		if (errors.isEmpty()) {
			
			bookDao.delete(book);
			
		
			result = "adding successfull.";
		} else {
			System.out.println("Pas d'erreur");
			result = "adding failure.";
	
		}
	}catch (DAOException e) {
		result = "adding failure : an error has occured. Please try again in a few seconds.";
		e.printStackTrace();
	}
		
	}

	private  void  fillBean(HttpServletRequest request,Book book) {
		String  isbn = getFieldValue(request,FIELD_ISBN );
		String title=getFieldValue(request,FIELD_TITLE);
		String author=getFieldValue(request,FIELD_AUTHOR );
		
		book.setISBN(isbn);
		book.setAuteur(author);
		book.setTitle(title);
	}

	private  void  fillNote(HttpServletRequest request,Notes note) {
		String  isbn = getFieldValue(request,FIELD_ISBN );
		String title=getFieldValue(request,FIELD_TITLE);
		String author=getFieldValue(request,FIELD_AUTHOR );
		  int qWriting=Integer.parseInt(getFieldValue(request,FIELD_QWRITING) );
		  int  iSubject=Integer.parseInt(getFieldValue(request,FIELD_ISUBJECT));
		 int  dEnd=Integer.parseInt(getFieldValue(request,FIELD_DEND));
		 int  dAuteur=Integer.parseInt(getFieldValue(request,FIELD_DAUTEUR));
		 int recommend=Integer.parseInt(getFieldValue(request,FIELD_RECOMMEND));
		 int completed=Integer.parseInt(getFieldValue(request,FIELD_COMPLETED));
		 
	
		 
		note.setIsbn(isbn);
		note.setAuteur(author);
		note.setBooktitle(title);
		note.setdAuteur(dAuteur);		
		note.setRecommend(recommend);
		note.setiSubject(iSubject);
		note.setdEnd(dEnd);
		note.setqWriting(qWriting);
		note.setCompleted(completed);
	}
	
	public Book fillUserBook(HttpServletRequest request) {
		Book book=new Book();
		if (request.getParameter(EVALUATION)!=null){
			fillBean(request,book);
			request.setAttribute(EVALUATION,true);
			
		}
		return book;
	}

	
	
public Book handleAddBook (HttpServletRequest request){
	
	Book book=new Book();
//	if(request.getParameter(ADD_BOOK)!=null){
	// the user want to add a book so we do it 
		 addBook(request,book);
//	}
	
	return book;
	
}
public void  upgradeBook (HttpServletRequest request) {

	if (request.getParameter(FIELD_ISUBJECT)==null){
		deleteBook(request);
	}
	else{
		
		evaluate(request);
	}				 
}
private void evaluate(HttpServletRequest request){
	
	Notes note=new Notes();
	fillNote(request,note);


  try{
		
	bookDao.update(note);
		
	}catch (DAOException e) {
		result = "failure while updating the note";
		System.out.println(result);
		e.printStackTrace();
	}
}

public List<Book> lookForBook(HttpServletRequest request) {
	
	List<Book> books= new ArrayList<Book>();
	
		String champ=getFieldValue(request,ACTION);
	 books=bookDao.findBookByIdOrNameOrISBNorAuthor(champ,getFieldValue(request,champ));
	
	return books ;
}

}
