package classwork;

import java.util.Scanner;
public class NumberConverter {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter how many digit of binary number you want to convert: ");
		int totalDigit = sc.nextInt();
		System.out.println("Enter "+totalDigit+" digit binary number: ");
		int binaryNumber=0;
		String binaryNum = " ";
		
		for(int i=(totalDigit-1); i>=0; i--) {
			System.out.print("Enter the binary digits: ");
			int binaryDigit = sc.nextInt();		
			binaryNum=binaryNum+Integer.toString(binaryDigit);
			binaryNumber=(int) (binaryNumber+(binaryDigit*(Math.pow(2, i))));
		}
		System.out.println("The Decimal number of"+binaryNum+" is "+binaryNumber+".");
	}
}
