package swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Home {
	public static void main(String[] args) {
		Login log=new Login();
	}
}

class Login{
	Login(){
		JFrame frame = new JFrame("HomePage"); 
		JLabel label_user, label_password;
		JTextField text_user;
		JPasswordField password;
		JButton button_login, button_signup;
		
		label_user = new JLabel("Username:");
		frame.add(label_user);
		label_user.setBounds(50, 50, 200, 50);
		
		text_user = new JTextField();
		frame.add(text_user);
		text_user.setBounds(120, 50, 200, 30);
		
		label_password = new JLabel("Password:");
		frame.add(label_password);
		label_password.setBounds(50, 110, 200, 30);
		
		password = new JPasswordField();
		frame.add(password);
		password.setBounds(120, 110, 200, 30);
		
		button_login = new JButton("Login");
		frame.add(button_login);
		button_login.setBounds(80, 150, 100, 30);
		
		button_signup = new JButton("Signup");
		frame.add(button_signup);
		button_signup.setBounds(190, 150, 100, 30);
		
		JButton btn_employee = new JButton("View Employee");
		frame.add(btn_employee);
		btn_employee.setBounds(120, 190, 150, 30);
		
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setSize(450, 300);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		// employee action
		btn_employee.addActionListener(e->{
			frame.dispose();
			new ViewEmployee();
		});
		
		
		// login action
		button_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = text_user.getText();
				String pswd = password.getText();
				
				boolean result = userLogin(username, pswd);
				
				if(result) {
					new EmployeeForm();
					frame.dispose();
				}
				else{
					JOptionPane.showMessageDialog(frame, "Invalid Username/password!");
				}
			}			
		});
	}
	
	public boolean userLogin(String user, String psw) {
		if(user.equals("A") && psw.equals("A")) {
			return true;
		}
		return false;
	}
}
