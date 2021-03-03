package shortestPathOfUndirectedGraph;

public class LinkedList {
	static class Node{
		int data;
		Node next;
		
		Node(int data){
			this.data=data;
			this.next=null;
		}
	}
	
	// Start
	public Node head=null;
	public void addNode(int data) {
		Node newNode=new Node(data);
		if(head==null) {
			head=newNode;
		}
		else {
			Node current=head;
			while(current.next!=null) {
				current=current.next;
			}
			current.next=newNode;
		}
	}
	//End
	
	/* Simple way than above adding method
	public Node head=null;
	public Node tail=null;
	public void addNode(int data) {
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
	 */
	
	public void printLinkedList() {
		Node current=head;
		while(current!=null) {
			System.out.println(current.data);
			current=current.next;
		}
	}
	
	public int size() {
		int count=0;
		Node current=head;
		while(current!=null) {
			count++;
			current=current.next;
		}
		return count;
	}
	
	public int get(int i) {
		if(size()!=0 && i<size()) {
			Node current=head;
			for(int j=0; j<i; j++) {
				current=current.next;
			}
			return current.data;
		}
		return -1;
	}
}
