package tester;

public class BinaryTree {
	int treeHeight = 4;
	int vertex;
	int tree [];
	
	public void root(int rootNode) {
		tree[0] = rootNode;
	}
	
	public void left(int child, int parent)
    {
        int index = (linearSearch(parent) * 2) + 1; 
        if (index<0) {
            System.out.println("Can not set child, parent node not found.");
        }
        else {
            tree[index] = child;
        }
    }
	
    public void right(int child, int parent)
    {
        int index = (linearSearch(parent) * 2) + 2; 
        if (index<0) {
            System.out.println("Can not set child, parent node not found.");
        }
        else {
            tree[index] = child;
        }
    }

	public int linearSearch(int parent) {
		for(int i=0; i<vertex; i++) {
			if(tree[i]==parent) {
				return i;
			}
		}
		return -2;
	}
    
    public void createTree() {
    	for(int i=0; i<treeHeight; i++) {
    		vertex += (int) Math.pow(2, i);
    	}
    	tree = new int[vertex];
    	for(int i=0; i<vertex; i++) {
    		tree[i]=-1;
    	}
		root(1);
		left(6, 1);
		right(5, 1);
		right(4, 6);
		left(3, 5);
		right(9, 5);
		left(2, 9);
		right(7, 9);
    }  
    
    public boolean checkBalanceLeaf(int array []) {
    	boolean result = true;
    	for(int j: array) {
    		int leftIndex = (2*linearSearch(j))+1;
    		int rightIndex = (2*linearSearch(j))+2;
    		if(leftIndex>=vertex || rightIndex>=vertex) {
                System.out.println(j+" don't have any child."); 
                result = false;
    		}
    		else if(tree[leftIndex]==-1 || tree[rightIndex]==-1) {
    			result = false;
    		}
    	}
    	return result;
    }
	
	public static void main(String[] args) {
		BinaryTree obj = new BinaryTree();
		obj.createTree();
		
		int head [] = {5, 9};
		System.out.println(obj.checkBalanceLeaf(head));
	}
}
