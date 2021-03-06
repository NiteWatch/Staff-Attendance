import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import database_console.DBConnect;

public class IDWindow extends JFrame{

	//label titles
	private JLabel idLabel;
	
	//label textfields
	private JTextField idTF;
	
	//variables to handle events
	private idHandler IDHandler;

	//set dimensions
	private static final int WIDTH = 300;
	private static final int HEIGHT = 80;
	
	//variables
	public int idValue = 0;
	public int eventID = 0;
	
	public IDWindow(int eventIDNumber) 
	{
		//sets GUI design
		setTitle("ID Viewer");
		Container c = getContentPane();
		c.setLayout(new GridLayout(1, 3));
		
		//create label
		idLabel = new JLabel("ID", SwingConstants.CENTER);
		
		//create textbox
		idTF = new JTextField(10);
		
		//add components
		c.add(idLabel);
		c.add(idTF);
		
		//event handler
		IDHandler = new idHandler();
		
		//message observers
		idTF.addActionListener(IDHandler);
		
		//sets the special ID number
		eventID = eventIDNumber;
		
		//sets dimensions
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);	
	}
	
	private class idHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//obtain id number from text field
			idValue = Integer.parseInt(idTF.getText());
			idTF.selectAll();
			
			//connect to server
			DBConnect dbConnect = new DBConnect();
			//dbConnect.DBConnect("jbdc:sqlserver://OS-Case-1.usd233.local;database=TSOS;", "adrian;", "osfalcons15;",idValue,eventID);
		}
	}
	
	public static void main(String[] args) {
		IDWindow windowID = new IDWindow(0);
	}

}
