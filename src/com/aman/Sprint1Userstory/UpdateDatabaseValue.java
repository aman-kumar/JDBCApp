package com.aman.Sprint1Userstory;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.*;
/**
 * Servlet implementation class UpdateDatabaseValue
 */
public class UpdateDatabaseValue extends HttpServlet {
	private static final long serialVersionUID = 1L;
PreparedStatement pst;
	
ResultSet rs;
	Integer userId;
String newPassword;
String newEmail;
String newCountry;
String newUsername;
Connection con=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDatabaseValue() {
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
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		userId=(Integer.parseInt(request.getParameter("employeeId")));
		newPassword=request.getParameter("employeePassword");
		newUsername=request.getParameter("employeeUsername");
		newEmail=request.getParameter("employeeEmail");
		newCountry=request.getParameter("employeeCountry");
		String driver="com.mysql.jdbc.Driver";
		String database="test";
		String url="jdbc:mysql://localhost:3306/";
		String username="root";
		String password="aman";
	//	String sql="UPDATE aman_table SET password ="+ newPassword+",email= "+newEmail+", country="+newCountry+"WHERE Id ="+userId ;
		
		try{
			
			Class.forName(driver);
			con=DriverManager.getConnection(url+database,username,password);
			pw.println("connected to the database");
			try{
			pst=con.prepareStatement("UPDATE aman_table set password=?"+",email=?"+",country=?" +"WHERE Id=?");
			pst.setInt(4, userId);
			pst.setString(1, newPassword);
			pst.setString(2,newEmail);
			pst.setString(3, newCountry);
			int p=pst.executeUpdate();
			if(p!=0){
				pw.println("Querry was succesful");
			}else{
				pw.println("Querry was not succesful");
			}
			}catch(SQLException ex1){
				ex1.printStackTrace();
			}
			con.close();
			pw.println("closing the connectoin with database");
		}catch(Exception ex){
		}
	}

}
