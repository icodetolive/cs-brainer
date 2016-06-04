package com.icode.bt;
/*
 *  @Author Sugandha
 *  
 *  1) Print nodes at all levels (traverseLevels())
 *  2) Print levels of tree line by line(traverseLevelsLineByLine1()) => uses delimeter technique
 *  3) Print levels line by line (traverseLevelsLineByLine2()) => Uses nodecount technique
 *  4) Print levels in spiral fashion (traverseSpirally())
 *  5) Print levels in reverse order(bottom up) fashion (traverseLevelsBottomUp())
 *  6) Print reversed levels line by line(traverseLevelesBottomUpLineByLine())
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderTraversal {

	public static void main(String[] args) {
		
		      /*
		       *            a
		       *          /   \ 
		       *		 b     c
		       			  \   / \
		       			   d e   f
		       			          \
		       			           g 
		       			   
		       */
		
		LevelOrderTraversal tree = new LevelOrderTraversal();
		BTNode root = new BTNode('a');
		root.left = new BTNode('b');
		root.right = new BTNode('c');
		root.left.right = new BTNode('d');
		root.right.left = new BTNode('e');
		root.right.right = new BTNode('f');
		root.right.right.right = new BTNode('g');
		
		//tree.traverseLevels(root);
		//tree.traverseLevelsLineByLine1(root);
		//tree.traverseLevelsLineByLine2(root);
		//tree.traverseLevelsSpirally(root);
		//tree.traverseLevelsBottomUp(root);
	}
	
	//In order to traverse levels bottom up line by line, 
	//refer: leetcode problem or http://buttercola.blogspot.com/2014/08/leetcode-binary-tree-level-order_20.html(iterative solution)
	public void traverseLevelsBottomUp(BTNode root) {
		if(root == null) {
			return;
		}
		BTNode curr = root;
		Queue<BTNode> q = new LinkedList<BTNode>();
		Stack<BTNode> s = new Stack<BTNode>();
		q.add(root);
		while(!q.isEmpty()) {
			curr = q.remove();
			if(curr.right != null) {
				q.add(curr.right);
			}
			if(curr.left != null) {
				q.add(curr.left);
			}
			s.push(curr);
		}
		
		while(!s.isEmpty()) {
			curr = s.pop();
			System.out.print(curr.data+" ");
		}
	}
	
	public void traverseLevelsSpirally(BTNode root) {
		
		if(root == null) {
			return;
		}
		
		Stack<BTNode> stack1 = new Stack<BTNode>(); //L to R
		Stack<BTNode> stack2 = new Stack<BTNode>(); //R to L
		stack1.push(root);
		while(!stack1.isEmpty() || !stack2.isEmpty()) {
			while(!stack1.isEmpty()) {
				BTNode node = stack1.pop();
				System.out.print(node.data+" ");
				if(node.left != null) {
					stack2.push(node.left);
				}
				if(node.right != null) {
					stack2.push(node.right);
				}
			}
			System.out.println();
			while(!stack2.isEmpty()) {
				BTNode node = stack2.pop();
				System.out.print(node.data+" ");
				if(node.right != null) {
					stack1.push(node.right);
				}
				if(node.left != null) {
					stack1.push(node.left);
				}
			}
			System.out.println();
		}
	}
	
	public void traverseLevels(BTNode root) {
		
		if(root == null) {
			return;
		}
		Queue<BTNode> q = new LinkedList<BTNode>();
		q.add(root);
		while(!q.isEmpty()) {
			BTNode node = q.remove();
			System.out.print(node.data+" ");
			if(node.left != null) {
				q.add(node.left);
			}
			if(node.right != null) {
				q.add(node.right);
			}
		}
	}

	//Using a delimiter technique
	//Keep pushing node's children in the queue until you see a delimiter.
	//if a node == delimter, push delimtiere in queue and print a new line
	public void traverseLevelsLineByLine1(BTNode root) {
		if(root == null) {
			return;
		}
		Queue<BTNode> q = new LinkedList<BTNode>();
		q.add(root);
		q.add(null); //null is the delimiter in this case
		BTNode curr = root;
		while(!q.isEmpty()) {
			curr = q.remove();
			if(curr == null) {
				if(!q.isEmpty()) {
					q.add(null);
					System.out.println();
				}
				else {
					break;
				}
			}
			else {
				System.out.print(curr.data+" ");
				if(curr.left != null) {
					q.add(curr.left);
				}
				if(curr.right != null) {
					q.add(curr.right);
				}
			}
		}
	}
	
	//Using a node count technique
	//Can also be used to find the max width
	public void traverseLevelsLineByLine2(BTNode root) {
		int maxWidth = 0;
		int width;
		Queue<BTNode> q = new LinkedList<BTNode>();
		q.add(root);
		while(!q.isEmpty()) {
			int nodeCount = q.size();
			width = nodeCount;
			if(maxWidth < width) {
				maxWidth = width;
			}
			
			while(nodeCount > 0) {
				BTNode node = q.remove();
				System.out.print(node.data+" ");
				if(node.left != null) {
					q.add(node.left);
				}
				if(node.right != null) {
					q.add(node.right);
				}
				nodeCount--;
			}
			System.out.println();
		} 
		System.out.println("Max width is: "+maxWidth);
	}
}
