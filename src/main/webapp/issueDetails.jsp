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

<table align="left" width="2" border="3" bordercolor="black">
	<tr>
		<th width="15%">BookTitle</th>
		<th width="15%">AuthorName</th>
		<th width="15%">BookGenre</th>
		<th width="15%">BookDescription</th>
		<th width="15%">Publisher</th>
		<th width="15%">CopiesOfBook</th>
		<th width="15%">firstName</th>
		<th width="15%">lastName</th>
		<th width="15%">emailId</th>
		<th width="15%">phoneNumber</th>
		<th width="15%">address</th>

	</tr>
	<% 
List<Book> bookList=(ArrayList<Book>)request.getAttribute("book") ;
	List<Student> studentList=(ArrayList<Student>)request.getAttribute("student");
	Iterator<Student> itrStudent=studentList.iterator();
Iterator<Book> itr=bookList.iterator();
while(itr.hasNext()){
    Book book=(Book)itr.next();
%>
	
		<tr>
		<td width="15%"><%=book.getTitle() %></td>
		<td width="15%"><%=book.getAuthor()%></td>
		<td width="15%"><%=book.getGenre()%></td>
		<td width="15%"><%=book.getDescription()%></td>
		<td width="15%"><%=book.getPublisher()%></td>
		<td width="15%"><%=book.getCopies()%></td>
	<%
}
while(itrStudent.hasNext()){
    Student student=(Student)itrStudent.next();
	%>
	<td width="15%"><%=student.getFirstName()%> </td>
	<td width="15%"><%=student.getLastName()%> </td>
	<td width="15%"><%=student.getEmailId()%></td>
	<td width="15%"><%=student.getAddress()%></td>
	<td width="15%"><%=student.getPhoneNumber()%></td>
	
	
		</tr>
	

	<%
}
	%>  
    	
</table>
<br><br><br>
<br>
<br>
<br>
</body>
</html>
