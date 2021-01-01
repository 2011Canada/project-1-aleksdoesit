package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Factory design pattern
// Factory is an object that builds other objects -> based on configuration we provide
public class ConnectionFactory {
	
//	Turn Factory into a singleton so you can only get the connection thru the factory
//	make a private static reference to ourselves -> i.e. only copy
	private static ConnectionFactory cf = new ConnectionFactory(1);
	
//	Provide a single point of access to the ConnectionFactory
	public static ConnectionFactory getConnectionFactory() {
		return cf;
	}
	
//	Holds all of our connections
	private Connection[] conn;
	
//	Singleton -> all constructors must be private
	private ConnectionFactory(int numberOfConnections) {
		
		try {
			DriverManager.registerDriver(new org.postgresql.Driver());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String url = System.getenv("DB_URL");
		String user = System.getenv("DB_USER");
		String password = System.getenv("DB_PASSWORD");
		
		try {
			this.conn = new Connection[numberOfConnections];
			for (int i = 0; i < this.conn.length; i++) {
				Connection conn = DriverManager.getConnection(url, user, password);
				this.conn[i] = conn;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public Connection getConnection() {
//		TODO
		return this.conn[0];
	}
	
	public void releaseConnection(Connection conn) {
//		TODO
		// do nothing
		
	}
	
}
