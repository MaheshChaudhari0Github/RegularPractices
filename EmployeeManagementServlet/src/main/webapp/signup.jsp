<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee SignUp</title>
</head>
<body style="background-color: cyan">
<form action="EmployeeController" method="get" style="text-align: center">
<input type="hidden" name="action" value="signup">
<h1>
Employee Id <input type="text" name="empid"> <br> 
Employee Name <input type="text" name="empname"> <br>
Employee Address <input type="text" name="empaddress"> <br>
Employee Salary <input type="text" name="empsalary"> <br>
Employee EmailId <input type="text" name="empemailid"> <br>
Employee Password <input type="password" name="emppassword"> <br>
</h1>
<input type="submit" value="SignUp">
</form>
</body>
</html>