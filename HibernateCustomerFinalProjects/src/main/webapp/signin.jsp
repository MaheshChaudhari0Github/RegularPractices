<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Sign In</title>
</head>
<body style="background-color: pink">
<form action="CustomerController" method="get">
<input type="hidden" name="action" value="signin">
<h1>
Customer Email<input type="text" name="custemailid"><br>
Customer Password<input type="password" name="custpassword"><br>
<input type="submit" value="SignIn">
</h1>
</form>
</body>
</html>