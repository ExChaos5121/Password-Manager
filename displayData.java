package mainPackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public abstract class displayData implements ActionListener{
	
	public static void displayData() {
		
	
		JFrame frameMain = new JFrame();
		frameMain.setSize(700, 230);
		frameMain.setTitle("Password Manager Program");
		
				
		JPanel panelMain = new JPanel();
		panelMain.setLayout(new GridBagLayout());
		GridBagConstraints con = new GridBagConstraints();
		
		
		Color bgColor = new Color(66, 135, 245);
		panelMain.setBackground(bgColor);
		
		String headers = String.format("%-46s\t %-55s\t %-50s\n", "Description", "Username", "Password");
		con.gridx = 0;
		con.gridy = 0;
		JLabel dataLabel = new JLabel(headers);
		panelMain.add(dataLabel, con);
		
		JTextArea displayArea = new JTextArea (5, 50);
		
		File dataFile = new File("Description Information.txt");
		
		String dataOutputs = new String(" ");
		ArrayList<String> dataOutput = new ArrayList<String>();
		
		int n = 0;
		
		Scanner lineReader;
		try {
			lineReader = new Scanner(dataFile);
			
			while(lineReader.hasNextLine()) {
				
				String temp = lineReader.nextLine();
				String data = temp.split(";;;;`")[0];
				
				String temp2 = temp.substring(temp.indexOf(";;;;`") , temp.indexOf(";;;;="));
				
				String data2 = temp2.replace(";;;;`", "");
				
				String[] segments = temp.split(";;;;=");
				String data3 = segments[segments.length - 1];
				
				String dataString = String.format("%s %-25s\t %-30s\t %-30s %s\n", " ", data, data2, data3, " ");
				dataOutput.add(dataString);
				n++;
			
			}
		} catch (FileNotFoundException e1) {

			e1.printStackTrace();
		}
		
		String[] ordered = new String[dataOutput.size()];
	    int count = 0;
	     
	        while(count < dataOutput.size()) {
	        	
	        	ordered[count] = dataOutput.get(count);
	            count++;
	        }
	        
	        int index;
	        
	        for(int j = 0; j < ordered.length - 1; j++) {
	        	
	        	index = j;
	        	
	            for(int i = j + 1; i < ordered.length; i++) {
	            	
	                if(ordered[i].trim().compareTo(ordered[index].trim()) < 0) {
	                	
	                	index = i;
	                }
	            }
	            
	            if(index != j) {
	            	
	                String temp = ordered[j];
	                ordered[j] = ordered[index];
	                ordered[index]= temp;
	            }
	        }
	    
	    for(int j = 0; j < ordered.length; j++) {
	    	
	    	dataOutputs =  dataOutputs + ordered[j];
	    	
	    }
	    
		displayArea.setText(dataOutputs);
		JScrollPane scroll = new JScrollPane(displayArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		con.gridx = 0;
		con.gridy = 1;
		scroll.setMaximumSize(new Dimension(100, 100));
		panelMain.add(scroll, con);
		frameMain.add(panelMain);
		frameMain.setResizable(false);
		frameMain.setLocationRelativeTo(null);
		frameMain.setVisible(true);	
		frameMain.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
	

	
	
	

	
		public static void updateData(String description, String username, String password, JTextArea displayArea) {
		
		String dataString = String.format("%s %-25s\t %-30s\t %-30s %s\n", " ", description, username, password, " ");
		displayArea.append("\n" + dataString);
		
		mainPackage.displayData.displayData();
		
		}



}



	


