package com.aman.librarymanagementsystem;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aman.domain.Book;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    execute(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	execute(request, response);
	}
// search student,get it's studentId,then out that Id in BookRecord and change the status of the book to "issued"
    private void execute(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        List<Book> bookList;
        List<Student> studentList;
            Student student=new Student();
        student.setFirstName(request.getParameter("firstName"));
        student.setLastName(request.getParameter("lastName"));
        
IssueService service=new IssueService();	
// searchStudent

service.book();
        service.createStudent(student);
        service.issueBook();
        bookList=service.getBookList();
        studentList=service.getStudentList();
        request.setAttribute("book", bookList);
        request.setAttribute("student", studentList);
        RequestDispatcher view=request.getRequestDispatcher("issueDetails.jsp");
        view.forward(request, response);
    }

}
