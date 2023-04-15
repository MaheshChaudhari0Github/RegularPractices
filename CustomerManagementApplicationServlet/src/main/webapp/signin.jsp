<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign In</title>
</head>
<body style="background-color: tomato">

<form action="CustomerController" method="get">
<div align="center"> <h1>
<input type="hidden" name="action" value="signin"> 
Email Id <input type="text" name="custemailid"> <br> 
Password <input type="password" name="custpassword"> <br> 
<input type="submit" value="Sign In">
</h1>
</div>
</form>
</body>
</html>