package database_console;

import java.sql.*;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

public class DBConnect {

	public void DBConnect(String DB_URL, String uName, String uPass,int teacherID,int eventID)
	
	{
		try
		{	
			SQLServerDataSource ds = new SQLServerDataSource();
			ds.setIntegratedSecurity(false);
			ds.setServerName("OS-Case-1.usd233.local");
			ds.setDatabaseName("TSOS");
			ds.setUser("adrian");
			ds.setPassword("osfalcons15");
			Connection con = ds.getConnection();
			
			//show if connection is established
	        if (con != null)
	        	System.out.println("Connection achieved");
	        
	        String SQL = "INSERT INTO tbl_attendees(teacher_id,event_id) " + "VALUES (" + teacherID + "," + eventID + ")";
	        System.out.println(SQL);
     		Statement stmt = con.createStatement();
     		ResultSet rs = stmt.executeQuery(SQL);
     
     		// Iterate through the data in the result set and display it.
     		//while (rs.next()) {
     		//	System.out.println(rs.getString(2) + " " + rs.getString(3));
     		//}
     		
     		con.close();
		}
		
		catch(SQLException error)
		{
			System.out.println(error.getMessage());
		}
	}
	public static void main(String[] args) {
		
		//define server location
		DBConnect dbConnect = new DBConnect();
		//dbConnect.DBConnect("jbdc:sqlserver://OS-Case-1.usd233.local;database=TSOS;", "adrian;", "osfalcons15;",0,0);
	}
}
