package mainPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;



public class createacctWindow implements ActionListener {
	
	 public void actionPerformed(ActionEvent e) {
		 
	 JFrame acctFrame = new JFrame();
	 acctFrame.setSize(600,250);
	 acctFrame.setTitle("Create account window");
	 
	 JPanel acctPanel = new JPanel();
	 acctPanel.setLayout(new GridBagLayout());
	 GridBagConstraints con = new GridBagConstraints();
	 
	 
	 con.gridx = 1;
	 con.gridy = 0;
	 JLabel createLabel = new JLabel("Create Account");
	 acctPanel.add(createLabel, con);
	 
	 con.gridx = 1;
	 con.gridy = 2;
	 JLabel passwordLabel = new JLabel("<html>Please enter a valid password - Password must: <br/>"
	 		+ "Be at least nine characters long. Have at least one uppercase letter.<br/>"
	 		+ "Have at least one lowercase letter. Have at least one digit.</html>");		 		
	 acctPanel.add(passwordLabel, con);
	 
	 con.gridx = 0;
	 con.gridy = 5;
	 JLabel userLabel = new JLabel("Username:");
	 acctPanel.add(userLabel, con);
	 
	 con.gridx = 1;
	 con.gridy = 5;
	 JTextField enterUsername = new JTextField();
	 enterUsername.setColumns(10);
	 acctPanel.add(enterUsername, con);
	 
	 con.gridx = 0;
	 con.gridy = 6;
	 JLabel passLabel = new JLabel("Password:");
	 acctPanel.add(passLabel, con);
	 
	  con.gridx = 1;
	 con.gridy = 6;
	 JTextField enterPassword = new JTextField();
	 enterPassword.setColumns(10);
	 acctPanel.add(enterPassword, con);
	 
	 con.gridx = 0;
	 con.gridy = 7;
	 JButton createButton = new JButton("Create Account");
	 createButton.addActionListener(new ActionListener() {
		 
		 public void actionPerformed(ActionEvent e) {
			 
			 String password = "";
			 String username = "";
			 
			 password = enterPassword.getText();
			 username = enterUsername.getText();
			 verifyAccount(password, username, acctFrame);
			
		 }
		 
	 });
			 
			
	 acctPanel.add(createButton, con);
	
	 
	 con.gridx = 6;
	 con.gridy = 7;
	 JButton cancelButton = new JButton("Cancel");
	 acctPanel.add(cancelButton, con);
	 cancelButton.addActionListener(new ActionListener() {
		 
		 public void actionPerformed(ActionEvent e) {
			 
			 acctFrame.dispose();
		 }
		 
		 
	 });
	
	 
	 acctFrame.add(acctPanel);
	 acctFrame.setResizable(false);
	 acctFrame.setLocationRelativeTo(null);
	 acctFrame.setVisible(true);
	 
	 }

	public void verifyAccount(String password, String username, JFrame acctFrame) {
		
		File usernameFile = new File("Account Information.txt");
		boolean validPW = false;
		boolean validUser = false;
		try {
			
			Scanner lineReader = new Scanner(usernameFile);
			
			
			while(lineReader.hasNextLine()) {
				
				String temp = lineReader.nextLine();
				String usernames = temp.split(";;;;`")[0];
				boolean compare = username.equals(usernames);
				ArrayList<Boolean> valid = new ArrayList<Boolean>();
				valid.add(compare);
				if(valid.get(0) == true) {
					
					JOptionPane.showMessageDialog(acctFrame, "Username already taken.", "Username Error", 
							JOptionPane.ERROR_MESSAGE);
					return;
					
				
				}else {
					validUser = true;
				}
							
			}
			
			lineReader.close();
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		if(password.length() < 9 | password.equals(password.toLowerCase()) | 
				password.equals(password.toUpperCase()) | password.matches("[0-9]")) {
			
			JOptionPane.showMessageDialog(acctFrame, "Password is invalid.", "Password Error", 
					JOptionPane.ERROR_MESSAGE);
			return;
		
			
		}else {
			
			validPW = true;
		}
		
		if(validPW == true & validUser == true) {
			
			try {
				
				FileWriter lineWriter = new FileWriter("Account Information.txt", true);
				lineWriter.write("\n" + username + ";;;;`" + password);
				lineWriter.close();
				acctFrame.dispose();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			JOptionPane.showMessageDialog(acctFrame, "Account Successfully created.", "Account Creation", 
					JOptionPane.INFORMATION_MESSAGE);
			
			
		}


		
	}

 
	 
	
}
	 
	 
	 
	 
	 
	 
 
