package classwork;

import java.util.*;

public class MissingPrimeNumbers {
	public static void main(String[] args) {
		System.out.print("Enter how many contiguous prime number you want to give: ");
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		
		int given_prime[] = new int[size];
		for(int i=0; i<size; i++) {
			System.out.print("Enter the pirme numbers one by one: ");
			int num = sc.nextInt();
			given_prime[i] = num;
		}
		
		System.out.println("Missing elements in between the contiguous prime number: "
		+primeChecker(given_prime, given_prime[0], given_prime[size-1]));
	}
	
	public static List<Integer> primeChecker(int given_prime[] ,int start, int end) {
		int prime [] = given_prime;
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=start; i<=end; i++) {
			boolean bol=true;
			for(int j=2; j<i; j++) {
				if(i%j==0) {
					bol=false;
				}				 
			}
			if(bol) {
				list.add(i);
			}
		}
		for(int i=0; i<prime.length; i++) {
			int index = list.indexOf(prime[i]);
			list.remove(index);
		}
		return list;
	}	
}
