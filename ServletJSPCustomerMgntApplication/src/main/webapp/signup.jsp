<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SignUp</title>
</head>
<body style="background-color: green">

<form action="CustomerController" method="get">

<input type="hidden" name="action" value="signup">

Id<input type="number" name="custid"><br>
Name<input type="text" name="custname"><br>
Address<input type="text" name="custaddress"><br>
Contact Number<input type="text" name="custcontactnumber"><br>
Account Balance<input type="text" name="custaccountbalance"><br>
Age<input type="text" name="custage"><br>

DOB<input type="text" name="custdob"><br>
Email Id<input type="text" name="custemailid"><br>
Password<input type="password" name="custpassword"><br>


<input type="submit" value="SignUp">
</form>

</body>
</html>