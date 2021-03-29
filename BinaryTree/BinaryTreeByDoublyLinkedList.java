package binaryTree;

public class BinaryTreeByDoublyLinkedList {
	public static class Node{
		Node left;
		Node right;
		int data;
		
		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	Node root;	
	public void createTree() {
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
	}
	
	public void traversal() {
		preOrder(root);
	}
	
	public void preOrder(Node root) {
		if(root==null) {
			return;
		}
		System.out.println(root.data);
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public static void main(String[] args) {
		BinaryTreeByDoublyLinkedList obj = new BinaryTreeByDoublyLinkedList();
		obj.createTree();
		obj.traversal();
	}
}
