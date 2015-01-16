package com.utc.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.utc.beans.Book;
import com.utc.beans.User;
import com.utc.dao.AuteurDao;
import com.utc.dao.BookDao;
import com.utc.dao.UserDao;
import com.utc.factory.DAOFactory;
import com.utc.forms.BookForm;
import com.utc.forms.InscriptionForm;

//@WebServlet("/userBook")
public class UserBook extends HttpServlet {
	public static final String EVALUATION= "evaluation";
		public static final String TITLE= "title";
		public static final String INSCRIPTION= "inscription";
		
		public static final String ATT_FORM= "form";
		public static final String ATT_BOOK= "book";
		public static final String ISBN= "isbn";
		public static final String ID= "Id";
		
		private static final String ATT_DAO_FACTORY = "daofactory";
		public static final String VIEW ="/WEB-INF/jsp/userBook.jsp";
		private static final long serialVersionUID = 1L;
		
	    private BookDao bookDao;
	    private AuteurDao auteurDao;
	
	     public void init() throws ServletException {
        this.bookDao = ( (DAOFactory) getServletContext().getAttribute( ATT_DAO_FACTORY) ).getBookDao();
        this.auteurDao = ( (DAOFactory) getServletContext().getAttribute( ATT_DAO_FACTORY) ).getAuteurDao();
    }
		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			BookForm form = new BookForm(bookDao);
		 	Book book = form.fillUserBook(request); // when we want to add a book , book does not have any value for their attribute
		 	request.setAttribute(ATT_BOOK,book);
		 	
			this.getServletContext().getRequestDispatcher(VIEW).forward(request, response);
			
		}
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		
			
						BookForm form=new BookForm(bookDao);
			Book book=form.handleAddBook(request);
			request.setAttribute(ATT_FORM, form);
			request.setAttribute(ATT_BOOK,book);
			
	
	//	else{
//			
//			
//			if (request.getParameter(TITLE) != null) action="title";
//			else if (request.getParameter(ISBN) != null) action="ISBN";
//			else if (request.getParameter(ID) != null) action="id";
//			else action="author";		
//		request.setAttribute(RESULTAT_RECHERCHE,bookDao.findBookByIdOrNameOrISBNorAuthor(action,request.getParameter(action)));
//			
			
//		}
		
		this.getServletContext().getRequestDispatcher(VIEW).forward(request, response);
		
}
}
