import java.util.Scanner;

public class Task {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Which task do you want to do?[1 for first task and 2 for second task]");
		int task = sc.nextInt();
		
		if (task==1) {
			System.out.println(task1());
		}
		else if (task==2) {		
			System.out.println(task2());
		}
		else {
			System.out.println("Enter 1 or 2.");
		}
	}	
	public static String task1() {	
		Scanner sc = new Scanner(System.in);
		System.out.println("Is it snowing?[true/false]");
		boolean isSnowing = sc.nextBoolean();
		System.out.println("Is it raining?[true/false]");
		boolean isRaining = sc.nextBoolean();
		System.out.println("What is outdoor temperature in Fahrenheit?");
		double temperature = sc.nextDouble();
		
		if (isSnowing || isRaining || temperature<50) {
			return "Let's stay home.";
		}
		else {
			return "Let's go out!";
		}		
	}	
	public static String task2() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of a day of week:");
		int day = sc.nextInt();
		
		String schedule;
		
		switch(day) {
		case 1:
			schedule = "Monday schedule: Gym in the morning.";
			break;
		case 2:
			schedule = "Tuesday schedule: class after work.";
			break;
		case 3:
			schedule = "Wednesday schedule: meetings all day.";
			break;
		case 4:
			schedule = "Thursday schedule: work from home.";
			break;
		case 5:
			schedule = "Friday schedule: game night after work.";
			break;
		case 6:
			schedule = "Saturday: free";
			break;
		case 7:
			schedule = "Sunday: free";
			break;
		default:
			schedule = "Please enter the number of a day of week!";
		}
		return schedule;
	}
}
