<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SignUp</title>
</head>
<body style="background-color: tomato">

<form action="CustomerController" method="get">

<input type="hidden" name="action" value="signin">


Email Id<input type="text" name="custemailid"><br>
Password<input type="password" name="custpassword"><br>


<input type="submit" value="SignIn">
</form>

</body>
</html>