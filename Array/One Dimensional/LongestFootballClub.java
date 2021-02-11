
public class LongestFootballClub {

	public static void main(String args[]) {
		String footballClub[] = {"Manchester", "Liverpool", "Everton", "LeedsUnited", "Fulham", "WesthamUnited", "Spurs"};
		System.out.println("The longest named football club is: " + longestName(footballClub));
	}	
	
	public static String longestName(String array[]) {
		int size = array.length;
		String max = array[0];
		for(int i=1; i<size; i++) {
			if(array[i].length()>max.length()) {
				max=array[i];
			}
		}		
		return max;
	}
}
