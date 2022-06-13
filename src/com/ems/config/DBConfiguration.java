package com.ems.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfiguration {
	Connection con;
	public Connection getDB() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("Driver class Found");
			String username="c##cijd3";
			String password = "cijd123";
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			con = DriverManager.getConnection(url,username,password);
			System.out.println("Connected successfylly");
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.println("Unable to find the Driver class");
		} catch(SQLException e){
			System.out.println("Unable to execute");
		}
		return con;
	}
	
}
