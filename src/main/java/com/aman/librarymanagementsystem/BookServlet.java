package com.aman.librarymanagementsystem;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 1. to create the connection -->to create the all the table in the first
	// servlet--> tables to create are Book,BookRecord,student
	// to do
	// populate the bean object with the values entered --> Call the service -->
	// view
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	Connection con = null;

	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		try {

			Class.forName("org.hsqldb.jdbcDriver").newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			con = DriverManager.getConnection(
					"jdbc:hsqldb:librarymanagementsystem6", "SA", "");
			System.out
					.println("successfully connected to the database now it's the time to create the tables");
			try {
				String createTableBook = "CREATE TABLE Book (bookId VARCHAR(20) PRIMARY KEY, name VARCHAR(25),author VARCHAR(25),publication VARCHAR(25),description VARCHAR(50),noOfCopies INTEGER)";
				con.createStatement().executeUpdate(createTableBook);
				System.out
						.println("table Book has been successfully created it seems now ");
			} catch (SQLException ex) {
				System.out.println("problem in creating Book Table");
				throw new IllegalStateException(ex);
			}
			try {
				// FOREIGN KEY REFERENCES Book(bookId)
				String bookRecordTable = "CREATE TABLE BookRecord (bookRecordId VARCHAR(25) PRIMARY KEY, bookId VARCHAR(20) ,status VARCHAR(20),studentId VARCHAR(25), FOREIGN KEY(bookId) REFERENCES Book(bookId))";
				con.createStatement().executeUpdate(bookRecordTable);
				System.out
						.println("table BookRecord has been successfully created it seems now ");
			} catch (SQLException ex1) {
				System.out.println("problem in creating BookRecord");
				throw new IllegalStateException(ex1);
			}
			try {
				String createStudentTable = "CREATE TABLE Student (studentId VARCHAR(25) PRIMARY KEY,firstName VARCHAR(25),lastName VARCHAR(25),address VARCHAR(50),phoneNumber INTEGER,email VARCHAR(50))";
				con.createStatement().executeUpdate(createStudentTable);
				System.out
						.println("table Student has been successfully created it seems now ");
			} catch (SQLException ex3) {
				System.out.println("problem in creating Student table");
				throw new IllegalStateException(ex3);
			}
		} catch (SQLException ex2) {
			System.out.println("problem occurred while creating Book table ");
			throw new IllegalStateException();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		execute(request, response);

	}

	private void execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Book book = populateBook(request);

		BookService bookService = new BookService();
		bookService.create(book);
		List<Book> books = new ArrayList<Book>();
		books = bookService.getList();
		request.setAttribute("bookDetails", books);
		RequestDispatcher view = request
				.getRequestDispatcher("BookUserScreen.jsp");
		view.forward(request, response);

	}

	private Book populateBook(HttpServletRequest request) {
		Book book = new Book();
		book.setAuthor(request.getParameter("author"));
		book.setName(request.getParameter("name"));
		book.setCopies(Integer.parseInt(request.getParameter("copies")));
		book.setDescription(request.getParameter("description"));
		// book.setGenre(request.getParameter("genre"));
		book.setPublisher(request.getParameter("publisher"));
		book.setbookId(request.getParameter("bookId"));
		return book;
	}

}
