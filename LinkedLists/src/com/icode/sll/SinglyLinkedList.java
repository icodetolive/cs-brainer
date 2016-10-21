package com.icode.sll;
/*
 * @Author Sugandha 
 * 
 * Basic SLL functions:
 * 
 * 1. Push/Add an element in front 
 * 2. Push/Add an element in end
 * 3. Get list count (I and R)
 * 4. Display elements (head to tail)
 * 5. Reverse list (I and R)
 * 
 * Reference(s):
 * Reverse (I): https://leetcode.com/articles/reverse-linked-list/
 * Reverse (L): Tail recursive method -> http://www.geeksforgeeks.org/write-a-function-to-reverse-the-nodes-of-a-linked-list/
 */
public class SinglyLinkedList {
	
	SLLNode head, curr;
	public SinglyLinkedList() {
		head = null;
	}
	
	public void pushInFront(int data) {
		SLLNode node = new SLLNode(data);
		if(head == null) {
			head = node;
		}
		else {
			node.next = head;
			head = node;
		}
	}
	
	public void pushInEnd(int data) { //pushes the given node at the end of the linked list
		SLLNode node = new SLLNode(data);
		if(head == null) {
			head = node;
			curr = node;
		}
		
		else {
			curr.next = node;
			curr = node;
		}
	}
	
	public int getCount(SLLNode head) {
		SLLNode curr = head;
		int count = 0;
		while(curr != null) {
			count++;
			curr = curr.next;
		}
		return count;
	}
	
	public int getCountR(SLLNode head) {
		
		if(head == null) {
			return 0;
		}
		else {
			return 1 + getCount(head.next);
		}
	}
	
	public SLLNode getHead() {
		return head;
	}
	
	public void display(SLLNode head) {
		
		SLLNode curr = head;
		while(curr != null) {
			System.out.print(curr.data+" ");
			curr = curr.next;
		}
	}
	
	public SLLNode reverseI(SLLNode head) {
		
		if(head == null || head.next == null) {
			return head;
		}
		
		SLLNode curr = head;
		SLLNode prev = null;
		SLLNode next = null;
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}
	
	public SLLNode reverseRec(SLLNode head) {
		if(head == null) {
			return head;
		}
		return reverseUtil(head, null);
	}
	
	private SLLNode reverseUtil(SLLNode curr, SLLNode prev) {
	
		SLLNode head1 = null;
		
		if(curr.next == null) {
			head1 = curr;
			curr.next = prev;
			return null;
		}
		
		SLLNode next = curr.next;
		curr.next = prev;
		SLLNode temp = reverseUtil(next, curr);
		System.out.println("New head::"+head1.data);
		return head1;
	}
	
	public static void main(String[] args) {
		
		SinglyLinkedList list = new SinglyLinkedList();
		list.pushInFront(3);
		list.pushInFront(2);
		list.pushInFront(1);
		System.out.println("List contents: ");
		list.display(list.getHead());
		SLLNode newHead = list.reverseRec(list.getHead());
		System.out.println("After reversing: ");
		list.display(newHead);
	}
}
