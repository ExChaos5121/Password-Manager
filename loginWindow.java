package mainPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;





public class loginWindow implements ActionListener {
	
	
	public dataentryMain managerWindow;
	
	 public void actionPerformed(ActionEvent e) {
		 
	 JFrame loginFrame = new JFrame();
	 loginFrame.setSize(250,150);
	 loginFrame.setTitle("Account Login");
	 loginFrame.setLayout(new GridBagLayout());
	 GridBagConstraints con = new GridBagConstraints();
	 
	 JPanel loginPanel = new JPanel(); 
	 
	 con.gridx = 1;
	 con.gridy = 0;
	 JLabel loginLabel = new JLabel("Login Window");
	 loginPanel.add(loginLabel);
	 
	 con.gridx = 0;
	 con.gridy = 1;
	 JLabel userLabel = new JLabel("Username:");
	 loginFrame.add(userLabel, con);
	 
	 con.gridx = 1;
	 con.gridy = 1;
	 JTextField enterUsername = new JTextField();
	 enterUsername.setColumns(10);
	 loginFrame.add(enterUsername, con);
	 
	 con.gridx = 0;
	 con.gridy = 2;
	 JLabel passLabel = new JLabel("Password:");
	 loginFrame.add(passLabel, con);
	 
	 con.gridx = 1;
	 con.gridy = 2;
	 JPasswordField enterPassword = new JPasswordField();
	 enterPassword.setEchoChar('*');
	 enterPassword.setColumns(10);
	 loginFrame.add(enterPassword, con);
	 
	 con.gridx = 0;
	 con.gridy = 3;
	 JButton createButton = new JButton("Login");
	 createButton.addActionListener(new ActionListener() {
		 
		 @SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e) {
			 
			 String password = "";
			 String username = "";
			 
			 password = enterPassword.getText();
			 username = enterUsername.getText();
			 
				verifyAccount(password, username, loginFrame);
			
			
		 }
		 
	 });
	 loginFrame.add(createButton, con);
	 
	 con.gridx = 1;
	 con.gridy = 3;
	 JButton cancelButton = new JButton("Cancel");
	 loginFrame.add(cancelButton, con);
	 cancelButton.addActionListener(new ActionListener() {
		 
		 	public void actionPerformed(ActionEvent e) {
			 
		 		loginFrame.dispose();
		 	}
		 
		 
	 });
	
	 
	 
	 loginFrame.add(loginPanel);
	 loginFrame.setResizable(false);
	 loginFrame.setLocationRelativeTo(null);
	 loginFrame.setVisible(true);
	 
	 }
	 
	 public void verifyAccount(String password, String username, JFrame loginFrame) {
		 
			File usernameFile = new File("Account Information.txt");
			Scanner lineReader;
			
			try {
				lineReader = new Scanner(usernameFile);
				
								
				while(lineReader.hasNextLine() == true){
					String temp = lineReader.nextLine();
					
					String userData = temp;
					
					String compare = username + ";;;;`" + password;
					ArrayList<Boolean> valid = new ArrayList<Boolean>();
					boolean validEntry = compare.contains(userData);
					valid.add(validEntry);
					
					
					if(valid.get(0) == true) {
						
						mainPackage.dataentryMain.managerWindow();
						loginFrame.dispose();
						lineReader.close();
						return;
						
												
					}
					else if(lineReader.hasNextLine() == false) {
						
						JOptionPane.showMessageDialog(loginFrame, "User information incorrect.", "Login info Error", 
								JOptionPane.ERROR_MESSAGE);
						

					}	
								

				
					
				}
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}
			
				
			
		
				
			}

	

	 } 

