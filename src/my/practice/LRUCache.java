package my.practice;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

	Node head, tail;
	int max_capacity;
	Map<Integer, Node> map = new HashMap<>();
	
	class Node {
		Node pre, next;
		int key, value;
		
		public Node (int key, int value) {
			this.key = key;
			this.value = value;
			this.pre = this.next = null;
		}
	}
	
	void setHead(Node node) {
		node.next = head;
		node.pre = null;
		
		if (head != null) {
			head.pre = node;
		}
		head = node;
		
		if (tail == null) {
			tail = head;
		}
	}
	
	void remove(Node node) {
		if (node == null) return;
		
		if (node.pre != null) {
			node.pre.next = node.next;
		} else {
			head = node.next;
		}
		
		if(node.next != null) {
			node.next.pre = node.pre;
		} else {
			tail = node.pre;
		}
	}
	
	void set(int key, int value) {
		if (map.containsKey(key)) {
			Node node = map.get(key);
			node.value = value;
			remove(node);
			setHead(node);
		} else {
			Node node = new Node(key, value);
			setHead(node);
			if (max_capacity < map.size()) {
				remove(tail);
				map.remove(tail.key);
			}
			map.put(key, node);
		}
	}
	
	int get(int key) {
		if (map.containsKey(key)) {
			Node node = map.get(key);
			remove(node);
			setHead(node);
			return node.value;
		}
		return -1;
	}

}
