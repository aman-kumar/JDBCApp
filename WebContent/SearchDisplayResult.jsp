<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="java.sql.*,com.aman.LibraryManagementSystem.*,java.io.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SearcPageDisplay</title>
</head>
<body>
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
	PrintWriter pwm = response.getWriter();
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
			boolean searchEmpty = true;
			while (rst.next()) {
				searchEmpty = false;
				// pwm.println("The book has been located in the database");
%>
<table align="left" width="2" border="3" bordercolor="black">
	<tr>
		<th width="30">BookTitle</th>
		<th width="30">AuthorName</th>
		<th width="30">BookGenre</th>
		<th width="30">BookDescription</th>
		<th width="30">Publisher</th>
		<th width="30">CopiesOfBook</th>

	</tr>
	<tr>
		<td><%=rst.getString("bookTitle")%></td>
		<td><%=rst.getString("author")%></td>
		<td><%=rst.getString("genre")%></td>
		<td><%=rst.getString("book_description")%></td>
		<td><%=rst.getString("publisher")%></td>
		<td><%=rst.getString("noOfCopies")%></td>
	</tr>

	<%
		}
	%>
</table>
<%
	if (searchEmpty) {
%>
<br>
The book is not present in the database,that means the book is not
present in the Library try some book shop or submit
<br>
<br>
a request for getting the book in library
<br>
<%
	// pwm.println("The book is not present ins database");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		con.close();
	} catch (Exception ex1) {
		ex1.printStackTrace();
	}
%>
</body>
</html>
