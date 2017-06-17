package com.satyendra.db.util;

import java.sql.*;

public class DBConnection {

	static Connection con;
	private static ResultSet rs;
	public DBConnection() {

	}

	public static Connection ConnectDb() {
		
		try {
			Class.forName("org.h2.Driver");
			 con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/olx", "olx", "olx");
			// con.close();
		} catch (ClassNotFoundException notFoundEx) {
			System.out.println("class not found");
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return con;
	}
	  static public void closeConnection()
	  {
		  try {
			  if(con!=null)
			con.close();
			  else
				  System.out.println("error occure while");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error while closing connection "+e.getMessage());
			//e.printStackTrace();
		}
	  }
}
