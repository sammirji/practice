package my.practice.linkedlists;

public class DeleteMiddleLinkedList {
	Node head;

	/* Adds element to front of the list */
	void push(int data) {
		Node node = new Node(data);
		node.next = this.head;
		this.head = node;
	}
	
	void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.value + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	void removeMiddle() {
		if (this.head == null)
			return;
		if (this.head.next == null) {
			this.head = null;
			return;
		}
		Node tempNext = this.head;
		Node tempNextNext = this.head.next.next;
		while (tempNextNext != null && tempNextNext.next != null) {
			System.out.println("tempNext: " + tempNext.value + ", tempNextNext: " + tempNextNext.value);
			tempNext = tempNext.next;
			tempNextNext = tempNextNext.next.next;
		}
		tempNext.next = tempNext.next.next;
	}

	public static void main(String[] args) {
		DeleteMiddleLinkedList ll = new DeleteMiddleLinkedList();
		ll.push(1);
		ll.push(3);
		ll.push(5);
		ll.push(9);
		ll.push(11);
		ll.push(13);
		ll.printList();
		
		ll.removeMiddle();
		
		ll.printList();
	}

}

class Node {
	Node next;
	int value;

	Node(int val) {
		this.value = val;
		this.next = null;
	}
}