package database_console;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.microsoft.sqlserver.jdbc.SQLServerResultSet;

public class DBConnect {

	static final String JBDC_DRIVER = "";
	static final String DB_URL = "jbdc:sqlserver//OS-CASE-1.usd233.local/events";
	
	static final String uName = "adrian";
	static final String uPass = "flores";
	
	public static void main(String[] args) {
		
		
		try
		{	
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	         Connection con = DriverManager.getConnection(DB_URL, uName, uPass);
			//Driver myDriver = new com.microsoft.sqlserver.jdbc.SQLServerDriver();
			//DriverManager.registerDriver(arg0)
			
		}
		catch(SQLException error)
		{
			System.out.println(error.getMessage());
		}

	}

}
