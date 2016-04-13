package com.icode.sll;
/*
 * @Author Sugandha
 */
public class NumbersAdditionReverse {

	public SLLNode add(SLLNode h1, SLLNode h2, SLLNode res, int size1, int size2) {
		
		SLLNode temp;
		
		//first list is empty
		if(h1 == null) {
			return h2;
		}
		
		//second list is empty
		if(h2 == null) {
			return h1;
		}
		
		int[] carry =  new int[1];
		if(size1 == size2) { //Add same size lists
			res = addSameSize(h1, h2, carry);
		}
		else {
			int diff = Math.abs(size1 - size2);
			
			// First list should always be larger than second list.
	        // If not, swap pointers
			if(size1 < size2) {
				temp = h1;
				h1 = h2;
				h2 = temp;
			}
			
			temp = h1;
			 // move diff. number of nodes in first list
			while(diff != 0) {
				temp = temp.next;
				diff--;
			}
			
			// get addition of same size lists (right sublist of larger list + smaller list)
			res = addSameSize(temp, h2, carry);
			
			// get addition of remaining first list and carry (left sublist of larger list + carry)
			res = addCarryToRemaining(h1, temp, carry, res);
			
		}
		// if some carry is still there, add a new node to the front of the result list
		if(carry[0] != 0) {
			SLLNode newNode = new SLLNode(carry[0]);
			newNode.next = res;
			res = newNode;
		}
		
		return res;
	}
	
	private SLLNode addSameSize(SLLNode head1, SLLNode head2, int[] carry) {
		
	    // Since the function assumes linked lists are of same size,
	    // check any of the two head pointers
		if(head1 == null) {
			return null;
		}
		int sum;
		//Allocate memory for sum node of current two nodes
		SLLNode result = new SLLNode();
		
		 // Recursively add remaining nodes and get the carry
		result.next = addSameSize(head1.next, head2.next, carry);
		
		// add digits of current nodes and propagated carry
		sum = head1.data + head2.data + carry[0];
		carry[0] = sum/10;
		sum = sum%10;
		
		 // Assign the sum to current node of resultant list
		result.data = sum;
		
		return result;
	}
	
	// This function is called after the smaller list is added to the bigger
	// lists's sublist of same size.  Once the right sublist is added, the carry
	// must be added the left side of larger list to get the final result.
	public SLLNode addCarryToRemaining(SLLNode head1, SLLNode curr, int[] carry, SLLNode result) {
		
		int sum = 0;
		
		//If the nodes are different, add carry
		if(head1 != curr) {
			addCarryToRemaining(head1.next, curr, carry, result);
			
			sum = head1.data + carry[0];
			carry[0] = sum / 10;
			sum = sum % 10;
			
			//Add this node to the front of the list
			SLLNode newNode = new SLLNode(sum);
			newNode.next = result;
			result = newNode;
			
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
		
//		Add two numbers: 563 and 842 represented as: 5->6->3->null and 8->4->2->null 
		//Output: 1405 represented as: 1->4->0->5->null
		int[] l1 = {5,6,3};
		int[] l2 = {8,4,2};
		
		//Create first list as 5->6->3->null
		for(int i = l1.length - 1; i >= 0; i--) {
			list1.pushInFront(l1[i]);
		}
		
		//Create second list as 8->4->2->null 
		for(int i = l2.length - 1; i >= 0; i--) {
			list2.pushInFront(l2[i]);
		}
		head1 = list1.getHead();
		head2 = list2.getHead();
		
		NumbersAdditionReverse numbers = new NumbersAdditionReverse();
		result = numbers.add(head1, head2, result, l1.length, l2.length);
		displayAdditionResult(result);
	}
}


