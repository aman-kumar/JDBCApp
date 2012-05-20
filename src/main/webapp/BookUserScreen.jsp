<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.aman.librarymanagementsystem.*,java.sql.*,java.util.*,com.aman.domain.*"   %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Test</title>
</head>
<body>

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
	List<Book> bookList=(ArrayList<Book>)request.getAttribute("bookDetails");	
	//SSystem.out.println(bookList.size());
	Iterator<Book> itr=bookList.iterator();
		while (itr.hasNext() ) {
		   Book book=(Book)itr.next();
	%>
	<tr>
		<td width="15%"><%=book.getTitle() %></td>
		<td width="15%"><%=book.getAuthor()%></td>
		<td width="15%"><%=book.getGenre()%></td>
		<td width="15%"><%=book.getDescription()%></td>
		<td width="15%"><%=book.getPublisher()%></td>
		<td width="15%"><%=book.getCopies()%></td>
	</tr>
	<%
	}
	%>
 

	
</table>
</body>
</html>