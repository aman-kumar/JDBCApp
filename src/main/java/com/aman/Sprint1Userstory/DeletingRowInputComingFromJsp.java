package com.aman.Sprint1Userstory;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.*;
import java.sql.*;
import java.io.*;

/**
 * Servlet implementation class DeletingRowInputComingFromJsp
 */
public class DeletingRowInputComingFromJsp extends HttpServlet {
    private static final long serialVersionUID = 1L;
    Statement stm;
    Connection con = null;
    Integer userId;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletingRowInputComingFromJsp() {
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
        userId = Integer.parseInt(request.getParameter("employeeId"));
        String url = "jdbc:mysql://localhost:3306/";
        String database = "test";
        String password = "aman";
        String driver = "com.mysql.jdbc.Driver";
        String username = "root";
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url + database, username,
                    password);
            String sql = "DELETE from aman_table WHERE Id=" + userId;
            pw.println("connected to the database");
            stm = con.createStatement();
            int d = stm.executeUpdate(sql);
            if (d == 1) {
                pw.println("Qerry updated successfully");
            } else {
                pw.println("Querry not updated properly");
            }
            pw.println("Since operation is successfully completed it's time to close down the connection with database");
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
