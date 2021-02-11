package queue;

public class QueeOperation {
	public static void main(String[] args) {
		Queue obj=new Queue(6);
		obj.enqueue(10);
		obj.enqueue(20);
		obj.enqueue(30);
		obj.enqueue(40);
		obj.enqueue(50);
		obj.enqueue(60);
		obj.enqueue(70);
		obj.dequeue();
		obj.dequeue();
		obj.dequeue();
		obj.dequeue();
		obj.dequeue();
		obj.enqueue(70);
		obj.enqueue(80);
		obj.enqueue(90);
		obj.enqueue(100);
		obj.enqueue(110);
		obj.enqueue(120);
		obj.display();
	}
}
