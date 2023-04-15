<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up</title>
</head>
<body style="background-color: green">

<form action="CustomerController" method="get">

<input type="hidden" name="action" value="signup">
<div align="center">
<h1>
Id <input type="number" name="custid">  <br>
Name <input type="text" name="custname">  <br>
Address <input type="text" name="custaddress">  <br>
Number <input type="text" name="custnumber">  <br>
Balance <input type="text" name="custaccbalance">  <br>
Age <input type="text" name="custage">  <br>
Dob <input type="text" name="custdob">  <br>
Email Id <input type="text" name="custemailid">  <br>
Password <input type="password" name="custpassword">  <br>

<input type="submit" value="Sign Up">
</h1>
</div>
</form>
</body>
</html>