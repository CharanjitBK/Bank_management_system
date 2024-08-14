package atmsimulator;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;


public class Login extends JFrame implements ActionListener
{
	
	JTextField cardTextField; // To make the text fields global
	JButton login, signup, clear;     // To make the button global, so that it can accessed outside the constructor
	JPasswordField pinTextField;
	Login(){
		setTitle("AUTOMATED TELLER MACHINE");
		
		setLayout(null);          // To create custom layout we need to set the layout provided by swing as null
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/logo.jpg")); // add image from the file to the frame
		Image i2 = i1.getImage().getScaledInstance(100,  100,  Image.SCALE_DEFAULT);     // Used to scale the images
		ImageIcon i3 = new ImageIcon(i2);       // ImageIcon can be used in JLabel but image can not be used hence we need to convert the image to ImageIcon 
		JLabel label = new JLabel(i3);          // JLabel is used to content on to the frame
		
		label.setBounds(70, 10, 100, 100);    // to set the image to given coordinates from origin
		add(label);
		
		JLabel text = new JLabel("Welcome to ATM");
		text.setFont(new Font("Osward",Font.BOLD, 38)); // It is used to set the font size and font style
		text.setBounds(200, 40, 400, 40); // As the default layout is set to null, the setBounds() is specify the coordinates where the text has to be placed 
 		add(text);
 		
		JLabel cardno = new JLabel("Card No:");            // It is used to add labels
		cardno.setFont(new Font("Raleway",Font.BOLD, 28)); // It is used to set the font size and font style
		cardno.setBounds(120, 150, 150, 30); // As the default layout is set to null, the setBounds() is specify the coordinates where the text has to be placed 
 		add(cardno);
 		
 		cardTextField = new JTextField();     // It is used text fields
 		cardTextField.setBounds(300, 150, 230, 30);
 		cardTextField.setFont(new Font("Arial", Font.BOLD, 14));   // 
 		add(cardTextField);
 		
		JLabel pin = new JLabel("PIN:");
		pin.setFont(new Font("Raleway",Font.BOLD, 28)); // It is used to set the font size and font style
		pin.setBounds(120, 220, 250, 30); // As the default layout is set to null, the setBounds() is specify the coordinates where the text has to be placed 
 		add(pin);
 		
 		pinTextField = new JPasswordField();      // Used to add password field
 		pinTextField.setBounds(300, 220, 230, 30);
 		add(pinTextField);
 		
 		login = new JButton("LOG IN");            // Used to add buttons on the frames
 		login.setBounds(300, 300, 90, 40);
 		login.setBackground(Color.BLACK);     // To set the button background to black
 		login.setForeground(Color.WHITE);     // To set the font to white 
 		login.addActionListener(this);
 		add(login);
 		
 		clear = new JButton("CLEAR");
 		clear.setBounds(430, 300, 90, 40);
 		clear.setBackground(Color.BLACK);     // To set the button background to black
 		clear.setForeground(Color.WHITE);     // To set the font to white 
 		clear.addActionListener(this);
 		add(clear);
 		
 		signup = new JButton("SIGN UP");
 		signup.setBounds(300, 350, 220, 40);
 		signup.setBackground(Color.BLACK);     // To set the button background to black
 		signup.setForeground(Color.WHITE);     // To set the font to white 
 		signup.addActionListener(this);
 		add(signup);
 		
 		
 		
		getContentPane().setBackground(Color.WHITE);
		
		setSize(800,480);   //It is used to set the size of the frame to the given size
		setVisible(true);   // By default the visibility is false and the frames is not visible, by making it true the frames is made visible
		setLocation(350,200);   // The frames opens at the top left corner(i.e., the origin) these sets the frame to given coordinates
	}
	
	public void actionPerformed(ActionEvent ae) 
	{
		if(ae.getSource() == clear)  // getSource is used to get the button on which the user has clicked. 
	    //perform the actions the as per the button clicked is done
		{
			cardTextField.setText("");      // Used to set a text when the button is clicked
			pinTextField.setText("");       // As the button is clear, the setText is left without text i.e., null   
		}
		else if(ae.getSource() == login)
		{
			Conn conn = new Conn();                        // To establish connection with the database
			String cardnumber = cardTextField.getText();      // To retrieve the cardnumber and from the textfield
			String pinnumber = pinTextField.getText();        // TO retrieve the pin number from the text fields
			String query = "select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"'";
			try {
				ResultSet rs = conn.s.executeQuery(query);  
				//This line executes the SQL query stored in the query string. The executeQuery method 
				//of the Statement object (conn.s) sends the SQL query to the database.
				if(rs.next()) 
				{
					//The rs.next() method moves the cursor to the next row of the 
					//ResultSet. Initially, the cursor is positioned before the first row.
					//If the ResultSet is not empty (i.e., the query returned at least one row), 
					//rs.next() will return true, and 
					//the code inside the if block will be executed. If no rows are returned, rs.
					//next() returns false, and the code inside the else block will be executed.
					setVisible(false);
					new Transactions(pinnumber).setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null,"Incorrect card Number orPin");
				}
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
		else if(ae.getSource() == signup)
		{
			setVisible(false);                    // To set the visibility of the login page false, so it closes as soon as the signup button is clicked
			new Signupone().setVisible(true);     // To set the visibility of the signup page true, so the page opens as soon as the signup button is clicked
			
		}		
	}

public static void main(String[] args) 
	{
		new Login();
	}
}
