package classwork;

import java.util.*;

public class InfixConversionToRPN {
	public static void main(String[] args) {
		InfixConversionToRPN obj=new InfixConversionToRPN();
		
		System.out.print("Provide an infix expression whithout any space: ");
		Scanner scnr=new Scanner(System.in);
		String infix = scnr.next();
		
		String postfix =obj.formulation(infix);
		System.out.println("Formulation of Reverse Polish Notation: "+postfix);
		System.out.println("Evaluation of Reverse Polish Notation: "+obj.evaluation(postfix));
	}
	
	public boolean operatorChecker(char letter) {
		if(letter == '[' || letter == '{' || letter == '(' || letter == ']' || letter == '}' || letter == ')'
				|| letter == '^' || letter == '*' || letter == '/' || letter == '+' || letter == '-') {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean priorityChecker(char upComming, char history) { // Checking higher priority between operators
		String priority_operator = "^*/+-";
		if(upComming == history) {
			return false;
		}
		else if(priority_operator.indexOf(String.valueOf(upComming))<priority_operator.indexOf(String.valueOf(history))) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String formulation(String infix) { // best testing infix value p*q*r+[s^{A+B*C/(E-F)}]^u-v/w 
		String infix_expression = infix;
		String postfix_expression = "";
		
		Stack<Character> stack = new Stack<>(); 
		
		for(int i=0; i<infix.length(); i++) {
			char letter = infix_expression.charAt(i);
			if(!operatorChecker(letter)) { // checking if the letter is operand or not
				postfix_expression = postfix_expression + letter;
			}
			else {
				if(stack.size()==0) { // checking if the stack is empty or not at first time
					stack.add(letter);
				}
				else {		
					if(letter=='[' || letter=='{' || letter=='(') { // if there any opening parentheses, adding to stack
						stack.add(letter);
					}
					else if(letter==']' || letter=='}' || letter==')') { 
						// if there any closing parentheses, popping out from the stack until the next popping value is its relative closing parentheses 
						while(true) {
							if(stack.peek()=='[' || stack.peek()=='{' || stack.peek()=='(') {
								break;
							}
							postfix_expression = postfix_expression + stack.pop();	
						}
						stack.pop();
					}
					else {
						if(stack.peek()=='[' || stack.peek()=='{' || stack.peek()=='(') { 
							// if there any opening parentheses in the top of stack before checking the priority of upComming input and value of top of stack then
							// inserting the upComming input to the stack without (popping out the opening parentheses and adding to the postfix expression)
							stack.add(letter);
						}
						else {
							if(priorityChecker(letter, stack.peek())) { // if the upComming input has higher priority to the value of top of the stack 
								stack.add(letter);
							}
							else {
								while(!priorityChecker(letter, stack.peek())) {
									// if the upComming input has lower priority to the value of top of the stack 
									// popping out the value of top of the stack until the if conditon does not meet given below
									postfix_expression = postfix_expression + stack.pop();
									if(stack.size()==0 || stack.peek()=='[' || stack.peek()=='{' || stack.peek()=='(') {
										// while popping out, if the stack get empty or if there is any closing parentheses, stop popping out
										break;
									}
								}
								stack.add(letter); // adding the upComming input at the top of stack after popping out the desired elements of the stack
							}
						}
					}
				}
			}			
		}
		while(stack.size()!=0) {
			postfix_expression = postfix_expression + stack.pop(); // adding the remaining top of the values of the stack to postfix expression at last
		}
		return postfix_expression;
	}
	
	public int evaluation(String postfix) { 
		String postfix_expression = postfix;
		int sum = 0;
		
		Stack<Integer> stack = new Stack<>(); 
		
		for(int i=0; i<postfix.length(); i++) {
			char letter = postfix_expression.charAt(i);
			if(!operatorChecker(letter)) { // checking if the letter is operand or not
				stack.add(Character.getNumericValue(letter));
			}
			else {
				int top = stack.pop();
				int below_top = stack.pop();
				
				if(letter=='^') {
					sum = below_top^top;
				}
				else if(letter=='*') {
					sum = below_top*top;
				}
				else if(letter=='/') {
					sum = below_top/top;
				}
				else if(letter=='+') {
					sum = below_top+top;
				}
				else if(letter=='-') {
					sum = below_top-top;
				}
				stack.add(sum);				
			}			
		}		
		return stack.pop();
	}
}
