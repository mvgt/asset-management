<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="pkg.Conn"%>
<%@page import="com.sun.xml.internal.bind.v2.schemagen.xmlschema.Import"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Due Asset</title>
</head>
<body>


	<%
		Conn c = new Conn();
		Statement stmt = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		String q1 = "select b.TransId, u.username,i.type, i.title, to_char(b.IssueDate) from usertable u, itemtable i, billtable b where (u.userid= b.userid) and (i.itemid= b.itemid) and (i.status='issued') and((months_between(sysdate,b.issuedate)) > 1)";
		String q2 = "select b.TransId, u.username,i.type, i.title, b.IssueDate from usertable u, itemtable i, billtable b where (u.userid= b.userid) and (i.itemid= b.itemid) and (i.status='issued') and((months_between(sysdate,b.issuedate)) > 1)";

		Connection con = c.getConnection();
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(q1);
		} catch (Exception e) {
			System.out.print("pramod asdad " + e);
		}
	%>



	<table border="2px">
		<tr>
			<td>Trans_Id</td>
			<td>Name</td>
			<td>Type</td>
			<td>Title</td>
			<td>Issue Date</td>
		</tr>
		<%
			while (rs.next()) {
		%>
		<tr>
			<td><%=rs.getString(1)%></td>
			<td><%=rs.getString(2)%></td>
			<td><%=rs.getString(3)%></td>
			<td><%=rs.getString(4)%></td>
			<td><%=rs.getString(5)%></td>
		</tr>
		<%
			}
		%>
	</table>

</body>
</html>