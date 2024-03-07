package mainPackage;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;


public class dataentryMain extends JFrame{
	
	

	public static void managerWindow() {
		
		Frame[] frame = JFrame.getFrames();
		frame[0].setVisible(false);
		
		JFrame frameMain = new JFrame();
		frameMain.setSize(500, 600);
		frameMain.setTitle("Password Manager Program");
		
				
				
		JPanel panelMain = new JPanel();
		panelMain.setLayout(new GridBagLayout());
		GridBagConstraints con = new GridBagConstraints();
		
		
		Color bgColor = new Color(66, 135, 245);
		panelMain.setBackground(bgColor);
		
		
		JLabel icon = new JLabel(new ImageIcon ("background2.jpg"));
		con.gridx = 1;
		con.gridy = 1;
		con.insets = new Insets (0, 0, 40, 40);
		panelMain.add(icon, con);
		
		
		
		con.gridx = 1;
		con.gridy = 2;
		con.insets = new Insets (0, 0, 40, 0);
		JLabel descipLabel = new JLabel("Enter the Description or Company:");
		panelMain.add(descipLabel, con);
		
		con.gridx = 1;
		con.gridy = 3;
		con.insets = new Insets (0, 0, 40, 0);
		JLabel userLabel = new JLabel("Enter the Username:");
		panelMain.add(userLabel, con);
		
		con.gridx = 1;
		con.gridy = 4;
		con.insets = new Insets (0, 0, 40, 0);
		JLabel passLabel = new JLabel("Enter the Password:");
		panelMain.add(passLabel, con);
		
		con.gridx = 1;
		con.gridy = 6;
		JButton cancelButton = new JButton("Cancel");
		panelMain.add(cancelButton, con);
		cancelButton.addActionListener(new ActionListener() {
			 
			 public void actionPerformed(ActionEvent e) {
				 
				 frameMain.dispose();
			 }
			 
			 
		 });
		
		con.gridx = 1;
		con.gridy = 5;
		JButton displayButton = new JButton("Display All");
		 displayButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			 
			
			 mainPackage.displayData.displayData();
			
		 	}
		 
		});
			 
		panelMain.add(displayButton, con);
		
		con.gridx = 2;
		con.gridy = 2;
		JTextField enterDescript = new JTextField();
		enterDescript.setColumns(10);
		panelMain.add(enterDescript, con);
		
		con.gridx = 2;
		con.gridy = 3;
		JTextField enterUsername = new JTextField();
		enterUsername.setColumns(10);
		panelMain.add(enterUsername, con);
		
		con.gridx = 2;
		con.gridy = 4;
		JTextField enterPassword = new JTextField();
		enterPassword.setColumns(10);
		panelMain.add(enterPassword, con);
		
		con.gridx = 2;
		con.gridy = 5;
		JButton searchButton = new JButton("Search");
		panelMain.add(searchButton, con);
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
				
				 mainPackage.searchWindow.searchWindow();
				
			 	}
			 
			});
		
		
		con.gridx = 2;
		con.gridy = 6;
		JButton updateButton = new JButton("Update");
		updateButton.addActionListener(new ActionListener() {
			 
			 public void actionPerformed(ActionEvent e) {
				 
				 
				 String password = "";
				 String username = "";
				 String description = "";
				 
				 password = enterPassword.getText();
				 username = enterUsername.getText();
				 description = enterDescript.getText();
				 
				 File descFile = new File("Description Information.txt");
					boolean validDesc = false;
					try {
						
						try (Scanner lineReader = new Scanner(descFile)) {
							while(lineReader.hasNextLine()) {
								
								String temp = lineReader.nextLine();
								String descriptions = temp.split(";;;;`")[0];
								boolean compare = description.equals(descriptions);
								ArrayList<Boolean> valid = new ArrayList<Boolean>();
								valid.add(compare);
								if(valid.get(0) == true) {
									
									JOptionPane.showMessageDialog(frameMain, "This description is already taken.", "Description Error", 
											JOptionPane.ERROR_MESSAGE);
									return;
									
								
								}else {
									validDesc = true;
									
								}
											
							}
							
							lineReader.close();
						} catch (HeadlessException e1) {
							
							e1.printStackTrace();
						}
						
					} catch (FileNotFoundException e1) {
						
						e1.printStackTrace();
					}
				
					if(validDesc == true) {
						
						try {
							
							
							FileWriter lineWriter = new FileWriter("Description Information.txt", true);
							
							lineWriter.write( "\n"+ description + ";;;;`" + username + ";;;;=" + password  );
							lineWriter.close();
							JTextArea displayArea = new JTextArea();
							mainPackage.displayData.updateData(description, username, password, displayArea);
							
						} catch (IOException e1) {
							
							e1.printStackTrace();
						}
						
						JOptionPane.showMessageDialog(frameMain, "Information successfully entered.", "Updated Information", 
								JOptionPane.INFORMATION_MESSAGE);
						
						
					}
					
				 
				 
				 
				
			 }

			
			 
		 });
		panelMain.add(updateButton, con);
		
		
		
		frameMain.add(panelMain);
		frameMain.setResizable(false);
		frameMain.setLocationRelativeTo(null);
		frameMain.setVisible(true);	
		frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
	
	}
	


		
		
}
	

	