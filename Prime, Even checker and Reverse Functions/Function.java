import java.util.Scanner;

public class Function {
	
	public static boolean isEven(int n) {
		if(n%2==0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public int isPrime(int n) {
		int flag=1;
		for(int i=2; i<n; i+=1) {
			if(n%i==0) {
				flag=0;
				break;			
			}			
		}
		return flag;
	}
	
	public int reverse(int number) {
		int reverseNumber;
		reverseNumber = 0;
		
		while (number!=0) {
			int digit = number%10;
			reverseNumber = reverseNumber*10 + digit;
			number = number/10;
		}
		return  reverseNumber;
	}
	
	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		
		//isEven
		System.out.println("Enter the number you want to check whether it is even or odd: ");
		int num = sc.nextInt();
		boolean result=isEven(num);
		if(result) {
			System.out.println("The number is Even.");
		}
		else {
			System.out.println("The number is Odd.");
		}
		
		//isPrime
		Function obj = new Function();
		System.out.println("Enter the number you want to check whether it is prime or composite: ");
		int num1 = sc.nextInt();
		if(obj.isPrime(num1)==1) {
			System.out.println("The number is Prime.");
		}
		else {
			System.out.println("The number is composite.");
		}
		
		// Reversing Number
		System.out.println("Enter the number you want to reverse: ");
		int num2 = sc.nextInt();
		System.out.print("Reversed number: ");
		System.out.print(obj.reverse(num2));
	}

}




