package com.utc.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.utc.beans.User;
import com.utc.dao.UserDao;
import com.utc.factory.DAOFactory;
import com.utc.forms.InscriptionForm;

@WebServlet("/futureUser")
public class FutureUser extends HttpServlet {
	public static final String CONF_DAO_FACTORY = "daofactory";
	public static final String ATT_USER = "user";
	public static final String ATT_FORM = "form";
	public static final String VIEW = "/admin/futureUser.jsp";
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
		InscriptionForm form=new InscriptionForm(userDao);
		User user =form.infoNewUser(request);
		request.setAttribute(ATT_USER, user);
		
		this.getServletContext().getRequestDispatcher(VIEW).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		InscriptionForm form = new InscriptionForm(userDao);
 	User newUser = form.inscriptionUser(request);
		request.setAttribute(ATT_FORM, form);
		request.setAttribute(ATT_USER, newUser);
		System.out.println("direction view");
		this.getServletContext().getRequestDispatcher(VIEW).forward(request, response);
	}

}
