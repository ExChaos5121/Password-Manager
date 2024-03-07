package mainPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class windowMain extends JFrame{
	
	
	
	public static void mainFrame() {
		 
		
	
		JFrame frameMain = new JFrame();
		frameMain.setSize(550, 250);
		frameMain.setTitle("Password Manager Program");
		
				
		JPanel panelMain = new JPanel();
		panelMain.setLayout(new GridBagLayout());
		GridBagConstraints con = new GridBagConstraints();
		
		
		Color bgColor = new Color(66, 135, 245);
		panelMain.setBackground(bgColor);
		
		
		JLabel icon = new JLabel(new ImageIcon ("background.jpg"));
		con.gridx = 1;
		con.gridy = 1;
		con.insets = new Insets (0, 0, 20, 20);
		panelMain.add(icon, con);
		
		
		
		con.gridx = 2;
		con.gridy = 1;
		con.insets = new Insets (0, 0, 40, 0);
		JLabel welcomeLabel = new JLabel("Password Manager Program");
		panelMain.add(welcomeLabel, con);
		
		con.gridx = 1;
		con.gridy = 2;
		JButton cancelButton = new JButton("Cancel");
		panelMain.add(cancelButton, con);
		cancelButton.addActionListener(new ActionListener() {
			 
			 public void actionPerformed(ActionEvent e) {
				 
				frameMain.dispose();
			 }
			 
			 
		 });
		
		con.gridx = 2;
		con.gridy = 2;
		JButton acctButton = new JButton("Create Account");
		panelMain.add(acctButton, con);
		acctButton.addActionListener(new createacctWindow());
		
		con.gridx = 3;
		con.gridy = 2;
		JButton loginButton = new JButton("Login");
		panelMain.add(loginButton, con);
		loginButton.addActionListener(new loginWindow());
		
		
		frameMain.add(panelMain);
		frameMain.setResizable(false);
		frameMain.setLocationRelativeTo(null);
		frameMain.setVisible(true);	
		frameMain.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
	}

	
	

	
}