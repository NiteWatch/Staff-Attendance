import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUIWindow extends JFrame{
	
	//label titles
	private JLabel idLabel;
	
	//label textfields
	private JTextField idTF;
	
	//variables to handle events
	private idHandler IDHandler;

	//set dimensions
	private static final int WIDTH = 300;
	private static final int HEIGHT = 80;
	
	public GUIWindow() 
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
		
		//sets dimensions
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);	
	}
	
	private class idHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//variable
			double idValue = 0;
			//obtain id number from text field
			idValue = Double.parseDouble(idTF.getText());
			System.out.println(idValue);
		}
	}
	
	public static void main(String[] args) {
		GUIWindow windowGUI = new GUIWindow();

	}

}
