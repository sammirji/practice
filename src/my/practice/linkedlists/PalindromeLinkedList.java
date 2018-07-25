package my.practice.linkedlists;

public class PalindromeLinkedList {
	
	ListNode head;
	
	class ListNode {
		ListNode next;
		int data;
		
		public ListNode(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	public boolean palindromeCheck() {
		if (head == null || head.next == null)
			return true;
		
		System.out.println("Find middle Node");
		// Find middle Node
		ListNode fastNode = head;
		ListNode slowNode = head;
		while (fastNode.next != null && fastNode.next.next != null) {
			fastNode = fastNode.next.next;
			slowNode = slowNode.next;
		}
		
		ListNode secondNode = slowNode.next;
		slowNode.next = null;
		
		System.out.println("Reverse second-half");
		// Reverse second-half
		ListNode p1 = secondNode;
		ListNode p2 = p1.next;
		while (p1 != null && p2 != null) {
			ListNode temp = p2.next;
			p2.next = p1;
			p1 = p2;
			p2 = temp;
		}
		
		secondNode.next = null;
		
		System.out.println("Compare sub-lists");
		// Compare sub-lists
		ListNode p = (p2==null)?p1:p2;
		ListNode q = head;
		while (p != null) {
			if (p.data != q.data)
				return false;
			p = p.next;
			q = q.next;
		}
		
		return true;
	}

	public static void main(String[] args) {
		PalindromeLinkedList pLL = new PalindromeLinkedList();
		pLL.head = pLL.new ListNode(10);
		pLL.head.next = pLL.new ListNode(11);
		pLL.head.next.next = pLL.new ListNode(12);
		pLL.head.next.next.next = pLL.new ListNode(11);
		pLL.head.next.next.next.next = pLL.new ListNode(10);
		
		boolean isPalindrome = pLL.palindromeCheck();
		System.out.println("Palindrome: " + isPalindrome);
	}

}
