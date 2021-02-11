
public class RubicCubeChampion {

	public static void main(String[] args) {
		double speed[] = {6.5, 4.1, 10.2, 11.4, 8.8, 9.8, 3.1};
		double min = searchForMin(speed);
		System.out.println("Min speed is: "+min);
	}
	
	public static double searchForMin(double array[]) {
		int size = array.length;
		double min = array[0];
		
		for(int i=0; i<size; i++) {
			if(array[i]<min) {
				min=array[i];
			}
		}
		return min;
	}
}
