package tester;

public class Stack {
	int size;
	char stk [];
	int top=-1;
	
	Stack(int size){
		this.size=size; // this initializes the use of class variables
		stk=new char[size];
	}
	void push(char data) {
		if(isFull()){
			System.out.println("Stack overflow");
		}
		else {
		stk[++top]=data;
		}
	}
	
	int pop() {
		if(isEmpty()){
			System.out.println("Stack underflow");
			return -1;
		}
		else {
		return stk[top--];
		}
	}
	
	boolean isFull() {
		return top==size-1;
	}
	
	boolean isEmpty() {
		return top==-1;
	}
	
	int peak() {
		if(isEmpty()){
			System.out.println("Stack underflow");
			return -1;
		}
		else {
		return stk[top];
		}
	}
	
	void printStack() {
		System.out.println("Start printting Stack value");
		for(int i=0; i<=top; i++) {
			System.out.println(stk[i]);
		}
		System.out.println("End printitng Stack value");
	}

}
