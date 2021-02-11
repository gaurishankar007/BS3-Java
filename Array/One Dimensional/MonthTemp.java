
public class MonthTemp {

	public static void main(String[] args) {
		double temp[] = {72.6, 76.2, 75.8, 55, 6, 45.5};
		
		double average = avg(temp);
		System.out.println("Our avg week Temp is: " + average);
	}
	
	public static double avg(double array[]) {
		int size = array.length;
		double total = 0;
		for(int i=0; i<size; i++) {
			total += array[i];
		}
		return total/size;
	}
}
