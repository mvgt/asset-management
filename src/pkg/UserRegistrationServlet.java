package pkg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserRegistrationServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String userName = request.getParameter("userName");
		String type = request.getParameter("type");
		String gender = request.getParameter("gender");
		String contact = request.getParameter("contact");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String pass1 = request.getParameter("pass1");
		String pass2 = request.getParameter("pass2");


		if (pass1.equals(pass2)) {
			Conn c = new Conn();
			Connection con = c.getConnection();

			try {
				if (type.equalsIgnoreCase("admin")) {
					Statement stmt = con.createStatement();
					int rownum=0;
					ResultSet rs=stmt.executeQuery("select rownum from admininfo");
					while(rs.next())
					{
						rownum=rs.getInt(1);
					}
					System.out.println("row num is : "+rownum);
					
					if(rownum==0)
					{
					stmt.executeUpdate("insert into adminInfo(USERNAME ,adminName, CONTACT ,EMAIL ,GENDER ,ADDRESS) "
							+ "values('"
							+ userName
							+ "','"
							+ name
							+ "','"
							+ contact
							+ "','"
							+ email
							+ "','"
							+ gender
							+ "','"
							+ address + "')");

					stmt.executeUpdate("insert into logintable values('"
							+ userName + "','" + pass1 + "','" + type + "')");
				}
					else
					{
						showMessage(request, response, "Admin already exist!!!");
					}
					
				} else {
					Statement stmt = con.createStatement();
					stmt.executeUpdate("insert into userTable(USERID,USERNAME,CONTACT,EMAIL,GENDER,ADDRESS,UNAME) values(concat('UI',to_Char(User_Seq.nextval)),'"
							+ userName
							+ "','"
							+ contact
							+ "','"
							+ email
							+ "','"
							+ gender
							+ "','"
							+ address
							+ "','"
							+ name
							+ "')");

					stmt.executeUpdate("insert into logintable values('"
							+ userName + "','" + pass1 + "','" + type + "')");
					showMessage(request, response, "User Registered Successfully!!!");
				}


			} catch (Exception e) {
				showMessage(request, response, "Exception : + "+e);
			}
		} else {
			showMessage(request, response, "Both password not match");
		}
	}
	
	void showMessage(HttpServletRequest request,HttpServletResponse response,String msg)
	{
		PrintWriter out=null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		out.println("<html>");
		out.println("<head>");
		out.println("<meta http-equiv='refresh' content='3;url=login.jsp' />");
		out.println("<title>asdf</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h4>"+msg+"</h4>");
		out.println("<p>For Login <a href='login.jsp'>click here</a></p>");
		out.println("</body>");
		out.println("</html>");
		
		
	}
}
