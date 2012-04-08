package com.aman.JdbcExample;
import java.sql.*;
public class ConnectionExample {
public static void main(String[]args){
	System.out.println("Mysql connect example");
	
	Connection con=null;
	String url="jdbc:mysql://localhost:3306/";
	String driver="com.mysql.jdbc.Driver";
	String database="aman_database";
	String password="aman";
	String username="root";
	try{
		Class.forName(driver).newInstance();
con=DriverManager.getConnection(url+database,username,password);
System.out.println("Connected to the database");
con.close();
		System.out.println("Disconnected from the database");
	}catch(Exception ex){
		ex.printStackTrace();
	}
	
}
}
