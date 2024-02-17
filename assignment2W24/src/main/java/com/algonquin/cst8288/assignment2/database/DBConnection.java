	package com.algonquin.cst8288.assignment2.database;
	
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;
	
	public class DBConnection {
		
		private static Connection connection = null;
		
		private static String serverUrl = "jdbc:mysql://localhost:3306/bookvault";
		private static String userString = "***";
		private static String passwordString = "***";
		private static String driverString = "com.mysql.cj.jdbc.Driver";
		
	    // Private constructor to prevent instantiation
	    private DBConnection() {
	    }
	    // Public method to return the singleton Connection instance
	    public static Connection getConnection() {
	        if (connection == null) {
	        	
	            try {
	                Class.forName(driverString); // Ensure the driver is registered
	                connection = DriverManager.getConnection(serverUrl, userString, passwordString);
	            } catch (ClassNotFoundException e) {
	                System.out.println("MySQL JDBC Driver not found.");
	                e.printStackTrace();
	            } catch (SQLException e) {
	                System.out.println("Connection to database failed.");
	                e.printStackTrace();
	            }
	        }
	        return connection;
		
	}
	}