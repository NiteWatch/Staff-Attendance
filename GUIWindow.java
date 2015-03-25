import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUIWindow extends JFrame{
	
	//label titles
	private JLabel idLabel;
	
	//label textfields
	private JTextField idTF;

	//set dimensions
	private static final int WIDTH = 500;
	private static final int HEIGHT = 80;
	
	//variable
	double idValue = 0;
	
	public GUIWindow() 
	{
		//sets GUI design
		setTitle("ID Viewer");
		Container c = getContentPane();
		c.setLayout(new GridLayout(1, 4));
		
		//create label
		idLabel = new JLabel("ID", SwingConstants.RIGHT);
		
		//create textbox
		idTF = new JTextField(10);
		
		//add components
		c.add(idLabel);
		c.add(idTF);
		
		//sets dimensions
		setSize(WIDTH, HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	
	}
	
	private class FahrHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//obtain id number from text field
			idValue = Double.parseDouble(idTF.getText());
		}
	}
	
	public static void main(String[] args) {
		WindowGUI window = new WindowGUI();

	}

}
