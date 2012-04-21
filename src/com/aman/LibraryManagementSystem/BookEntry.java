package com.aman.LibraryManagementSystem;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
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
	ResultSet rstServl;

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
		// LibraryManagement obj=new LibraryManagement();
		// obj.setBookInfo(bookTitleEntered, bookAuthorEntered,
		// bookGenreEntered, bookDescriptionEntered, bookPublisherEntered,
		// bookCopiesEntered);
		QueryExecution querryObject = new QueryExecution();
		querryObject.insertBookDetailsToTable(bookTitleEntered,
				bookAuthorEntered, bookGenreEntered, bookDescriptionEntered,
				bookPublisherEntered, bookNumber);
		rstServl = querryObject.displayBookDetails();
		request.setAttribute("bookDetails", rstServl);
		RequestDispatcher view = request
				.getRequestDispatcher("BookUserScreen.jsp");
		view.forward(request, response);

	}

}