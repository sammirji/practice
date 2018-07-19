package my.practice.trees;

public class SumTree {

	Node root;
	
	class Node {
		Node left, right;
		int data;
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	private int sum(Node node) {
		if (node == null)
			return 0;
		return sum(node.left) + node.data + sum(node.right);
	}
	
	public int sumTree(Node node) {
		if (node == null || (node.left == null && node.right == null))
			return 1;
		
		int ls = sum(node.left);
		int rs = sum(node.right);
		
		if (node.data == ls + rs && sumTree(node.left) != 0 &&
				sumTree(node.right) != 0) 
			return 1;
		else 
			return 0;
	}
	
	public static void main(String[] args) {
		SumTree tree = new SumTree();
		tree.root = tree.new Node(26);
		tree.root.left = tree.new Node(10);
		tree.root.left.left = tree.new Node(4);
		tree.root.left.right = tree.new Node(6);
		tree.root.right = tree.new Node(3);
		tree.root.right.right = tree.new Node(3);
		
		int resp = tree.sumTree(tree.root);
		if (resp == 1)
			System.out.println("Sum Tree!");
		else 
			System.out.println("Not a Sum Tree.");
	}

}
