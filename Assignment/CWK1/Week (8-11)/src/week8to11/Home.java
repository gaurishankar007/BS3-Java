package week8to11;

import javax.swing.*;

import java.awt.*;
import javax.swing.border.Border;

import java.util.*;
import java.io.*;

public class Home {
	
	Home (){
		JFrame home = new JFrame("Home Page");
		home.setLayout(null);
		home.setVisible(true);
		home.setSize(1930, 1040);
		home.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		JLabel title = new JLabel("Softwarica Network Architecture");
		home.add(title);
		Border border = BorderFactory.createLineBorder(Color.GREEN, 4);
	    title.setBorder(border);
        title.setFont(new Font("Times", Font.PLAIN, 60));
		title.setBounds(535, 10, 860, 100);
		
		JButton logoutB = new JButton("Logout");
		home.add(logoutB);
        logoutB.setFont(new Font("Times", Font.PLAIN, 20));
		logoutB.setBounds(1800, 10, 100, 40);
		
		logoutB.addActionListener(e->{
			home.dispose();
			new Login();
		});
		
		JButton devicesB = new JButton("View Devices");
		home.add(devicesB);
        devicesB.setFont(new Font("Times", Font.PLAIN, 20));
		devicesB.setBounds(865, 120, 200, 40);
		
		devicesB.addActionListener(e-> {
			home.dispose();
			new Devices();
		});
		
		ArrayList<String> ids = new ArrayList<>();
		ArrayList<String> devName = new ArrayList<>();
		try {
			File file = new File("Devices.txt");
	        if (file.exists()) {  
	        	Scanner read = new Scanner(file);
	        	while(read.hasNextLine()) {
	        		String line = read.next();
	        		String lineArray [] = line.split(";");
	        		ids.add(lineArray[0]);
	        		devName.add(lineArray[3]);
	        	}
	        }
	    } 
		catch (IOException e2) {			    	
		    JOptionPane.showMessageDialog(home, "An error occurred.");
	        e2.printStackTrace();
	    }
		
		String mnArray [] = new String[devName.size()];
		for(int i=0; i<ids.size(); i++) {
			mnArray[i]=devName.get(i);
		}

		int devConGr [] [] = new int [100] [100];
		try {
			File file = new File("Connections.txt");
			if (file.exists()) {	
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
	        } 
	    } 
		catch (IOException e2) {			    	
		    JOptionPane.showMessageDialog(home, "An error occurred.");
	        e2.printStackTrace();
	    }
		
		JLabel deviceSelL = new JLabel("Select Devices:");
		home.add(deviceSelL);
        deviceSelL.setFont(new Font("Times", Font.PLAIN, 25));
		deviceSelL.setBounds(390, 175, 180, 50);
		
		JComboBox<String> deviceMNC1 = new JComboBox<>(mnArray);
		home.add(deviceMNC1);
        deviceMNC1.setFont(new Font("Times", Font.PLAIN, 20));
		deviceMNC1.setBounds(570, 180, 200, 40);
		
		JComboBox<String> deviceMNC2 = new JComboBox<>(mnArray);
		home.add(deviceMNC2);
        deviceMNC2.setFont(new Font("Times", Font.PLAIN, 20));
		deviceMNC2.setBounds(790, 180, 200, 40);
		
		JButton connectB = new JButton("Connect");
		home.add(connectB);
        connectB.setFont(new Font("Times", Font.PLAIN, 20));
		connectB.setBounds(1010, 180, 110, 40);
		
		JButton delConB = new JButton("Delete Connection");
		home.add(delConB);
        delConB.setFont(new Font("Times", Font.PLAIN, 20));
		delConB.setBounds(1140, 180, 200, 40);
		
		JButton optPthB = new JButton("Optimal Path");
		home.add(optPthB);
        optPthB.setFont(new Font("Times", Font.PLAIN, 20));
		optPthB.setBounds(1360, 180, 180, 40);
		
		JLabel connectedDivsL = new JLabel("Connected Devices' List");
		home.add(connectedDivsL);
        connectedDivsL.setFont(new Font("Times", Font.PLAIN, 50));
		connectedDivsL.setBounds(690, 240, 550, 50);
		
		DefaultListModel<String> divConLis = new DefaultListModel<>();  
		for(int i=0; i<devConGr.length; i++) {
			String dev="", conDevs="";
			for(int j=0; j<50; j++) {
				if(devConGr[i][j]==1) {
					if(dev=="") {
						dev += devName.get(ids.indexOf(String.valueOf(i)));  
					}
					conDevs += devName.get(ids.indexOf(String.valueOf(j)))+", ";  
				}
			}
			if(dev!="") {
			    divConLis.addElement("["+dev+"==> "+conDevs+"]");
			    divConLis.addElement("");
			}
		}
		
		JList<String> disDivCon = new JList<>(divConLis);
        disDivCon.setFont(new Font("selrif", Font.PLAIN, 35));
		disDivCon.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION );
		disDivCon.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		disDivCon.setLayoutOrientation(JList.VERTICAL_WRAP);
		disDivCon.setVisibleRowCount(100);
		
		JScrollPane listScroller = new JScrollPane(disDivCon);
		home.add(listScroller);
		listScroller.setBounds(300, 300, 1330, 500);
		listScroller.setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
		
		connectB.addActionListener(e-> {
			int id1 = Integer.parseInt(ids.get(devName.indexOf(deviceMNC1.getSelectedItem().toString())));
			int id2 = Integer.parseInt(ids.get(devName.indexOf(deviceMNC2.getSelectedItem().toString())));
			if(id1==id2) {
				JOptionPane.showMessageDialog(home, "Can not connect same devices.");
			}
			else if(devConGr[id1][id2]==1) {
				JOptionPane.showMessageDialog(home, "Devices are already connected.");
			}
			else {
				try {
					File file = new File("Connections.txt");
					if (!file.exists()) {
			        	file.createNewFile();
			        } 
		        	devConGr[id1][id2]=1;
		        	devConGr[id2][id1]=1;
					FileWriter fw = new FileWriter("Connections.txt");
		            BufferedWriter bw = new BufferedWriter(fw);
		    		for(int i=0; i<devConGr.length; i++) {
		    			for(int j=0; j<devConGr.length; j++) {
		    	            bw.write(devConGr[i][j]+";");
		    			}
		    			bw.newLine();
		    		}
		            bw.close();	
					JOptionPane.showMessageDialog(home, "Devices has been connected.");
					home.dispose();
					new Home();	
			    } 
				catch (IOException e2) {			    	
				    JOptionPane.showMessageDialog(home, "An error occurred.");
			        e2.printStackTrace();
			    }
			}
		});
		
		delConB.addActionListener(e-> {
			int id1 = Integer.parseInt(ids.get(devName.indexOf(deviceMNC1.getSelectedItem().toString())));
			int id2 = Integer.parseInt(ids.get(devName.indexOf(deviceMNC2.getSelectedItem().toString())));
			if(id1==id2) {
				JOptionPane.showMessageDialog(home, "Can not delete connections of same devices.");
			}
			else if(devConGr[id1][id2]==0) {
				JOptionPane.showMessageDialog(home, "Devices has never been connected.");
			}
			else {
				try {
		        	devConGr[id1][id2]=0;
		        	devConGr[id2][id1]=0;
					FileWriter fw = new FileWriter("Connections.txt");
		            BufferedWriter bw = new BufferedWriter(fw);
		    		for(int i=0; i<devConGr.length; i++) {
		    			for(int j=0; j<devConGr.length; j++) {
		    	            bw.write(devConGr[i][j]+";");
		    			}
		    			bw.newLine();
		    		}
		            bw.close();	
					JOptionPane.showMessageDialog(home, "Device has been disconnected.");
					home.dispose();
					new Home();	
			    } 
				catch (IOException e2) {			    	
				    JOptionPane.showMessageDialog(home, "An error occurred.");
			        e2.printStackTrace();
			    }
			}			
		});
		
		optPthB.addActionListener(e-> {
			int id1 = Integer.parseInt(ids.get(devName.indexOf(deviceMNC1.getSelectedItem().toString())));
			int id2 = Integer.parseInt(ids.get(devName.indexOf(deviceMNC2.getSelectedItem().toString())));
			if(id1==id2) {
				JOptionPane.showMessageDialog(home, "Can not find optimal path between same devices.");
			}
			else {	
				int size = devConGr.length;
				boolean visited [] = new boolean[size];
				int distance [] = new int[size];
				int prePath [] = new int[size];
				
				for(int i=0; i<size; i++) {
					distance[i]=Integer.MAX_VALUE;
					prePath[i]=-1;
				}
				
				visited[id1] = true;
				distance[id1] = 0;
				CustomQueue q = new CustomQueue(size);
				q.enqueue(id1);
				
				while(!q.isEmpty()) {
					int u = q.dequeue();
					Iterator<Integer> iterate = getAdjNodes(u, devConGr).iterator();
					while(iterate.hasNext()) {
						int v = iterate.next();
						if(!visited[v]) {
							q.enqueue(v);
							visited[v] = true;
							distance[v] = distance[u]+1;
							prePath[v] = u;
						}
					}
				}
				
				int des = id2;
				ArrayList<Integer> optPath = new ArrayList<>();
				optPath.add(des);
				while(prePath[des]!=-1) {
					optPath.add(prePath[des]);
					des=prePath[des];
				}
				
				if(distance[id2]!=Integer.MAX_VALUE) {
					JLabel optPathL = new JLabel("Optimal Path");
					home.add(optPathL);
			        optPathL.setFont(new Font("Times", Font.PLAIN, 50));
					optPathL.setBounds(815, 820, 300, 50);
					
					String a = "";
					for(int i=optPath.size()-1; i>=0; i--) {
						if(i!=0) {
							a+=devName.get(ids.indexOf(String.valueOf(optPath.get(i))))+" ---->";
						}
						else {
							a+=devName.get(ids.indexOf(String.valueOf(optPath.get(i))));
						}
					}
					DefaultListModel<String> optConPathLis = new DefaultListModel<>(); 
					optConPathLis.addElement("Shortest distance from "+devName.get(ids.indexOf(String.valueOf(id1)))+
											 " to "+devName.get(ids.indexOf(String.valueOf(id2)))+" is "+distance[id2]+".");
					optConPathLis.addElement(a);
					
					JList<String> optPathLis = new JList<>(optConPathLis);
					optPathLis.setFont(new Font("selrif", Font.PLAIN, 25));
					optPathLis.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION );
					optPathLis.setLayoutOrientation(JList.VERTICAL_WRAP);
					optPathLis.setVisibleRowCount(2);
					
					JScrollPane listScroller1 = new JScrollPane(optPathLis);
					home.add(listScroller1);
					listScroller1.setBounds(565, 875, 800, 110);
					listScroller1.setBorder(BorderFactory.createLineBorder(Color.BLUE, 4));
				}
				else {
					JOptionPane.showMessageDialog(home, "No connection between the device "+devName.get(ids.indexOf(String.valueOf(id1)))+
													    " to "+devName.get(ids.indexOf(String.valueOf(id2)))+".");			
				}
			}			
		});
	}
	
	public ArrayList<Integer> getAdjNodes(int source, int graph[] []) {
		ArrayList<Integer> adjnodes=new ArrayList<>();
		for(int i=0; i<graph.length; i++) {
			if(graph [source] [i]!=0) {
				adjnodes.add(i);
			}
		}
		return adjnodes;
	}
}
