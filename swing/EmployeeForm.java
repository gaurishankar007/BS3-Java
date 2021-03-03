package swing;

import javax.swing.*;

public class EmployeeForm {
	public static void main(String[] args) {
		Employee employee = new Employee();
	}
}

class Employee {
	Employee() {
		JFrame frm = new JFrame();
		frm.setLayout(null);
		frm.setVisible(true);
		frm.setSize(400, 350);
		frm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		JLabel lbl_name = new JLabel("Name:");
		frm.add(lbl_name);
		lbl_name.setBounds(100, 50, 50, 30);
		
		JTextField tf_name = new JTextField();
		frm.add(tf_name);
		tf_name.setBounds(140, 50, 150, 30);
		
		JLabel lbl_code = new JLabel("Code:");
		frm.add(lbl_code);
		lbl_code.setBounds(100, 90, 50, 30);
		
		JPasswordField pwf_code = new JPasswordField();
		frm.add(pwf_code);
		pwf_code.setBounds(140, 90, 150, 30);
		
		JLabel lbl_designation = new JLabel("Designation:");
		frm.add(lbl_designation);
		lbl_designation.setBounds(100, 130, 100, 30);
		
		JTextField tf_designation = new JTextField();
		frm.add(tf_designation);
		tf_designation.setBounds(180, 130, 150, 30);
		
		JLabel lbl_salary = new JLabel("Salary:");
		frm.add(lbl_salary);
		lbl_salary.setBounds(100, 170, 50, 30);
		
		JTextField tf_salary = new JTextField();
		frm.add(tf_salary);
		tf_salary.setBounds(140, 170, 150, 30);
		
		JButton btn_save = new JButton("Save");
		frm.add(btn_save);
		btn_save.setBounds(160, 210, 80, 30);
		
		JButton btn_exit = new JButton("Exit");
		frm.add(btn_exit);
		btn_exit.setBounds(160, 250, 80, 30);
	}
}
