package linkedlist;

public class AdjGraphList {
	int vertex=4;
	LinkedList list [] = new LinkedList[vertex];
	
	public  AdjGraphList() {
		for(int i=0; i<vertex; i++) {
			list[i]=new LinkedList();
		}
	}
	
	public void addEdge(int source, int destination) {
		list[source].addNode(destination);
		list[destination].addNode(source);
	}
	
	public void printGraph() {
		for(int i=0; i<vertex; i++) {
			System.out.print(i + " is connected to ");
			if(list[i].size()>0) {
				for(int j=0; j<list[i].size(); j++) {
					System.out.print(list[i].get(j)+ " ");
				}
			}
			System.out.println();
		}
	}
	
	public void getAdjNodes(int source) {
		if(list1[source].size()>0) {
			ArrayList<Integer> destinations=new ArrayList<>();
			for(int j=0; j<list1[source].size(); j++) {
				destinations.add(list1[source].get(j));
			}
			System.out.println(destinations);
		}
	}
	
	public static void main(String[] args) {
		AdjGraphList obj=new AdjGraphList();
		obj.addEdge(0, 1);
		obj.addEdge(0, 2);
		obj.addEdge(1, 2);
		obj.addEdge(2, 3);
		obj.printGraph();
		
		
		/*
		LinkedList linklist= new LinkedList();
		linklist.addNode(10);
		linklist.addNode(15);
		linklist.addNode(20);
		linklist.printLinkedList();
		System.out.println(linklist.size());
		System.out.println(linklist.get(0));*/
	}

}