package arraylist;

import java.util.*;
public class DynamicArray {
	public static void main(String args[]) {
		ArrayList soft1=new ArrayList(); // Initialization of ArrayList
		
		// Defining ArrayList of Specific Type
		ArrayList<String> soft2=new ArrayList(); 
		ArrayList<Integer> soft3=new ArrayList();
		ArrayList<Double> soft4=new ArrayList();
		
		
		// Add Method
		soft1.add("Batch 28");
		soft1.add("Batch 29");
		soft1.add("Batch 30");
		soft1.add(12);
		soft1.add(34.5);
		soft1.add(true);
		soft1.add(1,"Batch 27");
		System.out.println("size of soft1: "+soft1.size());
		System.out.println("Batch in softwarica: "+soft1);
		
		// get method
		System.out.println("Value of softwarica in index 1: " + soft1.get(1));
		
		// remove
		soft1.remove("Batch 28");
		System.out.println("Batch in softwarica: "+soft1);
	}
}
