<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>

</head>
<body>
<form action="LoginServlet" method="post">
<table >
	<tr>Login Page</tr>
	<tr>
		<td>User Name</td>
		<td><input type="text" name="userName"></td>
	</tr>
	<tr>
		<td>Password</td>
		<td><input type="password" name="password"></td>
	</tr>
	<tr>
		<td><input type="submit" value="Submit"></td>
		<td><input type="reset" value="Reset"></td>
	</tr> 

</table>

  New Registration <a href="newregistration.jsp">click here</a>
</form>
</body>
</html>