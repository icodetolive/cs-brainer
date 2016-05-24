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
		//tree.traversePostorder(root);
		tree.traversePreorder(root);
	}	
}
	
		
		
		
		
		