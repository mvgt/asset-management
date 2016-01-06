package pkg;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteAsset extends HttpServlet 
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String assetId=request.getParameter("assetId");
		
		System.out.println("asset ID  : "+assetId);
		Conn c=new Conn();
		Connection con=c.getConnection();
		System.out.println("after Connection");
		try
		{
			Statement stmt=con.createStatement();
			
			stmt.executeUpdate("update itemtable SET Status='deleted' where itemid ='"+assetId+"'");
			System.out.println("Deleted Successfully!");
		}
		catch(Exception e)
		{System.out.println("exc in deletion ");}
		
		System.out.println("getting out of post");
	}

}
