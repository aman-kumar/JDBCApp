<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="java.sql.*,com.aman.librarymanagementsystem.*,java.io.*,com.aman.domain.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SearcPageDisplay</title>
</head>
<body>
<%!
List<Book> bookList=new ArrayList<Book>(); %>
<%

bookList=(ArrayList<Book>)request.getAttribute("book") ;				// pwm.println("The book has been located in the database");
Iterator itr=bookList.iterator();
while(itr.hasNext()){
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
		<td><%=bookList.get(1).getTitle() %></td>
		<td><%=bookList.get(1).getAuthor() %></td>
		<td><%=bookList.get(1).getGenre() %></td>
		<td><%=bookList.get(1).getDescription()%></td>
		<td><%=bookList.get(1).getPublisher()%></td>
		<td><%=bookList.get(1).getCopies()%></td>
	</tr>

	<%
		}
	%>
</table>
<br>
<br>
<br>
</body>
</html>
