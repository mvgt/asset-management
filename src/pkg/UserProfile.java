package pkg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserProfile extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Conn c = new Conn();
		Connection con = c.getConnection();
PrintWriter out=response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<link href='css/metro-bootstrap.css' rel='stylesheet'>");
		out.println("<link href='css/metro-bootstrap-responsive.css' rel='stylesheet'>");
		out.println("<title>Borrowed Details</title></head>");
		out.println("<body class='metro'>");
		
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
				int i = stmt.executeUpdate("update usertable set userName='"
						+ userName + "' ,gender='" + gender + "', uname='"
						+ fullName + "', address='" + address + "', contact='"
						+ contact + "', email='" + email + "'  where rownum=1");
				
				stmt.executeQuery("update logintable set password='"+pass1+"' where username='"+userName+"'");

				if (i != 0)
					out.println("<h2>Submitted Successfully</h2>");
			} catch (Exception e) {
				System.out.println(e);
			}
		} else {
			out.println("<h2>Confirm password Does not match</h2>");
		}
		out.println("</body>");
		out.println("</html>");
	}

}
