package Array;

import java.util.Scanner;

public class UserMatrixSum {
	public static void main(String args[]) {
		//Taking user input
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the number of rows of the matrixes: ");
		int rows=sc.nextInt();
		System.out.print("Enter the number of columns of the matrixes: ");
		int columns=sc.nextInt();
		
		//Inserting the user input
		System.out.println();
		System.out.println("<===For matrixC===>");
		int matrixC[] [] =matrix(rows, columns);
		
		System.out.println();
		System.out.println("<===For matrixD===>");
		int matrixD[] [] =matrix(rows, columns);
		
		// calculation for sum
		int matrixSum[] []=new int[rows] [columns];
		for(int i=0; i<rows; i++) {
			for(int j=0; j<columns; j++) {
				matrixSum[i] [j] = matrixC[i] [j] +matrixD[i] [j];
			}
		}
		
		// displaying matrixSum using for-each loop
		System.out.println();
		System.out.println("<==The matrix after sum==>");
		for(int r[]:matrixSum) {
			for(int col:r) {
				System.out.print(col+" ");
			}
			System.out.println();
		}
	}
	
	public static int[] [] matrix(int rows, int columns){
		Scanner sc=new Scanner(System.in);
		int matrix[] [] =new int[rows] [columns];
		for(int i=0; i<rows; i++) {
			for(int j=0; j<columns; j++) {
				System.out.print("Enter the number for row "+(i+1)+" column "+(j+1)+":");
				int value=sc.nextInt();
				matrix[i][j]=value;
			}
		}
		for(int r[]:matrix) {
			for(int col:r) {
				System.out.print(col+" ");
			}
			System.out.println();
		}
		return matrix;
	}

}
