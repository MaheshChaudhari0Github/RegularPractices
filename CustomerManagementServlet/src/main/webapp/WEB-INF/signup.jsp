<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cust SignUp</title>
</head>
<body style="background-color: pink">

<form action="CustomerController" method="get">
<input type="hidden" name="action" value="signup">
<h1>
<label>Customer Id</label>
<input type="text" name="custid"><br>
<label>Customer Name</label>
<input type="text" name="custname"><br>
<label>Customer Address</label>
<input type="text" name="custaddress"><br>
<label>Customer Contact Number</label>
<input type="text" name="custnumber"><br>
<label>Customer Account Balance</label>
<input type="text" name="custaccbalance"><br>
<label>Customer Age</label>
<input type="text" name="custage"><br>
<label>Customer DOB</label>
<input type="text" name="custdob"><br>
<label>Customer Email</label>
<input type="text" name="custemailid"><br>
<label>Customer Password</label>
<input type="password" name="custpassword"><br>
</h1>
<input type="submit" value="SignUp">

</form>
</body>
</html>