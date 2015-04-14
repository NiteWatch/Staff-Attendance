import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

import database_console.DBConnect;

public class AddStaff extends JFrame{

	//server credentials
	private static final String USER = "admin";
	private static final String PASS = "osfalcons15";
	private static final String DB_URL = "OS-Case-1.usd233.local";
	private static final String DB_NAME=  "TSOS";
	
	//label titles
	private JLabel firstNameLabel;
	private JLabel lastNameLabel;
	private JLabel IDLabel;
	private JLabel passwordLabel;
	
	//label textfields
	private JTextField firstNameTF;
	private JTextField lastNameTF;
	private JTextField IDTF;
	private JTextField passwordTF;
	
	//design buttons
	private JButton enterB;
	private JButton clearB;
	
	//variables to handle events
	private enterHandler enterHandler;
	private clearHandler clearHandler;
	
	//set dimensions
	private static final int WIDTH = 500;
	private static final int HEIGHT = 300;
	
	//declare variables
	private	String firstName = "";
	private	String lastName = "";
	private	int idValue = 0;
	private	String passWord = "";
	
	public AddStaff()	
	{
		
		
		//sets GUI title
		setTitle("Administrator Page");
		
		//create textfields
		firstNameTF = new JTextField(50);
		lastNameTF = new JTextField(50);
		IDTF = new JTextField(6);
		passwordTF = new JTextField(30);
		
		//panel for labels and textfields 
		JPanel c1 = new JPanel();
		c1.setLayout(new GridLayout(4, 1));
		c1.add(firstNameLabel = new JLabel("First Name", SwingConstants.CENTER));
		c1.add(firstNameTF);
		c1.add(lastNameLabel = new JLabel("Last Name", SwingConstants.CENTER));
		c1.add(lastNameTF);
		c1.add(IDLabel = new JLabel("ID number", SwingConstants.CENTER));
		c1.add(IDTF);
		c1.add(passwordLabel = new JLabel("Password", SwingConstants.CENTER));
		c1.add(passwordTF);
		
		//panel for buttons
		JPanel c2 = new JPanel();
		c2.setLayout(new GridLayout(1, 1));
		c2.add(enterB = new JButton("Enter Staff Member"));
		c2.add(clearB = new JButton("Clear fields"));
		
		//add all created panels
		JPanel c = new JPanel(new GridLayout(2, 1));
		c.add(c1);
		c.add(c2);
		add(c);
		
		//event handler
		enterHandler = new enterHandler();
		clearHandler = new clearHandler();
		
		//sets dimensions
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private class enterHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//retrieve values
			firstName = firstNameTF.getText();
			System.out.print(firstName);
			/*lastName = lastNameTF.getText();
			System.out.println(lastName);
			idValue = Integer.parseInt(IDTF.getText());
			System.out.println(idValue);
			passWord = passwordTF.getText();
			System.out.println(passWord);*/
		}
	}
	
	private class clearHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			 firstName = firstName.
		}
	}
	
	public static void main(String[] args) {
		AddStaff staffAdditions = new AddStaff();

	}

}
