<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="pkg.Conn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/metro-bootstrap.css" rel="stylesheet">
<link href="css/metro-bootstrap-responsive.css" rel="stylesheet">
<!-- Load JavaScript Libraries -->
    <script src="js/jquery/jquery.min.js"></script>
    <script src="js/jquery/jquery.widget.min.js"></script>
    <script src="js/jquery/jquery.mousewheel.js"></script>
    <script src="js/prettify/prettify.js"></script>

 <!-- Metro UI CSS JavaScript plugins -->
    <script src="js/jquery/metro.min.js"></script> 

 <!-- Metro UI CSS JavaScript plugins -->
    <script src="js/load-metro.js"></script>

<title>My Profile</title>
</head>
<body class="metro">

	<div class="span6 offset2">
		<%
			Conn c = new Conn();
			Connection con = c.getConnection();
			Statement stmt = con.createStatement();
			Statement stmt1 = con.createStatement();
			String uname = session.getAttribute("userName").toString();
			ResultSet rs = stmt.executeQuery("select * from adminInfo");
			ResultSet rs1 = stmt1.executeQuery("select password from logintable where userName='"+uname+"'");
			
			String pass="";
			while(rs1.next()){pass=rs1.getString(1);}
			
			while (rs.next()) {
		%>


		<form action="AdminProfileServlet" method="post">

			<fieldset>
				<legend>PROFILE</legend>

				<label>name</label>
				<div class="input-control text" data-role="input-control">
					<input type="text" name="fullName" value=<%=rs.getString(2)%>>
					<button class="btn-clear" tabindex="-1"></button>
				</div>
				<label>user id</label>
				<div class="input-control text" data-role="input-control">
					<input type="text" name="userName" value=<%=rs.getString(1)%>>
					<button class="btn-clear" tabindex="-1"></button>
				</div>


				<%
					String gend = rs.getString(5);
				%>
				<%
					if (gend.equals("Male")) {
				%>

				<label>sex</label>
				<div class="input-control radio margin10" data-role="input-control">
					<label> Male <input type="radio" name="gender" checked />
						<span class="check"></span> </label>
				</div>
				<div class="input-control radio margin10" data-role="input-control">
					<label> Female <input type="radio" name="gender" /> <span
						class="check"></span> </label>
				</div>

				<%
					}
						if (gend.equals("Female")) {
				%>


				<div class="input-control radio margin10" data-role="input-control">
					<label> Male <input type="radio" name="gender" /> <span
						class="check"></span> </label>
				</div>
				<div class="input-control radio margin10" data-role="input-control">
					<label> Female <input type="radio" name="gender" checked />
						<span class="check"></span> </label>
				</div>

				<%
					}
				%>

				<label>password</label>
				<div class="input-control password" data-role="input-control">
					<input type="password" name="pass1" value="<%=pass%>" autofocus>
					<button class="btn-reveal" tabindex="-1"></button>
				</div>



				<label>confirm password</label>
				<div class="input-control password" data-role="input-control">
					<input type="password" name="pass2" value="<%=pass%>" placeholder="type password"
						autofocus>
					<button class="btn-reveal" tabindex="-1"></button>
				</div>


				<label>phone</label> <input type="tel" name="contact"
					value=<%=rs.getString(3)%> data-transform="input-control" /> <label>email</label>
				<input type="email" name="email" value=<%=rs.getString(4)%>
					data-transform="input-control" /> <label>address</label>
				<div class="input-control textarea" 
					 data-role="input-control">
					<textarea name="address"><%=rs.getString(6)%></textarea></div>

					</br> <input type="submit" value="SUBMIT"> <input type="submit"
						value="CLEAR">
			</fieldset>

		</form>
		<%
			}
		%>
	</div>
</body>
</html>