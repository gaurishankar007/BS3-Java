package tester;

import java.util.*;
public class ParenthesesChecker {	
	public static void main(String args[]) {
		System.out.print("Enter the Parentheses: "); // Example==>[()]{}{[()()]()} or [{{()}]
		Scanner sc=new Scanner(System.in);
		String parentheses=sc.next();
		ParenthesesChecker a=new ParenthesesChecker();
		System.out.println("Balance: "+a.checkBalanced(parentheses));
	}
	
	boolean checkBalanced(String data) {
		boolean bol = true;
		String openingbracket="[{(";
		String closingbracket="]})";
		int size=data.length();		
		Stack stk=new Stack(size);
		
		for(int i=0; i<size; i++) {
			char bracket=data.charAt(i); //Taking all characters of the string one by one
			if(openingbracket.indexOf(bracket)!=-1) { //Checking for opening brackets and pushing them to the stack
				stk.push(bracket);
			}
			else {
				int indx=closingbracket.indexOf(bracket); // taking the index of the closing brackets
				char corresponding=openingbracket.charAt(indx); // taking the character of index of the closing bracket
				
				if(stk.pop()!=corresponding) { 
					// checking stack's top opening bracket is equal to or not equal to corresponding opening bracket of the next coming closing bracket 
					bol = false;
					break;
				}
			}
		}
		return bol;
	}

}
