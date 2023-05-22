<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Management Application Signup Page</title>
</head>
<body style="background-color: pink">
<form action="CustomerController" method="get" style="text-align:center">
<input type="hidden" name="action" value="signup">
<h1>
Customer Name <input type="text" name="custname">		<br>
Customer Address <input type="text" name="custaddress">		<br>
Customer Number <input type="text" name="custnumber">		<br>
Customer Balance <input type="text" name="custaccbalance">		<br>
Customer Gender  <br> Male <input type="radio" name="custgender" value="Male">		<br>
					Female <input type="radio" name="custgender" value="female">		<br>
Customer Date of birth <input type="text" name="custdob">		<br>				
Customer EmailId <input type="email" name="custemailid">		<br>
Customer Password <input type="password" name="custpassword">		<br>

<input type="submit" value="Signup">
<input type="reset" value="Clear">
</h1>
</form>
</body>
</html>