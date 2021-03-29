package swing;

import javax.swing.*;
import java.sql.*;

public class EmployeeForm {	
	EmployeeForm() {
		JFrame frm = new JFrame("EmployeePage");
		frm.setLayout(null);
		frm.setVisible(true);
		frm.setSize(400, 350);
		frm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		JLabel lbl_name = new JLabel("Name:");
		frm.add(lbl_name);
		lbl_name.setBounds(100, 50, 50, 30);
		
		JTextField tf_name = new JTextField();
		frm.add(tf_name);
		tf_name.setBounds(180, 50, 150, 30);
		
		JLabel lbl_code = new JLabel("Code:");
		frm.add(lbl_code);
		lbl_code.setBounds(100, 90, 50, 30);		
		JPasswordField pwf_code = new JPasswordField();
		frm.add(pwf_code);
		pwf_code.setBounds(180, 90, 150, 30);
		
		JLabel lbl_position = new JLabel("Position:");
		frm.add(lbl_position);
		lbl_position.setBounds(100, 130, 100, 30);
		
		JTextField tf_designation = new JTextField();
		frm.add(tf_designation);
		tf_designation.setBounds(180, 130, 150, 30);
		
		JLabel lbl_salary = new JLabel("Salary:");
		frm.add(lbl_salary);
		lbl_salary.setBounds(100, 170, 50, 30);
		
		JTextField tf_salary = new JTextField();
		frm.add(tf_salary);
		tf_salary.setBounds(180, 170, 150, 30);
		
		JButton btn_save = new JButton("Save");
		frm.add(btn_save);
		btn_save.setBounds(160, 210, 80, 30);
		
		JButton btn_exit = new JButton("Exit");
		frm.add(btn_exit);
		btn_exit.setBounds(160, 250, 80, 30);
		
		
		// exit action
		btn_exit.addActionListener(e->{
			frm.dispose();
			new Login();
		});
		
		// save action
		btn_save.addActionListener(e->{
			String name = tf_name.getText();
			String code = pwf_code.getText();
			String position = tf_designation.getText();
			String salary = tf_salary.getText();
			
			try {
				DBConnection db = new DBConnection();
				String query = "Insert into employee values('" +name+ "','" +code+ "', '" +position+ "', '" +salary+ "')";
				int result = db.connect().executeUpdate(query);
				
				if(result>0) {
					JOptionPane.showMessageDialog(btn_save, "Employee Added Successfully.");
				}
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		});
	}
}
