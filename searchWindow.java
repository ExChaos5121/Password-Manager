package mainPackage;

import java.awt.Color;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public abstract class searchWindow implements ActionListener{
	
	public static void searchWindow() {
		
	
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
		JLabel topLabel = new JLabel("Enter the search information:");
		panelMain.add(topLabel, con);
		
		con.gridx = 1;
		con.gridy = 3;
		con.insets = new Insets (0, 0, 40, 0);
		JLabel descLabel = new JLabel("Description:");
		panelMain.add(descLabel, con);
		
		con.gridx = 1;
		con.gridy = 4;
		con.insets = new Insets (0, 0, 40, 0);
		JLabel userLabel = new JLabel("Username:");
		panelMain.add(userLabel, con);
		
		con.gridx = 1;
		con.gridy = 5;
		con.insets = new Insets (0, 0, 40, 0);
		JLabel passLabel = new JLabel("Password:");
		panelMain.add(passLabel, con);
		
		con.gridx = 2;
		con.gridy = 3;
		con.insets = new Insets (0, 0, 40, 0);
		JLabel desLabel = new JLabel(" ");
		panelMain.add(desLabel, con);
		
		con.gridx = 2;
		con.gridy = 4;
		con.insets = new Insets (0, 0, 40, 0);
		JLabel useLabel = new JLabel(" ");
		panelMain.add(useLabel, con);
		
		con.gridx = 2;
		con.gridy = 5;
		con.insets = new Insets (0, 0, 40, 0);
		JLabel pasLabel = new JLabel(" ");
		panelMain.add(pasLabel, con);
		
		con.gridx = 2;
		con.gridy = 7;
		con.ipadx = 10;
		JButton cancelButton = new JButton("Cancel");
		panelMain.add(cancelButton, con);
		cancelButton.addActionListener(new ActionListener() {
			 
			 public void actionPerformed(ActionEvent e) {
				 
				 frameMain.dispose();
			 }
			 
			 
		 });
		
		
		con.gridx = 2;
		con.gridy = 2;
		JTextField enterDescript = new JTextField();
		enterDescript.setColumns(10);
		panelMain.add(enterDescript, con);
		
		con.gridx = 1;
		con.gridy = 6;
		JButton deleteButton = new JButton("Delete Entry");
		deleteButton.setEnabled(false);
		deleteButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ae) {
			 
			
			 String description = "";
			 int n = 0;
			 
			 File creat = new File("temp.txt");
			 try {
				creat.createNewFile();
			} catch (IOException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			 description = enterDescript.getText();
			 
			 
			 File descFile = new File("Description Information.txt");
				
				try {
					
					 Scanner lineReader = new Scanner(descFile); 
					 Scanner lineReader2 = new Scanner(descFile); 
					 String writing = "";
					 
						while(lineReader.hasNextLine()) {
							
							String temp = lineReader.nextLine();
							String descriptions = temp.split(";;;;`")[0];
							boolean compare = description.equals(descriptions);
							ArrayList<Boolean> valid = new ArrayList<Boolean>();
							valid.add(compare);
							
							if(valid.get(0) == true) {
								
								File myFile = new File("temp.txt");
								myFile.createNewFile();
								FileWriter lineWriter = new FileWriter(myFile, true);
								
								while(lineReader2.hasNextLine()) {
									
								    writing = lineReader2.nextLine();
									
									if(writing.equals(temp)) {
										
										writing = "";
									}
									if(writing.isEmpty() != true) {
										
										lineWriter.write(writing);
										lineWriter.write("\n");
									}
									
									
								}

								lineWriter.close();
								lineReader2.close();
								JOptionPane.showMessageDialog(frameMain, "Information deleted from system.", "Information Message", 
										JOptionPane.INFORMATION_MESSAGE);
								
							  
								FileWriter lineWriters = new FileWriter("Description Information.txt", true);
								PrintWriter writer = new PrintWriter("Description Information.txt");
								writer.print("");
								writer.close();
								
								File tempFile = new File("temp.txt");
								Scanner line = new Scanner(tempFile);
								
								while(line.hasNextLine()) {
									
									writing = line.nextLine();	
									lineWriters.write(writing);
									lineWriters.write("\n");
									
									}
									lineWriters.close();
									line.close();
									tempFile.delete();
								}
							
							}
						String password = "";
						String username = "";
						description = "";
						JTextArea displayArea = new JTextArea();
						mainPackage.displayData.updateData(description, username, password, displayArea);		
						lineReader.close();
												
					} catch (HeadlessException e1) {
						
						e1.printStackTrace();
					} catch (FileNotFoundException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		
					
		}
			
			
			
		 	
		 
		});
			 
		 panelMain.add(deleteButton, con);
		
		con.gridx = 2;
		con.gridy = 6;
		JButton searchButton = new JButton("Search");
		panelMain.add(searchButton, con);
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				 String password = "";
				 String username = "";
				 String description = "";
				 int n = 0;
				 
				 description = enterDescript.getText();
				 
				 
				 File descFile = new File("Description Information.txt");
					
					try {
						
						 Scanner lineReader = new Scanner(descFile); 
						 
							while(lineReader.hasNextLine()) {
								
								String temp = lineReader.nextLine();
								String descriptions = temp.split(";;;;`")[0];
								boolean compare = description.equals(descriptions);
								ArrayList<Boolean> valid = new ArrayList<Boolean>();
								valid.add(compare);
								
								if(valid.get(0) == true) {
								
									Scanner lineReader2;
									try {
										lineReader2 = new Scanner(descFile);
										
										while(lineReader2.hasNextLine()) {
											
											String temp2 = lineReader2.nextLine();
											description = temp.split(";;;;`")[0];
											
											String temp23 = temp.substring(temp.indexOf(";;;;`") , temp.indexOf(";;;;="));
											
											username = temp23.replace(";;;;`", "");
											
											String[] segments = temp2.split(";;;;=");
											password = segments[segments.length - 1];
											
											desLabel.setText(description);
											useLabel.setText(username);
											pasLabel.setText(password);
											deleteButton.setEnabled(true);
											
											
											return;
								
										}
									}catch (FileNotFoundException e1) {

										e1.printStackTrace();
									}
									
								
								}else{
									
									n++;			
								}	
											
							};
							
							if(n > 0) {
									JOptionPane.showMessageDialog(frameMain, "Description not found please try again.", "Description Error", 
											JOptionPane.ERROR_MESSAGE);
								};
								
								
								
							lineReader.close();
						} catch (HeadlessException e1) {
							
							e1.printStackTrace();
						} catch (FileNotFoundException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
			
						
			}
				
			 
			});
				
		
		frameMain.add(panelMain);
		frameMain.setResizable(false);
		frameMain.setLocationRelativeTo(null);
		frameMain.setVisible(true);	
		frameMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
	
	}
	
	public static void updateData(String description, String username, String password, JTextArea displayArea) {
		
		String dataString = String.format("%s %-25s\t %-30s\t %-30s %s\n", " ", description, username, password, " ");
		displayArea.append("\n" + dataString);
		
		mainPackage.displayData.displayData();
		
		}


		
		
}





