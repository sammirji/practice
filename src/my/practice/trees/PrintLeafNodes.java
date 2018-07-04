package my.practice.trees;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class PrintLeafNodes {

	Node root;
	Map<Integer, LinkedHashSet<Integer>> map = null;
	
	class Node {
		Node left, right;
		int data;
		
		public Node(int data) {
			this.data = data;
			this.left = this.right = null;
		}
	}
	
	public void printLeafNodes() {
		map = new HashMap<>(); 
		printLeafNodes(root, 0);
		for (Integer key: map.keySet()) {
			LinkedHashSet<Integer> list = map.get(key);
			System.out.print("At height '" + key + "': ");
			list.forEach(element -> {System.out.print(element + " ");});
			System.out.println();
		}
	}
	
	void printLeafNodes(Node node, int height) {
		if (node == null) return;
		
		printLeafNodes(node.left, height+1);
		printLeafNodes(node.right, height+1);
		
		if (map.containsKey(height)) {
			LinkedHashSet<Integer> list = map.get(height);
			list.add(node.data);
		} else {
			LinkedHashSet<Integer> list = new LinkedHashSet<>();
			list.add(node.data);
			map.put(height, list);
		}
	}
	
	public static void main(String[] args) {
		PrintLeafNodes tree = new PrintLeafNodes();
		tree.root = tree.new Node(12);
		tree.root.left = tree.new Node(10);
		tree.root.left.left = tree.new Node(9);
		tree.root.left.right = tree.new Node(11);
		tree.root.right = tree.new Node(14);
		
		tree.printLeafNodes();
	}

}
