package atmsimulator;

import java.awt.*;

import javax.swing.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener
{
	JButton deposit, withdraw, ministatement, pinchange, fastcash, balanceenquiry, exit;
	String pinnumber;
	Transactions(String pinnumber){
		
		this.pinnumber = pinnumber;
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/atm.jpg")); // add image from the file to the frame
		Image i2 = i1.getImage().getScaledInstance(900,  900,  Image.SCALE_DEFAULT);     // Used to scale the images
		ImageIcon i3 = new ImageIcon(i2);       // ImageIcon can be used in JLabel but image can not be used hence we need to convert the image to ImageIcon 
		JLabel image = new JLabel(i3);          // JLabel is used to content on to the frame
		
		image.setBounds(0, 0, 900, 900);
		add(image);
		
		JLabel text = new JLabel("Please select your Transactions");
		text.setBounds(210, 300, 700, 35);
		image.add(text);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System", Font.BOLD, 16));
		image.add(text);
		
		// JButton named deposit, withdraw, fast cash, ministatement, balance enquiry, exit are created
		// ActionListener is added to these button using `.addActionListener(this)` 
		// class implements 'ActionListener' and overrides the 'ActionPerformed' method to define the action that should occur when the button is clicked.
		// when withdraw button is clicked, it triggers the 'actionPerformed' method, which prints a message to the console
		
		deposit = new JButton("Deposit");
		deposit.setBounds(170, 390, 150, 30);
		deposit.addActionListener(this);
		image.add(deposit);
		
		withdraw = new JButton("Cash Withdraw");  
		withdraw.setBounds(355, 390, 150, 30);    
		withdraw.addActionListener(this);         
		image.add(withdraw);                          
		                                           
		fastcash = new JButton("Fast Cash");
		fastcash.setBounds(170, 425, 150, 30);
		fastcash.addActionListener(this);
		image.add(fastcash);
		
		ministatement = new JButton("Mini Statement");
		ministatement.setBounds(355, 425, 150, 30);
		ministatement.addActionListener(this);
		image.add(ministatement);
		
		pinchange = new JButton("Pin change");
		pinchange.setBounds(170, 460, 150, 30);
		pinchange.addActionListener(this);
		image.add(pinchange);
		
		balanceenquiry = new JButton("Balance Enquiry");
		balanceenquiry.setBounds(355, 460, 150, 30);
		balanceenquiry.addActionListener(this);
		image.add(balanceenquiry);
		
		exit = new JButton("Exit");
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
			System.exit(0);
		}
		else if(ae.getSource() == deposit) {
			setVisible(false);
			new Deposit(pinnumber).setVisible(true);
		} 
		else if(ae.getSource() == withdraw)
		{
			setVisible(false);
			new Withdraw(pinnumber).setVisible(true);
		}
		else if(ae.getSource()==fastcash) {
			setVisible(false);
			new FastCash(pinnumber).setVisible(true);
		}
		else if(ae.getSource()==pinchange) {
			setVisible(false);
			new PinChange(pinnumber).setVisible(true);
		}
		else if(ae.getSource() == balanceenquiry) {
			setVisible(false);
			new BalanceEnquiry(pinnumber).setVisible(true);
		}
		else if(ae.getSource() == ministatement) {
			setVisible(true);
			new MiniStatement(pinnumber).setVisible(true);
		}
	}
	
	public static void main(String[] args) 
	{
		
		new Transactions("");
	}

}
