package com.cognizant.revcast.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import java.util.ResourceBundle;
public class DBConnection {

	public static Connection getConnection() throws ClassNotFoundException, SQLException {        

		//For using with ResourceBundle, but not working in cloud or remote server
		/*
		ResourceBundle rb= ResourceBundle.getBundle("../mysql");
		String url = rb.getString("db.url");
		String username = rb.getString("db.username");
		String password = rb.getString("db.password");
		*/
	
		String url = "jdbc:mysql://localhost:3306/revcast";
		String username = "root";
		String password = "root";
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username, password);
		return conn;
	}

}
