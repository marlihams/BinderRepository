package com.utc.servlets;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.utc.beans.User;
import com.utc.dao.UserDao;
import com.utc.forms.ConnexionForm;
import com.utc.factory.*;


//@WebServlet("/connexion")
public class Connexion extends HttpServlet {
	public static final String ATT_FORM = "form";
	public static final String EMAIL = "email";
	public static final String ADMIN= "admin";
	public static final String USER_ID = "userId";
	public static final String USERNAME = "username";
	public static final String VIEW = "/WEB-INF/jsp/index.jsp";
	private static final String ATT_DAO_FACTORY = "daofactory";

	private static final long serialVersionUID = 1L;
    private UserDao userDao;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public void init() throws ServletException {
        /* Récupération d'une instance de notre DAO Utilisateur */
        this.userDao = ((DAOFactory) getServletContext().getAttribute(ATT_DAO_FACTORY)).getUserDao();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 
			this.getServletContext().getRequestDispatcher(VIEW).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 
		
		HttpSession session = request.getSession();
		
		ConnexionForm form = new ConnexionForm(userDao);
		User user= form.connexionUser(request);
		boolean admin=form.checkUserRole(user);
		System.out.println("mon boolean vaut  "+  admin);
		if (form.getErrors().isEmpty()){
			int userId= user.getUserId().intValue();
			session.setAttribute(USER_ID,userId);
			session.setAttribute(USERNAME,user.getUsername());
			session.setAttribute(EMAIL,user.getEmail());
			session.setAttribute(ADMIN,admin);
		}
		
		request.setAttribute(ATT_FORM, form);
		this.getServletContext().getRequestDispatcher(VIEW).forward(request, response);
	}
}
