package week8to11;

import javax.swing.*;

import java.awt.*;
import javax.swing.border.Border;

import java.util.*;
import java.util.regex.*;

import java.io.*;

public class Registration {
	
	Registration() {
		JFrame register = new JFrame("Registration Page");
		register.setLayout(null);
		register.setVisible(true);
		register.setSize(1930, 1040);
		register.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		JLabel title = new JLabel("Softwarica Network Architecture");
		register.add(title);
		Border border = BorderFactory.createLineBorder(Color.GREEN, 4);
	    title.setBorder(border);
        title.setFont(new Font("Times", Font.PLAIN, 60));
		title.setBounds(535, 10, 860, 100);
		
		JButton backB = new JButton("Back");
		register.add(backB);
        backB.setFont(new Font("Times", Font.PLAIN, 20));
		backB.setBounds(1800, 10, 100, 40);
		
		backB.addActionListener(e->{
			register.dispose();
			new Login();
		});
		
		JLabel usernameL = new JLabel("Username:");
		register.add(usernameL);
        usernameL.setFont(new Font("Times", Font.PLAIN, 30));
		usernameL.setBounds(560, 360, 150, 50);
		
		JLabel u1 = new JLabel("# 6 to 30 Characters");
		register.add(u1);
        u1.setFont(new Font("Times", Font.PLAIN, 20));
		u1.setBounds(720, 420, 250, 20);
		
		JLabel u2 = new JLabel("# Alphanumeric characters and underscores (_) but no space");
		register.add(u2);
        u2.setFont(new Font("Times", Font.PLAIN, 20));
		u2.setBounds(720, 445, 550, 20);
		
		JLabel passwordL = new JLabel("Password:");
		register.add(passwordL);
        passwordL.setFont(new Font("Times", Font.PLAIN, 30));
		passwordL.setBounds(560, 485, 150, 50);
		
		JLabel p1 = new JLabel("# 8 to 20 Characters");
		register.add(p1);
        p1.setFont(new Font("Times", Font.PLAIN, 20));
		p1.setBounds(720, 545, 250, 20);
		
		JLabel p2 = new JLabel("# At least one digit, one upper and one lower case alphabet");
		register.add(p2);
        p2.setFont(new Font("Times", Font.PLAIN, 20));
		p2.setBounds(720, 570, 550, 20);
		
		JLabel p3 = new JLabel("# At least one special character which includes !@#$%&*()-+=^");
		register.add(p3);
        p3.setFont(new Font("Times", Font.PLAIN, 20));
		p3.setBounds(720, 595, 580, 20);
		
		JLabel p4 = new JLabel("# No white space");
		register.add(p4);
        p4.setFont(new Font("Times", Font.PLAIN, 20));
		p4.setBounds(720, 620, 250, 20);
		
		JTextField usernameI = new JTextField();
		register.add(usernameI);
        usernameI.setFont(new Font("Times", Font.PLAIN, 25));
		usernameI.setBounds(720, 360, 650, 50);
		
		JPasswordField passwordI = new JPasswordField();
		register.add(passwordI);
        passwordI.setFont(new Font("Times", Font.PLAIN, 25));
		passwordI.setBounds(720, 485, 650, 50);		
		
		JButton registerB = new JButton("Register");
		register.add(registerB);
        registerB.setFont(new Font("Times", Font.PLAIN, 20));
		registerB.setBounds(715, 660, 200, 40);
		
		JButton resetB = new JButton("Reset");
		register.add(resetB);
        resetB.setFont(new Font("Times", Font.PLAIN, 20));
		resetB.setBounds(1015, 660, 200, 40);
		
		resetB.addActionListener(e->{
			usernameI.setText("");
			passwordI.setText("");
		});
		
		registerB.addActionListener(e->{
			String username = usernameI.getText();
			String password = passwordI.getText();
			
	        String regexU = "^[A-Za-z]\\w{5,29}$";
	        Pattern pU = Pattern.compile(regexU);	        
	        Matcher mU = pU.matcher(username);
	        
//	        The username consists of 6 to 30 characters inclusive. If the username
//	        consists of less than 6 or greater than 30 characters, then it is an invalid username.
//	        The username can only contain alphanumeric characters and underscores (_). Alphanumeric characters describe the character set consisting of lowercase characters [a – z], uppercase characters [A – Z], and digits [0 – 9].
//	        The first character of the username must be an alphabetic character, i.e., either lowercase character
//	        [a – z] or uppercase character [A – Z].
	        
	        String regexP = "^(?=.*[0-9])"
                    + "(?=.*[a-z])(?=.*[A-Z])"
                    + "(?=.*[@#$%^&+=])"
                    + "(?=\\S+$).{8,20}$";
	        Pattern pP = Pattern.compile(regexP);	        
	        Matcher mP = pP.matcher(password);
	        
//	        It contains at least 8 characters and at most 20 characters.
//	        It contains at least one digit.
//	        It contains at least one upper case alphabet.
//	        It contains at least one lower case alphabet.
//	        It contains at least one special character which includes !@#$%&*()-+=^.
//	        It doesn’t contain any white space.
			
	        if(username.equals("") || password.equals("")) {
				JOptionPane.showMessageDialog(register, "Fill up the form first!");
			}
			else if(!mU.matches()){
				JOptionPane.showMessageDialog(register, "Invalid Username!");
			}
			else if(!mP.matches()){
				JOptionPane.showMessageDialog(register, "Invalid Password!");
			}
			else {
				try {
					File file = new File("Users.txt");
			        if (!file.exists()) {
			        	file.createNewFile();
			        }  
			        if(file.length()==0) {
			            FileWriter fw = new FileWriter("Users.txt");
			            BufferedWriter bw = new BufferedWriter(fw);
			            bw.write(username+";"+password);
			            bw.close();
						JOptionPane.showMessageDialog(register, "You have been successfully registered.");
						register.dispose();
						new Login();	
			        }
			        else {	
			        	ArrayList<String> users = new ArrayList<>();
			        	Scanner read = new Scanner(file);
			        	while(read.hasNextLine()) {
			        		String line = read.next();
			        		String lineArray [] =line.split(";");
			        		users.add(lineArray[0]);
			        	}
		        		if(users.contains(username)) {
							JOptionPane.showMessageDialog(register, "Username already exists.");
		        		}
		        		else {
				            BufferedWriter bw = new BufferedWriter(new FileWriter("Users.txt", true));
				            bw.newLine();
				            bw.write(username+";"+password);
				            bw.close();
							JOptionPane.showMessageDialog(register, "You have been successfully registered.");
							register.dispose();
							new Login();	
		        		}
			        }
			    } 
				catch (IOException e1) {			    	
				    JOptionPane.showMessageDialog(register, "An error occurred.");
			        e1.printStackTrace();
			    }
			}
		});	
	}
}
