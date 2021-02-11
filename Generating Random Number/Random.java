
public class Random {
	public static void main(String[] args) {
		
		int roll1 = rollDice(6);
		int roll2 = rollDice(10);
		System.out.println("First Roll: " + roll1);
		System.out.println("Second Roll: " + roll2);
	}
	
	public static int rollDice(int x) {
		//random number 0 to almost(1)
		double randomNumber = Math.random();
				
		//changing range 0 to almost(10)
		randomNumber = randomNumber * x;
		//casting to integer
		int randomInt = (int)randomNumber;
				
		//shifting range to 1-10
		randomInt = randomInt + 1;
				
		return randomInt;
	}
}
