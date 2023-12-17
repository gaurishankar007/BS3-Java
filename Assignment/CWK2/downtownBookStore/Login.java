package downtownBookStore;

import javax.swing.*;

import java.awt.*;
import javax.swing.border.Border;

import java.util.regex.*;

public class Login {
	
	Login(){
		JFrame login = new JFrame("Login Page");
		login.setLayout(null);
		login.setVisible(true);
		login.setSize(1930, 1040);
		login.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		JLabel title = new JLabel("Downtown BookStore Management System");
		login.add(title);
		Border border = BorderFactory.createLineBorder(Color.GREEN, 4);
	    title.setBorder(border);
        title.setFont(new Font("Times", Font.PLAIN, 60));
		title.setBounds(380, 10, 1170, 100);
		
		JLabel usernameL = new JLabel("Username:");
		login.add(usernameL);
        usernameL.setFont(new Font("Times", Font.PLAIN, 30));
		usernameL.setBounds(560, 380, 150, 50);
		
		JLabel passwordL = new JLabel("Password:");
		login.add(passwordL);
        passwordL.setFont(new Font("Times", Font.PLAIN, 30));
		passwordL.setBounds(560, 460, 150, 50);
		
		JTextField usernameI = new JTextField();
		login.add(usernameI);
        usernameI.setFont(new Font("Times", Font.PLAIN, 25));
		usernameI.setBounds(720, 380, 650, 50);
		
		JPasswordField passwordI = new JPasswordField();
		login.add(passwordI);
        passwordI.setFont(new Font("Times", Font.PLAIN, 25));
		passwordI.setBounds(720, 460, 650, 50);		
		
		JButton loginB = new JButton("Login");
		login.add(loginB);
        loginB.setFont(new Font("Times", Font.PLAIN, 20));
		loginB.setBounds(800, 530, 200, 40);
		
		JButton resetB = new JButton("Reset");
		login.add(resetB);
        resetB.setFont(new Font("Times", Font.PLAIN, 20));
		resetB.setBounds(1020, 530, 200, 40);	
		
		resetB.addActionListener(e->{
			usernameI.setText("");
			passwordI.setText("");
		});
		
		loginB.addActionListener(e->{
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
				JOptionPane.showMessageDialog(login, "Fill up the form first!");
			}
			else if(!mU.matches()){
				JOptionPane.showMessageDialog(login, "Invalid Username!");
			}
			else if(!mP.matches()){
				JOptionPane.showMessageDialog(login, "Invalid Password!");
			}
	        else if(userLogin(username, password)) {
				login.dispose();
				new Home();
			}
			else {
				JOptionPane.showMessageDialog(login, "Username or Password not matched! Try again!");
			}
		});
		
	}
	
	public boolean userLogin(String user, String psw) {
		if(user.equals("gaurishankar007") && psw.equals("Downtown@159")) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		new Login();
	}
}
