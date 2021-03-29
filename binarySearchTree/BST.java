package binarySearchTree;

public class BST {
	public static class Node{
		int data;
		Node left;
		Node right;
		
		public Node (int data) {
			this.data=data;
			this.left=null;
			this.right=null;
		}
	}
	
	public Node insertBST(Node root, int data) {
		if(root==null) {
			return new Node(data);
		}
		else {
			if(data<root.data) {
				root.left=insertBST(root.left, data);
			}
			else{
				root.right=insertBST(root.right, data);
			}
		}
		return root;
	}
	
	public void inOrder(Node root) {
		if(root==null) {
			return;
		}
		inOrder(root.left);
		System.out.println(root.data);
		inOrder(root.right);
	}
	
	public static void main(String[] args) {
		BST bstObj = new BST();
		Node root=null;
		root = bstObj.insertBST(root, 15);
		root = bstObj.insertBST(root, 8);
		root = bstObj.insertBST(root, 16);
		root = bstObj.insertBST(root, 7);
		root = bstObj.insertBST(root, 9);
		bstObj.inOrder(root);
	}
}
