import java.util.Scanner;

public class Swap {
	public static void main(String[] args){
		int firstNumber, secondNumber, temp;
		firstNumber=40;
		secondNumber=93;
		System.out.println("Before swapping:");
		System.out.println("First Number:"+firstNumber);
		System.out.println("Second Number: "+secondNumber);
		
		temp=firstNumber;
		
		firstNumber = secondNumber;
		secondNumber = temp;
		System.out.println("After swapping:");
		System.out.println("First Number: "+firstNumber);
		System.out.println("Second Number: "+secondNumber);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the passcode of the coffee you want to Drink: ");
		int passcode = sc.nextInt();
		
		String coffeeType;
		
		switch(passcode) {
		case 555:
			coffeeType= "Espresso";
			break;
		case 312:
			coffeeType = "Vannila Lattee";
			break;
		case 629:
			coffeeType = "Drip Coffee";
			break;
		default:
			coffeeType = "Unknown";
		}
		
		System.out.println("Yor Drink is " + coffeeType);
	}

}
