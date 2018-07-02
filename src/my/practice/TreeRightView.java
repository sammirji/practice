package my.practice;

import my.practice.TreeLeftView.Node;

public class TreeRightView {

	Node root;
	static int max_level = 0;
	
	class Node {
		Node left, right;
		int data;
		
		Node (int data) {
			this.data = data;
			right = left = null;
		}
	}
	
	private void rightViewUtil(Node node, int level) {
		if (node == null) return;
		
		if (max_level < level) {
			System.out.println(node.data);
			max_level = level;
		}
		rightViewUtil(node.right, level+1);
		rightViewUtil(node.left, level+1);
	}
	
	public void rightView() {
		rightViewUtil(root, 1);
	}
	
	public static void main(String[] args) {
		TreeRightView tree = new TreeRightView();
		tree.root = tree.new Node(12);
		tree.root.left = tree.new Node(10);
		tree.root.left.left = tree.new Node(9);
		tree.root.left.right = tree.new Node(11);
		tree.root.right = tree.new Node(14);
		
		tree.rightView();

	}

}
