import java.time.LocalTime;
import java.util.Scanner;

public class AlarmTimer {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the hour you want to play: ");
		int hr = sc.nextInt();
		System.out.print("Enter the minute you want to play: ");
		int min = sc.nextInt();
		alarm(hr, min);
	}
	
	public static void alarm(int hr, int min) {
		boolean on = checkalarm(hr, min);
		while(on) {
			beep();
			on = checkalarm(hr, min);
			if(on==false) {
				System.out.println("Alarm has benn offed.");
			}
		}
	}
	
	public static boolean checkalarm(int hr, int min) {
		LocalTime now = LocalTime.now();
		
		boolean set = false;
		if(hr==now.getHour() && min==now.getMinute()) {
			set = true;
		}
		else if (hr<now.getHour()) {
			System.out.println("Your Alarm has been set for tomorrow.");
		}
		else if (min<now.getMinute()) {
			System.out.println("Your Alarm has been set for tomorrow.");
		}
		else if (hr>now.getHour()) {
			System.out.println("Your time has not arrived at.");
		}
		else if (min>now.getMinute()) {
			System.out.println("Your time has not arrived at.");
		}
		return set;
	}
	
	public static void beep() {		
		System.out.println("Beep Beep Beep");
	}
}
