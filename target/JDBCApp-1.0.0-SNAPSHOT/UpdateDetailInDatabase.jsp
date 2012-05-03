<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UpdatedetailPage</title>
</head>
<h1>Welcome to the details updation page</h1>
<body>
<form action="UpdateDatabaseValue" method="post">Enter the id
whose detail you want to change:<input type="text" size="10"
	name="employeeId"><br>
Enter the username of the whose detail you want to change:<input
	type="text" size="25" name="employeeUsername"><br>
Enter the new password:<input type="text" size="30"
	name="employeePassword"><br>
Enter the new Email:<input type="text" size="100" name="employeeEmail"><br>
Enter the new country:<input type="text" size="20"
	name="employeeCountry"><br>
<input type="submit"></form>
</body>
</html>