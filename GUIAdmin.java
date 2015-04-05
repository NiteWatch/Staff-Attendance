import java.util.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import database_console.DBConnect;

public class GUIAdmin {

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
	
	//set dimensions
	private static final int WIDTH = 300;
	private static final int HEIGHT = 300;
	
	public GUIAdmin()
	{
		//sets GUI title
		setTitle("Administrator Page");
		
		//panel for sidebar
		JPanel c1 = new JPanel();
		c1.setLayout(new GridLayout(3, 1));
		c1.add(sortB = new JButton("Sort"));
		c1.add(historyB = new JButton("History"));
		c1.add(newEventB = new JButton("New Event"));
		c1.add(editEventB = new JButton("Edit Event"));
		
		//panel for information labels
		JPanel c2 = new JPanel();
		c2.setLayout(new GridLayout(1, 4));
		c2.add(eventLabel = new JLabel());
		c2.add(timeLabel = new JLabel());
		c2.add(dateLabel = new JLabel());
		c2.add(numberLabel = new JLabel());
		
		//panel for information display
		
	}
	
	public static void main(String[] args) {
		GUIAdmin adminWindow = new GUIAdmin();

	}

}
