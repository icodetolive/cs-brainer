package com.icode.sll;


/*
 * @Author Sugandha
 * 
 * References:
 * 1. Remove Nth node from end of the list: https://leetcode.com/problems/remove-nth-node-from-end-of-list/ 
 *    1.1 Length technique://www.geeksforgeeks.org/nth-node-from-the-end-of-a-linked-list/
 *    1.2 Two pointer technique: http://www.programcreek.com/2014/05/leetcode-remove-nth-node-from-end-of-list-java/
 * 
 */

public class NthNodeFromEnd {

	public static void main(String[] args) {
		
		SinglyLinkedList list = new SinglyLinkedList();
		list.pushInEnd(1);
		list.pushInEnd(2);
		list.pushInEnd(3);
		list.pushInEnd(4);
		list.pushInEnd(5);
		SLLNode head = list.getHead();
		int n = 5;
		
//		SLLNode newHead = nthNodeFromEnd(head,list.getCount(head),n);
		SLLNode newHead = nthNodeFromEnd2Pointer(head, n);
		if(newHead != null) {
			System.out.println("The new list contents are:");
			list.display(newHead);
		}
		else {
			System.out.println("Invalid input!");
		}
	}
	
	//Using length technique
	public static SLLNode nthNodeFromEnd(SLLNode head, int length, int n) {
		
		if(head == null || length < n) {
			return null;
		}
		
		SLLNode  curr = head;
		SLLNode prev = head;
		int i = 1;
		while(i < length-n+1) {
			prev = curr;
			curr = curr.next;
			i++;
		}
		//here, curr is the nth node from end
		
		//if n == length of list
		if(curr == head) {
			head = head.next;
		}
//		delink the curr node which is the nth node from end
		else {
			prev.next = curr.next;
		}
		
		return head;
	}
	
	public static SLLNode nthNodeFromEnd2Pointer(SLLNode head, int n) {
		
		if(head == null) {
			return null;
		}
		
		int i = 0;
		SLLNode slow = head;
		SLLNode fast = head;
		
		//move the fast pointer n nodes ahead of head
		while(i < n) {
			fast = fast.next;
			i++;
		}
		
		//if n == length of the list
		if(fast == null) {
			head = head.next;
			return head;
		}
		
		while(fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		
		slow.next = slow.next.next;
		return head;
	}
}
