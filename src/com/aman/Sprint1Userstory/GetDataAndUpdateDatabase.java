package com.aman.Sprint1Userstory;
import java.sql.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
/**
 * Servlet implementation class GetDataAndUpdateDatabase
 */
public class GetDataAndUpdateDatabase extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetDataAndUpdateDatabase() {
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
response.setContentType("text/html");
PrintWriter pw=response.getWriter();
String userId=request.getParameter("userId");
String userName=request.getParameter("userName");
String password=request.getParameter("password");
String email=request.getParameter("email");
String country=request.getParameter("country");

		//time to connect to the database
		// TODO Auto-generated method stub
	Connection con=null;
	String url="jdbc:mysql://localhost:3306/";
	String driver="com.mysql.jdbc.Driver";
	String username="root";
	String databasePassword="aman";
	String database="test";
	try{
		Class.forName(driver);
		con=DriverManager.getConnection(url+database,username,databasePassword);
		pw.println("connected to the database");
		pw.println("now it's the time to insert the values to the database");
	//	pw.println(userId +  userName  + password +  email +  country );
		try{
			PreparedStatement pw1=con.prepareStatement("insert into aman_table values (?,?,?,?,?)");
			pw1.setString(1, userId);
			pw1.setString(2, userName);
			pw1.setString(3, password);
			pw1.setString(4, email);
			pw1.setString(5, country);
			int p=pw1.executeUpdate();
			if(p!=0){
				pw.println("The insertion operation is successful");
			}else{
				pw.println("The insertion operation is not successful");
			}
			pw.println("So it;s time to close the connection with the Database");	
			}catch(SQLException ex)
			{
			ex.printStackTrace();	
			}
			con.close();
		}catch(Exception ecp){
			ecp.printStackTrace();
			
		}
		
	}
	
	
	}


