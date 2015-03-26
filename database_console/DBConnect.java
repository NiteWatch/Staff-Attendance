package database_console;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

	static final String JBDC_DRIVER = "com.mysql.jbdc.Driver";
	static final String DB_URL = "OS-CASE-1.usd233.local";
	
	static final String uName = "adrian";
	static final String uPass = "flores";
	
	public static void main(String[] args) {
		
		
		try
		{	
			Connection con = DriverManager.getConnection(DB_URL, uName, uPass);
		}
		catch(SQLException error)
		{
			System.out.println(error.getMessage());
		}

	}

}
