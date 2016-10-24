package com.icode.sll;
/*
 * @Author Sugandha
 * 
 * Following functions included:
 * 
 * 1. Detect if a singly linked list has a cycle
 * 2. If yes, fetch the entrance/starting node of the cycle
 * 3. If yes, fetch the length of the cycle
 * 4. If yes, remove the loop from the cycle
 * 
 * Reference(s): 
 * Detect cycle: http://buttercola.blogspot.com/2014/08/leetcode-linked-list-cycle.html
 * Fetch entrance node of cycle and length of list: http://buttercola.blogspot.com/2014/08/leetcode-linked-list-cycle-ii.html
 * Remove loop: http://www.geeksforgeeks.org/detect-and-remove-loop-in-a-linked-list/
 */
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
		list.getHead().next.next.next.next.next = head.next;

//		boolean result = hasCycle(head);
//		System.out.println("Linked list has cycle? ::"+result);
		SLLNode result = fetchStartingNodeOfCycle(head);
		if(result != null) {
			System.out.println("The cycle starts at: "+result.data);
		}
		else {
			System.out.println("The list doesn't contain cycle!");
		}
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
	
	public static SLLNode fetchStartingNodeOfCycle(SLLNode head) {
		  if(head == null) {
	            return null;
	        }
	        
	        SLLNode temp = hasCycleCustom(head);
	        
	        //check if there is a cycle
	        if(temp == null || temp.next == null) {
	            return null;
	        }
	        
	        //fetch the entrance node of the cycle
	        SLLNode slow = head;
	        while(slow != temp) {
	            slow = slow.next;
	            temp = temp.next;
	        }
	        
	        return slow;
	    }
	
	private static SLLNode hasCycleCustom(SLLNode head) {
		SLLNode slow = head;
		SLLNode fast = head;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			
			if(slow == fast) {
				break;
			}
		}
		
		return fast;
	}
	  
}
