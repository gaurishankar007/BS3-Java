import java.util.Scanner;
public class NumberGuess {
	
	public static void main(String args[]) {
		NumberGuess obj=new NumberGuess();
		int rnum=obj.randomNumber();
		
		boolean judge=false;
		
		Scanner scn=new Scanner(System.in);
		System.out.println("A random number is generated.Now you ten chance to guess the number");
		System.out.println();
		for(int i=1; i<=10; i++) {
			System.out.print("Guess the number: ");
			int gnum=scn.nextInt();
			
			if(rnum==gnum) {
				System.out.println("Congratulation! You have won the game.");
				judge=true;
				break;
			}
			
			else if(rnum>gnum) {
				System.out.println("The number is greater than your guess."+"Remaining chance "+(10-i)+".");
				System.out.println();
			}
			
			else {
				System.out.println("The number is less than your guess."+"Remaining chance "+(10-i)+".");
				System.out.println();
			}
		}
		if(judge==false) {
			System.out.println("You have failed the game.");
		}
	}
	
	int randomNumber() {
		double number=Math.random();
		number = number*100;
		number=number+1;
		int number1=(int) number;
		return number1;
	}

}
