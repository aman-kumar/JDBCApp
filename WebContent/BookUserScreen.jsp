<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<h1>Welcome to the page that shows the contents</h1>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%!Connection con = null;
	Statement stm;
	ResultSet rs;
	String username = "root";
	String password = "aman";
	String url = "jdbc:mysql://localhost:3306/";
	String database = "libraryManagementSystem";
	String driver = "com.mysql.jdbc.Driver";
	String sql = "SELECT * from bookdetails";
	String title;
	String authorName;
	String bookGenre;
	String bookDescription;
	String bookPublisher;%>
<body>
<table border="2" bordercolor="black">
	<caption>Books present in the library</caption>
	<tr>
		<th width="30">Title</th>
		<th width="20">Author</th>
		<th width="30">Genre</th>
		<th width="100">Description</th>
		<th width="30">Publisher</th>
		<th width="30">Copies</th>

	</tr>



	<%
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url + database, username,
					password);
			stm = con.createStatement();
			rs = stm.executeQuery(sql);
			while (rs.next()) {
	%>



	<tr>
		<td width="30" bordercolor="pink"><%=rs.getString("bookTitle")%></td>
		<td width="20"><%=rs.getString("author")%></td>
		<td width="30"><%=rs.getString("genre")%></td>
		<td width="100"><%=rs.getString("book_description")%></td>
		<td width="30"><%=rs.getString("publisher")%></td>
		<td width="30"><%=rs.getString("noOfCopies")%></td>
	</tr>
	<%
		}
	%>
</table>

<%
	con.close();
	} catch (Exception ex) {
		ex.printStackTrace();
	}
%>






</body>
</html>
