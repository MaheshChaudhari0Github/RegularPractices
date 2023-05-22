<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Management Application SignIn Page</title>
</head>
<body style="background-color: gray">
<%
    if(null!=request.getAttribute("message"))
    {
        out.println(request.getAttribute("message"));
    }
%>
<form action="CustomerController" method="get" style=""> 
<input type="hidden" name="custemailid" value="signin">	<br>
<h1>
Customer EmailId <input type="email" name="custemailid">		<br>
Customer Password <input type="password" name="custpassword">		<br>
<input type="submit" value="SignIn">
</h1>
</form>
</body>
</html>