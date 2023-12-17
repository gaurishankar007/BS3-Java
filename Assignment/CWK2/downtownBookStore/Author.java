package downtownBookStore;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import javax.swing.table.TableModel;

import java.sql.*;

import java.util.*;

public class Author {
	
	Author() {
		JFrame author = new JFrame("Author Page");
		author.setLayout(null);
		author.setVisible(true);
		author.setSize(1930, 1040);
		author.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		JLabel title = new JLabel("Downtown BookStore Management System");
		author.add(title);
		Border green = BorderFactory.createLineBorder(Color.GREEN, 4);
	    title.setBorder(green);
        title.setFont(new Font("Times", Font.PLAIN, 60));
		title.setBounds(380, 10, 1170, 100);
		
		JButton backB = new JButton("Back");
		author.add(backB);
        backB.setFont(new Font("Times", Font.PLAIN, 20));
		backB.setBounds(1800, 10, 100, 40);
		
		backB.addActionListener(e->{
			author.dispose();
			new Home();
		});
		
		JLabel nameSL = new JLabel("Name:");
		author.add(nameSL);
        nameSL.setFont(new Font("Times", Font.PLAIN, 25));
		nameSL.setBounds(555, 120, 80, 50);
		
		JTextField nameSI = new JTextField();
		author.add(nameSI);
        nameSI.setFont(new Font("Times", Font.PLAIN, 20));
		nameSI.setBounds(635, 125, 200, 40);
		
		JButton nameSB = new JButton("Search");
		author.add(nameSB);
        nameSB.setFont(new Font("Times", Font.PLAIN, 20));
		nameSB.setBounds(845, 125, 100, 40);
		
		JButton showAllB = new JButton("Show All");
		author.add(showAllB);
        showAllB.setFont(new Font("Times", Font.PLAIN, 20));
		showAllB.setBounds(955, 125, 120, 40);
		
		JButton aB = new JButton("Ascending");
		author.add(aB);
        aB.setFont(new Font("Times", Font.PLAIN, 20));
		aB.setBounds(1125, 125, 150, 40);
		
		JButton dB = new JButton("Descending");
		author.add(dB);
        dB.setFont(new Font("Times", Font.PLAIN, 20));
		dB.setBounds(1285, 125, 150, 40);
		
		DBConnection db = new DBConnection();
		String query = "select * from authors";
		ArrayList<AuthorData> authorData = new ArrayList<>();
		try {
			ResultSet data = db.connect().executeQuery(query);
			while(data.next()) {
				AuthorData obj = new AuthorData(data.getString("Name"), 
												data.getString("TotalBooks"));
				authorData.add(obj);
			}
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		try {
			for(int i=0; i<authorData.size(); i++) {
				ResultSet bookNumber = db.connect().executeQuery("Select count(Author) as 'TotalBooks' from books where Author='"+authorData.get(i).name+"';");
				while(bookNumber.next()) {
					db.connect().executeUpdate("Update authors set TotalBooks='"+bookNumber.getString("TotalBooks")+"' "+"where Name='"+authorData.get(i).name+"';");
					authorData.get(i).totalBooks=bookNumber.getString("TotalBooks");					
				}
			}
		} catch (SQLException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		
		String column [] = {"Name", "Total Books"};
		Object row [] [] = new Object [authorData.size()] [column.length];
		for(int i=0; i<authorData.size(); i++) {
			row[i][0] = authorData.get(i).name;
			row[i][1] = authorData.get(i).totalBooks;
		}
		
		JTable table = new JTable(row, column);
        table.setFont(new Font("selrif", Font.PLAIN, 15));
		JScrollPane sp = new  JScrollPane(table);
		Border blue = BorderFactory.createLineBorder(Color.BLUE, 4);
		sp.setBorder(blue);
		author.add(sp);
		sp.setBounds(50, 185, 1830, 400);
		
		nameSB.addActionListener(e-> {
			String sName = nameSI.getText();
			if(sName.equals("")) {
				JOptionPane.showMessageDialog(author, "Empty field, provide author name!");				
			}
			else {
				int index=0;
				for(int i=0; i<authorData.size(); i++) {
					if(authorData.get(i).name.equals(sName)) {
						System.out.println(authorData.get(i).name);
						row[index][0] = authorData.get(i).name;
						row[index][1] = authorData.get(i).totalBooks;
						index++;
					}
				}
				for(int i=index; i<authorData.size(); i++) {
					row[i][0] = null;
					row[i][1] = null;
				}
				table.repaint();
			}
		});
		
		showAllB.addActionListener(e-> {
			for(int i=0; i<authorData.size(); i++) {
				row[i][0] = authorData.get(i).name;
				row[i][1] = authorData.get(i).totalBooks;
			}
			table.repaint();
		});
		
		aB.addActionListener(e-> {
			for(int i = 0; i<authorData.size()-1; i++) {  
				for (int j = i+1; j<authorData.size(); j++) {  
				//compares each elements of the array to all the remaining elements  
					if(authorData.get(i).name.compareTo(authorData.get(j).name)>0) {  
						//swapping array elements  
						Collections.swap(authorData, i, j);
					}  
				}  
			}  
			for(int i=0; i<authorData.size(); i++) {
				row[i][0] = authorData.get(i).name;
				row[i][1] = authorData.get(i).totalBooks;
			}
			table.repaint();
		});
		
		dB.addActionListener(e-> {
			descending(authorData);
			for(int i=0; i<authorData.size(); i++) {
				row[i][0] = authorData.get(i).name;
				row[i][1] = authorData.get(i).totalBooks;
			}
			table.repaint();
		});
		
		JButton addB = new JButton("Add New Author");
		author.add(addB);
        addB.setFont(new Font("Times", Font.PLAIN, 20));
		addB.setBounds(1360, 595, 180, 40);
		
		JButton updateB = new JButton("Update Author");
		author.add(updateB);
        updateB.setFont(new Font("Times", Font.PLAIN, 20));
		updateB.setBounds(1550, 595, 160, 40);
		
		JButton deleteB = new JButton("Delete Author");
		author.add(deleteB);
        deleteB.setFont(new Font("Times", Font.PLAIN, 20));
		deleteB.setBounds(1720, 595, 160, 40);
		
		addB.addActionListener(e-> {
			addB.setVisible(false);
			updateB.setVisible(false);
			deleteB.setVisible(false);

			JLabel nameL = new JLabel("Name:");
			author.add(nameL);
	        nameL.setFont(new Font("Times", Font.PLAIN, 25));
			nameL.setBounds(775, 655, 80, 50);
			
			JTextField nameI = new JTextField();
			author.add(nameI);
	        nameI.setFont(new Font("Times", Font.PLAIN, 20));
			nameI.setBounds(855, 660, 300, 40);
			
			JButton addAuthorB = new JButton("Add Author");
			author.add(addAuthorB);
	        addAuthorB.setFont(new Font("Times", Font.PLAIN, 20));
			addAuthorB.setBounds(825, 725, 140, 40);
			
			JButton cancelB = new JButton("Cancel");
			author.add(cancelB);
	        cancelB.setFont(new Font("Times", Font.PLAIN, 20));
			cancelB.setBounds(1005, 725, 100, 40);
			
			cancelB.addActionListener(e1-> {
				author.dispose();
				new Author();
			});
			
			addAuthorB.addActionListener(e1-> {
				if(nameI.getText().equals("")) {
					JOptionPane.showMessageDialog(author, "Empty field, provide author name!");					
				}
				else if(isNumeric(nameI.getText())) {
					JOptionPane.showMessageDialog(author, "Provied alphabetical character in name!");					
				}
				else {
					String aQuery = "Insert into authors(Name) values('"+nameI.getText()+"');";
					try {
						int aResult = db.connect().executeUpdate(aQuery);
						if(aResult>0) {
							JOptionPane.showMessageDialog(author, "Author Added Successfully.");
							author.dispose();
							new Author();
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
				author.add(nameL);
		        nameL.setFont(new Font("Times", Font.PLAIN, 25));
				nameL.setBounds(775, 655, 80, 50);
				
				JTextField nameI = new JTextField();
				author.add(nameI);
		        nameI.setFont(new Font("Times", Font.PLAIN, 20));
				nameI.setBounds(855, 660, 300, 40);
				
				JButton updateAuthorB = new JButton("Update Author");
				author.add(updateAuthorB);
		        updateAuthorB.setFont(new Font("Times", Font.PLAIN, 20));
				updateAuthorB.setBounds(815, 725, 160, 40);
				
				JButton cancelB = new JButton("Cancel");
				author.add(cancelB);
		        cancelB.setFont(new Font("Times", Font.PLAIN, 20));
				cancelB.setBounds(1015, 725, 100, 40);
				
				TableModel model = table.getModel();
				String authorName = (String) model.getValueAt(selectedRow, 0);
				nameI.setText(authorName);
				
				cancelB.addActionListener(e1-> {
					author.dispose();
					new Author();
				});
				
				updateAuthorB.addActionListener(e1-> {
					if(nameI.getText().equals("")) {
						JOptionPane.showMessageDialog(author, "Empty field, provide author name!");					
					}
					else if(isNumeric(nameI.getText())) {
						JOptionPane.showMessageDialog(author, "Provied alphabetical character in name!");					
					}
					else {
						String uQuery = "Update authors set name='"+nameI.getText()+"' where name='"+authorName+"';";
						try {
							int uResult = db.connect().executeUpdate(uQuery);
							if(uResult>0) {
								JOptionPane.showMessageDialog(author, "Author Updated Successfully.");
								author.dispose();
								new Author();
							}
						} catch (SQLException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
					}
				});
			}
			else {
				JOptionPane.showMessageDialog(author, "Select a Row first!");				
			}
		});
		
		deleteB.addActionListener(e-> {				
			int selectedRow = table.getSelectedRow();
			
			if(selectedRow>=0) {				
				TableModel model = table.getModel();
				String authorName = (String) model.getValueAt(selectedRow, 0);
				
				String dQuery = "delete from authors where name='"+authorName+"';";
				try {
					int dResult = db.connect().executeUpdate(dQuery);
					if(dResult>0) {
						JOptionPane.showMessageDialog(author, "Author Deleted Successfully.");
						author.dispose();
						new Author();
					}
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
			else {
				JOptionPane.showMessageDialog(author, "Select a Row first!");				
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
	
	public static ArrayList<AuthorData> descending(ArrayList<AuthorData> authorData) {
		for(int i = 0; i<authorData.size()-1; i++) {  
			for (int j = i+1; j<authorData.size(); j++) {  
			//compares each elements of the array to all the remaining elements  
				if(authorData.get(i).name.compareTo(authorData.get(j).name)<0) {  
					//swapping array elements  
					Collections.swap(authorData, i, j);
				}  
			}  
		}  
		return authorData;
	}
}
