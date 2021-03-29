package swing;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.TableModel;

import java.util.*;

public class ViewEmployee {	
	ViewEmployee() {
		JFrame f = new JFrame("Employee View");
		
		f.setSize(900, 800);
		f.setLayout(null);
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		JButton Back = new JButton("Back");
		f.add(Back);
		Back.setBounds(50, 10, 100, 30);
		
		Back.addActionListener(e->{
			f.dispose();
			new Login();
		});
		
		String column[] = {"Name", "Code", "Position", "Salary"};		
		DBConnection db = new DBConnection();
		String query = "Select * from employee";
		ArrayList<Staff> stf_ar = new ArrayList<>();
		try {
			ResultSet result = db.connect().executeQuery(query);
			while(result.next()) {
				String name = result.getString("name");
				String code = result.getString("code");
				String position = result.getString("position");
				int salary = result.getInt("salary");
				
				Staff stf = new Staff(name, code, position, salary);
				stf_ar.add(stf);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Object data[][] = new Object [stf_ar.size()] [column.length];

		for(int i=0; i<stf_ar.size(); i++) {
			data[i][0] = stf_ar.get(i).name;
			data[i][1] = stf_ar.get(i).code;
			data[i][2] = stf_ar.get(i).position;
			data[i][3] = stf_ar.get(i).salary;
		}
		
		JTable table = new JTable(data, column);
		JScrollPane sp = new JScrollPane(table);
		f.add(sp);
		sp.setBounds(50, 40, 700, 400);
		
		JButton Update = new JButton("Update");
		f.add(Update);
		Update.setBounds(530, 440, 100, 30);
		
		JButton Delete = new JButton("Delete");
		f.add(Delete);
		Delete.setBounds(650, 440, 100, 30);
		
		Delete.addActionListener(e->{
			int row = table.getSelectedRow();
			
			if(row>=0) {
				TableModel model = table.getModel();
				String code = (String) model.getValueAt(row, 1);
				String dquery = "delete from employee where code='"+code+"'";				
				try {
					int result = db.connect().executeUpdate(dquery);
					if (result>0) {
						JOptionPane.showMessageDialog(f, "Employee Deleted");
						new ViewEmployee();
						f.dispose();
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else {
				JOptionPane.showMessageDialog(f, "Select Row Please!");
			}
		});
		
		Update.addActionListener(e->{
			int row = table.getSelectedRow();
			
			if(row>=0) {
				JLabel lname = new JLabel("Name");
	            f.add(lname);
	            lname.setBounds(50, 500, 300, 50);
	            

	            JTextField tfname = new JTextField();
	            f.add(tfname);
	            tfname.setBounds(90, 510, 150, 30);
	            

	            JLabel lcode = new JLabel("Code");
	            f.add(lcode);
	            lcode.setBounds(240, 500, 300, 50);
	            

	            JTextField tfcode = new JTextField();
	            f.add(tfcode);
	            tfcode.setBounds(280, 510, 150, 30);
	            

	            JLabel lpos = new JLabel("Desigination");
	            f.add(lpos);
	            lpos.setBounds(440, 500, 300, 50);

	            JTextField tfpos = new JTextField();
	            f.add(tfpos);
	            tfpos.setBounds(520, 510, 150, 30);
	            

	            JLabel lsalary = new JLabel("Salary");
	            f.add(lsalary);
	            lsalary.setBounds(680, 500, 300, 50);
	            

	            JTextField tfsalary = new JTextField();
	            f.add(tfsalary);
	            tfsalary.setBounds(730, 510, 150, 30);
	            

	            JButton btnChange = new JButton("Make Change");
	            f.add(btnChange);
	            btnChange.setBounds(400, 550, 150, 50);
	            

	            JButton btnCancle = new JButton("Cancle");
	            f.add(btnCancle);
	            btnCancle.setBounds(400, 600, 150, 50);
				
				TableModel model = table.getModel();
				String name = (String) model.getValueAt(row, 0);
				String code = (String) model.getValueAt(row, 1);
				String position = (String) model.getValueAt(row, 2);
				int salary = (int) model.getValueAt(row, 3);	
				
				 tfname.setText(name);
                 tfcode.setText(code);
                 tfpos.setText(position);
                 tfsalary.setText(salary+"");
				
                 btnChange.addActionListener(e1->{                	 
	            	String uquery = "UPDATE employee SET name='"+tfname.getText()+"', "+"code='"+tfcode.getText()+"', "+
	            					"position='"+tfpos.getText()+"', "+"salary='"+tfsalary.getText()+"' "+" WHERE code='"+code+"'";
	            	try {
	 					int result = db.connect().executeUpdate(uquery);
	 					if (result>0) {
	 						JOptionPane.showMessageDialog(f, "Employee Updated Successfully");
	 						new ViewEmployee();
	 						f.dispose();
	 					}
	 					
	 				} catch (SQLException e2) {
	 					// TODO Auto-generated catch block
	 					e2.printStackTrace();
	 				} 
                 });
                 
                 btnCancle.addActionListener(e1->{  
                	 f.dispose();
                	 new ViewEmployee();
                  });			
				
			}
			else {
				JOptionPane.showMessageDialog(f, "Select Row Please!");
			}
		});
	}
}
