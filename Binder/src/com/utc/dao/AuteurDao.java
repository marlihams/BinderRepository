package com.utc.dao;

import java.util.List;

import com.utc.beans.Auteur;
import com.utc.exceptions.DAOException;



public interface AuteurDao {
	Auteur create(Auteur auteur) throws DAOException;
	Auteur findAuteurByIdOrAuteurName(String action,String auteurIdorName) throws DAOException;
	boolean delete(Auteur auteur) throws DAOException;
	List<Auteur> findAllAuteurs() throws DAOException;	
}
