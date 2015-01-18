package com.utc.servlets;



import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utc.beans.User;
import com.utc.dao.UserDao;
import com.utc.factory.DAOFactory;
import com.utc.forms.ConnexionForm;
import com.utc.forms.InscriptionForm;

@WebServlet("/userList")
public class UserList extends HttpServlet {
	public static final String CONF_DAO_FACTORY = "daofactory";
	public static final String ATT_USER = "user";
	public static final String FUTURE_USER = "futureUser";
	public static final String ATT_FORM = "form";
	public static final String VIEW = "/admin/usersList.jsp";
	private static final long serialVersionUID = 1L;
     
	private UserDao userDao;
    
	/**
     * @see HttpServlet#HttpServlet()
     */
   
    public void init() throws ServletException {
    	this.userDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getUserDao();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		handlerFutureUser(request);
		
		
		this.getServletContext().getRequestDispatcher(VIEW).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		InscriptionForm form = new InscriptionForm(userDao);
		 form.acceptOrRejectUser(request);
		 handlerFutureUser(request);
		this.getServletContext().getRequestDispatcher(VIEW).forward(request, response);
	}
	
	private void handlerFutureUser(HttpServletRequest request) {
		
		ConnexionForm form=new ConnexionForm(userDao);
		 List<User> users=form.getFutureUser(request);
		 request.setAttribute(FUTURE_USER,users);
	}

}
