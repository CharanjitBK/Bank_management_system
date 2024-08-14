package atmsimulator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.SQLException;




public class Withdraw extends JFrame implements ActionListener
{
	JTextField amount;
	JButton withdraw, back;
	String pinnumber;
	Withdraw(String pinnumber)
	{
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/atm.jpg")); // add image from the file to the frame
		Image i2 = i1.getImage().getScaledInstance(900,  900,  Image.SCALE_DEFAULT);     // Used to scale the images
		ImageIcon i3 = new ImageIcon(i2);       // ImageIcon can be used in JLabel but image can not be used hence we need to convert the image to ImageIcon 
		JLabel image = new JLabel(i3);          // JLabel is used to content on to the frame
		
		image.setBounds(0, 0, 900, 900);
		add(image);
		
		JLabel text = new JLabel("Enter the amount to withdraw");
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System", Font.BOLD, 16));
		text.setBounds(170, 300, 400, 20);
		image.add(text);
		
		amount = new JTextField();
		amount.setFont(new Font("Raleway", Font.BOLD, 22));
		amount.setBounds(170, 350, 320, 20);
		image.add(amount);                              //As we want to add amount text field on the image
		
		// JButton named deposit, back are created
		// ActionListener is added to these button using `.addActionListener(this)` 
		// class implements 'ActionListener' and overrides the 'ActionPerformed' method to define the action that should occur when the button is clicked.
		// when withdraw button is clicked, it triggers the 'actionPerformed' method, which prints a message to the console
		
		withdraw = new JButton("Withdraw");
		withdraw.setBounds(355, 455, 150, 30);
		withdraw.addActionListener(this);
		image.add(withdraw);
		
		back = new JButton("Back");
		back.setBounds(355, 490, 150, 30);
		back.addActionListener(this);
		image.add(back); 
		
		
 		
		
		setSize(900, 900);
		setLocation(300,0);
		setVisible(true);
		
		
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == withdraw) 
		{
			String number = amount.getText();
			Date date = new Date();
			if(number.equals("")) {
				JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");
			}else {
				Conn conn = new Conn();
				String query = "Insert into bank values('"+pinnumber+"', '"+date+"', 'Withdraw', '"+number+"')";
				try {
					conn.s.executeUpdate(query);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Rs "+number+"Withdrawn successfully");
			}
		}
		else if(ae.getSource() == back) 
		{
			setVisible(false);
			new Transactions(pinnumber).setVisible(true);
		}
	}
	
	public static void main(String[] args) 
	{
		new Withdraw("");
		
	}

}

