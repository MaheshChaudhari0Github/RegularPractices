<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Sign Up</title>
</head>
<body style="background-color: green">
<form action="CustomerController" method="get" style="text-align: center">
<input type="hidden" name="action" value="signup">
<h1>
Customer Name<input type="text" name="custname"><br>
Customer Address<input type="text" name="custaddress"><br>
Customer Contact Number<input type="text" name="custnumber"><br>
Customer Account Balance<input type="text" name="custaccountbalance"><br>
DOB<input type="text" name="custdob"><br>
Email<input type="text" name="custemailid"><br>
Password<input type="password" name="custpassword"><br>
<input type="submit" value="SignUp">
</h1>
</form>
</body>
</html>