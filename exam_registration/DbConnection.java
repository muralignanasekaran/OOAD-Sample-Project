package exam_registration;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection 
{
	private static String url="jdbc:oracle:thin:@localhost:1522/orcl";
	public static Connection getConnection() throws Exception
	{
		Class.forName ("oracle.jdbc.OracleDriver");
		Connection con=DriverManager.getConnection(url,"system","murali");
		return con;
	}

}
