package com.aman.LibraryManagementSystem;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentDetailsEntryPage
 */
public class StudentDetailsEntryPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ResultSet rst;
	Connection con = null;
	PreparedStatement pst;
	String username = "root";
	String password = "aman";
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/";
	String database = "librarymanagementsystem";
	String sql = "INSERT into studentdetails values(?,?,?,?,?)";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentDetailsEntryPage() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url + database, username,
					password);
			pst = con.prepareStatement(sql);

			pst.setString(1, request.getParameter("firstName"));
			pst.setString(2, request.getParameter("lastName"));
			pst.setString(3, request.getParameter("emailId"));
			pst.setString(4, request.getParameter("address"));
			pst.setInt(5, Integer.parseInt(request.getParameter("phoneNumber")));
			int p = pst.executeUpdate();
			if (p != 0) {
				System.out.println("Querry succesfully executed ");
			} else {
				System.out.println("Querry is not executed succesfully ");
			}
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
