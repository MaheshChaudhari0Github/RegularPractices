<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Management Application Sign Up </title>
</head>
<body style="background-color: gray">
<form action="EmployeeController" method="get">
<input type="hidden" name="action" value="signup">
<h1>
Employee Name<input type="text" name="empname"><br>
Employee Address<input type="text" name="empaddress"><br>
Employee Contact Number<input type="text" name="empnumber"><br>
Employee Email<input type="text" name="empemailid"><br>
Employee Password<input type="password" name="emppassword"><br>
<input type="submit" value="SignUp">
</h1>
</form>
</body>
</html>