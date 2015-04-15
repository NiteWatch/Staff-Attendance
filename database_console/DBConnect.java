package database_console;

import java.sql.*;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

public class DBConnect {

	public static void AddStaff(String firstName, String lastName, int idValue)
	{
		try{
			//insert data
			Connection con = DBConnect.getSQLConnection();
			String SQL = "INSERT INTO tbl_staff(teacher_id, first_name, last_name) " + "VALUES (" + idValue + ",'" +  firstName + "','" + lastName + "')";
			System.out.println(SQL);
			Statement stmt = con.createStatement();
			stmt.execute(SQL);
		}
		catch(SQLServerException e){
			System.out.println("Error");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	private static Connection getSQLConnection() throws SQLServerException
	{
		//set up login
		SQLServerDataSource ds = new SQLServerDataSource();
		ds.setIntegratedSecurity(false);
		ds.setServerName("OS-Case-1.usd233.local");
		ds.setDatabaseName("TSOS");
		ds.setUser("adrian");
		ds.setPassword("osfalcons15");
		return(ds.getConnection());
	}
}