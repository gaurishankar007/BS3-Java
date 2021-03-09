package shortestPathOfDirectedGraph;

import java.util.*;

import shortestPathOfUndirectedGraph.LinkedList;
public class Graph {
	int vertex=5;
	int graph [] [] = new int[vertex] [vertex];
	
	public void addEdge(int source, int destination, int distance) {
		graph [source] [destination] = distance;
		graph [destination] [source] = distance;
	}
	
	public List<Integer> getAdjNodes(int source){
		ArrayList<Integer> adjnodes=new ArrayList<>();
		for(int i=0; i<vertex; i++) {
			if(graph [source] [i]!=0) {
				adjnodes.add(i);
			}
		}
		return adjnodes;
	}
	
	public void shortestPath(int source, int destination) {
		boolean visited [] = new boolean[vertex];
		int prevPath [] = new int[vertex];
		int minDistance [] = new int[vertex];
		
		for(int i=0; i<vertex; i++) {
			prevPath[i]=-1;
			minDistance[i]=Integer.MAX_VALUE;
		}
		
		int s = source;
		minDistance[s] = 0;
		Queue q = new Queue(vertex);
		q.enqueue(s);
		
		while(!q.isEmpty()) {
			int u = q.dequeue();
			visited[u] = true;
			
			Iterator<Integer> iterate = getAdjNodes(u).iterator();
			ArrayList<Integer> adjdistance=new ArrayList<>();
			
			while(iterate.hasNext()) {
				int v = iterate.next();
				if(!visited[v]) {					
					int dis = minDistance[u] + graph [u] [v];
					if(dis<minDistance[v]) {
						minDistance[v]=dis;	
						prevPath[v] = u;	
					}
					adjdistance.add(v);					
				}
			}
		
			
			if(adjdistance.size()!=0) {
				int min = adjdistance.get(0);
				for(int i: adjdistance) {
					if(minDistance[min]>minDistance[i]) {
						min = i;
					}
				}
				q.enqueue(min); // searching the node having less distance
			}
		}
		
		int crawl=destination;
		LinkedList path = new LinkedList();
		path.addNode(crawl);
		while(prevPath[crawl]!=-1) {
			path.addNode(prevPath[crawl]);
			crawl=prevPath[crawl];
		}
		
		System.out.println("The Shortest Distance of 4 is "+minDistance[destination]+".");
		System.out.print("Shortest path of 4: ");
		for(int i=path.size()-1; i>=0; i--) {
			System.out.print("-->"+path.get(i));
		}
	}
	
	public static void main(String[] args) {
		Graph obj = new Graph();
		obj.addEdge(0, 1, 6);
		obj.addEdge(0, 2, 1);
		obj.addEdge(1, 2, 2);
		obj.addEdge(1, 3, 2);
		obj.addEdge(1, 4, 5);
		obj.addEdge(2, 3, 1);
		obj.addEdge(3, 4, 5);
		obj.shortestPath(0, 4);		
	}
}
