<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register User</title>
</head>
<body>
<form action="registerUser" method="post">
	<pre>
	
		<h2>User Registration:</h2>
	
		First Name: <input type="text" name="firstName" id="firstName">
		Last Name: <input type="text" name="lastName" id="lastName">
		User Name: <input type="text" name="userName" id="userName">
		Password: <input type="password" name="password" id="password">
		Confirm Password: <input type="password" name="confirmPassword" id="confirmPassword">
		<br>
		<input type="submit" value="Register">
		
	</pre>
</form>

</body>
</html>