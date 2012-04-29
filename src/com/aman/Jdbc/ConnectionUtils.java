package com.aman.Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
	private static String userName = "root";
	private static String password = "aman";
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/";
	private static String database = "librarymanagementsystem";


	// private ResultSet rs1;

	public static Connection getConnection() {
	 Connection con = null;
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException ex) {
			System.out.println("the required class is not found ");
			throw new IllegalStateException();

		}
		try {
			con = DriverManager.getConnection(url + database, userName,
					password);
			System.out.println("successfully connected to the database");
		} catch (SQLException ex1) {
			throw new IllegalStateException();

		}
		return con;
	}
}