package week8to11;

import javax.swing.*;

import java.awt.*;
import javax.swing.border.Border;

import java.util.*;

import java.io.*;

public class Devices {
	
	Devices () {
		JFrame devices = new JFrame("Home Page");
		devices.setLayout(null);
		devices.setVisible(true);
		devices.setSize(1930, 1040);
		devices.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		JLabel title = new JLabel("Softwarica Network Architecture");
		devices.add(title);
		Border border = BorderFactory.createLineBorder(Color.GREEN, 4);
	    title.setBorder(border);
        title.setFont(new Font("Times", Font.PLAIN, 60));
		title.setBounds(535, 10, 860, 100);
		
		JButton backB = new JButton("Back");
		devices.add(backB);
        backB.setFont(new Font("Times", Font.PLAIN, 20));
		backB.setBounds(1800, 10, 100, 40);
		
		backB.addActionListener(e->{
			devices.dispose();
			new Home();
		});

		ArrayList<DeviceData> deviceData = new ArrayList<>();
		try {
			File file = new File("Devices.txt");
	        if (file.exists()) {  
	        	Scanner read = new Scanner(file);
	        	while(read.hasNextLine()) {
	        		String line = read.next();
	        		String lineArray [] = line.split(";");
	        		DeviceData obj = new DeviceData(lineArray[0], lineArray[1], lineArray[2], lineArray[3], lineArray[4]);
	        		deviceData.add(obj);
	        	}
	        }
	    } 
		catch (IOException e2) {			    	
		    JOptionPane.showMessageDialog(devices, "An error occurred.");
	        e2.printStackTrace();
	    }
		
		String column [] = {"ID", "Model Number", "Ports", "Product Name", "Product Type"};
		Object row [] [] = new Object [deviceData.size()] [column.length];
		for(int i=0; i<deviceData.size(); i++) {
			row[i][0] = deviceData.get(i).id;
			row[i][1] = deviceData.get(i).mn;
			row[i][2] = deviceData.get(i).ports;
			row[i][3] = deviceData.get(i).pn;
			row[i][4] = deviceData.get(i).pt;
		}
		
		JTable table = new JTable(row, column);
        table.setFont(new Font("selrif", Font.PLAIN, 15));
		JScrollPane sp = new  JScrollPane(table);
		Border blue = BorderFactory.createLineBorder(Color.BLUE, 4);
		sp.setBorder(blue);
		devices.add(sp);
		sp.setBounds(50, 120, 1830, 400);
		
		JButton addB = new JButton("Add New Device");
		devices.add(addB);
        addB.setFont(new Font("Times", Font.PLAIN, 20));
		addB.setBounds(1350, 530, 180, 40);
		
		JButton updateB = new JButton("Update Device");
		devices.add(updateB);
        updateB.setFont(new Font("Times", Font.PLAIN, 20));
		updateB.setBounds(1540, 530, 170, 40);
		
		JButton deleteB = new JButton("Delete Device");
		devices.add(deleteB);
        deleteB.setFont(new Font("Times", Font.PLAIN, 20));
		deleteB.setBounds(1720, 530, 160, 40);
		
		addB.addActionListener(e-> {
			addB.setVisible(false);
			updateB.setVisible(false);
			deleteB.setVisible(false);
			
			JLabel idL = new JLabel("ID:");
			devices.add(idL);
	        idL.setFont(new Font("Times", Font.PLAIN, 25));
			idL.setBounds(70, 630, 40, 50);
			
			JTextField idI = new JTextField();
			devices.add(idI);
	        idI.setFont(new Font("Times", Font.PLAIN, 20));
			idI.setBounds(110, 635, 200, 40);
			
			JLabel mnL = new JLabel("Model Number:");
			devices.add(mnL);
	        mnL.setFont(new Font("Times", Font.PLAIN, 25));
			mnL.setBounds(350, 630, 180, 50);
			
			JTextField mnI = new JTextField();
			devices.add(mnI);
	        mnI.setFont(new Font("Times", Font.PLAIN, 20));
			mnI.setBounds(530, 635, 200, 40);
			
			JLabel portsL = new JLabel("Ports:");
			devices.add(portsL);
	        portsL.setFont(new Font("Times", Font.PLAIN, 25));
			portsL.setBounds(770, 630, 70, 50);
			
			JTextField portsI = new JTextField();
			devices.add(portsI);
	        portsI.setFont(new Font("Times", Font.PLAIN, 20));
			portsI.setBounds(840, 635, 200, 40);
			
			JLabel pnL = new JLabel("Product Name:");
			devices.add(pnL);
	        pnL.setFont(new Font("Times", Font.PLAIN, 25));
			pnL.setBounds(1080, 630, 170, 50);
			
			JTextField pnI = new JTextField();
			devices.add(pnI);
	        pnI.setFont(new Font("Times", Font.PLAIN, 20));
			pnI.setBounds(1250, 635, 200, 40);
			
			JLabel  ptL = new JLabel("Product Type:");
			devices.add(ptL);
	        ptL.setFont(new Font("Times", Font.PLAIN, 25));
			ptL.setBounds(1490, 630, 170, 50);
			
			JTextField ptI = new JTextField();
			devices.add(ptI);
	        ptI.setFont(new Font("Times", Font.PLAIN, 20));
			ptI.setBounds(1660, 635, 200, 40);
			
			JButton addDeviceB = new JButton("Add Device");
			devices.add(addDeviceB);
	        addDeviceB.setFont(new Font("Times", Font.PLAIN, 20));
			addDeviceB.setBounds(820, 705, 150, 40);
			
			JButton cancelB = new JButton("Cancel");
			devices.add(cancelB);
	        cancelB.setFont(new Font("Times", Font.PLAIN, 20));
			cancelB.setBounds(990, 705, 100, 40);
			
			cancelB.addActionListener(e1-> {
				devices.dispose();
				new Devices();
			});
			
			addDeviceB.addActionListener(e1-> {	
				String id = idI.getText();
				String mn = mnI.getText();
				String ports = portsI.getText();
				String pn = pnI.getText();
				String pt = ptI.getText();
				
				if(id.equals("") || mn.equals("") || ports.equals("") || pn.equals("") || pt.equals("")) {
					JOptionPane.showMessageDialog(devices, "Fill up the form first!");
				}
				else {
					try {
						File file = new File("Devices.txt");
						if (!file.exists()) {
				        	file.createNewFile();
				        } 
				        if(file.length()==0) {
				        	if(id.equals("0")) {
					            FileWriter fw = new FileWriter("Devices.txt");
					            BufferedWriter bw = new BufferedWriter(fw);
					            bw.write(id+";"+mn+";"+ports+";"+pn+";"+pt);
					            bw.close();
								JOptionPane.showMessageDialog(devices, "Device has been successfully added.");
								devices.dispose();
								new Devices();	
							}
				        	else {
								JOptionPane.showMessageDialog(devices, "Start ID with Zero");				        		
				        	}
				        }
				        else {	
				        	ArrayList<String> ids = new ArrayList<>();
				        	ArrayList<String> mns = new ArrayList<>();
				        	Scanner read = new Scanner(file);
				        	while(read.hasNextLine()) {
				        		String line = read.next();
				        		String lineArray [] =line.split(";");
				        		ids.add(lineArray[0]);
				        		mns.add(lineArray[1]);
				        	}
			        		if(ids.contains(id)) {
								JOptionPane.showMessageDialog(devices, "ID already exists.");
			        		}
			        		else if(Integer.parseInt(ids.get(ids.size()-1))!=Integer.parseInt(id)-1) {
								JOptionPane.showMessageDialog(devices, "ID should be greater by one than the id of the last added device");		        			
			        		}
			        		else if(mns.contains(mn)) {
								JOptionPane.showMessageDialog(devices, "Model Number already exists.");		        			
			        		}
			        		else {
					            BufferedWriter bw = new BufferedWriter(new FileWriter("Devices.txt", true));
					            bw.newLine();
					            bw.write(id+";"+mn+";"+ports+";"+pn+";"+pt);
					            bw.close();
								JOptionPane.showMessageDialog(devices, "Device has been added.");
								devices.dispose();
								new Devices();	
			        		}
				        }
				    } 
					catch (IOException e2) {			    	
					    JOptionPane.showMessageDialog(devices, "An error occurred.");
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
				
				JLabel mnL = new JLabel("Model Number:");
				devices.add(mnL);
		        mnL.setFont(new Font("Times", Font.PLAIN, 25));
				mnL.setBounds(190, 630, 180, 50);
				
				JTextField mnI = new JTextField();
				devices.add(mnI);
		        mnI.setFont(new Font("Times", Font.PLAIN, 20));
				mnI.setBounds(370, 635, 200, 40);
				
				JLabel portsL = new JLabel("Ports:");
				devices.add(portsL);
		        portsL.setFont(new Font("Times", Font.PLAIN, 25));
				portsL.setBounds(610, 630, 70, 50);
				
				JTextField portsI = new JTextField();
				devices.add(portsI);
		        portsI.setFont(new Font("Times", Font.PLAIN, 20));
				portsI.setBounds(680, 635, 200, 40);
				
				JLabel pnL = new JLabel("Product Name:");
				devices.add(pnL);
		        pnL.setFont(new Font("Times", Font.PLAIN, 25));
				pnL.setBounds(920, 630, 170, 50);
				
				JTextField pnI = new JTextField();
				devices.add(pnI);
		        pnI.setFont(new Font("Times", Font.PLAIN, 20));
				pnI.setBounds(1090, 635, 200, 40);
				
				JLabel  ptL = new JLabel("Product Type:");
				devices.add(ptL);
		        ptL.setFont(new Font("Times", Font.PLAIN, 25));
				ptL.setBounds(1330, 630, 170, 50);
				
				JTextField ptI = new JTextField();
				devices.add(ptI);
		        ptI.setFont(new Font("Times", Font.PLAIN, 20));
				ptI.setBounds(1500, 635, 200, 40);
				
				JButton updateDeviceB = new JButton("Update Device");
				devices.add(updateDeviceB);
		        updateDeviceB.setFont(new Font("Times", Font.PLAIN, 20));
				updateDeviceB.setBounds(820, 705, 170, 40);
				
				JButton cancelB = new JButton("Cancel");
				devices.add(cancelB);
		        cancelB.setFont(new Font("Times", Font.PLAIN, 20));
				cancelB.setBounds(1010, 705, 100, 40);
				
				cancelB.addActionListener(e1-> {
					devices.dispose();
					new Devices();
				});			
				
				mnI.setText((String) table.getModel().getValueAt(selectedRow, 1));
				portsI.setText((String) table.getModel().getValueAt(selectedRow, 2));
				pnI.setText((String) table.getModel().getValueAt(selectedRow, 3));
				ptI.setText((String) table.getModel().getValueAt(selectedRow, 4));
				
				updateDeviceB.addActionListener(e1-> {	
					String mn = mnI.getText();
					String ports = portsI.getText();
					String pn = pnI.getText();
					String pt = ptI.getText();
					
					if(mn.equals("") || ports.equals("") || pn.equals("") || pt.equals("")) {
						JOptionPane.showMessageDialog(devices, "Fill up the form first!");
					}
					else {
						deviceData.get(selectedRow).mn=mn;
						deviceData.get(selectedRow).ports=ports;
						deviceData.get(selectedRow).pn=pn;
						deviceData.get(selectedRow).pt=pt;
						try {
					        BufferedWriter bw = new BufferedWriter(new FileWriter("Devices.txt"));
							for(int i=0; i<deviceData.size(); i++) {
								if(i==0) {
						            bw.write(deviceData.get(i).id+";"+deviceData.get(i).mn+";"+deviceData.get(i).ports+";"+deviceData.get(i).pn+";"+deviceData.get(i).pt);
								}
								else {
						            bw.newLine();
						            bw.write(deviceData.get(i).id+";"+deviceData.get(i).mn+";"+deviceData.get(i).ports+";"+deviceData.get(i).pn+";"+deviceData.get(i).pt);							
								}
							}
				            bw.close();
							JOptionPane.showMessageDialog(devices, "Device has been updated.");
							devices.dispose();
							new Devices();	
						} 
						catch (IOException e2) {			    	
						    JOptionPane.showMessageDialog(devices, "An error occurred.");
					        e2.printStackTrace();
					    }
					}
				});				
			}
			else {
				JOptionPane.showMessageDialog(devices, "Select a Row first!");								
			}
		});
		
		deleteB.addActionListener(e-> {
			int selectedRow = table.getSelectedRow();
			if(selectedRow>=0) {
	        	boolean conChecker = false;
				try {
					File file = new File("Connections.txt");
					if(file.exists()) {	
						int devConGr [] [] = new int [100] [100];
			            int indx=-1;
			        	Scanner read = new Scanner(file);
			        	while(read.hasNextLine()) {
			        		String line = read.nextLine();
			        		String lineArray [] = line.split(";");
			        		indx++;
			        		for(int j=0; j<lineArray.length; j++) {
			        			devConGr[indx][j]=Integer.parseInt(lineArray[j]);
			        		}
			        	}
			        	
			        	int deviceId = Integer.parseInt((String) table.getModel().getValueAt(selectedRow,0));
			        	for(int i=0; i<devConGr.length; i++) {
			        		if(devConGr[deviceId][i]==1) {
			        			conChecker = true;
			        		}
			        	}
					}
					if(conChecker) {		    	
					    JOptionPane.showMessageDialog(devices, "This Device has connection with other divices. Delete the connections first.");					
					}
					else {			
						deviceData.remove(selectedRow);
				        BufferedWriter bw = new BufferedWriter(new FileWriter("Devices.txt"));
						for(int i=0; i<deviceData.size(); i++) {
							if(i==0) {
					            bw.write(deviceData.get(i).id+";"+deviceData.get(i).mn+";"+deviceData.get(i).ports+";"+deviceData.get(i).pn+";"+deviceData.get(i).pt);
							}
							else {
					            bw.newLine();
					            bw.write(deviceData.get(i).id+";"+deviceData.get(i).mn+";"+deviceData.get(i).ports+";"+deviceData.get(i).pn+";"+deviceData.get(i).pt);							
							}
						}
			            bw.close();
						JOptionPane.showMessageDialog(devices, "Device has been deleted.");
						devices.dispose();
						new Devices();								
					}
				} 
				catch (IOException e2) {			    	
				    JOptionPane.showMessageDialog(devices, "An error occurred.");
			        e2.printStackTrace();
			    }
			}
			else {
				JOptionPane.showMessageDialog(devices, "Select a Row first!");								
			}
		});
	}
}
