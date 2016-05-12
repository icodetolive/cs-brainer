//Implement stack using Linked Lists
package com.icode.stacks;

public class StackUsingLL {

	StackNode top, curr;
	public StackUsingLL() {
		top = null;
	}
	
	public void push(int data) {
		curr = new StackNode(data);
		if(top != null) {
			curr.next = top;
		}
		top = curr;
	}
	
	public StackNode pop() {
		if(isEmpty()) {
			return null;
		}
		curr = top;
		top = top.next;
		curr.next = null;
		return curr;
	}
	
	private boolean isEmpty() {
		if(top == null) {
			System.out.println("The stack is empty");
			return true;
		}
		return false;
	}
	
	public void print() {
		if(isEmpty()) {
			return;
		}
		curr = top;
		while(curr != null) {
			System.out.print(curr.data+" ");
			curr = curr.next;
		}
	}
	
	public StackNode peek() {
		if(isEmpty()) {
			return null;
		}
		return top;
	}
}
