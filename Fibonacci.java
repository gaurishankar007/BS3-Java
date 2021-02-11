import java.util.Scanner;

public class Fibonacci {
	
	public static void main(String[] args) {
		System.out.print("Enter the number you want to fibonacci of: ");
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		System.out.println("Fibonacci of " + number + " is " +fib(number) + ".");
	}
	
	public static int fib(int n) {
		if (n==0 || n==1) {
			return n;
		}
		else {
			return fib(n-1) + fib(n-2);
		}
	}
	
}
