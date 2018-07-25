package my.practice.trees;

import java.util.Stack;

public class ZigZagTraversal {

	Node root;
	
	public void printZigZagTraversal() {
		if (root == null)
			return;
		
		Stack<Node> currentLevel = new Stack<>();
		Stack<Node> nextLevel = new Stack<>();
		
		currentLevel.push(root);
		boolean leftToRight = true;
		
		while(!currentLevel.isEmpty()) {
			Node node = currentLevel.pop();
			System.out.print(node.data + " ");
			
			if(leftToRight) {
				if (node.left != null) {
					nextLevel.push(node.left);
				}
				if (node.right != null) { 
					nextLevel.push(node.right);
				}
			} else {
				if (node.right != null) { 
					nextLevel.push(node.right);
				}
				if (node.left != null) {
					nextLevel.push(node.left);
				}
			}
			
			if (currentLevel.isEmpty()) {
				leftToRight = !leftToRight;
				Stack<Node> temp = currentLevel;
				currentLevel = nextLevel;
				nextLevel = temp;
			}
		}
	}
	
	class Node {
		Node left, right;
		int data;
		
		public Node(int data) {
			this.data = data;
			this.left = this.right = null;
		}
	}
	
	public static void main(String[] args) {
		ZigZagTraversal tree = new ZigZagTraversal();
	    tree.root = tree.new Node(1);
	    tree.root.left = tree.new Node(2);
	    tree.root.right = tree.new Node(3);
	    tree.root.left.left = tree.new Node(7);
	    tree.root.left.right = tree.new Node(6);
	    tree.root.right.left = tree.new Node(5);
	    tree.root.right.right = tree.new Node(4);
	 
	    System.out.println("ZigZag Order traversal of binary tree is: ");
	    tree.printZigZagTraversal();
	}

}
