package stack;

public class StackByLinkedList {
	
	static class Node{
		int data;
		Node next;
		
		Node(int data){
			this.data=data;
			this.next=null;
		}
	}
	
	Node head=null;
	Node tail=null;
	public void push(int data) {
		Node newnode=new Node(data);
		if(head==null) {
			head=newnode;
			tail=newnode;
		}
		else {
			tail.next=newnode;
			tail=newnode;
		}
		
	}
	
	public void pop() {
		if(head==null) {
			System.out.println("Stack is Empty.");
		}
		else {
			System.out.println("Popped item="+tail.data);
			Node current=head;
			if(tail!=head) {
				while(current.next!=tail) {
					current=current.next;
				}
			}
			else {
				head=null;
			}
			tail=current;
		}
	}
	
	public void printStack() {
		if(head==null) {
			System.out.println("Stack is empty.");
		}
		else {
			System.out.print("Items in the stack=");
			Node last=tail;
			while(true) {
				System.out.print(last.data+" ");
				Node current=head;
				if(last!=head) {
					while(current.next!=last) {
						current=current.next;
					}
				}
				else {
					break;
				}
				last=current;
			}			
		}
		System.out.println();
	}
	
	public void size() {
		int count=0;
		if(head==null) {
			System.out.println("Stack size="+count);
		}
		else {
			Node current=head;
			while(current!=tail.next) {
				count++;
				current=current.next;
			}
			System.out.println("Stack size="+count);
		}
	}
	
	public static void main(String[] args) {
		StackByLinkedList stack=new StackByLinkedList();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.printStack();
		stack.size();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();
		stack.printStack();
		stack.size();
		stack.push(50);
		stack.push(60);
		stack.push(70);
		stack.printStack();
		stack.size();
	}
}
