package com.kavi.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {

	private static Connection con;

	

	public static Connection getConnection() {
	
		try {
			/*Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kavi", "temre");*/
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Petrol","root", "root");
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("DB connection cannot be establish due to : " + e.getMessage());
			e.printStackTrace();

		}
		return con;
	}

	
}
