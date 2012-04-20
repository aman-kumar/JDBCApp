<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*,com.aman.LibraryManagementSystem.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Details Screen</title>
</head>
<body>

<%!ResultSet rsJsp1;%>
<table border="2" bordercolor="black">
	<caption>
	<h4>Students details</h4>
	</caption>
	<tr>
		<th width="15%">First Name</th>
		<th width="15%">Last Name</th>
		<th width="15%">Email Id</th>
		<th width="15%">Address</th>
		<th width="15%">Phone Number</th>

	</tr>
	<%
		DatabaseConnectionDAO dcDAO1 = new DatabaseConnectionDAO();
		dcDAO1.setUpConnectionToDatabase();
		String query = "SELECT * FROM studentdetails";
		dcDAO1.executeSqlQuery(query);
		rsJsp1 = dcDAO1.getExecutedSqlQueryDisplay();
		while (rsJsp1.next()) {
	%>
	<tr>
		<td width="15%"><%=rsJsp1.getString("firstName")%></td>
		<td width="15%"><%=rsJsp1.getString("lastName")%></td>
		<td width="15%"><%=rsJsp1.getString("emailId")%></td>
		<td width="15%"><%=rsJsp1.getString("address")%></td>
		<td width="15%"><%=rsJsp1.getString("phoneNumber")%></td>
	</tr>
	<%
		}
		dcDAO1.closeDatabaseConnection();
	%>
</table>
</body>
</html>