package com.icode.sll;

public class NumbersAddition {

	public SLLNode add(SLLNode head1, SLLNode head2) {
		SLLNode result = null, curr = null, temp;
		int sum = 0, carry = 0;
		while(head1 != null || head2 != null) {
			
			sum = (head1 != null ? head1.data : 0) + (head2 != null ? head2.data : 0) + carry;
			carry = sum/10;
			sum = sum % 10;
			temp = new SLLNode(sum);
			if(result == null) {
				result = temp;
				curr = temp;
			}
			else {
				curr.next = temp;
				curr = temp;
			}
			
			if(head1 != null) {
				head1 = head1.next;
			}
			
			if(head2 != null) {
				head2 = head2.next;
			}
		}
		
		if(carry != 0) {
			temp = new SLLNode(carry);
			curr.next = temp;
			curr = temp;
		}
		
		return result;
	}
	
	//a function to print linkedlist
	public static void displayAdditionResult(SLLNode curr) {
		System.out.println("Addition result: ");
		while(curr != null) {
			System.out.print(curr.data+" ");
			curr = curr.next;
		}
	}
	
	public static void main(String[] args) {
		
		SinglyLinkedList list1 = new SinglyLinkedList();
		SinglyLinkedList list2 = new SinglyLinkedList();
		
		SLLNode head1, head2, result = null;
		
//		Add two numbers: 365 and 248 represented as: 5->6->3->null and 8->4->2->null 
		//Output: 613 represented as: 3->1->6
//		int[] l1 = {3,6,5};
//		int[] l2 = {2,4,8};
		int[] l1 = {6,4,9,5,7};
		int[] l2 = {4,8};
		
		//Create first list as 5->6>3->null
		for(int i = l1.length - 1; i >= 0; i--) {
			list1.pushInEnd(l1[i]);
		}
		
		//Create second list as 8->4->2->null
		for(int i = l2.length - 1; i >= 0; i--) {
			list2.pushInEnd(l2[i]);
		}
		head1 = list1.getHead();
		head2 = list2.getHead();
		
		NumbersAddition numbers = new NumbersAddition();
		result = numbers.add(head1, head2);
		displayAdditionResult(result);
	}
}
