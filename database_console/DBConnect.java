package database_console;

import java.sql.*;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

public class DBConnect {

	public void DBConnect(String DB_URL, String uName, String uPass)
	
	{
		try
		{	
//			//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//			DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
//	        Connection con = DriverManager.getConnection(DB_URL, uName, uPass);
			
			SQLServerDataSource ds = new SQLServerDataSource();
			ds.setIntegratedSecurity(false);
			ds.setServerName("OS-Case-1.usd233.local");
			ds.setDatabaseName("TSOS");
			ds.setUser("adrian");
			ds.setPassword("osfalcons15");
			Connection con = ds.getConnection();
			
	        if (con != null)
	        	System.out.println("Connection achieved");
	            
     		// Create and execute an SQL statement that returns some data.
     		//String SQL = "INSERT INTO tbl_staff " + "VALUES(23456, 'Tim', 'Shipley', 4)";
	        String SQL = "SELECT * FROM tbl_staff";
     		Statement stmt = con.createStatement();
     		ResultSet rs = stmt.executeQuery(SQL);
     
     		// Iterate through the data in the result set and display it.
     		while (rs.next()) {
     			System.out.println(rs.getString(2) + " " + rs.getString(3));
     		}
     		
     		con.close();
		}
		
		catch(SQLException error)
		{
			System.out.println(error.getMessage());
		}
	}
	public static void main(String[] args) {
		
		
		DBConnect dbConnect = new DBConnect();
		dbConnect.DBConnect("jbdc:sqlserver://OS-Case-1.usd233.local;database=TSOS;", "adrian;", "osfalcons15;");
		
				
		//String DB_URL =  //;integratedSecurity=true";
		//String uName = "adrian";
		//String uPass = "flores";
		
		//Connection con = null;
		//Statement stmt = null;
		//ResultSet rs = null;
		
		
		
		
	}
}
