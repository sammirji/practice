package my.practice.trees;

public class TreeLeftView {

	Node root;
	static int maxLevel = 0;
	
	class Node {
		Node left, right;
		int data;
		
		public Node(int data) {
			this.data = data;
			this.left = this.right = null;
		}
	}
	
	public void leftView() {
		leftViewUtil(root, 1);
	}
	
	private void leftViewUtil(Node node, int level) {
		if (node == null)
			return;
		
		if (maxLevel < level) {
			System.out.println(node.data);
			maxLevel = level;
		}
		leftViewUtil(node.left, level+1);
		leftViewUtil(node.right, level+1);
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
