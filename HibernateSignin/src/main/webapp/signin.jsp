<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Employee MAnagement Application Sign In</title>
</head>
<body style="background-color: green">
<form action="EmployeeController" method="get">
<input type="hidden" name="action" value="signin">

Employee Email<input type="text" name="empemailid"><br>
Employee Password<input type="password" name="emppassword"><br>
<h1>
<input type="submit" value="SignIn">
</h1>
</form>
</body>
</html>