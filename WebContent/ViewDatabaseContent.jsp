<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DatabaseContent</title>

</head>
<%
	Integer id = (Integer) request.getAttribute("idvalue");
	String user = (String) request.getAttribute("uservalue");
	String userpassword = (String) request
			.getAttribute("userpasswordvalue");
	String useremail = (String) request.getAttribute("useremailvalue");
	String usercountry = (String) request
			.getAttribute("usercountryvalue");
%>
<body>

<h1>Here we will display the details of the Entered Id number in
the Form page</h1>
UserId:<%=id%><br>
UserName:<%=user%><br>
UserPassword:<%=userpassword%><br>
UserEmail:<%=useremail%><br>
UserCountry:<%=usercountry%><br>
</body>
</html>