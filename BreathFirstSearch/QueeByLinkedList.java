package breathFirstSearch;

public class QueeByLinkedList {
	static class Node{
		int data;
		Node next;
		
		Node(int data){
			this.data=data;
			this.next=null;
		}
	}
	
	public Node head=null;
	public Node tail=null;
	public void enqueue(int data) {
		Node newNode=new Node(data);
		if(head==null) {
			head=newNode;
			tail=head;
		}
		else {
			tail.next=newNode;
			tail=newNode;
		}
	}
	
	public int dequeue() {
		int dequeued_item = 0;
		if(head==null) {
			System.out.println("Quee is empty.");
		}
		else {
			dequeued_item = head.data;
			head=head.next;
			
		}
		return dequeued_item;
	}
	
	public int size() {
		Node front=head;
		int count=0;
		while(front!=null) {
			count++;
			front=front.next;
		}
		return count;
	}
	
	public void printQueue() {
		if(head==null) {
			System.out.println("Quee is Empty.");
		}
		else {
			Node front=head;
			System.out.print("Items in the queue=");
			while(front!=null) {
				System.out.print(front.data+" ");
				front=front.next;
			}
			System.out.println();
		}
	}
	
	public static void main(String args[]) {
		QueeByLinkedList queue=new QueeByLinkedList();
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.printQueue();
		queue.size();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.printQueue();
		queue.size();
		queue.enqueue(50);
		queue.enqueue(60);
		queue.enqueue(70);
		queue.printQueue();
		queue.size();
		queue.dequeue();
		queue.dequeue();
		queue.printQueue();
		queue.size();
	}
}
