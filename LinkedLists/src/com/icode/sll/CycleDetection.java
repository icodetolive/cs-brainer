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
//		SLLNode result = fetchStartingNodeOfCycle(head);
//		if(result != null) {
//			System.out.println("The cycle starts at: "+result.data);
//		}
//		else {
//			System.out.println("The list doesn't contain cycle!");
//		}
		
		int result = calculateLength(head);
		System.out.println();
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
	
	/*Algorithm: 
	 * 1. Find the collision point in the loop
	 * 2. Then move two pointers at the same speed - one starts from the head of the linked list,
	 *    while the other starts from the collision node. 
	 * 3. The next collision is the entrance of the loop.
	 */

	public static SLLNode fetchStartingNodeOfCycle(SLLNode head) {
		  if(head == null) {
	            return null;
	        }
	        
	        SLLNode temp = findCollisionPoint(head);
	        
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
	
	private static SLLNode findCollisionPoint(SLLNode head) {
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
	
	/*
	 * Algorithm:
	 * 1. Find the collision point 
	 * 2. From the collision point in the cycle, use two pointers - 
	 *    One moves one step at a time while the other moves two at a time. 
	 * 3. Until they meet again, the number of steps is the length of the cycle. 
	 */
	
	public static int calculateLength(SLLNode head) {
		
		if(head == null) {
			return -1;
		}
		
		SLLNode temp = findCollisionPoint(head);
		
		 //check if there is a cycle
        if(temp == null || temp.next == null) {
        	return -1;
        }
//        
		SLLNode fast = temp;
		SLLNode slow = fast;
		int counter = 0;
		
		slow = slow.next;
		fast = fast.next.next;
		counter++;	
		
		while(slow != fast) {
			slow = slow.next;
			fast = fast.next.next;
			counter++;
		}
		
		System.out.println("--"+counter);
		return counter;
	}
	  
}
