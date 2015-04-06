import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Box;
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
	private static final int WIDTH = 600;
	private static final int HEIGHT = 400;
	
	public GUIAdmin()
	{
		//sets GUI title
		setTitle("Administrator Page");
		
		//panel for sidebar
		JPanel c1 = new JPanel();
		//c1.setLayout(new GridLayout(4, 1));
		//c1.add(sortB = new JButton("Sort"));
		//c1.add(historyB = new JButton("History"));
		//c1.add(newEventB = new JButton("New Event"));
		//c1.add(editEventB = new JButton("Edit Event"));
		JButton editEventB = new JButton("Edit Event");
		//setSize(100, 40);
		setLocation(5, 35);
		c1.add(editEventB);
		
		//panel for information labels
		JPanel c2 = new JPanel();
		c2.setLayout(new GridLayout(1, 4));
		c2.add(eventLabel = new JLabel("Event"));
		c2.add(timeLabel = new JLabel("Time"));
		c2.add(dateLabel = new JLabel("Date"));
		c2.add(numberLabel = new JLabel("Number Attended"));
		
		//panel for information display
		
		//add all created panels
		JPanel c = new JPanel(new FlowLayout());
		c.add(c1, BorderLayout.EAST);
		c.add(Box.createHorizontalStrut(40));
		c.add(c2, BorderLayout.WEST);
		add(c);
		
		//add action listeners
		//sortB.addActionListener(new sortHandler());
		//historyB.addActionListener(new historyHandler());
		//newEventB.addActionListener(new newEventHandler());
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
