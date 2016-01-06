<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%
	String uname = session.getAttribute("userName").toString();
	if (uname == "") {
response.sendRedirect("login.jsp");
	}
%>

</head>
<body>
	<form>
		<table>
			<tr>
				<td>
					<select>
							<option >----Type----</option>
							<option name="type" value="books">Books</option>
							<option name="type" value="electronics">Electronics</option>
					</select>
				</td>
				<td>
					<input type="submit" value="Search">
				</td>
			</tr>
		</table>
	</form>


		<table>
			<tr>
				<td>
					<select>
							<option >----Type----</option>
							<option name="books">Books</option>
							<option name="electronics">Electronics</option>
					</select>
				</td>
				<td>
					<input type="submit" value="Search">
				</td>
			</tr>
		</table>




	
</body>
</html>