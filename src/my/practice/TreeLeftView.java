package my.practice;

public class TreeLeftView {

	Node root;
	static int max_level = 0;
	
	class Node {
		Node left, right;
		int data;
		
		Node(int data) {
			this.data = data;
			left = right = null;
		}
	}
	
	private void leftViewUtil(Node node, int level) {
		if (node == null) return;
		
		if (max_level < level) {
			System.out.println(node.data);
			max_level = level;
		}
		leftViewUtil(node.left, level + 1);
		leftViewUtil(node.right, level + 1);
	}
	
	public void leftView() {
		leftViewUtil(root, 1);
	}
	
	public static void main(String[] args) {
		TreeLeftView tree = new TreeLeftView();
		tree.root = tree.new Node(12);
		tree.root.left = tree.new Node(10);
		tree.root.left.left = tree.new Node(9);
		tree.root.left.right = tree.new Node(11);
		tree.root.right = tree.new Node(14);
		
		tree.leftView();
	}

}
