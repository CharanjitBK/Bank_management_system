package atmsimulator;

import javax.swing.*;

import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;                   // To make the frame responsive we have to import this library

public class Signupone extends JFrame implements ActionListener
{
	
	// To make all the variables global
	String random;
	JTextField nameTextField, fnameTextField, emailTextField, addressTextField, cityTextField,stateTextField, pincodeTextField;
	JButton next;
	JRadioButton male, female, others, married, unmarried, other;
	JDateChooser dateChooser;
	
	Signupone()
	{
		setLayout(null);
		Random ran = new Random();                           // Creating the object of the random class to get random numbers to the application number
		
		
		// To get a four digit random number   
		random = String.format("%04d", Math.abs((ran.nextInt() % 10000)));
		JLabel formno = new JLabel("APPLICATION FORM NO. "+random);    // To add the application number label
		formno.setFont(new Font("Raleway", Font.BOLD, 38));             // To add the font to the label 
		formno.setBounds(140, 20, 600, 40);
		add(formno);
		
		JLabel personDetails = new JLabel("Page 1: Personal Details");    // To add the personal details label
		personDetails.setFont(new Font("Raleway", Font.BOLD, 22));             // To add the font to the label 
		personDetails.setBounds(290, 80, 400, 30);
		add(personDetails);
		
		JLabel name = new JLabel("Name:");    // To add the name label
		name.setFont(new Font("Raleway", Font.BOLD, 20));             // To add the font to the label 
		name.setBounds(100, 140, 100, 30);
		add(name);
		
		nameTextField = new JTextField();
		nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));       // To add a text field 
		nameTextField.setBounds(300, 140, 400, 30);
		add(nameTextField);
		
		
		JLabel fname = new JLabel("Father's Name:");    // To add the father's name label
		fname.setFont(new Font("Raleway", Font.BOLD, 20));             // To add the font to the label 
		fname.setBounds(100, 190, 200, 30);
		add(fname);
		
		fnameTextField = new JTextField();
		fnameTextField.setFont(new Font("Raleway", Font.BOLD, 14));       // To add a text field 
		fnameTextField.setBounds(300, 190, 400, 30);
		add(fnameTextField);
		
		JLabel dob = new JLabel("Date of Birth:");    // To add the date of birth label
		dob.setFont(new Font("Raleway", Font.BOLD, 20));             // To add the font to the label 
		dob.setBounds(100, 240, 200, 30);
		add(dob);
		
		dateChooser = new JDateChooser();          // To add the calendar chooser which is created using jar class file
		dateChooser.setBounds(300, 240, 400, 30);
		dateChooser.setForeground(new Color(105, 105, 105));
		add(dateChooser);
		
		JLabel gender = new JLabel("Gender:");    // To add the gender  label
		gender.setFont(new Font("Raleway", Font.BOLD, 20));             // To add the font to the label 
		gender.setBounds(100, 290, 200, 30);
		add(gender);
		
		male = new JRadioButton("Male");
		male.setBounds(300, 290, 60, 30);
		male.setBackground(Color.WHITE);
		add(male);
		
		female = new JRadioButton("Female");
		female.setBounds(450, 290, 120, 30);
		female.setBackground(Color.WHITE);
		add(female);
		
		others = new JRadioButton("others");
		others.setBounds(600, 290, 120, 30);
		others.setBackground(Color.WHITE);
		add(others);
		
		ButtonGroup gendergroup = new ButtonGroup();         // We have to group the two buttons so that we can select any one button
		gendergroup.add(male);
		gendergroup.add(female);
		gendergroup.add(others);
		
		
		JLabel email = new JLabel("E-mail Address:");    // To add the e-mail label
		email.setFont(new Font("Raleway", Font.BOLD, 20));             // To add the font to the label 
		email.setBounds(100, 340, 200, 30);
		add(email);
		
		emailTextField = new JTextField();
		emailTextField.setFont(new Font("Raleway", Font.BOLD, 14));       // To add a text field 
		emailTextField.setBounds(300, 340, 400, 30);
		add(emailTextField);
		
		JLabel martial = new JLabel("Martial Status:");    // To add the martial status label
		martial.setFont(new Font("Raleway", Font.BOLD, 20));             // To add the font to the label 
		martial.setBounds(100, 390, 200, 30);
		add(martial);
		
		married = new JRadioButton("Married");
		married.setBounds(300,390, 100, 30);
		married.setBackground(Color.WHITE);
		add(married);
		
		unmarried = new JRadioButton("Unmarried");
		unmarried.setBounds(450,390, 100, 30);
		unmarried.setBackground(Color.WHITE);
		add(unmarried);
		
		other = new JRadioButton("other");
		other.setBounds(600,390, 100, 30);
		other.setBackground(Color.WHITE);
		add(other);
		
		ButtonGroup martialgroup = new ButtonGroup();         // We have to group the two buttons so that we can select any one button
		martialgroup.add(married);
		martialgroup.add(unmarried);
		martialgroup.add(other);
		
		
		JLabel address = new JLabel("Address:");    // To add the address label
		address.setFont(new Font("Raleway", Font.BOLD, 20));             // To add the font to the label 
		address.setBounds(100, 440, 200, 30);
		add(address);
		
		addressTextField = new JTextField();
		addressTextField.setFont(new Font("Raleway", Font.BOLD, 14));       // To add a text field 
		addressTextField.setBounds(300, 440, 400, 30);
		add(addressTextField);
		
		JLabel city = new JLabel("City:");         
		city.setFont(new Font("Raleway", Font.BOLD, 20));     //// To add the city label
		city.setBounds(100, 490, 200, 30);                  // To add the font to the label
		add(city);
		
		cityTextField = new JTextField();
		cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));       // To add a text field 
		cityTextField.setBounds(300, 490, 400, 30);
		add(cityTextField);
		
		
		JLabel state = new JLabel("State:");                // To add state label
		state.setFont(new Font("Raleway", Font.BOLD, 20));   // To add the font to the label
		state.setBounds(100, 540, 200, 30);                  
		add(state); 
		
		stateTextField = new JTextField();
		stateTextField.setFont(new Font("Raleway", Font.BOLD, 14));       // To add a text field 
		stateTextField.setBounds(300, 540, 400, 30);
		add(stateTextField);
		
		JLabel pincode = new JLabel("Pincode:");                  // To add pincode
		pincode.setFont(new Font("Raleway", Font.BOLD, 20));        // To add the font to the label
		pincode.setBounds(100, 590, 200, 30);
		add(pincode);   
		
		pincodeTextField = new JTextField();
		pincodeTextField.setFont(new Font("Raleway", Font.BOLD, 14));       // To add a text field 
		pincodeTextField.setBounds(300, 590, 400, 30);
		add(pincodeTextField);
		
		next = new JButton("Next");
		next.setBackground(Color.BLACK);          // To make the background black
		next.setForeground(Color.WHITE);                      // To make the text white
		next.setFont(new Font("Raleway", Font.BOLD, 14));
		next.setBounds(620, 660, 80, 30);
		next.addActionListener(this);
		add(next);
	
		
		setVisible(true);                              // To make the frame visible
		getContentPane().setBackground(Color.WHITE);   // To give the background color to the frame
		
		setSize(850, 800);           // To set the size of the frame
		setLocation(350,10);         // By default frame is opened on the left top, so it is set to the given coordinates
	}
		
		public void actionPerformed(ActionEvent ae)
		{
			String formno = random;               // long to string
			String name = nameTextField.getText();   // To get the text which is entered
			String fname = fnameTextField.getText();
			String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();   // getUIComponent() method inside getDateEditor() method  to get text choosen
			String gender = null;
			if(male.isSelected())            // To check which radio button is selected
			{
				gender = "Male";
			}
			else if(female.isSelected())
			{
				gender = "Female";
			}
			else if(others.isSelected())
			{
				gender = "others";
			}
			String email = emailTextField.getText();
			String martial = null;
			if(married.isSelected())
			{
				martial = "Married";
			}
			else if(unmarried.isSelected())
			{
				martial = "Unmarried";
			}
			else if(other.isSelected())
			{
				martial="Other";
			}
			String address = addressTextField.getText();
			String city = cityTextField.getText();
			String state = stateTextField.getText();
			String pin = pincodeTextField.getText();
			
			
			
			try {
				if(name.equals("")) {
					JOptionPane.showMessageDialog(null, "Name is required");      // To validate the text fields 
				}
				else if(fname.equals("")) {
					JOptionPane.showMessageDialog(null, "Fathers Name is Required");
				} else if(dob.equals("")) {
					JOptionPane.showMessageDialog(null, "Date of Birth is Required");
				} else if(email.equals("")) {
					JOptionPane.showMessageDialog(null, "Email is Required");
				} else if(address.equals("")) {
					JOptionPane.showMessageDialog(null, "Address is Required");
				} else if(city.equals("")) {
					JOptionPane.showMessageDialog(null, "City is Required");
				} else if(state.equals("")) {
					JOptionPane.showMessageDialog(null, "State is Required");
				} else if(pin.equals("")) {
					JOptionPane.showMessageDialog(null, "Pincode is Required");
				}
				
				else {
					Conn c = new Conn();                // To establish connection with database
					String query = "insert into signup values('"+formno+"', '"+name+"', '"+fname+"',  '"+dob+"', '"+gender+"', '"+email+"', '"+martial+"', '"+address+"', '"+city+"', '"+pin+"', '"+state+"')"; // 
					c.s.executeUpdate(query);  
					
					setVisible(false);                  // To make the Signup page visibility false 
					new SignupTwo(formno).setVisible(true);   // The signupone page closes and the next page signuptwo page opens up with the same form number
				}
			}
			catch(Exception e) {
				System.out.println(e);
			}
	}

	public static void main(String[] args) 
	{
		new Signupone();
	}

}
