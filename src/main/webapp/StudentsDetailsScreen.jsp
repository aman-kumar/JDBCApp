<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*,java.util.*,com.aman.librarymanagementsystem.*,com.aman.Jdbc.*,com.aman.dao.*,com.aman.domain.*,com.aman.service.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Details Screen</title>
</head>
<body>
<%!
List<Student> studentList=new ArrayList<Student>();

%>

<table border="2" bordercolor="black">
	<caption>
	<h4>Students details</h4>
	</caption>
	<tr>
	    <th width="15%">ID</th>
		<th width="15%">First Name</th>
		<th width="15%">Last Name</th>
		<th width="15%">Email Id</th>
		<th width="15%">Address</th>
		<th width="15%">Phone Number</th>

	</tr>
	<%
	studentList=(ArrayList<Student>)request.getAttribute("student");
	Iterator itr=studentList.iterator();
	while(itr.hasNext()){
	    Student student=(Student)itr.next();
	%>
	<tr>
	<td width="15%"><%=student.getStudentId()  %></td>
	<td width="15%"><%=student.getFirstName()  %></td>
		<td width="15%"><%=student.getLastName()%></td>
		<td width="15%"><%=student.getEmailId()  %></td>
		<td width="15%"><%=student.getAddress()%></td>
		<td width="15%"><%=student.getPhoneNumber()%></td>  
	</tr>
	<%
	}
	%>
</table>
</body>
</html>
