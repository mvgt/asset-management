package pkg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReportOverDue extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Conn c = new Conn();
		Statement stmt = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		String q = "select b.TransId, u.username,i.type, i.title, TO_CHAR(b.IssueDate) from usertable u, itemtable i, billtable b where (u.userName= b.userName) and (i.itemid= b.itemid) and (i.status='issued') and((months_between(sysdate,b.issuedate)) > 1)";

		Connection con = c.getConnection();
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(q);
			
			PrintWriter out=response.getWriter();
			
			
			
			out.println("<html>");
			out.println("<head>");
			out.println("<link href='css/metro-bootstrap.css' rel='stylesheet'>");
			out.println("<link href='css/metro-bootstrap-responsive.css' rel='stylesheet'>");
			out.println("<title>Category wise</title></head>");
			out.println("<body class='metro'>");
			out.println("<h2 align='center'><b>OVER DUE TABLE</b></h2>");
			out.println("<br>");

			out.println("<table class='table hovered'>");
			out.println("<thead>");
			out.println("<tr>");
			out.println("<th class='text-left'>SR NO.</th>");
			out.println("<th class='text-left'>TRANS_ID</th>");
			out.println("<th class='text-left'>USERNAME</th>");
			out.println("<th class='text-left'>TYPE</th>");
			out.println("<th class='text-left'>TITLE</th>");
			out.println("<th class='text-left'>ISSUE DATE</th>");
			out.println("</tr>");
			out.println("</thead>");
			int i=1;
			while (rs.next()) 
				{
					out.println("<tr>");
					out.println("<td>"+i+"</td>");
					out.println("<td>"+rs.getString(1)+"</td>");
					out.println("<td>"+rs.getString(2)+"</td>");
					out.println("<td>"+rs.getString(3)+"</td>");
					out.println("<td>"+rs.getString(4)+"</td>");
					out.println("<td>"+rs.getString(5)+"</td>");
					out.println("</tr>");
					i++;
				}
				out.println("</table>");
				out.println("</body>");
				out.println("</html>");
	
		}
		catch (Exception e) 
		{
			System.out.print("pramod asdad " + e);
		}

	}
}
