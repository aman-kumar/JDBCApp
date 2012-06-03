package com.aman.librarymanagementsystem;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aman.domain.Record;
import com.aman.service.RecordService;

/**
 * Servlet implementation class RecordEntry
 */
public class RecordEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecordEntry() {
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
// populate-->call service--> view display
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    execute(request, response);
	}

    private void execute(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        Record record = populateRecord(request);
	 RecordService recordService=new RecordService();
	 recordService.create(record);
	 ArrayList<Record> recordList=new ArrayList<Record>();
	 recordList=(ArrayList<Record>) recordService.getList();
	 request.setAttribute("record", recordList);
	 RequestDispatcher view=request.getRequestDispatcher("RecordDisplay.jsp");
	view.forward(request, response);
    }

    private Record populateRecord(HttpServletRequest request) {
        Record record=new Record();
	 record.setBookRecord(request.getParameter("bookRecord"));
	 record.setBookId(request.getParameter("bookId"));
	 record.setStatus(request.getParameter("status"));
	 record.setStudentId(request.getParameter("studentId"));
        return record;
    }

}
