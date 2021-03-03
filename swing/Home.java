package swing;

import javax.swing.*;

public class Home {
	public static void main(String[] args) {
		Login log=new Login();
	}
}

class Login{
	Login(){
		JFrame frame = new JFrame(); 
		JLabel label_user, label_password;
		JTextField text_user;
		JPasswordField password;
		JButton button_login, button_signup;
		
		label_user = new JLabel("Username:");
		frame.add(label_user);
		label_user.setBounds(50, 80, 200, 50);
		
		text_user = new JTextField();
		frame.add(text_user);
		text_user.setBounds(120, 90, 200, 30);
		
		label_password = new JLabel("Password:");
		frame.add(label_password);
		label_password.setBounds(50, 140, 200, 30);
		
		password = new JPasswordField();
		frame.add(password);
		password.setBounds(120, 140, 200, 30);
		
		button_login = new JButton("Login");
		frame.add(button_login);
		button_login.setBounds(50, 180, 100, 30);
		
		button_signup = new JButton("Signup");
		frame.add(button_signup);
		button_signup.setBounds(160, 180, 100, 30);
		
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setSize(800, 500);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
}
