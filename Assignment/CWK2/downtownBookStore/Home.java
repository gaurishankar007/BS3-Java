package downtownBookStore;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import javax.swing.table.TableModel;

import java.sql.*;

import java.util.*;

public class Home {
	
	Home(){
		JFrame home = new JFrame("Home Page");
		home.setLayout(null);
		home.setVisible(true);
		home.setSize(1930, 1040);
		home.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		JLabel title = new JLabel("Downtown BookStore Management System");
		home.add(title);
		Border green = BorderFactory.createLineBorder(Color.GREEN, 4);
	    title.setBorder(green);
        title.setFont(new Font("Times", Font.PLAIN, 60));
		title.setBounds(380, 10, 1170, 100);
		
		JButton logoutB = new JButton("Logout");
		home.add(logoutB);
        logoutB.setFont(new Font("Times", Font.PLAIN, 20));
		logoutB.setBounds(1800, 10, 100, 40);
		
		logoutB.addActionListener(e->{
			home.dispose();
			new Login();
		});
		
		JButton authorB = new JButton("View Author");
		home.add(authorB);
        authorB.setFont(new Font("Times", Font.PLAIN, 20));
		authorB.setBounds(265, 130, 200, 40);
		
		authorB.addActionListener(e-> {
			home.dispose();
			new Author();
		});
		
		JButton genreB = new JButton("View Genre");
		home.add(genreB);
        genreB.setFont(new Font("Times", Font.PLAIN, 20));
		genreB.setBounds(565, 130, 200, 40);
		
		genreB.addActionListener(e-> {
			home.dispose();
			new Genre();
		});
		
		JButton publisherB = new JButton("View Publisher");
		home.add(publisherB);
        publisherB.setFont(new Font("Times", Font.PLAIN, 20));
		publisherB.setBounds(865, 130, 200, 40);
		
		publisherB.addActionListener(e-> {
			home.dispose();
			new Publisher();
		});
		
		JButton aBB = new JButton("Available Books");
		home.add(aBB);
        aBB.setFont(new Font("Times", Font.PLAIN, 20));
		aBB.setBounds(1165, 130, 200, 40);
		
		JButton sBB = new JButton("Sold Books");
		home.add(sBB);
        sBB.setFont(new Font("Times", Font.PLAIN, 20));
		sBB.setBounds(1465, 130, 200, 40);
		
		JLabel nameSL = new JLabel("Name:");
		home.add(nameSL);
        nameSL.setFont(new Font("Times", Font.PLAIN, 25));
		nameSL.setBounds(70, 180, 80, 50);
		
		JTextField nameSI = new JTextField();
		home.add(nameSI);
        nameSI.setFont(new Font("Times", Font.PLAIN, 20));
		nameSI.setBounds(150, 185, 200, 40);
		
		JButton nameSB = new JButton("Search");
		home.add(nameSB);
        nameSB.setFont(new Font("Times", Font.PLAIN, 20));
		nameSB.setBounds(360, 185, 100, 40);
		
		JLabel publisherSL = new JLabel("Publisher:");
		home.add(publisherSL);
        publisherSL.setFont(new Font("Times", Font.PLAIN, 25));
		publisherSL.setBounds(500, 180, 120, 50);
		
		JTextField publisherSI = new JTextField();
		home.add(publisherSI);
        publisherSI.setFont(new Font("Times", Font.PLAIN, 20));
		publisherSI.setBounds(620, 185, 200, 40);
		
		JButton publisherSB = new JButton("Search");
		home.add(publisherSB);
        publisherSB.setFont(new Font("Times", Font.PLAIN, 20));
		publisherSB.setBounds(830, 185, 100, 40);
		
		JLabel publicationYearSL = new JLabel("Publication Year:");
		home.add(publicationYearSL);
        publicationYearSL.setFont(new Font("Times", Font.PLAIN, 25));
		publicationYearSL.setBounds(970, 180, 200, 50);
		
		JTextField publicationYearSI = new JTextField();
		home.add(publicationYearSI);
        publicationYearSI.setFont(new Font("Times", Font.PLAIN, 20));
		publicationYearSI.setBounds(1170, 185, 200, 40);
		
		JButton publicationYearSB = new JButton("Search");
		home.add(publicationYearSB);
        publicationYearSB.setFont(new Font("Times", Font.PLAIN, 20));
		publicationYearSB.setBounds(1380, 185, 100, 40);
		
		JButton aB = new JButton("Ascending");
		home.add(aB);
        aB.setFont(new Font("Times", Font.PLAIN, 20));
		aB.setBounds(1520, 185, 180, 40);
		
		JButton dB = new JButton("Descending");
		home.add(dB);
        dB.setFont(new Font("Times", Font.PLAIN, 20));
		dB.setBounds(1710, 185, 150, 40);
		
		DBConnection db = new DBConnection();
		String query = "select * from books";
		ArrayList<BookData> bookData = new ArrayList<>();
		ArrayList<String> authorName = new ArrayList<>();
		ArrayList<String> genreName = new ArrayList<>();
		ArrayList<String> publisherName = new ArrayList<>();
		try {
			ResultSet data = db.connect().executeQuery(query);
			while(data.next()) {
				BookData obj = new BookData(data.getString("ISBN"), 
											data.getString("Title"),
											data.getString("Language"),
											data.getString("Genre"),
											data.getString("Author"),
											data.getString("Publisher"),
											data.getString("PublicationYear"),
											data.getString("Edition"),
											data.getString("Price"),
											data.getString("AvailableBooks"),
											data.getString("SoldBooks"));
				bookData.add(obj);
			}
			
			ResultSet adata = db.connect().executeQuery("Select Name from authors");
			while(adata.next()) {
				authorName.add(adata.getString("Name"));
			}
			ResultSet gdata = db.connect().executeQuery("Select Name from genres");
			while(gdata.next()) {
				genreName.add(gdata.getString("Name"));
			}
			ResultSet pdata = db.connect().executeQuery("Select Name from publishers");
			while(pdata.next()) {
				publisherName.add(pdata.getString("Name"));
			}
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		String lName [] = {"Nepali", "English", "Hindi", "Spanish", "French", 
				"Russian", "Japanese", "Korean", "Chinese", "German", "Urdu"};
		String aName [] = new String[authorName.size()];
		for(int i=0; i<authorName.size(); i++) {
			aName[i] = authorName.get(i);
		}
		
		String gName [] = new String[genreName.size()];
		for(int i=0; i<genreName.size(); i++) {
			gName[i] = genreName.get(i);
		}
		
		String pName [] = new String[publisherName.size()];
		for(int i=0; i<publisherName.size(); i++) {
			pName[i] = publisherName.get(i);
		}
		
		String column [] = {"ISBN", "Title", "Language", "Genre", "Author", "Publisher", "Publication Year", "Edition", "Price", "Available Books"};
		Object row [] [] = new Object [bookData.size()] [column.length];
		for(int i=0; i<bookData.size(); i++) {
			row[i][0] = bookData.get(i).isbn;
			row[i][1] = bookData.get(i).title;
			row[i][2] = bookData.get(i).language;
			row[i][3] = bookData.get(i).genre;
			row[i][4] = bookData.get(i).author;
			row[i][5] = bookData.get(i).publisher;
			row[i][6] = bookData.get(i).publicationYear;
			row[i][7] = bookData.get(i).edition;
			row[i][8] = bookData.get(i).price;
			row[i][9] = bookData.get(i).availableBooks;
		}
		
		JTable table = new JTable(row, column);
        table.setFont(new Font("selrif", Font.PLAIN, 15));
		JScrollPane sp = new  JScrollPane(table);
		Border blue = BorderFactory.createLineBorder(Color.BLUE, 4);
		sp.setBorder(blue);
		home.add(sp);
		sp.setBounds(50, 250, 1830, 400);
		
		JButton soldB = new JButton("Sell Book");
		home.add(soldB);
        soldB.setFont(new Font("Times", Font.PLAIN, 20));
		soldB.setBounds(1250, 660, 130, 40);
		
		JButton addB = new JButton("Add New Book");
		home.add(addB);
        addB.setFont(new Font("Times", Font.PLAIN, 20));
		addB.setBounds(1390, 660, 170, 40);
		
		JButton updateB = new JButton("Update Book");
		home.add(updateB);
        updateB.setFont(new Font("Times", Font.PLAIN, 20));
		updateB.setBounds(1570, 660, 150, 40);
		
		JButton deleteB = new JButton("Delete Book");
		home.add(deleteB);
        deleteB.setFont(new Font("Times", Font.PLAIN, 20));
		deleteB.setBounds(1730, 660, 150, 40);
		
		nameSB.addActionListener(e-> {
			String sName = nameSI.getText();
			if(sName.equals("")) {
				JOptionPane.showMessageDialog(home, "Empty field, provide book title!");				
			}
			else {
				int index = 0;
				for(int i=0; i<bookData.size(); i++) {
					if(bookData.get(i).title.equals(sName)) {
						row[index][0] = bookData.get(i).isbn;
						row[index][1] = bookData.get(i).title;
						row[index][2] = bookData.get(i).language;
						row[index][3] = bookData.get(i).genre;
						row[index][4] = bookData.get(i).author;
						row[index][5] = bookData.get(i).publisher;
						row[index][6] = bookData.get(i).publicationYear;
						row[index][7] = bookData.get(i).edition;
						row[index][8] = bookData.get(i).price;
						if(table.getColumnModel().getColumn(9).getHeaderValue().equals("Available Books")) {
							table.getColumnModel().getColumn(9).setHeaderValue("Available Books");
							row[index][9] = bookData.get(i).availableBooks;
						}
						else {
							table.getColumnModel().getColumn(9).setHeaderValue("Sold Books");
							row[index][9] = bookData.get(i).soldBooks;
						}
						index++;
					}
				}
				for(int i=index; i<bookData.size(); i++) {
					row[i][0] = null;
					row[i][1] = null;
					row[i][2] = null;
					row[i][3] = null;
					row[i][4] = null;
					row[i][5] = null;
					row[i][6] = null;
					row[i][7] = null;
					row[i][8] = null;
					row[i][9] = null;						
				}
				table.repaint();
			}
		});
		
		publisherSB.addActionListener(e-> {
			String sPublisher = publisherSI.getText();
			if(sPublisher.equals("")) {
				JOptionPane.showMessageDialog(home, "Empty field, provide publisher name!");				
			}
			else {
				int index = 0;
				for(int i=0; i<bookData.size(); i++) {
					if(bookData.get(i).publisher.equals(sPublisher)) {
						row[index][0] = bookData.get(i).isbn;
						row[index][1] = bookData.get(i).title;
						row[index][2] = bookData.get(i).language;
						row[index][3] = bookData.get(i).genre;
						row[index][4] = bookData.get(i).author;
						row[index][5] = bookData.get(i).publisher;
						row[index][6] = bookData.get(i).publicationYear;
						row[index][7] = bookData.get(i).edition;
						row[index][8] = bookData.get(i).price;
						if(table.getColumnModel().getColumn(9).getHeaderValue().equals("Available Books")) {
							table.getColumnModel().getColumn(9).setHeaderValue("Available Books");
							row[index][9] = bookData.get(i).availableBooks;
						}
						else {
							table.getColumnModel().getColumn(9).setHeaderValue("Sold Books");
							row[index][9] = bookData.get(i).soldBooks;
						}
						index++;
					}
				}
				for(int i=index; i<bookData.size(); i++) {
					row[i][0] = null;
					row[i][1] = null;
					row[i][2] = null;
					row[i][3] = null;
					row[i][4] = null;
					row[i][5] = null;
					row[i][6] = null;
					row[i][7] = null;
					row[i][8] = null;
					row[i][9] = null;						
				}
				table.repaint();
			}
		});
		
		publicationYearSB.addActionListener(e-> {
			String sPublicationYear = publicationYearSI.getText();
			if(sPublicationYear.equals("")) {
				JOptionPane.showMessageDialog(home, "Empty field, provide Publication Year!");				
			}
			else {
				int index = 0;
				for(int i=0; i<bookData.size(); i++) {
					if(bookData.get(i).publicationYear.equals(sPublicationYear)) {
						row[index][0] = bookData.get(i).isbn;
						row[index][1] = bookData.get(i).title;
						row[index][2] = bookData.get(i).language;
						row[index][3] = bookData.get(i).genre;
						row[index][4] = bookData.get(i).author;
						row[index][5] = bookData.get(i).publisher;
						row[index][6] = bookData.get(i).publicationYear;
						row[index][7] = bookData.get(i).edition;
						row[index][8] = bookData.get(i).price;
						if(table.getColumnModel().getColumn(9).getHeaderValue().equals("Available Books")) {
							table.getColumnModel().getColumn(9).setHeaderValue("Available Books");
							row[index][9] = bookData.get(i).availableBooks;
						}
						else {
							table.getColumnModel().getColumn(9).setHeaderValue("Sold Books");
							row[index][9] = bookData.get(i).soldBooks;
						}
						index++;
					}
				}
				for(int i=index; i<bookData.size(); i++) {
					row[i][0] = null;
					row[i][1] = null;
					row[i][2] = null;
					row[i][3] = null;
					row[i][4] = null;
					row[i][5] = null;
					row[i][6] = null;
					row[i][7] = null;
					row[i][8] = null;
					row[i][9] = null;						
				}
				table.repaint();
			}
		});
		
		aB.addActionListener(e-> {
			for(int i = 0; i<bookData.size()-1; i++) {  
				for (int j = i+1; j<bookData.size(); j++) {  
				//compares each elements of the array to all the remaining elements  
					if(bookData.get(i).title.compareTo(bookData.get(j).title)>0) {  
						//swapping array elements  
						Collections.swap(bookData, i, j);
					}  
				}  
			}  
			
			for(int i=0; i<bookData.size(); i++) {
				row[i][0] = bookData.get(i).isbn;
				row[i][1] = bookData.get(i).title;
				row[i][2] = bookData.get(i).language;
				row[i][3] = bookData.get(i).genre;
				row[i][4] = bookData.get(i).author;
				row[i][5] = bookData.get(i).publisher;
				row[i][6] = bookData.get(i).publicationYear;
				row[i][7] = bookData.get(i).edition;
				row[i][8] = bookData.get(i).price;
				if(table.getColumnModel().getColumn(9).getHeaderValue().equals("Available Books")) {
					table.getColumnModel().getColumn(9).setHeaderValue("Available Books");
					row[i][9] = bookData.get(i).availableBooks;
				}
				else {
					table.getColumnModel().getColumn(9).setHeaderValue("Sold Books");
					row[i][9] = bookData.get(i).soldBooks;
				}
			}
			table.repaint();
		});
		
		dB.addActionListener(e-> {
			for(int i = 0; i<bookData.size()-1; i++) {  
				for (int j = i+1; j<bookData.size(); j++) {  
				//compares each elements of the array to all the remaining elements  
					if(bookData.get(i).title.compareTo(bookData.get(j).title)<0) {  
						//swapping array elements  
						Collections.swap(bookData, i, j);
					}  
				}  
			}  
			
			for(int i=0; i<bookData.size(); i++) {
				row[i][0] = bookData.get(i).isbn;
				row[i][1] = bookData.get(i).title;
				row[i][2] = bookData.get(i).language;
				row[i][3] = bookData.get(i).genre;
				row[i][4] = bookData.get(i).author;
				row[i][5] = bookData.get(i).publisher;
				row[i][6] = bookData.get(i).publicationYear;
				row[i][7] = bookData.get(i).edition;
				row[i][8] = bookData.get(i).price;
				if(table.getColumnModel().getColumn(9).getHeaderValue().equals("Available Books")) {
					table.getColumnModel().getColumn(9).setHeaderValue("Available Books");
					row[i][9] = bookData.get(i).availableBooks;
				}
				else {
					table.getColumnModel().getColumn(9).setHeaderValue("Sold Books");
					row[i][9] = bookData.get(i).soldBooks;
				}
			}
			table.repaint();
		});
		
		aBB.addActionListener(e-> {
			soldB.setVisible(true);
			addB.setVisible(true);
			updateB.setVisible(true);
			deleteB.setVisible(true);
			
			table.getColumnModel().getColumn(9).setHeaderValue("Available Books");
			for(int i=0; i<bookData.size(); i++) {
				row[i][0] = bookData.get(i).isbn;
				row[i][1] = bookData.get(i).title;
				row[i][2] = bookData.get(i).language;
				row[i][3] = bookData.get(i).genre;
				row[i][4] = bookData.get(i).author;
				row[i][5] = bookData.get(i).publisher;
				row[i][6] = bookData.get(i).publicationYear;
				row[i][7] = bookData.get(i).edition;
				row[i][8] = bookData.get(i).price;
				row[i][9] = bookData.get(i).availableBooks;
			}
			table.repaint();
		});
		
		sBB.addActionListener(e-> {
			soldB.setVisible(false);
			addB.setVisible(false);
			updateB.setVisible(false);
			deleteB.setVisible(false);
			
			table.getColumnModel().getColumn(9).setHeaderValue("Sold Books");
			for(int i=0; i<bookData.size(); i++) {
				row[i][0] = bookData.get(i).isbn;
				row[i][1] = bookData.get(i).title;
				row[i][2] = bookData.get(i).language;
				row[i][3] = bookData.get(i).genre;
				row[i][4] = bookData.get(i).author;
				row[i][5] = bookData.get(i).publisher;
				row[i][6] = bookData.get(i).publicationYear;
				row[i][7] = bookData.get(i).edition;
				row[i][8] = bookData.get(i).price;
				row[i][9] = bookData.get(i).soldBooks;
			}
			table.repaint();
		});
		
		soldB.addActionListener(e-> {		
			int selectedRow = table.getSelectedRow();
			
			if(selectedRow>=0) {
				soldB.setVisible(false);
				addB.setVisible(false);
				updateB.setVisible(false);
				deleteB.setVisible(false);

				JLabel sbnL = new JLabel("Sold Number of Books:");
				home.add(sbnL);
		        sbnL.setFont(new Font("Times", Font.PLAIN, 25));
				sbnL.setBounds(730, 720, 270, 50);
				
				JTextField sbnI = new JTextField();
				home.add(sbnI);
		        sbnI.setFont(new Font("Times", Font.PLAIN, 20));
				sbnI.setBounds(1000, 725, 200, 40);
				
				JButton sellBookB = new JButton("Sell Book");
				home.add(sellBookB);
		        sellBookB.setFont(new Font("Times", Font.PLAIN, 20));
				sellBookB.setBounds(830, 790, 130, 40);
				
				JButton cancelB = new JButton("Cancel");
				home.add(cancelB);
		        cancelB.setFont(new Font("Times", Font.PLAIN, 20));
				cancelB.setBounds(1000, 790, 100, 40);
				
				TableModel model = table.getModel();
				String bookISBN = (String) model.getValueAt(selectedRow, 0);
				String bookAvailableNumber = (String) model.getValueAt(selectedRow, 9);
				
				cancelB.addActionListener(e1-> {
					home.dispose();
					new Home();
				});
				
				sellBookB.addActionListener(e1-> {
					if(sbnI.getText().equals("")) {
						JOptionPane.showMessageDialog(home, "Empty field, provide sold number of book!");					
					}
					else if(!isNumeric(sbnI.getText())) {
						JOptionPane.showMessageDialog(home, "Provied number!");					
					}
					else if(sbnI.getText().length()>5){
						JOptionPane.showMessageDialog(home, "Provied number less than or equal to 5 Digits in Available Books");					
					}
					else if(Integer.parseInt(sbnI.getText())<0 || Integer.parseInt(sbnI.getText())>Integer.parseInt(bookAvailableNumber)) {
						JOptionPane.showMessageDialog(home, "Provied number between 0 and the available numbers of the book!");					
					}
					else {
						try {
							int faN=0;
							int fsN=0;
							ResultSet sN = db.connect().executeQuery("Select AvailableBooks, SoldBooks from books where ISBN='"+bookISBN+"';");
							while(sN.next()) {
								faN = Integer.parseInt(sN.getString("AvailableBooks")) - Integer.parseInt(sbnI.getText());
								fsN = Integer.parseInt(sN.getString("SoldBooks")) + Integer.parseInt(sbnI.getText());
							}
							int uResult = db.connect().executeUpdate("Update books set AvailableBooks='"+Integer.toString(faN)+
																	"', SoldBooks='"+Integer.toString(fsN)+"' where ISBN='"+bookISBN+"';");
							if(uResult>0) {
								JOptionPane.showMessageDialog(home, "Book has been Sold.");
								home.dispose();
								new Home();
							}
						} catch (SQLException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
					}
					
				});
			}
			else {
				JOptionPane.showMessageDialog(home, "Select a Row first!");		
			}
			
		});
		
		addB.addActionListener(e-> {
			soldB.setVisible(false);
			addB.setVisible(false);
			updateB.setVisible(false);
			deleteB.setVisible(false);
			
			JLabel isbnL = new JLabel("ISBN:");
			home.add(isbnL);
	        isbnL.setFont(new Font("Times", Font.PLAIN, 25));
			isbnL.setBounds(175, 720, 70, 50);
			
			JTextField isbnI = new JTextField();
			home.add(isbnI);
	        isbnI.setFont(new Font("Times", Font.PLAIN, 20));
			isbnI.setBounds(245, 725, 200, 40);
			
			JLabel titleL = new JLabel("Title:");
			home.add(titleL);
	        titleL.setFont(new Font("Times", Font.PLAIN, 25));
			titleL.setBounds(485, 720, 60, 50);
			
			JTextField titleI = new JTextField();
			home.add(titleI);
	        titleI.setFont(new Font("Times", Font.PLAIN, 20));
			titleI.setBounds(545, 725, 200, 40);
			
			JLabel languageL = new JLabel("Language:");
			home.add(languageL);
	        languageL.setFont(new Font("Times", Font.PLAIN, 25));
			languageL.setBounds(785, 720, 120, 50);
			
			JComboBox<String> languageC = new JComboBox<>(lName);
			home.add(languageC);
	        languageC.setFont(new Font("Times", Font.PLAIN, 20));
			languageC.setBounds(905, 725, 200, 40);
			
			JLabel genreL = new JLabel("Genre:");
			home.add(genreL);
	        genreL.setFont(new Font("Times", Font.PLAIN, 25));
			genreL.setBounds(1145, 720, 80, 50);
			
			JComboBox<String> genreC = new JComboBox<>(gName);
			home.add(genreC);
	        genreC.setFont(new Font("Times", Font.PLAIN, 20));
			genreC.setBounds(1225, 725, 200, 40);
			
			JLabel  authorL = new JLabel("Author");
			home.add(authorL);
	        authorL.setFont(new Font("Times", Font.PLAIN, 25));
			authorL.setBounds(1465, 720, 90, 50);
			
			JComboBox<String> authorC = new JComboBox<>(aName);
			home.add(authorC);
	        authorC.setFont(new Font("Times", Font.PLAIN, 20));
			authorC.setBounds(1555, 725, 200, 40);
			
			JLabel publisherL = new JLabel("Publisher:");
			home.add(publisherL);
	        publisherL.setFont(new Font("Times", Font.PLAIN, 25));
			publisherL.setBounds(45, 790, 120, 50);
			
			JComboBox<String> publisherC = new JComboBox<>(pName);
			home.add(publisherC);
	        publisherC.setFont(new Font("Times", Font.PLAIN, 20));
			publisherC.setBounds(165, 795, 200, 40);
			
			JLabel publicationYearL = new JLabel("Publication Year:");
			home.add(publicationYearL);
	        publicationYearL.setFont(new Font("Times", Font.PLAIN, 25));
			publicationYearL.setBounds(405, 790, 200, 50);
			
			JTextField publicationYearI = new JTextField();
			home.add(publicationYearI);
	        publicationYearI.setFont(new Font("Times", Font.PLAIN, 20));
			publicationYearI.setBounds(605, 795, 200, 40);
			
			JLabel editionL = new JLabel("Edition:");
			home.add(editionL);
	        editionL.setFont(new Font("Times", Font.PLAIN, 25));
			editionL.setBounds(845, 790, 90, 50);
			
			JTextField editionI = new JTextField();
			home.add(editionI);
	        editionI.setFont(new Font("Times", Font.PLAIN, 20));
			editionI.setBounds(935, 795, 200, 40);
			
			JLabel priceL = new JLabel("Price:");
			home.add(priceL);
	        priceL.setFont(new Font("Times", Font.PLAIN, 25));
			priceL.setBounds(1175, 790, 70, 50);
			
			JTextField priceI = new JTextField();
			home.add(priceI);
	        priceI.setFont(new Font("Times", Font.PLAIN, 20));
			priceI.setBounds(1245, 795, 200, 40);
			
			JLabel availableBooksL = new JLabel("Available Books:");
			home.add(availableBooksL);
	        availableBooksL.setFont(new Font("Times", Font.PLAIN, 25));
			availableBooksL.setBounds(1485, 790, 200, 50);
			
			JTextField availableBooksI = new JTextField();
			home.add(availableBooksI);
	        availableBooksI.setFont(new Font("Times", Font.PLAIN, 20));
			availableBooksI.setBounds(1685, 795, 200, 40);
			
			JButton addBookB = new JButton("Add Book");
			home.add(addBookB);
	        addBookB.setFont(new Font("Times", Font.PLAIN, 20));
			addBookB.setBounds(835, 855, 120, 40);
			
			JButton cancelB = new JButton("Cancel");
			home.add(cancelB);
	        cancelB.setFont(new Font("Times", Font.PLAIN, 20));
			cancelB.setBounds(995, 855, 100, 40);
			
			cancelB.addActionListener(e1-> {
				home.dispose();
				new Home();
			});
			
			addBookB.addActionListener(e1-> {		
				if(isbnI.getText().equals("") || titleI.getText().equals("") || languageC.getSelectedItem().toString().equals("") ||
						genreC.getSelectedItem().toString().equals("") || authorC.getSelectedItem().toString().equals("") ||
						publisherC.getSelectedItem().toString().equals("") || publicationYearI.getText().equals("") || 
						editionI.getText().equals("") || priceI.getText().equals("") || availableBooksI.getText().equals("")) {
					JOptionPane.showMessageDialog(home, "Empty field, fill up the form completely!");					
				}
				else if(isbnI.getText().length()!=13){
					JOptionPane.showMessageDialog(home, "Provied 13 Digits in ISBN");					
				}
				else if(publicationYearI.getText().length()!=4){
					JOptionPane.showMessageDialog(home, "Provied 4 Digits in Publication Year");					
				}
				else if(availableBooksI.getText().length()>5){
					JOptionPane.showMessageDialog(home, "Provied number less than or equal to 5 Digits in Available Books");					
				}
				else if(!isNumeric(isbnI.getText().substring(0,7)) || !isNumeric(isbnI.getText().substring(7)) || !isNumeric(publicationYearI.getText()) || 
						!isNumeric(priceI.getText()) || !isNumeric(availableBooksI.getText())){
					JOptionPane.showMessageDialog(home, "Provied Numeric Value in ISBN, Publication Year, Price and Available Books");					
				}
				else if(isNumeric(titleI.getText()) || isNumeric(editionI.getText())){
					JOptionPane.showMessageDialog(home, "Provied Alphabetic Character in Title, Edition");					
				}
				else {
					String aQuery = "Insert into books(ISBN, Title, Language, Genre, Author, Publisher, PublicationYear, Edition, Price, AvailableBooks)"
									+ " values('"+isbnI.getText()+"', '"+titleI.getText()+"', '"+languageC.getSelectedItem().toString()+
									"', '"+genreC.getSelectedItem().toString()+"', '"+authorC.getSelectedItem().toString()+
									"', '"+publisherC.getSelectedItem().toString()+"', '"+publicationYearI.getText()+
									"', '"+editionI.getText()+"', 'Rs."+priceI.getText()+"', '"+availableBooksI.getText()+"');";
					try {
						int aResult = db.connect().executeUpdate(aQuery);
						if(aResult>0) {
							JOptionPane.showMessageDialog(home, "Book Added Successfully.");
							home.dispose();
							new Home();
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
				soldB.setVisible(false);
				addB.setVisible(false);
				updateB.setVisible(false);
				deleteB.setVisible(false);
				
				JLabel isbnL = new JLabel("ISBN:");
				home.add(isbnL);
		        isbnL.setFont(new Font("Times", Font.PLAIN, 25));
				isbnL.setBounds(175, 720, 70, 50);
				
				JTextField isbnI = new JTextField();
				home.add(isbnI);
		        isbnI.setFont(new Font("Times", Font.PLAIN, 20));
				isbnI.setBounds(245, 725, 200, 40);
				
				JLabel titleL = new JLabel("Title:");
				home.add(titleL);
		        titleL.setFont(new Font("Times", Font.PLAIN, 25));
				titleL.setBounds(485, 720, 60, 50);
				
				JTextField titleI = new JTextField();
				home.add(titleI);
		        titleI.setFont(new Font("Times", Font.PLAIN, 20));
				titleI.setBounds(545, 725, 200, 40);
				
				JLabel languageL = new JLabel("Language:");
				home.add(languageL);
		        languageL.setFont(new Font("Times", Font.PLAIN, 25));
				languageL.setBounds(785, 720, 120, 50);
				
				JComboBox<String> languageC = new JComboBox<>(lName);
				home.add(languageC);
		        languageC.setFont(new Font("Times", Font.PLAIN, 20));
				languageC.setBounds(905, 725, 200, 40);
				
				JLabel genreL = new JLabel("Genre:");
				home.add(genreL);
		        genreL.setFont(new Font("Times", Font.PLAIN, 25));
				genreL.setBounds(1145, 720, 80, 50);
				
				JComboBox<String> genreC = new JComboBox<>(gName);
				home.add(genreC);
		        genreC.setFont(new Font("Times", Font.PLAIN, 20));
				genreC.setBounds(1225, 725, 200, 40);
				
				JLabel authorL = new JLabel("Author:");
				home.add(authorL);
		        authorL.setFont(new Font("Times", Font.PLAIN, 25));
				authorL.setBounds(1465, 720, 90, 50);
				
				JComboBox<String> authorC = new JComboBox<>(aName);
				home.add(authorC);
		        authorC.setFont(new Font("Times", Font.PLAIN, 20));
				authorC.setBounds(1555, 725, 200, 40);
				
				JLabel publisherL = new JLabel("Publisher:");
				home.add(publisherL);
		        publisherL.setFont(new Font("Times", Font.PLAIN, 25));
				publisherL.setBounds(45, 790, 120, 50);
				
				JComboBox<String> publisherC = new JComboBox<>(pName);
				home.add(publisherC);
		        publisherC.setFont(new Font("Times", Font.PLAIN, 20));
				publisherC.setBounds(165, 795, 200, 40);
				
				JLabel publicationYearL = new JLabel("Publication Year:");
				home.add(publicationYearL);
		        publicationYearL.setFont(new Font("Times", Font.PLAIN, 25));
				publicationYearL.setBounds(405, 790, 200, 50);
				
				JTextField publicationYearI = new JTextField();
				home.add(publicationYearI);
		        publicationYearI.setFont(new Font("Times", Font.PLAIN, 20));
				publicationYearI.setBounds(605, 795, 200, 40);
				
				JLabel editionL = new JLabel("Edition:");
				home.add(editionL);
		        editionL.setFont(new Font("Times", Font.PLAIN, 25));
				editionL.setBounds(845, 790, 90, 50);
				
				JTextField editionI = new JTextField();
				home.add(editionI);
		        editionI.setFont(new Font("Times", Font.PLAIN, 20));
				editionI.setBounds(935, 795, 200, 40);
				
				JLabel priceL = new JLabel("Price:");
				home.add(priceL);
		        priceL.setFont(new Font("Times", Font.PLAIN, 25));
				priceL.setBounds(1175, 790, 70, 50);
				
				JTextField priceI = new JTextField();
				home.add(priceI);
		        priceI.setFont(new Font("Times", Font.PLAIN, 20));
				priceI.setBounds(1245, 795, 200, 40);
				
				JLabel availableBooksL = new JLabel("Available Books:");
				home.add(availableBooksL);
		        availableBooksL.setFont(new Font("Times", Font.PLAIN, 25));
				availableBooksL.setBounds(1485, 790, 200, 50);
				
				JTextField availableBooksI = new JTextField();
				home.add(availableBooksI);
		        availableBooksI.setFont(new Font("Times", Font.PLAIN, 20));
				availableBooksI.setBounds(1685, 795, 200, 40);
				
				JButton updateBookB = new JButton("Update Book");
				home.add(updateBookB);
		        updateBookB.setFont(new Font("Times", Font.PLAIN, 20));
				updateBookB.setBounds(820, 855, 150, 40);
				
				JButton cancelB = new JButton("Cancel");
				home.add(cancelB);
		        cancelB.setFont(new Font("Times", Font.PLAIN, 20));
				cancelB.setBounds(990, 855, 100, 40);
				
				TableModel model = table.getModel();
				isbnI.setText((String) model.getValueAt(selectedRow, 0));
				titleI.setText((String) model.getValueAt(selectedRow, 1));
				for (int i=0; i<languageC.getItemCount(); i++) {
				    if (languageC.getItemAt(i).toString().equals((String) model.getValueAt(selectedRow, 2))) {
				    	languageC.setSelectedIndex(i);
				        break;
				    }
				}
				for (int i=0; i<genreC.getItemCount(); i++) {
				    if (genreC.getItemAt(i).toString().equals((String) model.getValueAt(selectedRow, 3))) {
				    	genreC.setSelectedIndex(i);
				        break;
				    }
				}
				for (int i=0; i<authorC.getItemCount(); i++) {
				    if (authorC.getItemAt(i).toString().equals((String) model.getValueAt(selectedRow, 4))) {
				    	authorC.setSelectedIndex(i);
				        break;
				    }
				}
				for (int i=0; i<publisherC.getItemCount(); i++) {
				    if (publisherC.getItemAt(i).toString().equals((String) model.getValueAt(selectedRow, 5))) {
				    	publisherC.setSelectedIndex(i);
				        break;
				    }
				}
				publicationYearI.setText((String) model.getValueAt(selectedRow, 6));
				editionI.setText((String) model.getValueAt(selectedRow, 7));
				priceI.setText(((String) model.getValueAt(selectedRow, 8)).substring(3));
				availableBooksI.setText((String) model.getValueAt(selectedRow, 9));
				
				cancelB.addActionListener(e1-> {
					home.dispose();
					new Home();
				});	
				
				updateBookB.addActionListener(e1-> {					
					if(isbnI.getText().equals("") || titleI.getText().equals("") || languageC.getSelectedItem().toString().equals("") ||
							genreC.getSelectedItem().toString().equals("") || authorC.getSelectedItem().toString().equals("") ||
							publisherC.getSelectedItem().toString().equals("") || publicationYearI.getText().equals("") || 
							editionI.getText().equals("") || priceI.getText().equals("") || availableBooksI.getText().equals("")) {
						JOptionPane.showMessageDialog(home, "Empty field, fill up the form completely!");					
					}
					else if(isbnI.getText().length()!=13){
						JOptionPane.showMessageDialog(home, "Provied 13 Digits in ISBN");					
					}
					else if(publicationYearI.getText().length()!=4){
						JOptionPane.showMessageDialog(home, "Provied 4 Digits in Publication Year");					
					}
					else if(availableBooksI.getText().length()>5){
						JOptionPane.showMessageDialog(home, "Provied number less than or equal to 5 Digits in Available Books");					
					}
					else if(!isNumeric(isbnI.getText().substring(0,7)) || !isNumeric(isbnI.getText().substring(7)) || !isNumeric(publicationYearI.getText()) || 
							!isNumeric(priceI.getText()) || !isNumeric(availableBooksI.getText())){
						JOptionPane.showMessageDialog(home, "Provied Numeric Value in ISBN, Publication Year, Price and Available Books");					
					}
					else if(isNumeric(titleI.getText()) || isNumeric(editionI.getText())){
						JOptionPane.showMessageDialog(home, "Provied Alphabetic Character in Title, Edition");					
					}
					else {
						String uQuery = "Update books set "
										+ "ISBN='"+isbnI.getText()+"', Title='"+titleI.getText()+"', Language='"+languageC.getSelectedItem().toString()+
										"', Genre='"+genreC.getSelectedItem().toString()+"', Author='"+authorC.getSelectedItem().toString()+
										"', Publisher='"+publisherC.getSelectedItem().toString()+"', PublicationYear='"+publicationYearI.getText()+
										"', Edition='"+editionI.getText()+"', Price='Rs."+priceI.getText()+"', AvailableBooks='"+availableBooksI.getText()+
										"' where ISBN='"+(String) model.getValueAt(selectedRow, 0)+"';";
						try {
							int uResult = db.connect().executeUpdate(uQuery);
							if(uResult>0) {
								JOptionPane.showMessageDialog(home, "Book Updated Successfully.");
								home.dispose();
								new Home();
							}
						} catch (SQLException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
					}
				});			
			}
			else {
				JOptionPane.showMessageDialog(home, "Select a Row first!");				
			}
		});
		
		deleteB.addActionListener(e-> {				
			int selectedRow = table.getSelectedRow();
			
			if(selectedRow>=0) {				
				TableModel model = table.getModel();				
				String dQuery = "delete from books where ISBN='"+(String) model.getValueAt(selectedRow, 0)+"';";
				try {
					int dResult = db.connect().executeUpdate(dQuery);
					if(dResult>0) {
						JOptionPane.showMessageDialog(home, "Book Deleted Successfully.");
						home.dispose();
						new Home();
					}
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
			else {
				JOptionPane.showMessageDialog(home, "Select a Row first!");				
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
