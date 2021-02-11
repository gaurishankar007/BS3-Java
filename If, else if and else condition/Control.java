import java.util.Scanner;

public class Control {
	public static void main(String[] args) {
		
		boolean isGreen=true;
		// if statement
		if (isGreen) {
			System.out.println("You can Drive");			
		}
		
		// if statement with variable scope
		if (isGreen) {
			double carSpeed=100.45; // speed in kilometer
			System.out.println("You can drive");
			System.out.println("Speed is: "+carSpeed+" KM");
		}
		
		// if-else statement
		if (isGreen) {
			System.out.println("You can drive");
		}
		else {
			System.out.println("Please stop!");
		}
		
		//Inputing 
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the passcode of the coffee you want to Drink: ");
		int passcode = sc.nextInt();
		
		String coffeeType;
		
		if(passcode == 555) {
			coffeeType = "Espresso";
		}
		else if(passcode==312) {
			coffeeType = "Vannila Latte";
		}
		else if(passcode ==629) {
			coffeeType = "Drip Coffe";
		}
		else
		{
			coffeeType = "Unknown";
		}
		System.out.println(coffeeType);
	}

}
