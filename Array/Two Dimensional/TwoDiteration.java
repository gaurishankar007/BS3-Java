package Array;

import java.util.Arrays;

public class TwoDiteration {
	public static void main(String args[]) {
		int random1[] [] = {{2,4,8},{8,9,11},{22,10,13}};
		
		int rows=random1.length;
		int columns=random1[0].length;
		
		for(int i=0; i<rows; i++) {
			for(int j=0; j<columns; j++) {
				System.out.print(random1[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println("-----------");
		
		//Use of for each
		for(int row[]:random1) {
			for(int column:row) {
				System.out.print(column+" ");
			}
			System.out.println();
		}
	}
}
