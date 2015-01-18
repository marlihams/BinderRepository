package com.utc.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOUtility {
	
	public static PreparedStatement initializePreparedStatement(Connection connection, String sql, Boolean returnGeneratedKeys, Object... objects) throws SQLException{
		PreparedStatement preparedStatement = connection.prepareStatement(sql, returnGeneratedKeys?Statement.RETURN_GENERATED_KEYS:Statement.NO_GENERATED_KEYS);
		for (int i =0;i<objects.length;i++){
			preparedStatement.setObject(i+1, objects[i]);
		}
		
		
		return preparedStatement;
	}
	
	public static void silentClose( Statement statement ) {
	    if ( statement != null ) {
	        try {
	            statement.close();
	        } catch ( SQLException e ) {
	            System.out.println( "Could not close Statement : " + e.getMessage() );
	        }
	    }
	}

	
	public static void silentClose( Connection connection ) {
	    if ( connection != null ) {
	        try {
	        	connection.close();
	        } catch ( SQLException e ) {
	            System.out.println( "Could not close connection : " + e.getMessage() );
	        }
	    }
	}
	public static void silentClose( ResultSet resultSet ) {
	    if ( resultSet != null ) {
	        try {
	            resultSet.close();
	        } catch ( SQLException e ) {
	            System.out.println( "Could not close ResultSet : " + e.getMessage() );
	        }
	    }
	}
	
	public static void silentCloses(Statement statement, Connection connection){
		silentClose(statement);
		silentClose(connection);
	}
	public static void silentCloses(Statement statement, Connection connection, ResultSet resultSet){
		silentClose(resultSet);
		silentClose(statement);
		silentClose(connection);
	}
}
