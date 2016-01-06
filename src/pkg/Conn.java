package pkg;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conn {

	private Connection con = null;

	public Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@10.34.226.106:1521:ORCL", "SQL_1",
					"Tech1");

			return con;
		} catch (Exception e) {
			System.out
					.println("exception in connetion class' Consutructor : \n"
							+ e);
			return con;
		}
	}

}
