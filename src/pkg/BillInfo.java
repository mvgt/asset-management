package pkg;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BillInfo extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		
		
		System.out.println("agagtwertwertrwetadfg  : "+request.getAttribute("TransId").toString());
		HttpSession s = request.getSession();
		String a = s.getAttribute("TransId").toString();
		System.out.println(request.getAttribute("TransId : " + a));
	}

}
