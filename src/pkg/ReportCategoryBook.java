package pkg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.corba.se.pept.transport.Connection;

public class ReportCategoryBook extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Conn c = new Conn();
		java.sql.Connection con = c.getConnection();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt
					.executeQuery("select distinct(title), subtype from itemtable where type='book' order by subtype");

			PrintWriter out = response.getWriter();

			out.println("<html>");
			out.println("<head>");
			out.println("<link href='css/metro-bootstrap.css' rel='stylesheet'>");
			out.println("<link href='css/metro-bootstrap-responsive.css' rel='stylesheet'>");
			out.println("<title>Category wise</title></head>");
			out.println("<body class='metro'>");
			out.println("<h2 align='center'><b>STOCK(BOOK)</b></h2>");

			out.println("<br>");
			out.println("<table class='table hovered'>");
			out.println("<thead>");
			out.println("<tr>");
			out.println("<th class='text-left'>SR NO.</th>");
			out.println("<th class='text-left'>TITLE</th>");
			out.println("<th class='text-left'>TYPE</th>");
			out.println("</tr>");
			out.println("</thead>");

			int i = 1;
			while (rs.next()) {
				out.println("<tr>");
				out.println("<td>" + i + "</td>");
				out.println("<td>" + rs.getString(1) + "</td>");
				out.println("<td>" + rs.getString(2) + "</td>");
				out.println("</tr>");
				i++;
			}

			out.println("</table>");
			out.println("</body>");
			out.println("</html>");

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
