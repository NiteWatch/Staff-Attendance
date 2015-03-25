package database_console;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try
		{
			String host = "OS-CASE-1.usd233.local";
			String uName = "adrian";
			String uPass = "flores";
			Connection con = DriverManager.getConnection(host, uName, uPass);
		}
		catch(SQLException error)
		{
			System.out.println(error.getMessage());
		}

	}

}
