<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*,com.aman.LibraryManagementSystem.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SearcPageDisplay</title>
</head>
<body>
<table border="3" bordercolor="black">
	<tr>
		<th width="30">title</th>
		<th width="30">author</th>
		<th width="30">genre</th>
		<th width="30">book_description</th>
		<th width="30">publisher</th>
		<th width="30">Copies</th>
	</tr>
	<%!ResultSet rst;
	Connection con = null;
	PreparedStatement stm;
	String username = "root";
	String password = "aman";
	String url = "jdbc:mysql://localhost:3306/";
	String driver = "com.mysql.jdbc.Driver";
	String database = "librarymanagementsystem";
	Integer copiesOfBooksAvailable;
	String searchedBookName;
	String searchedBookAuthor;
	String searchedBookGenre;
	String searchedBookDescription;
	String searchedBookPublisher;

	//BookIssueLogic bklogic=new BookIssueLogic();%>
	<%
		String enteredBookName = request.getParameter("bookName");
		String enteredAuthorName = request.getParameter("authorName");
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url + database, username,
					password);
			String sql = "SELECT * from bookdetails where bookTitle=? and author=?";
			try {
				stm = con.prepareStatement(sql);
				stm.setString(1, enteredBookName);
				stm.setString(2, enteredAuthorName);
				rst = stm.executeQuery();
				while (rst.next()) {
	%>
	<tr>

		<td><%=rst.getString("bookTitle")%></td>
		<td><%=rst.getString("author")%></td>
		<td><%=rst.getString("genre")%></td>
		<td><%=rst.getString("book_description")%></td>
		<td><%=rst.getString("publisher")%></td>
		<td><%=rst.getString("noOfCopies")%></td>
	</tr>


	<%
		searchedBookName = rst.getString("bookTitle");
					searchedBookAuthor = rst.getString("author");
					searchedBookGenre = rst.getString("genre");
					searchedBookDescription = rst
							.getString("book_description");
					searchedBookPublisher = rst.getString("publisher");
					copiesOfBooksAvailable = Integer.parseInt(rst
							.getString("noOfCopies"));

				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			con.close();
		} catch (Exception ex1) {
			ex1.printStackTrace();
		}
	%>
	<%
		if (copiesOfBooksAvailable > 1) {
			request.setAttribute("bookName", searchedBookName);
			request.setAttribute("bookAuthorName", searchedBookAuthor);
	%>


</table>
<br>
<form action="BookIssueLogic" method="post"><input type="text"
	name="firstName" size="30"><br>
<input type="text" name="lastName" size="30"><br>
issuebook:<input type="submit" name="issue"></form>
<%
	} else {
%>
<br>
<br>
This book is not present in the stock .Sorry try this after some days.
<%
	}
%>
</body>
</html>
