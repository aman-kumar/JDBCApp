<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.aman.LibraryManagementSystem.*,java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test</title>
</head>
<body>
<%!ResultSet rsJsp;%>
<table border="2" bordercolor="black">
	<caption>
	<h4>Books present in the library</h4>
	</caption>
	<tr>
		<th width="15%">Title</th>
		<th width="15%">Author</th>
		<th width="15%">Genre</th>
		<th width="15%">Description</th>
		<th width="15%">Publisher</th>
		<th width="15%">Copies</th>
	</tr>
	<%
		DatabaseConnectionDAO dcDAO = new DatabaseConnectionDAO();
		dcDAO.setUpConnectionToDatabase();
		String query = "SELECT * FROM bookdetails";
		dcDAO.executeSqlQuery(query);
		rsJsp = dcDAO.getExecutedSqlQueryDisplay();
		while (rsJsp.next()) {
	%>
	<tr>
		<td width="15%"><%=rsJsp.getString("bookTitle")%></td>
		<td width="15%"><%=rsJsp.getString("author")%></td>
		<td width="15%"><%=rsJsp.getString("genre")%></td>
		<td width="15%"><%=rsJsp.getString("book_description")%></td>
		<td width="15%"><%=rsJsp.getString("publisher")%></td>
		<td width="15%"><%=rsJsp.getString("noOfCopies")%></td>
	</tr>
	<%
		}
		dcDAO.closeDatabaseConnection();
	%>
</table>
</body>
</html>