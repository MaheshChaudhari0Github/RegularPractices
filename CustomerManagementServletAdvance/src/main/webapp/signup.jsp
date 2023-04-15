<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Sign Up</title>
</head>
<body style="background-color: yellow">
<form action="CustomerController" method="get">
<input type="hidden" name="action" value="signup">
<h1>
Customer Id <input type="text" name="custid"> <br>
Customer Name <input type="text" name="custname"> <br>
Customer Address <input type="text" name="custaddress"> <br>
Customer Contact Number<input type="text" name="custnumber"> <br>
Customer Account Balance <input type="text" name="custaccbalance"> <br>
Customer Age <input type="text" name="custage"> <br>
Customer Dob <input type="text" name="custdob"> <br>
Customer Email Id <input type="text" name="custemailid"> <br>
Customer Password <input type="password" name="custpassword"> <br>
</h1>
<input type="submit" value="SignUp">

</form>
</body>
</html>