package com.icode.bt;
/*
 *  @Author Sugandha
 */

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
		       			   
		       */
		
		LevelOrderTraversal tree = new LevelOrderTraversal();
		BTNode root = new BTNode('a');
		root.left = new BTNode('b');
		root.right = new BTNode('c');
		root.left.right = new BTNode('d');
		root.right.left = new BTNode('e');
		root.right.right = new BTNode('f');
		
		//tree.traverseLevels(root);
		//tree.traverseLevelByLevel1(root);
		//tree.traverseLevelByLevel2(root);
		tree.traverseSpirally(root);
	}
	
	public void traverseSpirally(BTNode root) {
		
		if(root == null) {
			return;
		}
		
		Stack<BTNode> stack1 = new Stack<BTNode>(); //R to L
		Stack<BTNode> stack2 = new Stack<BTNode>(); //L to R
		stack1.push(root);
		while(!stack1.isEmpty() || !stack2.isEmpty()) {
			while(!stack1.isEmpty()) {
				BTNode node = stack1.pop();
				System.out.print(node.data);
				if(node.right != null) {
					stack2.push(node.right);
				}
				if(node.left != null) {
					stack2.push(node.left);
				}
			}
			while(!stack2.isEmpty()) {
				BTNode node = stack2.pop();
				System.out.print(node.data);
				if(node.left != null) {
					stack1.push(node.left);
				}
				if(node.right != null) {
					stack1.push(node.right);
				}
			}
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
	//Keep pushing in the queue node's children until you see a delimiter.
	//if a node == delimter, push delimtiere in queue and print a new line
	public void traverseLevelByLevel1(BTNode root) {
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
	public void traverseLevelByLevel2(BTNode root) {
		Queue<BTNode> q = new LinkedList<BTNode>();
		q.add(root);
		while(true) {
			int nodeCount = q.size();
			if(nodeCount == 0) {
				break;
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
	}
}
