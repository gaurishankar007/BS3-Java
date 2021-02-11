
public class Variables {
	public static void main(String[] args) {
		
		// Truncation
		double div = 5/2.0;
		System.out.println(div);
		
		// casting double into integer value
		double current=17;
		double rate=1.5;
		
		double future=current*rate;
		System.out.println("Future value: "+future);
		
		int nextFuture=(int)future;
		System.out.println("Next Future value: "+nextFuture); 
		
		// casting integer into double
		int x=5;
		int y=2;
		double div1 = x/y;
		System.out.println("int div1 value: "+div1);
		double nextdiv1=(double)x/y;
		System.out.println("double div1 value: "+nextdiv1);
	}

}
