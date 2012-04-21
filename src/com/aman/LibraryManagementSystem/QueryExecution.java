package com.aman.LibraryManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryExecution {
	DatabaseConnectionDAO obj = new DatabaseConnectionDAO();
	Connection con = null;
	PreparedStatement pst;
	ResultSet rst;

	public void insertBookDetailsToTable(String bookTitle, String bookAuthor,
			String bookGenre, String Description, String bookPublisher,
			Integer bookNumber) {
		con = obj.getConnection();
		String sql = "INSERT into bookdetails values(?,?,?,?,?,?)";
		try {
			pst = con.prepareStatement(sql);
			pst.setString(1, bookTitle);
			pst.setString(2, bookAuthor);
			pst.setString(3, bookGenre);
			pst.setString(4, Description);
			pst.setString(5, bookPublisher);
			pst.setInt(6, bookNumber);
			int p = pst.executeUpdate();
			if (p == 1) {
				System.out.println("query sucessfully executed");
			} else {
				System.out.println("query was not sucessfully executed");
			}
			con.close();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	public void insertStudentsDetailsinTable(String firstName, String lastName,
			String emanilId, String address, Integer phoneNumber) {
		String sql1 = "INSERT into studentdetails values(?,?,?,?,?)";
		con = obj.getConnection();
		try {
			pst = con.prepareStatement(sql1);
			pst.setString(1, firstName);
			pst.setString(2, lastName);
			pst.setString(3, emanilId);
			pst.setString(4, address);
			pst.setInt(5, phoneNumber);
			int p = pst.executeUpdate();
			if (p == 1) {
				System.out.println("Querry executed sucessfully");
			} else {
				System.out.println("Querry not executed sucessfully");
			}

		} catch (SQLException ex1) {
			ex1.printStackTrace();
		}

	}

	public ResultSet displayBookDetails() {
		String sql2 = "SELECT * from bookdetails";
		con = obj.getConnection();
		try {
			pst = con.prepareStatement(sql2);

			rst = pst.executeQuery();

		} catch (SQLException ex2) {
			ex2.printStackTrace();
		}
		return rst;
	}

	public ResultSet displayStudentDetails() {
		String sql3 = "SELECT * from studentdetails";
		con = obj.getConnection();
		try {
			pst = con.prepareStatement(sql3);

			rst = pst.executeQuery();

		} catch (SQLException ex2) {
			ex2.printStackTrace();
		}
		return rst;
	}

}
