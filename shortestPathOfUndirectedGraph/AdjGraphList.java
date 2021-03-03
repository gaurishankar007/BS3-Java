package shortestPathOfUndirectedGraph;

import java.util.*;

import depthFirstSearchRecursive.LinkedList;
import depthFirstSearchRecursive.QueeByLinkedList;
public class AdjGraphList {
	int vertex=5;
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
	
	public List<Integer> getAdjNodes(int source) {
		ArrayList<Integer> destinations=new ArrayList<>();
		if(list1[source].size()>0) {
			for(int j=0; j<list1[source].size(); j++) {
				destinations.add(list1[source].get(j));
			}
		}
		return destinations;
	}
	
	public void BFSShortestPath(int rootnode, int distance [], int prevpath []) {
		boolean visited[] = new boolean[vertex];
		for(int i=0; i<vertex; i++) {
			distance[i]=Integer.MAX_VALUE;
			prevpath[i]=-1;
		}
		visited[rootnode] = true;
		QueeByLinkedList queue=new QueeByLinkedList();
		queue.enqueue(rootnode);
		distance[rootnode]=0;
		
		while(queue.size()!=0) {
			int u = queue.dequeue();
			Iterator<Integer> iterator=getAdjNodes(u).iterator();
			while(iterator.hasNext()) {
				int v = iterator.next();
				if(!visited[v]) {
					queue.enqueue(v);
					visited[v]=true;
					distance[v]=distance[u]+1;
					prevpath[v]=u;
				}
			}
		}
	}
	
	public void printshortestPath(int source, int destination) {
		int distance[] = new int[vertex];
		int prevpath[] = new int[vertex];
		BFSShortestPath(source, distance, prevpath);
		
		int crawl=destination;
		LinkedList path = new LinkedList();
		path.addNode(crawl);
		while(prevpath[crawl]!=-1) {
			path.addNode(prevpath[crawl]);
			crawl=prevpath[crawl];
		}
		
		System.out.println("The Shortest Distance of 4 is "+distance[destination]+".");
		System.out.print("Path of 4: ");
		for(int i=path.size()-1; i>=0; i--) {
			System.out.print(path.get(i)+"-->");
		}
	}
	
	public static void main(String[] args) {
		AdjGraphList obj=new AdjGraphList();
		obj.addEdge(0, 1);
		obj.addEdge(0, 2);
		obj.addEdge(1, 3);
		obj.addEdge(2, 4);
		obj.addEdge(3, 4);
		obj.printshortestPath(0, 4);		
	}
}