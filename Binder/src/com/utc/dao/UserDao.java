package com.utc.dao;


import java.util.*;
import com.utc.beans.User;
import com.utc.exceptions.*;

public interface UserDao {
	void create(User user) throws DAOException;
	User findByEmail(String email) throws DAOException;
	boolean  checkEmail(String email) throws DAOException;
	User findByUsername(String username) throws DAOException;
	User findByID(int  id) throws DAOException;
	List<User> findAllUsers() throws DAOException;
	boolean deleteUser(int id) throws DAOException;
	boolean desactiveUser(int userId) throws DAOException;
	boolean HandleRoleUser (int userId,int roleId,String action) throws DAOException;
	User findUserRoles(String email) throws DAOException;
	
}
