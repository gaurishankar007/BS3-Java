package Array;

public class MatrixSum {
	public static void main(String args[]) {
		int matrixA[] []= {{1,2},{3,4}};
		int matrixB[] []= {{5,6},{7,8}};
		
		int rows=matrixA.length;
		int columns=matrixB[0].length;
		
		int matrixSum[] []=new int[rows] [columns];
		
		// calculation for sum
		for(int i=0; i<rows; i++) {
			for(int j=0; j<columns; j++) {
				matrixSum[i] [j] = matrixA[i] [j] +matrixB[i] [j];
			}
		}
		
		// displaying matrixSum using for-each loop
		System.out.println("<==Matrix after Sum==>");
		for(int r[]:matrixSum) {
			for(int col:r) {
				System.out.print(col+" ");
			}
			System.out.println();
		}
	}

}
