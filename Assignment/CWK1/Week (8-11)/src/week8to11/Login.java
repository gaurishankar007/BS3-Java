package week8to11;

import javax.swing.*;

import java.awt.*;
import javax.swing.border.Border;

import java.util.*;

import java.io.*;

public class Login {
	
	Login(){
		JFrame login = new JFrame("Login Page");
		login.setLayout(null);
		login.setVisible(true);
		login.setSize(1930, 1040);
		login.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		JLabel title = new JLabel("Softwarica Network Architecture");
		login.add(title);
		Border border = BorderFactory.createLineBorder(Color.GREEN, 4);
	    title.setBorder(border);
        title.setFont(new Font("Times", Font.PLAIN, 60));
		title.setBounds(535, 10, 860, 100);
		
		JLabel usernameL = new JLabel("Username:");
		login.add(usernameL);
        usernameL.setFont(new Font("Times", Font.PLAIN, 30));
		usernameL.setBounds(560, 280, 150, 50);
		
		JLabel passwordL = new JLabel("Password:");
		login.add(passwordL);
        passwordL.setFont(new Font("Times", Font.PLAIN, 30));
		passwordL.setBounds(560, 360, 150, 50);
		
		JTextField usernameI = new JTextField();
		login.add(usernameI);
        usernameI.setFont(new Font("Times", Font.PLAIN, 25));
		usernameI.setBounds(720, 280, 650, 50);
		
		JPasswordField passwordI = new JPasswordField();
		login.add(passwordI);
        passwordI.setFont(new Font("Times", Font.PLAIN, 25));
		passwordI.setBounds(720, 360, 650, 50);		
		
		JButton loginB = new JButton("Login");
		login.add(loginB);
        loginB.setFont(new Font("Times", Font.PLAIN, 20));
		loginB.setBounds(800, 430, 200, 40);
		
		JButton resetB = new JButton("Reset");
		login.add(resetB);
        resetB.setFont(new Font("Times", Font.PLAIN, 20));
		resetB.setBounds(1020, 430, 200, 40);
		
		JLabel noAccountL = new JLabel("Don't have an account!");
		login.add(noAccountL);
		noAccountL.setFont(new Font("Times", Font.PLAIN, 30));
		noAccountL.setBounds(810, 510, 310, 50);
		
		JButton registerB = new JButton("Register");
		login.add(registerB);
        registerB.setFont(new Font("Times", Font.PLAIN, 20));
		registerB.setBounds(865, 570, 200, 40);
		
		resetB.addActionListener(e->{
			usernameI.setText("");
			passwordI.setText("");
		});
		
		registerB.addActionListener(e-> {
			login.dispose();
			new Registration();
		});
		
		loginB.addActionListener(e->{
			String username = usernameI.getText();
			String password = passwordI.getText();
			
	        if(username.equals("") || password.equals("")) {
				JOptionPane.showMessageDialog(login, "Fill up the form first!");
			}
	        else {
	        	try {
		        	File file = new File("Users.txt");
		        	ArrayList<String> users = new ArrayList<>();
		        	ArrayList<String> passwords = new ArrayList<>();
		        	if(file.exists()) {
			        	Scanner read = new Scanner(file);
			        	while(read.hasNextLine()) {
			        		String line = read.next();
			        		String lineArray [] =line.split(";");
			        		users.add(lineArray[0]);
			        		passwords.add(lineArray[1]);
			        	}
		        		if(users.contains(username)) {
		        			if(password.equals(passwords.get(users.indexOf(username)))) {
		     					login.dispose();
		     					new Home();
		     				}
		     	        	else {
		    					JOptionPane.showMessageDialog(login, "Password not matched!");	     	        		
		     	        	}
		        		}
			        	else{
							JOptionPane.showMessageDialog(login, "User not found!");
			        	}
		        	}
		        	else {
						JOptionPane.showMessageDialog(login, "No any users not found! Please register first.");
		        	}
	        	} 
	        	catch (FileNotFoundException e1) {
	        	      System.out.println("An error occurred.");
	        	      e1.printStackTrace();
	        	}
	        }
		});		
	}
	
	public static void main(String[] args) {
		new Login();
	}
}
