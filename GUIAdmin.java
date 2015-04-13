import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

import database_console.DBConnect;

public class GUIAdmin extends JFrame{

	//server credentials
	private static final String USER = "admin";
	private static final String PASS = "osfalcons15";
	private static final String DB_URL = "OS-Case-1.usd233.local";
	private static final String DB_NAME=  "TSOS";
	
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
	private static final int WIDTH = 800;
	private static final int HEIGHT = 500;
	
	//create elements for database display
	protected DefaultListModel<String> attendanceInfo;
	private JScrollPane attendanceListScroll;
	private JList attendanceList;
	
	public GUIAdmin()
	{
		
		attendanceInfo = new DefaultListModel<String>();
		attendanceInfo.addElement("asdv ,..s,.admkxcn kladrhkfh gaerhgs");
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
		c2.setLayout(new GridLayout(1, 4));
		c2.add(eventLabel = new JLabel("Event"));
		c2.add(timeLabel = new JLabel("Time"));
		c2.add(dateLabel = new JLabel("Date"));
		c2.add(numberLabel = new JLabel("Number Attended"));
		
		//panel for information display
		JPanel c3 = new JPanel();
//		c3.setLayout(new GridBagLayout());
//		GridBagConstraints a = new GridBagConstraints();
//		a.fill = GridBagConstraints.BOTH;
//		a.weightx = 3;
//		a.gridwidth = 3;
//		a.weighty = 3;
//		a.gridx = 0;
//		a.gridy = 0;
		attendanceListScroll = new JScrollPane(attendanceList = new JList<String>(attendanceInfo));
//		c3.add(attendanceListScroll,a);
		c3.add(attendanceListScroll);
		
		//create table with data
		
		//add all created panels
		JPanel c = new JPanel(new FlowLayout());
		c.add(c1, BorderLayout.CENTER);
		//c.add(Box.createVerticalStrut(50));
		c.add(Box.createHorizontalStrut(70));
		c.add(c2, BorderLayout.EAST);
		c.add(Box.createHorizontalStrut(50));
		c.add(c3, BorderLayout.SOUTH);
		c.add(Box.createHorizontalStrut(30));
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
			
			String[] columnNames = {"First Name", "Last Name", "Event Type", "Time"};
			DefaultTableModel dtm = new DefaultTableModel(columnNames, 0);
			dtm.addColumn(9);
			
 			try
			{	
				SQLServerDataSource ds = new SQLServerDataSource();
				ds.setIntegratedSecurity(false);
				ds.setServerName(DB_URL);
				ds.setDatabaseName(DB_NAME);
				ds.setUser(USER);
				ds.setPassword(PASS);
				Connection con = ds.getConnection();
				
				//show if connection is established
		        if (con != null)
		        	System.out.println("Connection achieved");
		        
		        String SQL = "select first_name,last_name,event_id,time " +
		        		"from tbl_attendees a join tbl_staff s ON (a.teacher_id = s.teacher_id)";
	     		Statement stmt = con.createStatement();
	     		ResultSet rs = stmt.executeQuery(SQL);
	     		
	     		//Iterate through the data in the result set and display it.
	     		while (rs.next()) 
	     		{
	     			dtm.addRow(new Object[]{rs.getString(1),
	     									rs.getString(2),
	     									rs.getString(3)});
	     			
	     			
	     			//System.out.printf("%s\t%s\t%s\t%s\n",rs.getString(1),rs.getString(2),
	     			//		rs.getString(3),rs.getString(4));
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
		        
		        String SQL = "select * from tbl_attendees";
		        System.out.println(SQL);
	     		Statement stmt = con.createStatement();
	     		ResultSet rs = stmt.executeQuery(SQL);
	     		
	     		//Iterate through the data in the result set and display it.
	     		while (rs.next()) {
	     			System.out.printf("%s\t%s\t%s\t%s\n",rs.getString(1),rs.getString(2),
	     					rs.getString(3),rs.getString(4));
	     		}
	     		con.close();
			}
			
			catch(SQLException error)
			{
				System.out.println(error.getMessage());
			}
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
