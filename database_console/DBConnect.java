package database_console;

import java.lang.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import java.sql.DatabaseMetaData;
import com.microsoft.sqlserver.jdbc.SQLServerResultSet;

public class DBConnect {

	public static void main(String[] args) {
		
		String DB_URL = "jbdc:sqlserver://OS-Case-1.usd233.local:1433;database=TSOS;integratedSecurity=true";
		String uName = "adrian";
		String uPass = "flores";
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try
		{	
			//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
	        con = DriverManager.getConnection(DB_URL, uName, uPass);
	        if (con != null)
	        	System.out.println("Connection achieved");
	            
     		// Create and execute an SQL statement that returns some data.
     		String SQL = "SELECT TOP 10 * FROM tbl_staff";
     		stmt = con.createStatement();
     		rs = stmt.executeQuery(SQL);
     
     		// Iterate through the data in the result set and display it.
     		while (rs.next()) {
     			System.out.println(rs.getString(4) + " " + rs.getString(6));
     		}
     		
     		con.close();
		}
		
		catch(SQLException error)
		{
			System.out.println(error.getMessage());
		}
		
		
	}
}
