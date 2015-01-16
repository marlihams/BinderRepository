package com.utc.factory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.utc.dao.*;
import com.utc.daoImpl.AuteurDaoImpl;
import com.utc.daoImpl.BookDaoImpl;
import com.utc.daoImpl.UserDaoImpl;
import com.utc.exceptions.DAOConfigurationException;

public class DAOFactory {

    private static final String PROPERTIES_FILE       = "/com/utc/properties/dao.properties";
    private static final String PROPERTY_URL             = "url";
    private static final String PROPERTY_DRIVER          = "driver";
    private static final String PROPERTY_USERNAME = "username";
    private static final String PROPERTY_PASSWORD    = "password";

    private String              url;
    private String              username;
    private String              password;

    DAOFactory( String url, String username, String password ) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    /*
     * Méthode chargée de récupérer les informations de connexion à la base de
     * données, charger le driver JDBC et retourner une instance de la Factory
     */
    public static DAOFactory getInstance() throws DAOConfigurationException {
        Properties properties = new Properties();
        String url;
        String driver;
        String username;
        String password;

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream propertiesFile = classLoader.getResourceAsStream( PROPERTIES_FILE );

        if ( propertiesFile == null ) {
            throw new DAOConfigurationException( "File" + PROPERTIES_FILE + " cannot be found." );
        }

        try {
            properties.load( propertiesFile );
            url = properties.getProperty( PROPERTY_URL );
            driver = properties.getProperty( PROPERTY_DRIVER );
            username = properties.getProperty( PROPERTY_USERNAME );
            password = properties.getProperty( PROPERTY_PASSWORD );
        } catch ( IOException e ) {
            throw new DAOConfigurationException( "Impossible to load file " + PROPERTIES_FILE, e );
        }

        try {
            Class.forName( driver );
        } catch ( ClassNotFoundException e ) {
            throw new DAOConfigurationException( "Driver cannot be found in Classpath.", e );
        }

        DAOFactory instance = new DAOFactory( url, username, password );
        return instance;
    }

    /* Méthode chargée de fournir une connexion à la base de données */
     /* package */
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection( url, username, password );
    }

    /*
     * Méthodes de récupération de l'implémentation des différents DAO (un seul
     * pour le moment)
     */
    public UserDao getUserDao() {
        return new UserDaoImpl (this);
    }
    public BookDao getBookDao(){
    	return new BookDaoImpl(this);
    }
    public AuteurDao getAuteurDao(){
    	return new AuteurDaoImpl(this);
    }
}