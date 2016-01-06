package pkg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminProfileServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Conn c = new Conn();
		PrintWriter out=response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<link href='css/metro-bootstrap.css' rel='stylesheet'>");
		out.println("<link href='css/metro-bootstrap-responsive.css' rel='stylesheet'>");
		out.println("<title>Borrowed Details</title></head>");
		out.println("<body class='metro'>");
		
		
		Connection con = c.getConnection();

		String userName = request.getParameter("userName");
		String pass1 = request.getParameter("pass1");
		String pass2 = request.getParameter("pass2");
		String fullName = request.getParameter("fullName");
		String contact = request.getParameter("contact");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String gender=request.getParameter("gender");

		if (pass1.equals(pass2)) {
			try {
				java.sql.Statement stmt = con.createStatement();
				int i = stmt.executeUpdate("update adminInfo set userName='"
						+ userName + "' ,gender='" + gender + "', adminname='"
						+ fullName + "', address='" + address + "', contact='"
						+ contact + "', email='" + email + "'  where rownum=1");
				
				stmt.executeQuery("update logintable set password='"+pass1+"' where username='"+userName+"'");

				if (i != 0)
					out.println("<h2>submitted successfully!!!</h2>");
			} catch (Exception e) {
				out.println("<h2>Exception : "+e+"</h2>");
			}
		} else {
			out.println("<h2>Password does not match</h2>");
		}
		out.println("</body>");
		out.println("</html>");
	}

}
