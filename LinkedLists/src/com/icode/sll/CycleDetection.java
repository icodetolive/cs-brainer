package com.icode.sll;

public class CycleDetection {

	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		list.pushInEnd(1);
		list.pushInEnd(2);
		list.pushInEnd(3);
		list.pushInEnd(4);
		list.pushInEnd(5);
		SLLNode head = list.getHead();
		
		//create loop for testing
		list.getHead().next.next.next.next.next = head;

		boolean result = hasCycle(list.getHead());
		System.out.println("Linked list has cycle? ::"+result);
	}

	
	public static boolean hasCycle(SLLNode head) {
		SLLNode slow = head;
		SLLNode fast  = head;
		
		if(head == null) {
			return false;
		}
		
		//to avoid overflow
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			
			//intersect at one point
			if(slow == fast) {
				return true;
			}
		}
		return false;
	}
}
