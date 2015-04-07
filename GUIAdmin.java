import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

import database_console.DBConnect;

public class GUIAdmin extends JFrame{

	//label titles
	private JLabel firstNameLabel;
	private JLabel lastNamelabel;
	private JLabel eventLabel;
	private JLabel timeLabel;
	private JLabel dateLabel;
	private JLabel numberLabel;
		
	//label textfields
	private JTextField eventTF;
	private JTextField timeTF;
	private JTextField dateTF;
	
	//design buttons
	private JButton sortB;
	private JButton historyB;
	private JButton newEventB;
	private JButton editEventB;
	
	//variables to handle events
	private sortHandler sortHandler;
	private historyHandler historyHandler;
	private newEventHandler newEventHandler;
	private editEventHandler editEventHandler;
	
	//set dimensions
	private static final int WIDTH = 700;
	private static final int HEIGHT = 400;
	
	public GUIAdmin()
	{
		//sets GUI title
		setTitle("Administrator Page");
		
		//panel for sidebar
		JPanel c1 = new JPanel();
		c1.setLayout(new GridLayout(4, 1));
		c1.add(sortB = new JButton("Sort"));
		c1.add(historyB = new JButton("History"));
		c1.add(newEventB = new JButton("New Event"));
		c1.add(editEventB = new JButton("Edit Event"));
		
		//panel for information labels
		JPanel c2 = new JPanel();
		c2.setLayout(new GridBagLayout());
		c2.add(eventLabel = new JLabel("Event"));
		GridBagConstraints b = new GridBagConstraints();
		b.fill = GridBagConstraints.SOUTHWEST;
		b.weightx = 10;
		b.weighty = 10;
		b.gridx = 0;
		b.gridy = -2;
		c2.add(timeLabel = new JLabel("Time"));
		c2.add(dateLabel = new JLabel("Date"));
		c2.add(numberLabel = new JLabel("Number Attended"));
		
		//panel for information display
		
		//add all created panels
		JPanel c = new JPanel();
		c.setLayout(new GridBagLayout());
		GridBagConstraints a = new GridBagConstraints();
		a.fill = GridBagConstraints.SOUTHWEST;
		a.weightx = 10;
		a.weighty = 10;
		a.gridx = 0;
		a.gridy = -2;
		c.add(c1);
		
		//c.add(Box.createHorizontalStrut(40));
		//c.add(newEventB, Box.BOTTOM_ALIGNMENT);
		//c.add(c2, Box.LEFT_ALIGNMENT);
		add(c);
		
		//add action listeners
		sortB.addActionListener(new sortHandler());
		historyB.addActionListener(new historyHandler());
		newEventB.addActionListener(new newEventHandler());
		editEventB.addActionListener(new editEventHandler());
		
		//set dimensions
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationByPlatform(true);
		setVisible(true);
	}
	
	private class sortHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
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
		        
		        String SQL = "SELECT * FROM tbl_attendees ORDER BY teacher_id, time";
		        System.out.println(SQL);
	     		Statement stmt = con.createStatement();
	     		ResultSet rs = stmt.executeQuery(SQL);
	     		
	     	//Iterate through the data in the result set and display it.
	     		while (rs.next()) {
	     			System.out.println(rs.getString(3) + " " + rs.getString(1));
	     		}

	     		con.close();
			}
			
			catch(SQLException error)
			{
				System.out.println(error.getMessage());
			}
		}
	}
	
	private class historyHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			 
		}
	}
	
	private class newEventHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			 
		}
	}
	
	private class editEventHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			 
		}
	}
	
	public static void main(String[] args) {
		GUIAdmin adminWindow = new GUIAdmin();

	}

}
