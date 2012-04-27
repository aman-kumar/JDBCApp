package com.aman.LibraryManagementSystem;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aman.domain.Book;
import com.aman.service.BookService;

/**
 * Servlet implementation class BookEntry
 */
public class BookEntryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con = null;
	PreparedStatement pst;
	ResultSet rstServl;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		execute(request, response);
	}

	//Populate bean object from request
	//call service
	//dispatch the response to JSP
	private void execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		Book book = populateBookFromRequest(request);
		
		BookService bookService = new BookService();
		bookService.create(book);
		
		List<Book> books = bookService.listBooks();
		
		request.setAttribute("bookDetails", books);
		RequestDispatcher view = request
				.getRequestDispatcher("BookUserScreen.jsp");
		view.forward(request, response);
	}

	private Book populateBookFromRequest(HttpServletRequest request) {
		Book book = new Book();
		book.setTitle(request.getParameter("bookTitle"));
		book.setAuthor(request.getParameter("bookAuthor"));
		book.setDescription(request.getParameter("bookDescription"));
		book.setPublisher(request.getParameter("bookPublisher"));
		book.setCopies(request.getParameter("bookCopies"));
		return book;
	}
}