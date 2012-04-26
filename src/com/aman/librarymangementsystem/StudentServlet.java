package com.aman.librarymangementsystem;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentDetailsEntryPage
 */
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	private String firstNameEntered;
	private String lastNameEntered;
	private String emailIdEntered;
	private String addressEntered;
	private Integer phoneNumberEntered;
	ResultSet rst;

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

		firstNameEntered = request.getParameter("firstName");
		lastNameEntered = request.getParameter("lastName");
		emailIdEntered = request.getParameter("emailId");
		addressEntered = request.getParameter("address");
		phoneNumberEntered = Integer.parseInt(request
				.getParameter("phoneNumber"));
		QueryExecution qeObject = new QueryExecution();
		qeObject.insertStudentsDetailsinTable(firstNameEntered,
				lastNameEntered, emailIdEntered, addressEntered,
				phoneNumberEntered);
		rst = qeObject.displayStudentDetails();
		request.setAttribute("studentDetail", rst);
		RequestDispatcher view = request
				.getRequestDispatcher("StudentsDetailsScreen.jsp");
		view.forward(request, response);
	}

}
