package my.practice.trees;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MaximumSumLeafPath {

	Node root;
	int maxSum = 0;
	Queue<Integer> leftNodes = new LinkedList<>();
	Stack<Integer> rightStack = new Stack<>();
	boolean isRightSide = false;
	
	class Node {
		Node left, right;
		int data;
		
		public Node(int data) {
			this.data = data;
			this.left = this.right = null;
		}
	}
	
	private void getMaximumSumLeafPath() {
		treeTraverse(root);
		
		System.out.print("Maximum Path: ");
		while (!leftNodes.isEmpty()) {
			System.out.print(leftNodes.remove() + " ");
		}
		while (!rightStack.isEmpty()) {
			System.out.print(rightStack.pop() + " ");
		}
		System.out.println("\nMaximum path sum = " + maxSum);
	}
	
	private int treeTraverse(Node node) {
		if (node == null)
			return 0;
		
		if (node.left == null && node.right == null)
			return node.data;
		
		int ls = treeTraverse(node.left);
		int rs = treeTraverse(node.right);
		int data = node.data;
		
		if (node.left != null && node.right != null) {
			maxSum = Math.max(maxSum, ls + rs + data);
//			System.out.print(data + " ");
			if (data == root.right.data) {
				isRightSide = true;
			}
			if (!isRightSide) {
				leftNodes.add(data);
			} else {
				rightStack.push(data);
			}
			return Math.max(ls, rs) + data;
		}
		if (node.left == null) {
			rightStack.push(node.right.data);
			rightStack.push(data);
//			System.out.print(node.right.data + " " + data + " ");
			return rs + data;
		} else {
			leftNodes.add(node.left.data);
			leftNodes.add(data);
//			System.out.print(node.left.data + " " + data + " ");
			return ls + data;
		}
	}
	
	public static void main(String[] args) {
		MaximumSumLeafPath tree = new MaximumSumLeafPath();
		tree.root = tree.new Node(10);
		tree.root.left = tree.new Node(2);
		tree.root.right = tree.new Node(7);
		tree.root.left.left = tree.new Node(8);
		tree.root.left.right = tree.new Node(11);
		tree.root.left.left.left = tree.new Node(3);
		tree.root.right.left = tree.new Node(4);
		tree.root.right.right = tree.new Node(5);
		tree.root.right.left.right = tree.new Node(6);
		/**
		 * Sample:
		 * 			10
		 * 		   /  \
		 * 		  2    7
		 *       / \  / \
		 *      8  11 4  5
		 *     /       \
		 *    3         6
		 **/
		tree.getMaximumSumLeafPath();
	}

}
