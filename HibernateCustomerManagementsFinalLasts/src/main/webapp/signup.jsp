<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: tomato">
<form action="CustomerController" method="get" style="text-align: center">
<input type="hidden" name="action" value="signup">
<h1>
Customer Name<input type="text" name="custname"><br>
Customer Address<input type="text" name="custaddress"><br>
Customer Contact Number<input type="text" name="custnumber"><br>
Customer Account Balance<input type="text" name="custaccbalance"><br>
Customer DOB<input type="text" name="custdob"><br>
Customer Email Id<input type="text" name="custemailid"><br>
Customer Password<input type="password" name="custpassword"><br>
<input type="submit" value="SignUp">
</h1>
</form>
</body>
</html>