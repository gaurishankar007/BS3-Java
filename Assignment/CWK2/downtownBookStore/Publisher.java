package downtownBookStore;

import javax.swing.*;

import java.awt.*;
import javax.swing.border.Border;
import javax.swing.table.TableModel;

import java.sql.*;

import java.util.*;

public class Publisher {
	
	Publisher() {
		JFrame publisher = new JFrame("Publisher Page");
		publisher.setLayout(null);
		publisher.setVisible(true);
		publisher.setSize(1930, 1040);
		publisher.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		JLabel title = new JLabel("Downtown BookStore Management System");
		publisher.add(title);
		Border green = BorderFactory.createLineBorder(Color.GREEN, 4);
	    title.setBorder(green);
        title.setFont(new Font("Times", Font.PLAIN, 60));
		title.setBounds(380, 10, 1170, 100);
		
		JButton backB = new JButton("Back");
		publisher.add(backB);
        backB.setFont(new Font("Times", Font.PLAIN, 20));
		backB.setBounds(1800, 10, 100, 40);
		
		backB.addActionListener(e->{
			publisher.dispose();
			new Home();
		});

		JLabel nameSL = new JLabel("Name:");
		publisher.add(nameSL);
        nameSL.setFont(new Font("Times", Font.PLAIN, 25));
		nameSL.setBounds(555, 120, 80, 50);
		
		JTextField nameSI = new JTextField();
		publisher.add(nameSI);
        nameSI.setFont(new Font("Times", Font.PLAIN, 20));
		nameSI.setBounds(635, 125, 200, 40);
		
		JButton nameSB = new JButton("Search");
		publisher.add(nameSB);
        nameSB.setFont(new Font("Times", Font.PLAIN, 20));
		nameSB.setBounds(845, 125, 100, 40);
		
		JButton showAllB = new JButton("Show All");
		publisher.add(showAllB);
        showAllB.setFont(new Font("Times", Font.PLAIN, 20));
		showAllB.setBounds(955, 125, 120, 40);
		
		JButton aB = new JButton("Ascending");
		publisher.add(aB);
        aB.setFont(new Font("Times", Font.PLAIN, 20));
		aB.setBounds(1125, 125, 150, 40);
		
		JButton dB = new JButton("Descending");
		publisher.add(dB);
        dB.setFont(new Font("Times", Font.PLAIN, 20));
		dB.setBounds(1285, 125, 150, 40);
		
		DBConnection db = new DBConnection();
		String query = "select * from publishers";
		ArrayList<PublisherData> publisherData = new ArrayList<>();
		try {
			ResultSet data = db.connect().executeQuery(query);
			while(data.next()) {
				PublisherData obj = new PublisherData(data.getString("Name"), 
												data.getString("TotalBooks"));
				publisherData.add(obj);
			}
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}		

		try {
			for(int i=0; i<publisherData.size(); i++) {
				ResultSet bookNumber = db.connect().executeQuery("Select count(Publisher) as 'TotalBooks' from books where Publisher='"+publisherData.get(i).name+"';");
				while(bookNumber.next()) {
					db.connect().executeUpdate("Update publishers set TotalBooks='"+bookNumber.getString("TotalBooks")+"' "+"where Name='"+publisherData.get(i).name+"';");
					publisherData.get(i).totalBooks=bookNumber.getString("TotalBooks");					
				}
			}
		} catch (SQLException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		
		String column [] = {"Name", "Total Books"};
		Object row [] [] = new Object [publisherData.size()] [column.length];
		for(int i=0; i<publisherData.size(); i++) {
			row[i][0] = publisherData.get(i).name;
			row[i][1] = publisherData.get(i).totalBooks;
		}
		
		JTable table = new JTable(row, column);
        table.setFont(new Font("selrif", Font.PLAIN, 15));
		JScrollPane sp = new  JScrollPane(table);
		Border blue = BorderFactory.createLineBorder(Color.BLUE, 4);
		sp.setBorder(blue);
		publisher.add(sp);
		sp.setBounds(50, 185, 1830, 400);
		
		nameSB.addActionListener(e-> {
			String sName = nameSI.getText();
			if(sName.equals("")) {
				JOptionPane.showMessageDialog(publisher, "Empty field, provide publisher name!");				
			}
			else {
				int index=0;
				for(int i=0; i<publisherData.size(); i++) {
					if(publisherData.get(i).name.equals(sName)) {
						row[index][0] = publisherData.get(i).name;
						row[index][1] = publisherData.get(i).totalBooks;
						index++;
					}					
				}
				for(int i=index; i<publisherData.size(); i++) {
					row[i][0] = null;
					row[i][1] = null;						
				}
				table.repaint();
			}
		});
		
		showAllB.addActionListener(e-> {
			for(int i=0; i<publisherData.size(); i++) {
				row[i][0] = publisherData.get(i).name;
				row[i][1] = publisherData.get(i).totalBooks;
			}
			table.repaint();
		});
		
		aB.addActionListener(e-> {
			for(int i = 0; i<publisherData.size()-1; i++) {  
				for (int j = i+1; j<publisherData.size(); j++) {  
				//compares each elements of the array to all the remaining elements  
					if(publisherData.get(i).name.compareTo(publisherData.get(j).name)>0) {  
						//swapping array elements  
						Collections.swap(publisherData, i, j);
					}  
				}  
			}  
			for(int i=0; i<publisherData.size(); i++) {
				row[i][0] = publisherData.get(i).name;
				row[i][1] = publisherData.get(i).totalBooks;
			}
			table.repaint();
		});
		
		dB.addActionListener(e-> {
			for(int i = 0; i<publisherData.size()-1; i++) {  
				for (int j = i+1; j<publisherData.size(); j++) {  
				//compares each elements of the array to all the remaining elements  
					if(publisherData.get(i).name.compareTo(publisherData.get(j).name)<0) {  
						//swapping array elements  
						Collections.swap(publisherData, i, j);
					}  
				}  
			}  
			for(int i=0; i<publisherData.size(); i++) {
				row[i][0] = publisherData.get(i).name;
				row[i][1] = publisherData.get(i).totalBooks;
			}
			table.repaint();
		});
		
		JButton addB = new JButton("Add New Publisher");
		publisher.add(addB);
        addB.setFont(new Font("Times", Font.PLAIN, 20));
		addB.setBounds(1290, 595, 200, 40);
		
		JButton updateB = new JButton("Update Publisher");
		publisher.add(updateB);
        updateB.setFont(new Font("Times", Font.PLAIN, 20));
		updateB.setBounds(1500, 595, 190, 40);
		
		JButton deleteB = new JButton("Delete Publisher");
		publisher.add(deleteB);
        deleteB.setFont(new Font("Times", Font.PLAIN, 20));
		deleteB.setBounds(1700, 595, 180, 40);
		
		addB.addActionListener(e-> {
			addB.setVisible(false);
			updateB.setVisible(false);
			deleteB.setVisible(false);	

			JLabel nameL = new JLabel("Name:");
			publisher.add(nameL);
	        nameL.setFont(new Font("Times", Font.PLAIN, 25));
			nameL.setBounds(775, 655, 80, 50);
			
			JTextField nameI = new JTextField();
			publisher.add(nameI);
	        nameI.setFont(new Font("Times", Font.PLAIN, 20));
			nameI.setBounds(855, 660, 300, 40);
			
			JButton addPublisherB = new JButton("Add Publisher");
			publisher.add(addPublisherB);
	        addPublisherB.setFont(new Font("Times", Font.PLAIN, 20));
			addPublisherB.setBounds(785, 725, 170, 40);
			
			JButton cancelB = new JButton("Cancel");
			publisher.add(cancelB);
	        cancelB.setFont(new Font("Times", Font.PLAIN, 20));
			cancelB.setBounds(1005, 725, 100, 40);
			
			cancelB.addActionListener(e1-> {
				publisher.dispose();
				new Publisher();
			});
			
			addPublisherB.addActionListener(e1-> {
				if(nameI.getText().equals("")) {
					JOptionPane.showMessageDialog(publisher, "Empty field, provide publisher name!");					
				}
				else if(isNumeric(nameI.getText())) {
					JOptionPane.showMessageDialog(publisher, "Provied alphabetical character in name!");					
				}
				else {
					String aQuery = "Insert into publishers(Name) values('"+nameI.getText()+"');";
					try {
						int aResult = db.connect().executeUpdate(aQuery);
						if(aResult>0) {
							JOptionPane.showMessageDialog(publisher, "Publisher Added Successfully.");
							publisher.dispose();
							new Publisher();
						}
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				}
			});
		});
		
		updateB.addActionListener(e-> {		
			int selectedRow = table.getSelectedRow();
			
			if(selectedRow>=0) {
				addB.setVisible(false);
				updateB.setVisible(false);
				deleteB.setVisible(false);

				JLabel nameL = new JLabel("Name:");
				publisher.add(nameL);
		        nameL.setFont(new Font("Times", Font.PLAIN, 25));
				nameL.setBounds(775, 655, 80, 50);
				
				JTextField nameI = new JTextField();
				publisher.add(nameI);
		        nameI.setFont(new Font("Times", Font.PLAIN, 20));
				nameI.setBounds(855, 660, 300, 40);
				
				JButton updatePublisherB = new JButton("Update Publisher");
				publisher.add(updatePublisherB);
		        updatePublisherB.setFont(new Font("Times", Font.PLAIN, 20));
				updatePublisherB.setBounds(785, 725, 190, 40);
				
				JButton cancelB = new JButton("Cancel");
				publisher.add(cancelB);
		        cancelB.setFont(new Font("Times", Font.PLAIN, 20));
				cancelB.setBounds(1015, 725, 100, 40);
				
				TableModel model = table.getModel();
				String publisherName = (String) model.getValueAt(selectedRow, 0);
				nameI.setText(publisherName);
				
				cancelB.addActionListener(e1-> {
					publisher.dispose();
					new Publisher();
				});
				
				updatePublisherB.addActionListener(e1-> {
					if(nameI.getText().equals("")) {
						JOptionPane.showMessageDialog(publisher, "Empty field, provide publisher name!");					
					}
					else if(isNumeric(nameI.getText())) {
						JOptionPane.showMessageDialog(publisher, "Provied alphabetical character in name!");					
					}
					else {
						String uQuery = "Update publishers set name='"+nameI.getText()+"' where name='"+publisherName+"';";
						try {
							int uResult = db.connect().executeUpdate(uQuery);
							if(uResult>0) {
								JOptionPane.showMessageDialog(publisher, "Publisher Updated Successfully.");
								publisher.dispose();
								new Publisher();
							}
						} catch (SQLException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
					}
				});
			}
			else {
				JOptionPane.showMessageDialog(publisher, "Select a Row first!");						
			}
		});
		
		deleteB.addActionListener(e-> {				
			int selectedRow = table.getSelectedRow();
			
			if(selectedRow>=0) {				
				TableModel model = table.getModel();
				String publisherName = (String) model.getValueAt(selectedRow, 0);
				
				String dQuery = "delete from publishers where name='"+publisherName+"';";
				try {
					int dResult = db.connect().executeUpdate(dQuery);
					if(dResult>0) {
						JOptionPane.showMessageDialog(publisher, "Publisher Deleted Successfully.");
						publisher.dispose();
						new Publisher();
					}
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
			else {
				JOptionPane.showMessageDialog(publisher, "Select a Row first!");				
			}
		});
	}	

	public static boolean isNumeric(String string) {
		boolean bool;
	    int intValue;
	    try {
	        intValue = Integer.parseInt(string);
	        bool=true;
	    } catch (NumberFormatException e) {
	    	bool=false;
	    }
	    return bool;
	}
}
