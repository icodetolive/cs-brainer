package com.icode.bt;
/*
 *  @Author Sugandha
 */

import java.util.Stack;

public class IterativeTraversal {
	
	public void traverseInorder(BTNode root) {
		
		if(root == null) {
			return;
		}
		BTNode curr = root;
		Stack<BTNode> s = new Stack<BTNode>();
		while(true) {
			if(curr != null) {
				s.push(curr);
				curr = curr.left;
			}
			else {
				if(s.isEmpty()) {
					break;
				}
				curr = s.pop();
				System.out.print(curr.data+" ");
				curr = curr.right;
			}
		}
	}
	
	//Postorder traversal using 2 stacks
	public void traversePostorder1(BTNode root) {
		
		if(root == null) {
			return;
		}
		Stack<BTNode> s1 = new Stack<BTNode>();
		Stack<BTNode> s2 = new Stack<BTNode>();
		s1.push(root);
		BTNode curr;
		while(!s1.isEmpty()) {
			curr = s1.pop();
			s2.push(curr);
			if(curr.left != null) {
				s1.push(curr.left);
			}
			if(curr.right != null) {
				s1.push(curr.right);
			}
		}
		while(!s2.isEmpty()) {
			curr = s2.pop();
			System.out.print(curr.data+" ");
		}
	}
	
	//postorder traversal using one stack
	//In this variation, we actually modify the original tree structure by everytime pushing the children of the root node
	//and then disconnecting the root from its children
	//Reference: http://www.programcreek.com/2012/12/leetcode-solution-of-iterative-binary-tree-postorder-traversal-in-java/ (Solution 2)
	public void traversePostorder2(BTNode root) {
		if(root == null) {
			return;
		}
		
		Stack<BTNode> stack = new Stack<BTNode>();
        stack.push(root);
        while(!stack.isEmpty()) {
        	BTNode temp = stack.peek();
        	
            //if it is a leaf node, pop it and add it's value to the list
            if(temp.left == null && temp.right == null) {
            	BTNode poppedNode = stack.pop();
                System.out.println(poppedNode.data);
            }
            //disconnect the root from its children after pushing its children into the stack
            else {
                if(temp.right != null) {
                    stack.push(temp.right);
                    temp.right = null;
                }
                if(temp.left != null) {
                    stack.push(temp.left);
                    temp.left = null;
                }
            }
        }
	}
	
	//Using one stack
	//Reference: https://www.youtube.com/watch?v=xLQKdq0Ffjg&index=18&list=PLrmLmBdmIlpv_jNDXtJGYTPNQ2L1gdHxu 
	public void traversePostorder3(BTNode root) {
		BTNode curr = root;
        Stack<BTNode> stack = new Stack<BTNode>();
        
        while(curr != null || !stack.isEmpty()) {
            if(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            else {
            	BTNode temp = stack.peek().right;
                if(temp == null) {
                    temp = stack.pop();
                   System.out.println(temp.data);
                    while(!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.pop();
                        System.out.println(temp.data);
                    }
                }
                else {
                    curr = temp;
                }
            }
        }
    }
	
	
	public void traversePreorder(BTNode root) {
		
		if(root == null) { //tree is empty
			return;
		}
		Stack<BTNode> s = new Stack<BTNode>();
		s.push(root);
		BTNode curr;
		while(!s.isEmpty()) {
			curr = s.pop();
			System.out.print(curr.data+" ");
			if(curr.right != null) {
				s.push(curr.right);
			}
			if(curr.left != null) {
				s.push(curr.left);
			}
		}
	}

	public static void main(String[] args) {
		
		 /*
	       *            a
	       *          /   \ 
	       *		 b     c
	       			  \   / \
	       			   d e   f 
	       			   
	       */
	
		IterativeTraversal tree = new IterativeTraversal();
		BTNode root = new BTNode('a');
		root.left = new BTNode('b');
		root.right = new BTNode('c');
		root.left.right = new BTNode('d');
		root.right.left = new BTNode('e');
		root.right.right = new BTNode('f');
		
		//tree.traverseInorder(root);
		tree.traversePostorder3(root);
//		tree.traversePreorder(root);
	}	
}
	
		
		
		
		
		