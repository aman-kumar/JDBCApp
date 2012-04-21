package com.aman.LibraryManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionDAO {
	private String userName = "root";
	private String password = "aman";
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/";
	private String database = "librarymanagementsystem";
	private Connection con = null;

	// private ResultSet rs1;

	public Connection getConnection() {
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
			ex1.printStackTrace();

		}
		return con;
	}

}
