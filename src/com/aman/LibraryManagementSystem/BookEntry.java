package com.aman.LibraryManagementSystem;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookEntry
 */
public class BookEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con = null;
	PreparedStatement pst;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookEntry() {
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
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String bookTitleEntered = request.getParameter("bookTitle");
		String bookAuthorEntered = request.getParameter("bookAuthor");
		String bookGenreEntered = request.getParameter("bookGenre");
		String bookDescriptionEntered = request.getParameter("bookDescription");
		String bookPublisherEntered = request.getParameter("bookPublisher");
		String bookCopiesEntered = request.getParameter("bookCopies");
		Integer bookNumber = Integer.parseInt(bookCopiesEntered);
		String username = "root";
		String password = "aman";
		String url = "jdbc:mysql://localhost:3306/";
		String driver = "com.mysql.jdbc.Driver";
		String database = "libraryManagementSystem";
		pw.println("time to connect to the database");
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url + database, username,
					password);
			pw.println("successfully connected to the database ");
			String sql = "INSERT into bookdetails values(?,?,?,?,?,?)";
			try {
				pst = con.prepareStatement(sql);
				pst.setString(1, bookTitleEntered);
				pst.setString(2, bookAuthorEntered);
				pst.setString(3, bookGenreEntered);
				pst.setString(4, bookDescriptionEntered);
				pst.setString(5, bookPublisherEntered);
				pst.setInt(6, bookNumber);
				int p = pst.executeUpdate();
				if (p == 1) {
					pw.println("SQL querry successfully updated");
				} else {
					pw.println("SQL querry not successfull");
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}

			pw.println("It's time to close the connection with database");
			con.close();
			pw.println("connection sucessfully closed");
		} catch (Exception ex1) {
			ex1.printStackTrace();
		}
	}

}