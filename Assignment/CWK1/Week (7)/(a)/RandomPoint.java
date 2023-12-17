package classwork;

public class RandomPoint {
	
	public static int pointX() {
		double a=Math.random();
		a=a*100;
		int x = (int) a;
		x=x+1;	
		return x;
	}
	
	public static int pointY() {
		double b=Math.random();
		b=b*100;
		int y = (int) b;
		y=y+1;	
		return y;
	}
}
