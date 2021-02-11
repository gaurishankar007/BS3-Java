package stack;

public class StackOperation {
	
	public static void main(String args[]) {
		Stack stack= new Stack();
		stack.stackSize(5);
		stack.push(10);
		stack.push(9);
		stack.push(8);
		stack.push(7);
		stack.push(6);
		stack.printStack();
		System.out.println("Poped value= "+stack.pop());
		System.out.println("Poped value= "+stack.pop());
		stack.printStack();
		stack.push(5);
		stack.push(4);
		stack.printStack();
		stack.stackSize(6);
	}
}
