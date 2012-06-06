package com.aman.librarymanagementsystem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aman.domain.Record;
import com.aman.domain.Student;
import com.aman.service.IssueService;

/**
 * Servlet implementation class IssueServlet
 */
public class IssueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IssueServlet() {
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
		execute(request, response);
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

	// search student,get it's studentId,then out that Id in BookRecord and
	// change the status of the book to "issued"
	private void execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		List<Student> studentList;
		Student student = new Student();
		student.setFirstName(request.getParameter("firstName"));
		student.setLastName(request.getParameter("lastName"));
		Record record = new Record();
		record.setBookRecord(request.getParameter("bookRecordId"));
		List<Record> recordList = new ArrayList<Record>();
		IssueService service = new IssueService();
		// searchStudent
		service.SearchStudent(student);
		service.createRecord(record);
		service.updateRecord();
		recordList = service.getUpdatedRecord();
		request.setAttribute("record", recordList);

		RequestDispatcher view = request
				.getRequestDispatcher("issueDetails.jsp");
		view.forward(request, response);
	}

}
