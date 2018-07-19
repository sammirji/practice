package my.practice.trees;

/**
 * Program to compute sum of all the nodes
 * in the tree multiplied by the height.
 *			26  	-- 1
 *		   /  \
 *  	  10   5	-- 2
 *  sum = (10*2)+(5*2)+(26*1)
 */
public class WeightedSumTree {
	Node root;
	int sum = 0;
	
	class Node {
		Node left, right;
		int data;
		
		public Node(int data) {
			this.data = data;
			this.left = this.right = null;
		}
	}
	
	public void sum(int maxHeight) {
		sumUtil(root, maxHeight);
		System.out.println("sum: " + sum);
	}
	
	private void sumUtil(Node node, int height) {
		if (node == null) return;
		
		sum += (node.data * height);
		sumUtil(node.left, height-1);
		sumUtil(node.right, height-1);
	}
	
	public int getMaxHeight(Node node) {
		if (node == null)
			return 0;
		int leftHeight = getMaxHeight(node.left);
		int rightHeight = getMaxHeight(node.right);
		if (leftHeight > rightHeight) 
			return leftHeight + 1;
		else 
			return rightHeight + 1;
	}
	
	public static void main(String[] args) {
		WeightedSumTree tree = new WeightedSumTree();
		tree.root = tree.new Node(1);
		tree.root.left = tree.new Node(2);
		tree.root.right = tree.new Node(3);
		tree.root.right.left = tree.new Node(4);
		
		int maxHeight = tree.getMaxHeight(tree.root);
		System.out.println("MaxHeight: " + maxHeight);
		tree.sum(maxHeight);
	}

}
