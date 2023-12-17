package tester;

import java.util.*;

public class VulnerablePoints {
	int total_vertex=5;
	ArrayList<Integer> exchange= new ArrayList<>(); 
	LinkedList array [] = new LinkedList[total_vertex];
	ArrayList<Integer> vertices= new ArrayList<>(); 
	
	public VulnerablePoints() {
		for(int i=0; i<total_vertex; i++) {
			array[i]=new LinkedList();
		}
	}
	
	public void addEdge(int source, int destination) {
		array[source].addNode(destination); 
		array[destination].addNode(source);
		
		if(!this.vertices.contains(source)) {
			vertices.add(source);
		}
		if(!this.vertices.contains(destination)) {
			vertices.add(destination);
		}
	}
	
	public List<Integer> getAdjNodes(int source) {
		ArrayList<Integer> destinations=new ArrayList<>();
		if(array[source].size()>0) {
			for(int j=0; j<array[source].size(); j++) {
				destinations.add(array[source].get(j));
			}
		}
		return destinations;
	}
	
	public void exchanger(int source, int destination) {
		if(!this.exchange.contains(source)) {
			exchange.add(source);
		}
		if(!this.exchange.contains(destination)) {
			exchange.add(destination);
		}
		addEdge(this.exchange.indexOf(source), this.exchange.indexOf(destination));
	}
	
	public void searching() {
		System.out.print("Vulnerable Points: ");
		for(int i=0; i<this.vertices.size(); i++) {
			int vertex = this.vertices.get(i);
			int next_i = (i+1)%this.vertices.size();
			int next_vertex = this.vertices.get(next_i);
			if(checking(vertex, next_vertex)) {
				System.out.print(this.exchange.get(vertex)+" ");
			}
		}
	}
	
	public boolean checking(int node, int next_node) {	
		boolean check = true;
		int count = 0;
		boolean visited[] = new boolean[this.total_vertex];
		QueeByLinkedList q = new QueeByLinkedList();
		
		visited[node]=true;
		q.enqueue(next_node);
		
		while(q.size()!=0) {
			int val=q.dequeue();
			Iterator<Integer> iterate=getAdjNodes(val).iterator();
			while(iterate.hasNext()) {
				int adjval=iterate.next();
				if(!visited[adjval]) {
					q.enqueue(adjval);
					visited[adjval]=true;
					count++;
				}
			}
		}
		if (count == this.total_vertex-1) {
			check= false;
		}
		return check;
	}
	
	public static void main(String[] args) {
		VulnerablePoints obj=new VulnerablePoints();		
		obj.exchanger(5, 9);
		obj.exchanger(5, 7);
		obj.exchanger(9, 7);
		obj.exchanger(7, 12);
		obj.exchanger(12, 13);
		obj.searching();
	}
}
