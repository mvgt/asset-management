package pkg;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.corba.se.pept.transport.Connection;

public class AssetDeallocate extends HttpServlet {
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Conn c = new Conn();
		java.sql.Connection con = c.getConnection();

		String bookId=request.getParameter("bookId");
		
		try {
			Statement stmt = con.createStatement();

			stmt.executeUpdate("update itemtable set status='available' where itemid='"+bookId+"'");
			System.out.println("Updated successfully!");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
