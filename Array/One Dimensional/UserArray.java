package Array;

import java.util.Scanner;
public class UserArray {
	
	public static void main(String args[]) {
		// take input from the user
		Scanner sc= new Scanner(System.in);
		System.out.print("Enter the size of array: ");
		int n = sc.nextInt();
		
		// array to size and memory allocation
		int random[] = new int[n];
		
		// insert the data in the array
		for(int i=0; i<random.length; i++) {
			System.out.print("Enter the data at position " + i + ":");
			random[i]=sc.nextInt();
		}
		
		// display the created array
		for(int data:random) {
			System.out.print(data);
		}
	}

}
