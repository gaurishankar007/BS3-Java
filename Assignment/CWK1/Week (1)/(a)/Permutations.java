package tester;

import java.util.*;
public class Permutations {
	ArrayList<String> listPermutation=new ArrayList<>();
	LinkedList<Integer> listEvaluator = new LinkedList<>();

  public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter how many digit of binary number you want to find the permutations of: ");
		int totalDigit = sc.nextInt();
		
		LinkedList<Integer> linkedList=new LinkedList<>();
		
		for(int i=0; i<totalDigit; i++) {
			System.out.print("Enter the binary digits one by one: ");
			int digit = sc.nextInt();
			linkedList.add(digit);
		}
		
		String binary_number = "";
		for(int i=0; i<linkedList.size(); i++){
			binary_number = binary_number+String.valueOf(linkedList.get(i));
		}
		
		System.out.println();
		System.out.println("Provided set of binary numbers in a linked list: "+linkedList);
		
		Permutations obj = new Permutations();
		obj.generatePermutation(binary_number);
	}

	public void generatePermutation(String string) {
    int [] factorials = new int[string.length()+1];
    factorials[0] = 1;
    for (int i = 1; i<=string.length();i++) {
        factorials[i] = factorials[i-1] * i;
    }

    for (int i = 0; i < factorials[string.length()]; i++) {
        String onePermutation="";
        String temp = string;
        int positionCode = i;
        for (int position = string.length(); position > 0 ;position--){
            int selected = positionCode / factorials[position-1];
            onePermutation += temp.charAt(selected);
            positionCode = positionCode % factorials[position-1];
            temp = temp.substring(0,selected) + temp.substring(selected+1);
        }
        if (!listPermutation.contains(onePermutation)) { 
          listPermutation.add(onePermutation); 
          evaluator(onePermutation);
        } 
    }
    System.out.println("Unique Permutations: ");
    for(String i:listPermutation){
      System.out.println(i);
    }
	System.out.println("Integer value of generated permutations as linked list: "+listEvaluator);
  } 

	public void evaluator(String permutation) {
		String number = permutation;
		int integer_value = 0;
		for(int i=0; i<number.length(); i++) {
			char digit = number.charAt(i);
			int power = (number.length()-1)-i;
			integer_value= (int) (integer_value+(Character.getNumericValue(digit)*(Math.pow(2, power))));
		}
		listEvaluator.add(integer_value);
	}
}
