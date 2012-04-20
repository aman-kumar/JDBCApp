package com.aman.LibraryManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnectionDAO {
	private String userName = "root";
	private String password = "aman";
	private String driver = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/";
	private String database = "librarymanagementsystem";
	private Connection con = null;
	private PreparedStatement pStatement;
	private ResultSet rs;
	private String sqlQueryEntered;

	// private ResultSet rs1;

	public void setUpConnectionToDatabase() {
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
	}

	public void executeSqlQuery(String sql) {
		sqlQueryEntered = sql;
		try {
			pStatement = con.prepareStatement(sqlQueryEntered);
			rs = pStatement.executeQuery();

		} catch (SQLException ex2) {
			ex2.printStackTrace();
		}
	}

	public ResultSet getExecutedSqlQueryDisplay() {
		return rs;
	}

	public void closeDatabaseConnection() {
		try {
			con.close();
			System.out.println("Successfully closed the database connection");
		} catch (SQLException ex2) {
			ex2.printStackTrace();
		}
	}

}
