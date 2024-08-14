package atmsimulator;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener
{
	// To make all the variables global
		JTextField panTextField, aadharTextField;
		JButton next;
		JRadioButton syes, sno, eyes, eno;
		JComboBox religionname, categoryname, income, educationalqual, occupationval;
		String formno;
		SignupTwo(String formno)
		{
			this.formno = formno;
			setLayout(null);
			
			setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
			
			
			
			JLabel additionalDetails = new JLabel("Page 2: Additional Details");    // To add the additional details label
			additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));             // To add the font to the label 
			additionalDetails.setBounds(290, 80, 400, 30);
			add(additionalDetails);
			
			JLabel religion = new JLabel("Religion:");    // To add the religion label
			religion.setFont(new Font("Raleway", Font.BOLD, 20));             // To add the font to the label 
			religion.setBounds(100, 140, 100, 30);
			add(religion);
			
			String valReligion[] = {"Hindu", "Buddhist", "Jain", "Sikh","Christian","Zoroastrians","Muslim","Other"};    //
			religionname = new JComboBox(valReligion);         // To create a drop down 
			religion.setBackground(Color.WHITE);
			religionname.setBounds(300, 140, 400, 30);
			add(religionname);
			
			JLabel Category = new JLabel("Category:");    // To add the category label
			Category.setFont(new Font("Raleway", Font.BOLD, 20));             // To add the font to the label 
			Category.setBounds(100, 190, 200, 30);
			add(Category);
			
			String valCategory[] = {"General", "OBC", "SC", "ST", "Other"};
			categoryname = new JComboBox(valCategory);  // To create drop down for the category 
			categoryname.setBounds(300, 190, 400, 30);
			categoryname.setBackground(Color.WHITE);
			add(categoryname);
			
			JLabel incomecat = new JLabel("Income:");    // To add the income label
			incomecat.setFont(new Font("Raleway", Font.BOLD, 20));             // To add the font to the label 
			incomecat.setBounds(100, 240, 200, 30);
			add(incomecat);
			
			String incomecategory[] = {"Null", "< 1,50,000", "< 2,50,000", "< 5,00,000", "Upto 10,00,000"};
			income = new JComboBox(incomecategory);         // To create income category drop down
			income.setBounds(300, 240, 400, 30);
			income.setBackground(Color.WHITE);
			add(income);
			
			JLabel education = new JLabel("Educational");    // To add the educational qualifications label
			education.setFont(new Font("Raleway", Font.BOLD, 20));             // To add the font to the label 
			education.setBounds(100, 290, 200, 30);
			add(education);
			
			JLabel qualification = new JLabel("Qualification:");    // To add the educational qualifications label
			qualification.setFont(new Font("Raleway", Font.BOLD, 20));             // To add the font to the label 
			qualification.setBounds(100, 315, 200, 30);
			add(qualification);
			
			String educationqualification[] = {"Non-Graduation", "Graduation", "Post - Graduation", "Phd", "Others"};
			educationalqual = new JComboBox(educationqualification);         // To create educational qualification category drop down
			educationalqual.setBounds(300, 300, 400, 30);
			educationalqual.setBackground(Color.WHITE);
			add(educationalqual);
			
			
			JLabel occupation = new JLabel("Occupation:");    // To add the occupation label
			occupation.setFont(new Font("Raleway", Font.BOLD, 20));             // To add the font to the label 
			occupation.setBounds(100, 375, 200, 30);
			add(occupation);
			
			String occupationvalues[] = {"Salaried", "Self-Employed", "Businessman", "Student", "Retired", "Others"};
			occupationval = new JComboBox(occupationvalues);         // To create educational qualification category drop down
			occupationval.setBounds(300, 375, 400, 30);
			occupationval.setBackground(Color.WHITE);
			add(occupationval);
			
			JLabel pan = new JLabel("PAN Number:");    // To add the address label
			pan.setFont(new Font("Raleway", Font.BOLD, 20));             // To add the font to the label 
			pan.setBounds(100, 440, 200, 30);
			add(pan);
			
			panTextField = new JTextField();
			panTextField.setFont(new Font("Raleway", Font.BOLD, 14));       // To add a text field 
			panTextField.setBounds(300, 440, 400, 30);
			add(panTextField);
			
			JLabel aadhar = new JLabel("Aadhar Number:");         
			aadhar.setFont(new Font("Raleway", Font.BOLD, 20));     //// To add the city label
			aadhar.setBounds(100, 490, 200, 30);                  // To add the font to the label
			add(aadhar);
			
			aadharTextField = new JTextField();
			aadharTextField.setFont(new Font("Raleway", Font.BOLD, 14));       // To add a text field 
			aadharTextField.setBounds(300, 490, 400, 30);
			add(aadharTextField);
			
			
			JLabel senior = new JLabel("Senior Citizen:");                // To add senior s=citizen label
			senior.setFont(new Font("Raleway", Font.BOLD, 20));   // To add the font to the label
			senior.setBounds(100, 540, 200, 30);                  
			add(senior); 
			
			syes = new JRadioButton("Yes");                  // To add radio button for yes
			syes.setBounds(300,540,60,30);
			syes.setBackground(Color.WHITE);
			add(syes);
			
			sno = new JRadioButton("No");                    // To add radio button for no
			sno.setBounds(450,540,60,30);
			sno.setBackground(Color.WHITE);
			add(sno);
			
			ButtonGroup seniorcitizen = new ButtonGroup();
			seniorcitizen.add(syes);
			seniorcitizen.add(sno);
			
			JLabel existacc = new JLabel("Existing Account:");                  // To add label for existing account
			existacc.setFont(new Font("Raleway", Font.BOLD, 20));        // To add the font to the label
			existacc.setBounds(100, 590, 200, 30);
			add(existacc);   
			
			eyes = new JRadioButton("Yes");                  // To add radio button for yes
			eyes.setBounds(300,590,60,30);
			eyes.setBackground(Color.WHITE);
			add(eyes);
			
			eno = new JRadioButton("No");                    // To add radio button for no
			eno.setBounds(450,590,60,30);
			eno.setBackground(Color.WHITE);
			add(eno);
			
			ButtonGroup existaccount = new ButtonGroup();
			existaccount.add(eyes);
			existaccount.add(eno);

			
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
				String sformno = formno;
				String sreligion = (String)religionname.getSelectedItem();   // To get the values which is choosen from dropdown 
				String scategory = (String)categoryname.getSelectedItem();   // To get the selected valued from drop down
				String sincome = (String)income.getSelectedItem();
				String seducation = (String)educationalqual.getSelectedItem();
				String soccupation = (String)occupationval.getSelectedItem();
				String seniorcitizens = null;
				if(syes.isSelected())            // To check which radio button is selected
				{
					seniorcitizens = "Yes";
				}
				else if(sno.isSelected())
				{
					seniorcitizens = "No";
				}
	
				String sexistacc = null;
				if(eyes.isSelected())
				{
					sexistacc = "Yes";
				}
				else if(eno.isSelected())
				{
					sexistacc = "Unmarried";
				}

				String span = panTextField.getText();       // To get the pan id entered
				String saadhar = aadharTextField.getText();  // To get the aadhar number entered

				
				
				try {
					if(sreligion.equals("")) {
						JOptionPane.showMessageDialog(null, "Religion is required");      // To validate the text fields 
					}
					else if(scategory.equals("")) {
						JOptionPane.showMessageDialog(null, "Category is Required");
					} else if(sincome.equals("")) {
						JOptionPane.showMessageDialog(null, "Income is Required");
					} else if(seducation.equals("")) {
						JOptionPane.showMessageDialog(null, "Education is Required");
					} else if(soccupation.equals("")) {
						JOptionPane.showMessageDialog(null, "Occupation is Required");
					} else if(span.equals("")) {
						JOptionPane.showMessageDialog(null, "PAN is Required");
					} else if(saadhar.equals("")) {
						JOptionPane.showMessageDialog(null, "Aadhar is Required");
					} else if(sexistacc.equals("")) {
						JOptionPane.showMessageDialog(null, "Account details is Required");
					}
					else if(seniorcitizens.equals("")) {
						JOptionPane.showMessageDialog(null, "Senior citizen or not field is required");
					}
					
					else {
						Conn c = new Conn();                // To establish connection with database
						String query = "insert into signuptwo values('"+sformno+"', '"+sreligion+"', '"+scategory+"',  '"+sincome+"', '"+seducation+"', '"+soccupation+"', '"+span+"', '"+saadhar+"', '"+seniorcitizens+"', '"+sexistacc+"')"; // 
						c.s.executeUpdate(query);             	
					}
					setVisible(false);
					new SignupThree(formno).setVisible(true);
				}
				catch(Exception e) {
					System.out.println(e);
				}
		}

		public static void main(String[] args) 
		{
			new SignupTwo("");
		}
}
