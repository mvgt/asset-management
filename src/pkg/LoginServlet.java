package pkg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String uName = request.getParameter("userName");
		String uPass = request.getParameter("password");
		String uName1 = "", uPass1 = "", designation1 = "";

		PrintWriter out = response.getWriter();

		Conn c = new Conn();
		Connection con = c.getConnection();

		out.println("<html>");
		out.println("<head>");
		out.println("<meta http-equiv='refresh' content='1;url=login.html' />");
		out.println("<link href='css/metro-bootstrap.css' rel='stylesheet'>");
		out.println("<link href='css/metro-bootstrap-responsive.css' rel='stylesheet'>");
		out.println("<title>Login</title></head>");
		out.println("<body class='metro'>");

		try {
			java.sql.Statement stmt = con.createStatement();
			ResultSet rs = stmt
					.executeQuery("select * from logintable where username='"
							+ uName + "'");

			while (rs.next()) {
				uName1 = rs.getString(1);
				uPass1 = rs.getString(2);
				designation1 = rs.getString(3);
				}

				if (uName.equals(uName1) && designation1.equals("admin")) {
					if (uPass.equals(uPass1)) {
						HttpSession session = request.getSession(true);
						session.setAttribute("userName", uName);

						// response.sendRedirect("welcomeadmin.jsp");
						response.sendRedirect("AdminHome.html");
					} else {
						out.println("<h2>Wrong Password!</h2>");
					}
				} else if (uName.equals(uName1) && designation1.equals("user")) {
					if (uPass.equals(uPass1)) {
						HttpSession session = request.getSession(true);
						session.setAttribute("userName", uName);

						response.sendRedirect("userHome.jsp");
					} else {
						out.println("<h2>Wrong Password!!</h2>");
					}
				} else if(!uName.equals(uName1)){
					out.println("<h2>Wrong userName!</h2>");
				}
			

		} catch (Exception e) {
			out.println("<h2>Exception " + e + "</h2>");
		}

		out.println("</body>");
		out.println("</html>");
	}

}
