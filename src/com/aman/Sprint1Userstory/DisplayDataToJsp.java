package com.aman.Sprint1Userstory;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.io.*;
import java.util.*;
/**
 * Servlet implementation class DisplayDataToJsp
 */
public class DisplayDataToJsp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Statement stm;
	ResultSet rs;
	Connection conn=null;
	int id;
	String user;
	String userpassword;
	String useremail;
	String usercountry;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayDataToJsp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//	response.setContentType("text/html");
	//	PrintWriter pw=response.getWriter();
		String userid=request.getParameter("id");
		String usernameDatabase="root";
		String passwordDatabase="aman";
		String database="test";
		 String url="jdbc:mysql://localhost:3306/";
		 String driver="com.mysql.jdbc.Driver";
		 //"/JDBCApp/WebContent/ViewDatabaseContent.jsp";
		 try{
			 Class.forName(driver);
			 conn=DriverManager.getConnection(url+database,usernameDatabase,passwordDatabase);
		//	 pw.println("successfully connected to the database");
			// pw.println("time to send some SQL querry to the database");
			 String sql="SELECT * FROM aman_table where Id ="+userid ;	
			// pw.println(sql);
stm=conn.createStatement();
rs=  stm.executeQuery(sql);
			 while(rs.next()){
			 id=rs.getInt("Id");
			 user=rs.getString("Username");
			 userpassword=rs.getString("password");
			 useremail=rs.getString("email");
			 usercountry=rs.getString("country");
			
			 }
		//	 pw.println("time to close the connection to the database");
			 conn.close();	 
		 }catch(Exception exc){
			 exc.printStackTrace();
		 }
		 
/*		pw.println("it's time to display the details of the person whose name is just enetered");
		pw.println("The userId: "+id);
		pw.println("The username: "+user);
		pw.println("The userpassword: "+userpassword);
		pw.println("The useremail: "+useremail);
		pw.println("The usercountry: "+usercountry);
	pw.println("it seems that everything is works out quitefine ");
	*/
		 request.setAttribute("idvalue", id);
		 request.setAttribute("uservalue", user);
		 request.setAttribute("userpasswordvalue", userpassword);
		 request.setAttribute("useremailvalue", useremail);
		 request.setAttribute("usercountryvalue", usercountry);
		 
		 RequestDispatcher view=request.getRequestDispatcher("ViewDatabaseContent.jsp");
	view.forward(request, response);
	}

	
}
