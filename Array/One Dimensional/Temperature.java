
public class Temperature {
	
	public static void main(String[] args) {
		
		double temp[] = {72.6, 75.6, 78, 4.55}; //Single dimensional array
		String name[] = {"Bikash", "Dilip", "Sunil"};
		
		int size = temp.length;
		for(int i=0; i<size; i++) {
			System.out.println(temp[i]);
		}
		
		for(String i:name) {
			System.out.println(i);
		}
	}
}
