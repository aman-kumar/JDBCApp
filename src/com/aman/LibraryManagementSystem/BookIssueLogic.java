package com.aman.LibraryManagementSystem;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookIssueLogic
 */
public class BookIssueLogic extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String issueBookAuthorName;
	String issueBookName;
	String studentFirstName;
	String studentLastName;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookIssueLogic() {
		super();
		// TODO Auto-generated constructor stub
		// request.setAttribute("bookName",searchedBookName);
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
		issueBookAuthorName = (String) request.getAttribute("bookAuthorName");
		issueBookName = (String) request.getAttribute("bookName");
		studentFirstName = request.getParameter("firstName");
		studentLastName = request.getParameter("lastName");
		pw.println(issueBookAuthorName);
		pw.println(issueBookName);
		pw.println(studentFirstName);
		pw.println(studentLastName);
	}

}
