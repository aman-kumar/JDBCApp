package com.aman.LibraryManagementSystem;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchBookDisplay
 */
public class SearchBookDisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchBookDisplay() {
		super();
		// TODO Auto-generated constructor stub
	}

	ResultSet rst;
	Connection con = null;
	Statement stm;
	String username = "root";
	String password = "aman";
	String url = "jdbc:mysql://localhost:3306/";
	String driver = "com.mysql.jdbc.Driver";
	String database = "librarymanagementsystem";

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

		String enteredBookName = request.getParameter("bookName");
		String enteredAuthorName = request.getParameter("authorName");
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url + database, username,
					password);
			String sql = "SELECT * FROM bookdetails where author=Joshua Bloch ";
			try {
				stm = con.createStatement();
				rst = stm.executeQuery(sql);
				while (rst.next()) {
					String recTitle = rst.getString("bookTitle");
					String recAuthor = rst.getString("author");
					String recGenre = rst.getString("genre");
					String recBookDescription = rst
							.getString("book_description");
					String recBookPublisher = rst.getString("publisher");
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			con.close();
		} catch (Exception ex1) {
			ex1.printStackTrace();
		}
		// request.setAttribute(arg0, arg1)
	}

}
