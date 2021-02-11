package Array;

import java.util.Scanner;
public class UserTwoDArray {
	public static void main(String args[]) {
		//Taking user input
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the number of rows of the array: ");
		int rows=sc.nextInt();
		System.out.print("Enter the number of columns of the array: ");
		int columns=sc.nextInt();
		
		//Inserting the user input
		int Array[] [] =new int[rows][columns];
		for(int i=0; i<rows; i++) {
			for(int j=0; j<columns; j++) {
				System.out.print("Enter the number for row "+(i+1)+" column "+(j+1)+":");
				int value=sc.nextInt();
				Array[i][j]=value;
			}
		}
		
		//Displaying data in matrix form
		System.out.println();
		System.out.println("<====Your Two Dimensional Array====>");
		for(int a[]:Array) {
			for(int b:a) {
				System.out.print(b+" ");
			}
			System.out.println();
		}
	}

}
