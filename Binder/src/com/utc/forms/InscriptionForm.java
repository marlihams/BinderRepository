package com.utc.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.jasypt.util.password.ConfigurablePasswordEncryptor;

import com.sun.jmx.snmp.Timestamp;
import com.utc.beans.User;
import com.utc.exceptions.DAOException;
import com.utc.dao.UserDao;
import com.utc.daoImpl.AppConfigDAO;

public class InscriptionForm {
	private static final String FIELD_EMAIL = "email";
	private static final String FIELD_PASSWORD = "password";
	private static final String FIELD_CONFIRMATION = "confirmation";
	private static final String FIELD_USERNAME = "username";
	private static final String FIELD_USER_ID = "userId";
	private static final String FIELD_ADDRESS = "addresse";
	private static final String FIELD_PHONE = "phone";
	private static final String FIELD_STATUS = "status";
	private static final String ADD = "add";
	private static final String ENCRYPTING_ALGO ="SHA-256";

	private UserDao userDao;

	public InscriptionForm(UserDao userDao) {
		this.userDao = userDao;
	}

	private String result;
	private Map<String, String> errors = new HashMap<String, String>();

	public String getResult() {
		return result;
	}

	public Map<String, String> getErrors() {
		return errors;
	}

	public User inscriptionUser(HttpServletRequest request) {
		String email = getFieldValue(request, FIELD_EMAIL);
		String password = getFieldValue(request, FIELD_PASSWORD);
		String confirmation = getFieldValue(request, FIELD_CONFIRMATION);
		String username = getFieldValue(request, FIELD_USERNAME);
		String addresse = getFieldValue(request, FIELD_ADDRESS);
		String phone = getFieldValue(request, FIELD_PHONE);

		User newUser = new User();
		try {
			manageEmail(email, newUser);
			managePassword(password, confirmation, newUser);
			manageUsername(username, newUser);
			
			try {
				validateAddress(addresse);
			} catch (Exception e) {
				setError(FIELD_ADDRESS, e.getMessage());
			}
			newUser.setAddresse(addresse);
			try {
				validatePhone(phone);
			} catch (Exception e) {
				setError(FIELD_PHONE, e.getMessage());
			}
			newUser.setTelephone(phone);
		
			newUser.setStatus("active");
			if (errors.isEmpty()) {
				userDao.create(newUser,true);
				result = "Inscription successfull.";
			} else {
				result = "Inscription failure.";
			}
		} catch (DAOException e) {
			result = "Inscription failure : an error has occured. Please try again in a few seconds.";
			e.printStackTrace();
		}
		return newUser;
	}
	private void manageEmail(String email, User user){
		try {
			validateEmail(email);
		} catch (Exception e) {
			setError(FIELD_EMAIL, e.getMessage());
		}
		user.setEmail(email);
	}
	
	private void managePassword(String password, String confirmation, User user){
		try {
			validatePassword(password, confirmation);
		} catch (Exception e) {
			setError(FIELD_PASSWORD, e.getMessage());
			setError(FIELD_CONFIRMATION, null);
		}
		
//		ConfigurablePasswordEncryptor passwordEncryptor = new ConfigurablePasswordEncryptor();
//		passwordEncryptor.setAlgorithm( ENCRYPTING_ALGO );
//		passwordEncryptor.setPlainDigest( false );
//		String encryptedPassword = passwordEncryptor.encryptPassword( password );
		
//		user.setPassword(encryptedPassword);
	}
	private void manageUsername(String username, User user){
		try {
			validateUsername(username);
		} catch (Exception e) {
			setError(FIELD_USERNAME, e.getMessage());
		}
		user.setUsername(username);
	}
	private void validateEmail(String email) throws Exception {
		if (email != null) {
			if (!email.matches("^[a-z0-9._-]+@[a-z0-9._-]{2,}\\.[a-z]{2,4}$")) {
				throw new Exception("Please enter a valid email");
			} else if (userDao.checkEmail(email)) {
				throw new Exception("This email is already in use.");
			}
		} else {
			throw new Exception("Please fill email field.");
		}
		System.out.println(email);
	}
	

	private void validatePassword(String password, String confirmation)
			throws Exception {
		if (password != null && confirmation != null) {
			if (!password.equals(confirmation)) {
				throw new Exception("Passwords are different. Please retry.");
			} else if (password.length() < 6) {
				throw new Exception(
						"Password must at least contain 6 characters");
			}
		} else {
			throw new Exception("Please fill password and confirmation field");
		}
	}

	private void validateUsername(String username) throws Exception {
		if (username == null) {
			throw new Exception("Please fill username field.");
		} else if (username.length() < 3) {
			throw new Exception(
					"Username should contain at least 3 characters.");
		}
	}


	private void validateAddress(String addresse) throws Exception {
		if (addresse == null) {
			throw new Exception("Please fill addresse field.");
		}
	}

	private void validatePhone(String phone) throws Exception {
		if (phone == null) {
			throw new Exception("Please fill phone field.");
		}
	}

	private void setError(String field, String message) {
		errors.put(field, message);
	}

	private static String getFieldValue(HttpServletRequest request,
			String nameField) {
		String value = request.getParameter(nameField);
		if (value == null || value.trim().length() == 0) {
			return null;
		} else {
			return value.trim();
		}
	}

	public User infoNewUser(HttpServletRequest request) {
		
		String email =getFieldValue(request ,FIELD_EMAIL);
		return  userDao.findByEmail(email,false);
		 
	}

	public void acceptOrRejectUser(HttpServletRequest request) {
		String email = getFieldValue(request, FIELD_EMAIL);
		String username = getFieldValue(request, FIELD_USERNAME);
		String addresse = getFieldValue(request, FIELD_ADDRESS);
		String phone = getFieldValue(request, FIELD_PHONE);
		String status = getFieldValue(request, FIELD_STATUS);
		
		if (request.getParameter(ADD)!=null){
			User user =userDao.findByEmail(email,false);
		user.setAddresse(addresse);
		user.setUsername(username);
		user.setTelephone(phone);
		user.setStatus(status);
		// encoder le mot de passe et l'inscrire 
		String password=user.getPassword();
		System.out.println("your password is before encoding "+password);
		 String encription=encryptPassword(password);
		 user.setPassword(encription);
		System.out.println("your password is after encoding"+user.getPassword());
		
			userDao.create(user,true);
	
			// envoi du mail
			//sendEmail(user,password);
		}
		
		userDao.deleteUser(email,false); // suppression de user dans la table inscription
	}
	private boolean sendEmail(User user,String password) {
		
		boolean success=false;
		AppConfigDAO appconfig=new AppConfigDAO();
		MailSendingManager mailMan=new MailSendingManager();
		String subject="Your count is ready";
		String message="<p>welcome on board Mr/Ms"+ user.getUsername()+"!!!! you count has been created.<p> your login is<strong> "+user.getEmail()+"</strong> and your  password is <strong> "+password+"</strong> go to the <a href='http://localhost.utc.fr:8080/Binder/connexion'>Lets read together </a></p>";
		System.out.println(message);
		try{
			mailMan.sendMail("mohamedmadioud@gmail.com",subject,message);
			success=true;
		}
		catch(Exception e){
			System.out.println("l'envoi du mail a échoué  consulte la fonction sendEmail de la classe InscriptionForm");
			e.printStackTrace();
			
		}
		return success;
	}
		
	public static String encryptPassword(String password){
		 ConfigurablePasswordEncryptor passwordEncryptor = new ConfigurablePasswordEncryptor();
		    passwordEncryptor.setAlgorithm(ENCRYPTING_ALGO );
		    passwordEncryptor.setPlainDigest( false );
		    password= passwordEncryptor.encryptPassword(password);
		   return password;
	}

}