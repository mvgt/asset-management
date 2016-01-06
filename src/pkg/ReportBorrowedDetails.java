package pkg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ReportBorrowedDetails extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Conn c = new Conn();
		Connection con = c.getConnection();
System.out.println("hey pramod, borrowed is called:)");
		
		try {

			Statement stmt = con.createStatement();
			ResultSet rs = stmt
					.executeQuery("SELECT U.uname,U.EMAIL,I.ITEMID,I.TITLE,to_char(B.ISSUEDATE),to_char(B.RETURNDATE),B.PAIDAMMOUNT, b.fine FROM billtable B, itemtable I, usertable U WHERE (b.userName= u.userName) AND (b.itemid= i.itemid) ");

			PrintWriter out=response.getWriter();
			
			out.println("<html>");
			out.println("<head>");
			out.println("<link href='css/metro-bootstrap.css' rel='stylesheet'>");
			out.println("<link href='css/metro-bootstrap-responsive.css' rel='stylesheet'>");
			out.println("<title>Borrowed Details</title></head>");
			out.println("<body class='metro'>");
			out.println("<h2 align='center'><b>BORROWED TABLE</b></h2>");
			out.println("<br>");

			out.println("<table class='table hovered'>");
			out.println("<thead>");
			out.println("<tr>");
			out.println("<th class='text-left'>SR NO.</th>");
			out.println("<th class='text-left'>NAME</th>");
			out.println("<th class='text-left'>EMAIL</th>");
			out.println("<th class='text-left'>ITEM ID</th>");
			out.println("<th class='text-left'>TITLE</th>");
			out.println("<th class='text-left'>ISSUE DATE</th>");
			out.println("<th class='text-left'>RETURN DATE</th>");
			out.println("<th class='text-left'>AMT(INT)</th>");
			out.println("<th class='text-left'>FINE</th>");
			out.println("</tr>");
			out.println("</thead>");

			int i=1;
			while(rs.next())
			{
				out.println("<tr>");
				out.println("<td>"+i+"</td>");
				out.println("<td>"+rs.getString(1)+"</td>");
				out.println("<td>"+rs.getString(2)+"</td>");
				out.println("<td>"+rs.getString(3)+"</td>");
				out.println("<td>"+rs.getString(4)+"</td>");
				out.println("<td>"+rs.getString(5)+"</td>");
				out.println("<td>"+rs.getString(6)+"</td>");
				out.println("<td>"+rs.getString(7)+"</td>");
				out.println("<td>"+rs.getString(8)+"</td>");
				out.println("</tr>");
				i++;
			}

			out.println("</table>");
			out.println("</body>");
			out.println("</html>");
			
			
			

			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
