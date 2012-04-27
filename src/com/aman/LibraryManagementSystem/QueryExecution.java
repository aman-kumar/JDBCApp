package com.aman.LibraryManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryExecution {
	ConnectionUtil obj = new ConnectionUtil();
	Connection con = null;
	PreparedStatement pst;
	ResultSet rst;



	public ResultSet displayStudentDetails() {
		String sql3 = "SELECT * from studentdetails";
		con = obj.getConnection();
		try {
			pst = con.prepareStatement(sql3);

			rst = pst.executeQuery();

		} catch (SQLException ex2) {
			ex2.printStackTrace();
		}
		return rst;
	}

}
