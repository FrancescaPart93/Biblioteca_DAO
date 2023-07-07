package it.betacom.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Configuration {

	private static Configuration instance;
	private Connection conn;
	private String connessione = "jdbc:mysql://localhost:3306/";
	private String nomeDB = "biblioteca_dao";
	private String utente = "root";
	private String pwd = "root";
	
	
	public static Configuration getInstance() {
		if(instance == null) {
					
			System.out.println("Instanzio la classe");
			instance = new Configuration();
		}
		return instance;
	}
	
	
	private Configuration() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			System.out.println("Non è stato possibile caricare il driver");
			e1.printStackTrace();
		}
		
	}
	
	public Connection getConnection() {
		conn = null;
		try {
			conn = DriverManager.getConnection(connessione + nomeDB, utente, pwd);
			System.out.println("Connessione avvenuta");
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return conn;
	}
	
	public void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
