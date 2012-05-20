package com.aman.librarymanagementsystem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aman.domain.Student;
import com.aman.service.StudentService;

/**
 * Servlet implementation class StudentServlet
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

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        execute(request, response);
    }

    // populate bean object --> call the service --> view
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
        Student student = new Student();
        populateStudent(request, student);
        StudentService studentService = new StudentService();
        studentService.create(student);
        List<Student> studentList = new ArrayList<Student>();
        studentList = studentService.getList();
       // request.setAttribute("student", studentList);
        //RequestDispatcher view = request
          //      .getRequestDispatcher("StudentsDetailsScreen.jsp");
        //view.forward(request, response);
    }

    private void populateStudent(HttpServletRequest request, Student student) {
        student.setFirstName(request.getParameter("firstName"));
        student.setLastName(request.getParameter("lastName"));
        student.setEmailId(request.getParameter("emailId"));
        student.setAddress(request.getParameter("address"));
        student.setPhoneNumber(request.getParameter("phoneNumber"));
    }

}
