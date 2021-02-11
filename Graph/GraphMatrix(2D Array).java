package graph;

public class GraphMatrix {
	int size;
	int matrix [] [];
	
	public GraphMatrix(int size) {
		this.size=size;
		matrix=new int [size] [size];
	}
	
	void addedges(int source, int destination) {
		matrix[source][destination]=1;
		matrix[destination][source]=1;
	}
	
	void printGraph() {
		System.out.println("Printing graph data");
		for(int rows=0; rows<size; rows++) {
			for(int columns=0; columns<size; columns++) {
				System.out.print(matrix[rows][columns] +" ");
			}
			System.out.println();
		}
	}
	

	void printEdges() {
		System.out.println();
		System.out.println("Printing edges");
		for(int i=0; i<size; i++) {
			System.out.print(i+" is connected to ");
			for(int j=0; j<size; j++) {
				if(matrix[i][j]==1) {
					System.out.print(j+ " ");
				}
			}
			System.out.println();
		}
	}
	
	public static void main(String args[]) {
		GraphMatrix obj=new GraphMatrix(4);
		obj.addedges(0, 1);
		obj.addedges(0, 2);
		obj.addedges(0, 3);
		obj.addedges(1, 2);
		obj.addedges(1, 3);
		obj.printGraph();
		obj.printEdges();
	}
	
}
