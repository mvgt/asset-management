<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New  User</title>
</head>
<body>
<form action="UserRegistrationServlet" method="post">
<h3 align="center">New User Registration</h3>
	<table>
		<tr>
			<td>Name</td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td>User Name</td>
			<td><input type="text" name="userName"></td>
		</tr>
		<tr>
			<td>Password : </td>
			<td><input type="password" name="pass1"></td>
		</tr>
		<tr>
			<td>Confirm Pass :</td>
			<td><input type="password" name="pass2"></td>
		</tr>
		<tr>
			<td>User Type</td>
			<td><select name="type">
				<option >--Select Type--</option>
				<option value="admin">Admin</option>
				<option value="user">User</option>
			</select> </td>
		</tr>
		<tr>
			<td>Gender</td>
			<td><input type="radio" name="gender" value="Male">Male
				<input type="radio" name="gender" value="Female">Female
			</td>
		</tr>
		<tr>
			<td>Mobile No.</td>
			<td><input type="text" name="contact"></td>
		</tr>
		<tr>
			<td>E-Mail</td>
			<td><input type="text" name="email"></td>
		</tr>
		<tr>
			<td>Address</td>
			<td><textarea name="address" rows="3"></textarea></td>
		</tr>
		<tr>
			<td><input type="submit" value="Submit"></td>
			<td><input type="reset" name="Reset"></td>
		</tr>
	</table>

</form>
</body>
</html>