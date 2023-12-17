package week8to11;

public class CustomQueue {
	int length;
	int size;
	int queue [];
	int front=-1;
	int rear=-1;
	
	CustomQueue(int length) {
		this.length=length;
		queue=new int[length];
	}
	
	boolean isFull() {
		if(front==0 && rear==length-1) {
			return true;
		}
		if(front==rear+1) {
			return true;
		}
		return false;
	}
	
	boolean isEmpty() {
		return front==-1;
	}
	
	void enqueue(int data) {
		if(isFull()) {
			System.out.println("Queue is full.");
		}
		else {
			if(front==-1) {
				front++;
			}
			rear=(rear+1)%length;
			queue[rear]=data;
			size++;
		}
	}
	
	int dequeue() {
		int removed_element;
		if(isEmpty()) {
			System.out.println("Queue is empty.");
			return -1;
		}
		else {
			removed_element=queue[front];
			if(front==rear) {
				front=-1;
				rear=-1;
				size=0;
			}
			else {
				front=(front+1)%length;
				size--;
			}	
		}
		return removed_element;
	}
}
