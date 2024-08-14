package atmsimulator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;
import java.util.Date;

// The date package is present in both the classes so use import java.util.Date 
public class FastCash extends JFrame implements ActionListener
{
	JButton deposit, withdraw, ministatement, pinchange, fastcash, balanceenquiry, exit;
	String pinnumber;
	FastCash(String pinnumber){
		
		this.pinnumber = pinnumber;
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/atm.jpg")); // add image from the file to the frame
		Image i2 = i1.getImage().getScaledInstance(900,  900,  Image.SCALE_DEFAULT);     // Used to scale the images
		ImageIcon i3 = new ImageIcon(i2);       // ImageIcon can be used in JLabel but image can not be used hence we need to convert the image to ImageIcon 
		JLabel image = new JLabel(i3);          // JLabel is used to content on to the frame
		
		image.setBounds(0, 0, 900, 900);
		add(image);
		
		JLabel text = new JLabel("SELECT WITHDRAWAL AMOUNT");
		text.setBounds(210, 300, 700, 35);
		image.add(text);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System", Font.BOLD, 16));
		image.add(text);
		
		// JButton named deposit, withdraw, fast cash, ministatement, balance enquiry, exit are created
		// ActionListener is added to these button using `.addActionListener(this)` 
		// class implements 'ActionListener' and overrides the 'ActionPerformed' method to define the action that should occur when the button is clicked.
		// when withdraw button is clicked, it triggers the 'actionPerformed' method, which prints a message to the console
		
		deposit = new JButton("Rs 100");
		deposit.setBounds(170, 390, 150, 30);
		deposit.addActionListener(this);
		image.add(deposit);
		
		withdraw = new JButton("Rs. 500");  
		withdraw.setBounds(355, 390, 150, 30);    
		withdraw.addActionListener(this);         
		image.add(withdraw);                          
		                                           
		fastcash = new JButton("Rs. 1000");
		fastcash.setBounds(170, 425, 150, 30);
		fastcash.addActionListener(this);
		image.add(fastcash);
		
		ministatement = new JButton("Rs. 2000");
		ministatement.setBounds(355, 425, 150, 30);
		ministatement.addActionListener(this);
		image.add(ministatement);
		
		pinchange = new JButton("Rs. 5000");
		pinchange.setBounds(170, 460, 150, 30);
		pinchange.addActionListener(this);
		image.add(pinchange);
		
		balanceenquiry = new JButton("Rs. 10000");
		balanceenquiry.setBounds(355, 460, 150, 30);
		balanceenquiry.addActionListener(this);
		image.add(balanceenquiry);
		
		exit = new JButton("BACK");
		exit.setBounds(355, 495, 150, 28);
		exit.addActionListener(this);
		image.add(exit);
		
		setSize(900, 900);
		setLocation(300, 0);
		setUndecorated(true);                 // The setUndecorated(true) method is used in Java Swing to create a window without the standard window decorations like the title bar and borders. This can be useful when creating custom window designs.
		setVisible(true);
		
		
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == exit)
		{
			setVisible(false);
			new Transactions(pinnumber).setVisible(true);
		}
		else {
			String amount = ((JButton)ae.getSource()).getText().substring(3);
			Conn c = new Conn();
			try {
				//TO check the balance
				ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
				int balance = 0;
				//rs.next() helps in looping and visiting each row
				while(rs.next()) {
					if(rs.getString("type").equals("Deposit")) {
						balance += Integer.parseInt(rs.getString("amount"));
					}
					else {
						balance -= Integer.parseInt(rs.getString("amount"));
					}
				}
				if(ae.getSource() != exit && balance < Integer.parseInt(amount)) {
					JOptionPane.showMessageDialog(null, "Insuffiecient Balance");
					return;
				}
				Date date = new Date();
				String query = "insert into bank values('"+pinnumber+"', '"+date+"', 'Withdraw', '"+amount+"')";
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Rs."+amount+"Debited successfully");
				
				setVisible(false);
				new Transactions(pinnumber).setVisible(true);
			}
			catch(Exception e) {
				System.out.println(e);
			}
			}
	}
	
	public static void main(String[] args) 
	{
		
		new FastCash("");
	}

}
