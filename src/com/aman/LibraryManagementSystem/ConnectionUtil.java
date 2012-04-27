package com.aman.LibraryManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	private static final String userName = "root";
	private static final String password = "aman";
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/";
	private static final String database = "librarymanagementsystem";

	// private ResultSet rs1;

	public static Connection getConnection() {
	    Connection con = null;
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
			System.out.println("the required class is not found ");
		}
		try {
			con = DriverManager.getConnection(url + database, userName,
					password);
			System.out.println("successfully connected to the database");
		} catch (SQLException ex1) {
			throw new IllegalStateException(ex1);
		}
		return con;
	}
}
