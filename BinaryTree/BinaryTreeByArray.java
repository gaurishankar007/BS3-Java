package binaryTree;

import java.util.Arrays;

public class BinaryTreeByArray {
	int vertex = 7;
	String tree [] = new String[vertex];
 
    /*create root*/
    public void Root(String root)
    {
        tree[0] = root;
    }
 
    /*create left son of root*/
    public void Left(String child, int parent)
    {
        int index = (parent * 2) + 1;
 
        if (tree[parent] == null) {
            System.out.printf("Can't set child at %d, no parent found\n", index);
        }
        else {
            tree[index] = child;
        }
    }
 
    /*create right son of root*/
    public void Right(String child, int parent)
    {
        int index = (parent * 2) + 2;
 
        if (tree[parent] == null) {
            System.out.printf("Can't set child at %d, no parent found\n", index);
        }
        else {
            tree[index] = child;
        }
    }
    
    public void child(String parent) {
    	int index = Arrays.binarySearch(tree, parent);
    	System.out.println(tree[(2*index)+1] + "<==Left " + parent + " Right==>" + tree[(2*index)+2]);
    }
    
    public void parent(String child) {
    	int index = Arrays.binarySearch(tree, child);
    	System.out.println("Parent of "+child+" is "+tree[(index-1)/2]+".");
    }
 
    public void printTree()
    {
        for (int i = 0; i < 7; i++) {
            if (tree[i] != null)
                System.out.print(tree[i]);
            else
                System.out.print("-");
        }
    }
	
    public static void main(String[] args) { 
    	BinaryTreeByArray obj = new BinaryTreeByArray();
    	obj.Root("A");
    	obj.Left("B", 0);
        obj.Right("C", 0);
        obj.Left("D", 1);
        obj.Right("E", 1);
        obj.Left("F", 2);
        obj.Right("G", 2);
        obj.child("B");
        obj.parent("G");
        obj.printTree();
    } 
}