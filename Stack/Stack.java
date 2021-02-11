package stack;

public class Stack {
	int size=0;
	
	int array [];
	
	int top=-1;
	
	void stackSize(int data) {
		if(size==0) {
			array =new int[data];
			size=data;
		}
		else {
			System.out.println("Size of stack is already declared which is "+size+".");
		}
	}
	
	void push(int data) {
		if(size<1) {
			System.out.println("Insert Stack first!!!");
		}
		else if(isFull()){
			System.out.println("Stack overflow");
		}
		else {
		array[++top]=data;
		}
	}
	
	int pop() {
		if(size==0) {
			System.out.println("Insert Stack first!!!");
			return -1;
		}
		else if(isEmpty()){
			System.out.println("Stack underflow");
			return -1;
		}
		else {
		return array[top--];
		}
	}
	
	boolean isFull() {
		return top==size-1;
	}
	
	boolean isEmpty() {
		return top==-1;
	}
	
	void printStack() {
		System.out.println("Start printting Stack value");
		for(int i=0; i<=top; i++) {
			System.out.println(array[i]);
		}
		System.out.println("End printitng Stack value");
	}
	
	int peak() {
		if(size<1) {
			System.out.println("Insert Stack first!!!");
			return -1;
		}
		else if(isEmpty()){
			System.out.println("Stack underflow");
			return -1;
		}
		else {
		return array[top];
		}
	}
}
