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
int copies;
%>
<table align="left" width="2" border="3" bordercolor="black">
	<tr>
	    <th width="15%">ID</th>
		<th width="15%">Book</th>
		<th width="15%">Author</th>
		<th width="15%">Publisher</th>
		<th width="15%">BookDescription</th>
		
		

	</tr>
	<% 
List<Book> bookList=(ArrayList<Book>)request.getAttribute("searchedBook") ;				// pwm.println("The book has been located in the database");
Iterator<Book> itr=bookList.iterator();
while(itr.hasNext()){
    Book book=(Book)itr.next();
%>
	
		<tr>
		<td width="15%"><%=book.getbookId() %></td>
		<td width="15%"><%=book.getName() %></td>
		<td width="15%"><%=book.getAuthor()%></td>
		<td width="15%"><%=book.getPublisher()%></td>
		<td width="15%"><%=book.getDescription()%></td>

		
	</tr>
	

	  
      <%
      //copies=book.getCopies();
    	}

	%>
	
</table>
<%
if(copies>1){
%>
<br><br><br>
The book can be issued<br><br>
<a href="issue.html">issueBook</a>
<%

}else{
%>
The book cannot be issued<br>
<%
}
%>
<br>
<br>
<br>
</body>
</html>
