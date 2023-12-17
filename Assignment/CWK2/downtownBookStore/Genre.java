package downtownBookStore;

import javax.swing.*;

import java.awt.*;
import javax.swing.border.Border;
import javax.swing.table.TableModel;

import java.sql.*;

import java.util.*;

public class Genre {
	
	Genre() {
		JFrame genre = new JFrame("Genre Page");
		genre.setLayout(null);
		genre.setVisible(true);
		genre.setSize(1930, 1040);
		genre.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		JLabel title = new JLabel("Downtown BookStore Management System");
		genre.add(title);
		Border green = BorderFactory.createLineBorder(Color.GREEN, 4);
	    title.setBorder(green);
        title.setFont(new Font("Times", Font.PLAIN, 60));
		title.setBounds(380, 10, 1170, 100);
		
		JButton backB = new JButton("Back");
		genre.add(backB);
        backB.setFont(new Font("Times", Font.PLAIN, 20));
		backB.setBounds(1800, 10, 100, 40);
		
		backB.addActionListener(e->{
			genre.dispose();
			new Home();
		});

		JLabel nameSL = new JLabel("Name:");
		genre.add(nameSL);
        nameSL.setFont(new Font("Times", Font.PLAIN, 25));
		nameSL.setBounds(555, 120, 80, 50);
		
		String gName [] = {"Action/Adventure", "Art/Architecture", "Biography",
                "Business/Economics", "Children's", "Comic Book", "Crime", "Cultural",
                "Diary", "Dictionary", "Drama", "Encyclopedia", "Graphic novel",
                "Guide", "Health", "History", "Horror", "Humor", "Journal", "Math",
                "Mystery", "Poetry", "Review", "Romance", "Science", "Science Fiction",
                "Sports", "Story", "Thriller", "Travel"};
		
		JComboBox<String> nameSC = new JComboBox<>(gName);
		genre.add(nameSC);
        nameSC.setFont(new Font("Times", Font.PLAIN, 20));
		nameSC.setBounds(635, 125, 200, 40);
		
		JButton nameSB = new JButton("Search");
		genre.add(nameSB);
        nameSB.setFont(new Font("Times", Font.PLAIN, 20));
		nameSB.setBounds(845, 125, 100, 40);
		
		JButton showAllB = new JButton("Show All");
		genre.add(showAllB);
        showAllB.setFont(new Font("Times", Font.PLAIN, 20));
		showAllB.setBounds(955, 125, 120, 40);
		
		JButton aB = new JButton("Ascending");
		genre.add(aB);
        aB.setFont(new Font("Times", Font.PLAIN, 20));
		aB.setBounds(1125, 125, 150, 40);
		
		JButton dB = new JButton("Descending");
		genre.add(dB);
        dB.setFont(new Font("Times", Font.PLAIN, 20));
		dB.setBounds(1285, 125, 150, 40);
		
		DBConnection db = new DBConnection();
		String query = "select * from genres";
		ArrayList<GenreData> genreData = new ArrayList<>();
		try {
			ResultSet data = db.connect().executeQuery(query);
			while(data.next()) {
				GenreData obj = new GenreData(data.getString("Name"), 
												data.getString("TotalBooks"));
				genreData.add(obj);
			}
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		try {
			for(int i=0; i<genreData.size(); i++) {
				ResultSet bookNumber = db.connect().executeQuery("Select count(Genre) as 'TotalBooks' from books where Genre='"+genreData.get(i).name+"';");
				while(bookNumber.next()) {
					db.connect().executeUpdate("Update genres set TotalBooks='"+bookNumber.getString("TotalBooks")+"' "+"where Name='"+genreData.get(i).name+"';");
					genreData.get(i).totalBooks=bookNumber.getString("TotalBooks");					
				}
			}
		} catch (SQLException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		
		String column [] = {"Name", "Total Books"};
		Object row [] [] = new Object [genreData.size()] [column.length];
		for(int i=0; i<genreData.size(); i++) {
			row[i][0] = genreData.get(i).name;
			row[i][1] = genreData.get(i).totalBooks;
		}
		
		JTable table = new JTable(row, column);
        table.setFont(new Font("selrif", Font.PLAIN, 15));
		JScrollPane sp = new  JScrollPane(table);
		Border blue = BorderFactory.createLineBorder(Color.BLUE, 4);
		sp.setBorder(blue);
		genre.add(sp);
		sp.setBounds(50, 185, 1830, 400);
		
		nameSB.addActionListener(e-> {
			String sName = nameSC.getSelectedItem().toString();
			if(sName.equals("")) {
				JOptionPane.showMessageDialog(genre, "Empty field, provide genre name!");				
			}
			else {
				int index=0;
				for(int i=0; i<genreData.size(); i++) {
					if(genreData.get(i).name.equals(sName)) {
						row[index][0] = genreData.get(i).name;
						row[index][1] = genreData.get(i).totalBooks;
						index++;
					}
				}
				for(int i=index; i<genreData.size(); i++) {
					row[i][0] = null;
					row[i][1] = null;						
				}
				table.repaint();
			}
		});
		
		showAllB.addActionListener(e-> {
			for(int i=0; i<genreData.size(); i++) {
				row[i][0] = genreData.get(i).name;
				row[i][1] = genreData.get(i).totalBooks;
			}
			table.repaint();
		});
		
		aB.addActionListener(e-> {
			for(int i = 0; i<genreData.size()-1; i++) {  
				for (int j = i+1; j<genreData.size(); j++) {  
				//compares each elements of the array to all the remaining elements  
					if(genreData.get(i).name.compareTo(genreData.get(j).name)>0) {  
						//swapping array elements  
						Collections.swap(genreData, i, j);
					}  
				}  
			}  
			for(int i=0; i<genreData.size(); i++) {
				row[i][0] = genreData.get(i).name;
				row[i][1] = genreData.get(i).totalBooks;
			}
			table.repaint();
		});
		
		dB.addActionListener(e-> {
			for(int i = 0; i<genreData.size()-1; i++) {  
				for (int j = i+1; j<genreData.size(); j++) {  
				//compares each elements of the array to all the remaining elements  
					if(genreData.get(i).name.compareTo(genreData.get(j).name)<0) {  
						//swapping array elements  
						Collections.swap(genreData, i, j);
					}  
				}  
			}  
			for(int i=0; i<genreData.size(); i++) {
				row[i][0] = genreData.get(i).name;
				row[i][1] = genreData.get(i).totalBooks;
			}
			table.repaint();
		});
		
		JButton addB = new JButton("Add New Genre");
		genre.add(addB);
        addB.setFont(new Font("Times", Font.PLAIN, 20));
		addB.setBounds(1360, 595, 180, 40);
		
		JButton updateB = new JButton("Update Genre");
		genre.add(updateB);
        updateB.setFont(new Font("Times", Font.PLAIN, 20));
		updateB.setBounds(1550, 595, 160, 40);
		
		JButton deleteB = new JButton("Delete Genre");
		genre.add(deleteB);
        deleteB.setFont(new Font("Times", Font.PLAIN, 20));
		deleteB.setBounds(1720, 595, 160, 40);
		
		addB.addActionListener(e-> {
			addB.setVisible(false);
			updateB.setVisible(false);
			deleteB.setVisible(false);
			
			JLabel nameL = new JLabel("Name:");
			genre.add(nameL);
	        nameL.setFont(new Font("Times", Font.PLAIN, 25));
			nameL.setBounds(775, 655, 80, 50);
			
			JComboBox<String> nameC = new JComboBox<>(gName);
			genre.add(nameC);
	        nameC.setFont(new Font("Times", Font.PLAIN, 20));
			nameC.setBounds(855, 660, 300, 40);
			
			JButton addGenreB = new JButton("Add Genre");
			genre.add(addGenreB);
	        addGenreB.setFont(new Font("Times", Font.PLAIN, 20));
			addGenreB.setBounds(825, 725, 140, 40);
			
			JButton cancelB = new JButton("Cancel");
			genre.add(cancelB);
	        cancelB.setFont(new Font("Times", Font.PLAIN, 20));
			cancelB.setBounds(1005, 725, 100, 40);
			
			cancelB.addActionListener(e1-> {
				genre.dispose();
				new Genre();
			});
			
			addGenreB.addActionListener(e1-> {
				if(nameC.getSelectedItem().toString().equals("")) {
					JOptionPane.showMessageDialog(genre, "Empty field, provide genre name!");					
				}
				else {
					String aQuery = "Insert into genres(Name) values('"+nameC.getSelectedItem().toString()+"');";
					try {
						int aResult = db.connect().executeUpdate(aQuery);
						if(aResult>0) {
							JOptionPane.showMessageDialog(genre, "Genre Added Successfully.");
							genre.dispose();
							new Genre();
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
				genre.add(nameL);
		        nameL.setFont(new Font("Times", Font.PLAIN, 25));
				nameL.setBounds(775, 655, 80, 50);
				
				JComboBox<String> nameC = new JComboBox<>(gName);
				genre.add(nameC);
		        nameC.setFont(new Font("Times", Font.PLAIN, 20));
				nameC.setBounds(855, 660, 300, 40);
				
				JButton updateGenreB = new JButton("Update Genre");
				genre.add(updateGenreB);
		        updateGenreB.setFont(new Font("Times", Font.PLAIN, 20));
				updateGenreB.setBounds(815, 725, 160, 40);
				
				JButton cancelB = new JButton("Cancel");
				genre.add(cancelB);
		        cancelB.setFont(new Font("Times", Font.PLAIN, 20));
				cancelB.setBounds(1015, 725, 100, 40);
				
				TableModel model = table.getModel();
				String genreName = (String) model.getValueAt(selectedRow, 0);
				for (int i=0; i<nameC.getItemCount(); i++) {
				    if (nameC.getItemAt(i).toString().equals(genreName)) {
				        nameC.setSelectedIndex(i);
				        break;
				    }
				}
				
				cancelB.addActionListener(e1-> {
					genre.dispose();
					new Genre();
				});
				
				updateGenreB.addActionListener(e1-> {
					if(nameC.getSelectedItem().toString().equals("")) {
						JOptionPane.showMessageDialog(genre, "Empty field, provide genre name!");					
					}
					else {
						String uQuery = "Update genres set name='"+nameC.getSelectedItem().toString()+"' where name='"+genreName+"';";
						try {
							int uResult = db.connect().executeUpdate(uQuery);
							if(uResult>0) {
								JOptionPane.showMessageDialog(genre, "Genre Updated Successfully.");
								genre.dispose();
								new Genre();
							}
						} catch (SQLException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
					}
				});
			}
			else {
				JOptionPane.showMessageDialog(genre, "Select a Row first!");						
			}
		});
		
		deleteB.addActionListener(e-> {				
			int selectedRow = table.getSelectedRow();
			
			if(selectedRow>=0) {				
				TableModel model = table.getModel();
				String genreName = (String) model.getValueAt(selectedRow, 0);
				
				String dQuery = "delete from genres where name='"+genreName+"';";
				try {
					int dResult = db.connect().executeUpdate(dQuery);
					if(dResult>0) {
						JOptionPane.showMessageDialog(genre, "Genre Deleted Successfully.");
						genre.dispose();
						new Genre();
					}
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
			else {
				JOptionPane.showMessageDialog(genre, "Select a Row first!");				
			}
		});
	}
}
