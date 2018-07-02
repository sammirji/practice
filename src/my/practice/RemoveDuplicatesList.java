package my.practice;

public class RemoveDuplicatesList {

	Node head;
	
	/* Adds element to front of the list */
	void push(int data) {
		Node node = new Node(data);
		node.next = head;
		head = node;
	}
	
	void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.value + " ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	void removeDuplicates() {
		
	}
	
	class Node {
		Node next;
		int value;

		Node(int val) {
			this.value = val;
		}
	}
	
	public static void main(String[] args) {
		RemoveDuplicatesList rdl = new RemoveDuplicatesList();
		rdl.push(0);
		rdl.push(0);
		rdl.push(2);
		rdl.push(2);
		rdl.push(4);
		rdl.push(6);
		rdl.push(8);
		rdl.printList();
		
	}
}