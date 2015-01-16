package com.utc.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.utc.factory.DAOFactory;

public class InitializeDAOFactory implements ServletContextListener {
	private static final String ATT_DAO_FACTORY = "daofactory";
	private DAOFactory daoFactory;
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		// TODO Auto-generated method stub
	
		ServletContext servletContext = event.getServletContext();
		this.daoFactory = DAOFactory.getInstance();
		servletContext.setAttribute(ATT_DAO_FACTORY, this.daoFactory);
	}
	
}
