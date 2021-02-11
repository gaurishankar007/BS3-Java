package Array;

import java.util.Scanner;
public class RainTrapping {
	
	public static void main(String args[]) {
		userArray();
	}
	
	public static void userArray() {
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter number of building along with the gap: ");
		int length=scn.nextInt();
		
		int buildingHeight[]=new int[length];
		for(int i=0; i<length; i++) {
			System.out.print("Enter the height of the building for building "+(i+1)+": ");
			int value=scn.nextInt();
			buildingHeight[i]=value;
		}
		System.out.print("The amout of rain trapped between the building is "+firstWay(buildingHeight)+" unit.");
	}
	
	public static int firstWay(int bh[]) {
		int length=bh.length;
		
		int leftmax[]=new int[length];
		leftmax[0]=bh[0];
		for(int i=1; i<length; i++) {
			leftmax[i]=Math.max(bh[i], leftmax[i-1]);
		}
		
		int rightmax[]=new int[length];
		rightmax[length-1]=bh[length-1];
		for(int i=length-2; i>=0; i--) {
			rightmax[i]=Math.max(bh[i], rightmax[i+1]);
		}
		
		int total=0;
		for(int i=0; i<length; i++) {
			total=total +(Math.min(leftmax[i], rightmax[i])-bh[i]);
		}
		return total;
	}
}
