package depthFirstSearchRecursive;

import java.util.*;

import breathFirstSearch.LinkedList;
public class AdjGraphList {
	int vertex=4;
	LinkedList list1 [] = new LinkedList[vertex];
	
	public  AdjGraphList() {
		for(int i=0; i<vertex; i++) {
			list1[i]=new LinkedList();
		}
	}
	
	public void addEdge(int source, int destination) {
		list1[source].addNode(destination); 
		list1[destination].addNode(source);
	}
	
	public void printGraph() {
		for(int i=0; i<vertex; i++) {
			System.out.print(i + " is connected to ");
			if(list1[i].size()>0) {
				for(int j=0; j<list1[i].size(); j++) {
					System.out.print(list1[i].get(j)+ " ");
				}
			}
			System.out.println();
		}
	}
	
	public List<Integer> getAdjNodes(int source) {
		ArrayList<Integer> destinations=new ArrayList<>();
		if(list1[source].size()>0) {
			for(int j=0; j<list1[source].size(); j++) {
				destinations.add(list1[source].get(j));
			}
		}
		return destinations;
	}
	
	public void depthFirstSearch(int rootnode) {
		boolean visited[] = new boolean[this.vertex];
		DFS(rootnode, visited);
	}
	
	public void DFS(int rootnode, boolean visited[]) {
		visited[rootnode] = true;
		System.out.println(rootnode);		
		Iterator<Integer> iterate= getAdjNodes(rootnode).iterator();
		while(iterate.hasNext()) {
			int AdjVal = iterate.next();
			if(!visited[AdjVal]) {
				DFS(AdjVal, visited);
			}
		}
	}
	
	public static void main(String[] args) {
		AdjGraphList obj=new AdjGraphList();
		obj.addEdge(0, 1);
		obj.addEdge(0, 2);
		obj.addEdge(1, 2);
		obj.addEdge(2, 3);
		obj.printGraph();
		System.out.println(obj.getAdjNodes(0));
		System.out.println(obj.getAdjNodes(2));
		obj.depthFirstSearch(0);
		
		
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