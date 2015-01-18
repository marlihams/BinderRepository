package com.utc.servlets;

import com.utc.factory.*;
import com.utc.forms.BookForm;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.utc.beans.Book;
import com.utc.dao.BookDao;
import com.utc.dao.UserDao;

@WebServlet("/userProfile")
public class UserProfile extends  HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	public static String ACTION="action";
	public static final String RESULTAT_RECHERCHE= "recherche";
	public static final String FORM="form";
	public static final String USER_ID= "userId";
	public static final String BOOK_Lu="bookLu";
	public static final String EVALUATION="evaluation";
	private static final String ATT_DAO_FACTORY = "daofactory";
	public static final String VIEW = "/WEB-INF/jsp/userProfile.jsp";
    private BookDao bookDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public void init() throws ServletException {
        ( (DAOFactory) getServletContext().getAttribute(ATT_DAO_FACTORY)).getUserDao();
        this.bookDao = ( (DAOFactory) getServletContext().getAttribute( ATT_DAO_FACTORY) ).getBookDao();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookForm form = new BookForm(bookDao);
		
		if (request.getParameter(ACTION)!=null){
			
			List<Book> books =form.lookForBook(request);
		 	responseToAjax(response,books);
		}
		else{
			displayUserProfile(request);
			this.getServletContext().getRequestDispatcher(VIEW).forward(request, response);
	}
	}

	private void responseToAjax(HttpServletResponse response, List<Book> books) throws IOException { //violation du mvc mais bon on verra  ca après
        	 
		// On construit le tableau JSON des résultat
	        String arrayBuilder="" ;
	        
	      if (!books.isEmpty()){
        for(int i=0,taille= books.size(); i<taille;i++) {
        	String chaine="";
        	
            // On construit la chaine sous la forme "title;isbn;genre;auteur"
          
            chaine+=books.get(i).getTitle()+";";
            chaine+=books.get(i).getISBN() +";";
            chaine+=books.get(i).getAuteur()+";";
            chaine+=books.get(i).getGenre();
            arrayBuilder+=chaine;
            arrayBuilder+=(i==taille-1)?"":",";
            
        }
      
	      }
	      else{
	    	  arrayBuilder ="false";
	      }
     
         response.setContentType("application/text; charset=UTF-8");
		
//	      response.setContentType("application/plain");  
//	      response.setCharacterEncoding("UTF-8"); 
	      response.getWriter().write(arrayBuilder);
	   //  out.close();
	     //out.flush();
	     
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//traite les données ensuite appel
			
			BookForm form = new BookForm(bookDao);
			form.upgradeBook(request);  // function for deleting the book read or changing the valued book or displaying the search
			displayUserProfile(request); 
		this.getServletContext().getRequestDispatcher(VIEW).forward(request, response);
	}
	
	protected void  displayUserProfile(HttpServletRequest request) {
		HttpSession session = request.getSession();
		int  userId=(int) session.getAttribute(USER_ID);
		// add list of the read books 
		request.setAttribute(BOOK_Lu,bookDao.findBookLu(userId));
		// add list of the evaluate  books 
		request.setAttribute(EVALUATION,bookDao.findLastNotes(userId));
		
	}
	
}
