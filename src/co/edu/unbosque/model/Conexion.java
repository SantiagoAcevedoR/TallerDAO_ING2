package co.edu.unbosque.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
	private Connection connection = null;
	
	public Conexion() {
		
	}
	
	public void abrirConexion() {
		
		 
	      try{
	         connection = DriverManager.getConnection( "jdbc:sqlite:Data\\data.db" );
	         if ( connection != null ){
	         }
	      }
	      catch ( Exception ex ) {
	         System.err.println( ex.getClass().getName() + ": " + ex.getMessage() );
	         System.out.println("Error en la conexión");
	      }
	}

	/**
	 * @return the connection
	 */
	public Connection getConnection() {
		return connection;
	}

	/**
	 * @param connection the connection to set
	 */
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

}
