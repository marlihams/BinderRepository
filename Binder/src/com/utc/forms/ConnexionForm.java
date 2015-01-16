package com.utc.forms;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import com.utc.beans.Roles;
import com.utc.beans.User;
import com.utc.dao.UserDao;
import com.utc.exceptions.DAOException;

public class ConnexionForm {
	private static final String FIELD_EMAIL = "email";
	private static final String FIELD_PASSWORD = "password";
	private UserDao userDao;
	private String result;
	private Map<String, String> errors = new HashMap<String,String>();
	
	public ConnexionForm(UserDao userDao) {
		this.userDao = userDao;
	}
	public String getResult() {
		return result;
	}
	public Map<String, String> getErrors() {
		return errors;
	}
	
	public User  connexionUser(HttpServletRequest request){
		String email = getFieldValue(request, FIELD_EMAIL);
		String password = getFieldValue(request, FIELD_PASSWORD);
		Boolean validate = false;
		
		User user = this.userDao.findUserRoles(email);
		System.out.println(email);
		try{
			validationEmail(email,user.getEmail());
		}
			catch ( Exception e) {
			setError(FIELD_EMAIL, e.getMessage());
		}
		try{
			validationPassword(password,user.getPassword());
		}
			catch ( Exception e) {
			setError(FIELD_PASSWORD, e.getMessage());
		}
		return user ;
	}
		private void validationEmail( String email,String rightEmail ) throws Exception {
		        if ( !email.equals(rightEmail) ) {
		            throw new Exception( "wrong email." );
		        }
		}

		private void validationPassword( String motDePasse, String truePassword ) throws Exception {
		  
		        if ( !motDePasse.equals(truePassword ) ) {
		            throw new Exception( "wrong password" );
		            
		        }
		}
	
	private Boolean validateChamp( String email, String password ) throws Exception {
	    if ( email == null || password == null){
	    	throw new Exception( "Please enter an email and a password" );
	    }else{
	    	return true;
	    	
	    }
	}


	private void setError( String field, String message ) {
	    errors.put( field, message );
	}

	
	private static String getFieldValue( HttpServletRequest request, String nameField ) {
	    String value = request.getParameter( nameField );
	    if ( value == null || value.trim().length() == 0 ) {
	        return null;
	    } else {
	        return value.trim();
	    }
	}
	
	public boolean checkUserRole (User user){
		
		Set<Roles> roles=user.getRoles();
		boolean admin=false;
		Iterator<Roles> it =roles.iterator();
	    while(it.hasNext()){
	    	if (it.next().getRole().equals("admin")){
	    		admin=true;
	    	}
	    }
	      	
		return admin;
	}
}
