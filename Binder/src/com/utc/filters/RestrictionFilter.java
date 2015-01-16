package com.utc.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class RestrictionFilter
 */
@WebFilter("/RestrictionFilter")
public class RestrictionFilter implements Filter {
	public static final String ACCES_CONNEXION  = "/index.jsp";
    public static final String ATT_SESSION_USER = "id_user";

    /**
     * Default constructor. 
     */
    public RestrictionFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		  /* Non-filtrage des ressources statiques */
        String chemin = request.getRequestURI().substring( request.getContextPath().length() );
       if ( chemin.startsWith("/css")|| chemin.startsWith("/js")||chemin.startsWith("/fonts") ||chemin.startsWith("/images") ) {
            chain.doFilter( request, response );
            return;
        }
       /* Récupération de la session depuis la requête */
   		HttpSession session = request.getSession();
   		
   		/**
         * Si l'objet utilisateur n'existe pas dans la session en cours, alors
         * l'utilisateur n'est pas connecté.
         */
		if(session.getAttribute(ATT_SESSION_USER)==null){
			/* Redirection vers la page publique */
            request.getRequestDispatcher( ACCES_CONNEXION ).forward( request, response );
		} else {
		// pass the request along the filter chain
		chain.doFilter(request, response);
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
