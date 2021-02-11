package stack;

public class Stack1Operation {
	
	public static void main(String args[]) {
		String paranthesis="[{()}]";
		Stack1Operation a=new Stack1Operation();
		System.out.println(a.checkBalanced(paranthesis));
	}
	
	boolean checkBalanced(String data) {
		String openingbracket="[{(";
		String closingbracket="]})";
		int size=data.length();
		
		Stack1 stk=new Stack1(size);
		
		for(int i=0; i<size; i++) {
			char bracket=data.charAt(i);
			if(openingbracket.indexOf(bracket)!=-1) {
				stk.push(bracket);
			}
			else {
				int indx=closingbracket.indexOf(bracket);
				char corresponding=openingbracket.charAt(indx);
				
				if(stk.pop()!=corresponding) {
					return false;
				}
			}
		}
		if(stk.peak()==-1) {
			return true;
		}
		else {
			return false;
		}
	}

}
