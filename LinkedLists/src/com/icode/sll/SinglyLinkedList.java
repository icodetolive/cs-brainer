package com.icode.sll;
/*
 * @Author Sugandha 
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

	public static void main(String[] args) {
		
		SinglyLinkedList list = new SinglyLinkedList();
		list.pushInFront(5);
		list.pushInFront(4);
		list.pushInFront(3);
		System.out.println("List contents: ");
		list.display(list.getHead());
		int size = list.getCountR(list.getHead());
		System.out.println("Length of list:: "+size);
	}
}
