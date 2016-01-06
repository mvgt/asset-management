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

public class AddAssetServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Conn c = new Conn();
		
		Connection con = c.getConnection();
		PrintWriter out=response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<link href='css/metro-bootstrap.css' rel='stylesheet'>");
		out.println("<link href='css/metro-bootstrap-responsive.css' rel='stylesheet'>");
		out.println("<title>Borrowed Details</title></head>");
		out.println("<body class='metro'>");
		
		try {
			Statement stmt = con.createStatement();

			String type = request.getParameter("type");
			String subType = request.getParameter("subType");
			String assetName = request.getParameter("assetName");
			String purchaseDate = request.getParameter("purchaseDate");
			String vendorName = request.getParameter("vendorName");
			String depositPercent = request.getParameter("depositPercent");
			String price = request.getParameter("price");
			String quantity = request.getParameter("quantity");

			for (int i = 1; i <= Integer.parseInt(quantity); i++) {
				stmt.executeUpdate("insert into ItemTable(ITEMID,TYPE,TITLE ,STATUS ,DEPOSITPERCENTAGE ,PRICE, SUBTYPE,VENDORNAME ,PURCHASEDATE) values(concat('II',to_Char(Asset_Seq.nextval)),'"
						+ type
						+ "','"
						+ assetName
						+ "','available',"
						+ depositPercent
						+ ","
						+ price
						+ ",'"
						+ subType
						+ "','"
						+ vendorName + "','" + purchaseDate + "')");

				out.println("<h2>Submitted Successfully</h2>");
			}
		} catch (Exception e) {
			out.println("<h2>exception in addassetservlet : " + e+"</h2>");
		}
		out.println("</body>");
		out.println("</html>");
	}

}
