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
String status;
%>
<table align="left" width="2" border="3" bordercolor="black">
	<tr>
	    <th width="15%">BookRecordId</th>
		<th width="15%">BookId</th>
		<th width="15%">Status</th>
		<th width="15%">StudentId</th>
	</tr>
	<% 
List<Record> recordList=(ArrayList<Record>)request.getAttribute("searchedBook") ;				// pwm.println("The book has been located in the database");
Iterator<Record> itr=recordList.iterator();
while(itr.hasNext()){
    Record  record=(Record)itr.next();
%>
	
		<tr>
		<td width="15%"><%=record.getBookRecord() %></td>
		<td width="15%"><%=record.getBookId() %></td>
		<td width="15%"><%=record.getStatus() %></td>
		<td width="15%"><%=record.getStudentId() %></td>
	</tr>
	

	  
      <%
      //copies=book.getCopies();
      status=record.getStatus();
    	}

	%>
	
</table>
<%
if(status == "available"){
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
