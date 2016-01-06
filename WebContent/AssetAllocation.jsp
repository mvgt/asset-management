<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
      <%@page import="java.sql.*" %>
      <%@page import="pkg.*" %>
      <%	
      			
      		String category=request.getParameter("select1");
      		String subcategory=request.getParameter("select2");
      		
      		
      		ResultSet rs=null;
      		ResultSet rs1=null;
      		ResultSet rs2=null;
		
			Conn c=new Conn();
			Connection con=c.getConnection();
		
		try
		{
			Statement stmt=con.createStatement();
			Statement stmt1=con.createStatement();
			Statement stmt2=con.createStatement();
			
			rs2=stmt2.executeQuery(" select * from itemtable where type='"+category+"' and subtype='"+subcategory+"' ");
			
			
			rs=stmt.executeQuery("select category_name from category ");
			rs1=stmt1.executeQuery("select subtype from subcategory ");
			
		}
		catch(Exception e)
		{
			System.out.println("Database Error : "+e);
		}
	
	 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script type="text/javascript" language="javascript">
	
		function search()
		{
			var f=document.form;
			f.method="post";
			f.action='allocation1.jsp';
			f.submit();
		}
		function confirm()
		{
			var f1=document.form;
			f1.method="get";
			f1.action='confirmissue';
			
			f1.submit();
		}
	</script>
<body>
<form name="form" >
<table>
		<table>
			<tr>
			<td><select name="select1" >
								
								<%
									while(rs.next())
									{
									%>
								<option ><%=rs.getString("category_name") %></option>
								<% 
								
								 }
								 %>
						</select>
						</td>
							<td>
							<select name="select2"  >
								
								<%
									while(rs1.next())
									{
									
									%>
									<option ><%=rs1.getString("subtype") %></option>
								 <% 
								 }
								 %>
							</select>
						</td>
						<td><input type="submit" value="Search" onclick="search();"></td>
						</tr>
						
		</table>
		<table border="1">
		<%
						while(rs2.next())
									{
									
								
									%>
										<tr>
											<td><%=rs2.getString("itemid") %></td>
											<td><%=rs2.getString("type") %></td>
											<td><%=rs2.getString("title") %></td>
											<td><%=rs2.getString("status") %></td>
											<td><%=rs2.getInt("depositpercentage") %></td>
											<td><%=rs2.getInt("price") %></td>
											<td><%=rs2.getString("subtype") %></td>
											<td><%=rs2.getString("vendorname") %></td>
											<td><%=rs2.getDate("purchasedate") %></td>
											
											<td>
												<input type="radio" name="select" value="<%=rs2.getString("itemid") %>" />
												
											</td>
										</tr>	
									<%
									}
									%>
									
									<input type="submit" value="Confirm Issue"  onclick="confirm();" >
								
								
		</table>
</table>
</form>
</body>
</html>