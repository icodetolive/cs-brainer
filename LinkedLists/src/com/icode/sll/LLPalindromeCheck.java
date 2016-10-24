package com.icode.sll;

/*
 * @Author Sugandha 
 * 
 * Reference: http://www.geeksforgeeks.org/function-to-check-if-a-singly-linked-list-is-palindrome/
 */

public class LLPalindromeCheck {

	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		list.pushInEnd(1);
		list.pushInEnd(2);
		list.pushInEnd(3);
		list.pushInEnd(2);
		list.pushInEnd(1);
		
		boolean result = isPalindrome(list.getHead(),list);
		if(result) {
			System.out.println("The list is palindrome");
		}
		else {
			System.out.println("It is not");
		}
	}

	public static boolean isPalindrome(SLLNode head,SinglyLinkedList list) {
		 if(head == null || head.next == null) {
	            return true;
	        }
	        
	        SLLNode slow = head;
	        SLLNode fast = head;
	        SLLNode prevSlow = null;//to store the pointer previous to slow pointer.
	        SLLNode midNode = null;//For cases when the list has odd no. of elements
	        SLLNode secondHead = null; ////Head of the second part of the list starts here.
	        
	        //find mid of the list
	        while(fast != null && fast.next != null) {
	            fast = fast.next.next;
	            prevSlow = slow;
	            slow = slow.next;
	        }
	        
	        prevSlow.next = null;
	        if(fast != null) { //list is odd 
	            midNode = slow;
	            secondHead = slow.next;
	        }
	        else {
	            secondHead = slow;
	        }
	        
	        secondHead = list.reverseI(secondHead);
	        boolean result = compareLists(head, secondHead);
	        head = reconstructList(head, secondHead, midNode, prevSlow);
	        
	        return result;
	    }
	    
	    private static SLLNode reconstructList(SLLNode head1,SLLNode head2,SLLNode mid,SLLNode prev) {
	        if(mid != null) {
	            prev.next = mid;
	            mid.next = head2;
	        }
	        else {
	            prev.next = head2;    
	        }
	        
	        return head1;
	    }
	    
	    private static boolean compareLists(SLLNode head1, SLLNode head2) {
	        while(head1 != null && head2 != null) {
	            if(head1.data == head2.data) {
	                head1 = head1.next;
	                head2 = head2.next;
	            }
	            else {
	                return false;
	            }
	        }
	        
	        if(head1 == null && head2 == null) {
	            return true;
	        }
	        
	        return false;
	    }
}

