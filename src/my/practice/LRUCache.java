package my.practice;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

	Node head, tail;
	int maxCapacity;
	Map<Integer, Node> map;
	
	public LRUCache(int maxCapacity) {
		this.maxCapacity = maxCapacity;
		this.map = new HashMap<>();
		this.head = this.tail = null;
	}
	
	class Node {
		Node pre, next;
		int key, value;
		
		public Node(int key, int value) {
			this.key = key;
			this.value = value;
			this.pre = this.next = null;
		}
	}
	
	private void remove(Node node) {
		if (node == null)
			return;
		
		if (node.pre != null) {
			node.pre.next = node.next;
		} else {
			head = node.next;
		}
		
		if (node.next != null) {
			node.next.pre = node.pre;
		} else {
			tail = node.pre;
		}
	}
	
	private void setHead(Node node) {
		if (node == null)
			return;
		
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
	
	public void set(int key, int value) {
		if (map.containsKey(key)) {
			Node node = map.get(key);
			node.value = value;
			remove(node);
			setHead(node);
		} else {
			Node node = new Node(key, value);
			if (maxCapacity <= map.size()) {
				map.remove(tail.key);
				remove(tail);
			}
			setHead(node);
			map.put(key, node);
		}
	}
	
	public int get(int key) {
		if (map.containsKey(key)) {
			Node node = map.get(key);
			remove(node);
			setHead(node);
			return node.value;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		LRUCache lru = new LRUCache(1);
		lru.set(0, 1);
		System.out.println(lru.get(0));
		lru.set(1, 2);
		System.out.println(lru.get(0));
		System.out.println(lru.get(1));
	}

}
