package pkg;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pkg.Conn;


public class AssetAllocation extends HttpServlet {
	
   
  


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String itemid=request.getParameter("select");
		
		PrintWriter out=response.getWriter();
		out.print(itemid);
		Conn c=new Conn();
		Connection con=c.getConnection();
		ResultSet rs1=null;
		ResultSet rs2=null;
		int deposit;
		int rent;
		try
		{
			java.sql.Statement stmt=con.createStatement();
			java.sql.Statement stmt1=con.createStatement();
			java.sql.Statement stmt2=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from itemtable where itemid='"+itemid+"' and status='available' ");
			
			if(rs.next())
			{
				deposit=rs.getInt("price")*(rs.getInt("depositpercentage")/100);
				rent=rs.getInt("price")*(5/100);
				rs1=stmt.executeQuery("update itemtable set status='issued' where itemid='"+rs.getString("itemid")+"' ");
				rs2=stmt.executeQuery("insert into billtable values(bill.nextval,,'"+itemid+"',current_date,current_date+15,deposit,rent)");
			}
			else
			{
				out.print("Requested Book is not available");
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Database Error : "+e);
		}
	
	}
	

}
