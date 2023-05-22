<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color: orange">

<form action="CustomerController" method="get">
<input type="hidden" name="action" value="signup">
<h1>
Customer Name<input type="text" name="custname"><br>
Customer Address<input type="text" name="custaddress"><br>
Contact Number<input type="text" name="custnumber"><br>
Customer Account Balance<input type="text" name="custaccbalance"><br>
Gender
<br>
Male<input type="radio" name="custgender" value="Male"><br>
Female<input type="radio" name="custgender" value="Female"><br>
Customer DOB<input type="text" name="custdob"><br>

Customer Email Id<input type="email" name="custemailid"><br>
Customer Password<input type="password" name="custpassword"><br>
</h1>
<input type="submit" value="SignUp">
</form>
</body>
</html>