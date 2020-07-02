package com.cognizant.revcast.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
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
	
		String url = "jdbc:mysql://your_db_url";
		String username = "your_usr";
		String password = "your_pw";
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, username, password);
		
		return conn;
	}
}
