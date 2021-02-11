import java.util.Scanner;
public class Month {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of a month among 12 months:");
		int code = sc.nextInt();
		
		String Horoscope;
		
		switch(code) {
			case 1:
				Horoscope="Aries";
				break;
			case 2:
				Horoscope="Taurus";
				break;
			case 3:
				Horoscope="Gemini";
				break;
			case 4:
				Horoscope="Cancer";
				break;
			case 5:
				Horoscope="Leo";
				break;
			case 6:
				Horoscope="Virgo";
				break;
			case 7:
				Horoscope="Capri";
				break;
			case 8:
				Horoscope="Libra";
				break;
			case 9:
				Horoscope="Sagittarius";
				break;
			case 10:
				Horoscope="Capricorn";
				break;
			case 11:
				Horoscope="Pisces";
				break;
			case 12:
				Horoscope="Scorpio";
				break;
			default:
				Horoscope="Unknown";
		}
		System.out.println(Horoscope);
	}

}
