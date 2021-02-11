import java.util.Scanner;

public class Dice {
	public static void main(String[] args) {		
		System.out.println("Choose which dice you want to play between 6 side or 10 side dice.");
		System.out.println("Note: Type 6 for 6 side dice and 10 for 10 side dice.");
		boolean check=true;
		while(check) {
			Scanner sc=new Scanner(System.in);
			int input=sc.nextInt();
			if (input==6) {
				sixSideDice();
				check=false;
				break;
			}
			else if (input==10) {
				tenSideDice();
				check=false;
				break;
			}
			else {
				System.out.print("Incorrect Input! Please enter again: ");
			}
		}	
	}
	
	public static void sixSideDice() {
		System.out.println("================<Rolling 6 side dice>================");
		boolean check=true;
		while (check) {
			int result = randomNumber(6);
			if (result==6) {
				System.out.println(result);
				System.out.println("You Won!");
				check=false;
				break;
			}
			else if (result==3) {
				System.out.println(result);
				System.out.println("You lose!");
				check=false;
				break;
			}
			else {
				System.out.println(result);
			}
		}
	}
	
	public static void tenSideDice() {
		System.out.println("================<Rolling 10 side dice>================");
		boolean check=true;
		while (check) {
			int result = randomNumber(10);
			if (result==10) {
				System.out.println(result);
				System.out.println("You Won!");
				check=false;
				break;
			}
			else if (result==5) {
				System.out.println(result);
				System.out.println("You lose!");
				check=false;
				break;
			}
			else {
				System.out.println(result);
			}
		}
	}
	
	public static int randomNumber(int x) {
		double ranNum1 = (Math.random()*x) + 1;
		int ranNum = (int) ranNum1;
		return ranNum;
	}

}
