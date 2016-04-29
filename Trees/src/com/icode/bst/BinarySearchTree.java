/*
 * Basic Functionalities of binary tree
 * 
 * @Author Sugandha Naolekar
 */

package com.icode.bst;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
	
	private BSTNode root;
	
	public BinarySearchTree() {
		root = null;
	}
	
	public void insertI(int key) {
		
		BSTNode node = new BSTNode(key);
		if(root == null) {
			root = node;
			return;
		}
		
		BSTNode parent = null;
		BSTNode curr = root;
		while(curr != null) {
			parent = curr;
			if(curr.data < key) {
				curr = curr.right;
			}
			else if(curr.data > key) {
				curr = curr.left;	
			}
			else {
				curr.data = key;
				return;
			}
		}
		if(parent.data < key) {
			parent.right = node;
		}
		else {
			parent.left = node;
		}
	}
	
	public void insertR(int key) {
		root = insertRec(root, key);
	}
	
	private BSTNode insertRec(BSTNode root, int key) {
		
		BSTNode node = new BSTNode(key);
		if(root == null) {
			root = node;
			return root;
		}
		
		if(root.data > key) {
			root.left = insertRec(root.left, key);
			root.left.parent = root;
		}
		else if(root.data < key) {
			root.right = insertRec(root.right, key);
			root.right.parent = root;
		}
		return root;
	}
	
	public boolean searchI(int key) {
		
		if(root == null) { //tree is empty
			System.out.println("Key not found");
			return false;
		}
		BSTNode curr = root;
		while(curr != null) {
			if(curr.data == key) {
				System.out.println("Key found");
				return true;
			}
			else if(curr.data < key) {
				curr = curr.right;
			}
			else { 
				curr = curr.left;
			}
		}
		System.out.println("Key not found");
		return false;
	}
	
	public void searchR(int key) {
		
		if(searchRec(root, key)) {
			System.out.println("Key found");
		}
		else {
			System.out.println("Key not found");
		}
	}
	
	private boolean searchRec(BSTNode root, int key) {
		
		if(root == null) {
			return false;
		}
		if (root.data == key) {
			return true;
		}
		if(root.data > key) {
			return searchRec(root.left, key);
		}
		return searchRec(root.right, key);
	}
		
	public BSTNode getRoot() {
		
		return root;
	}
	
	public void traverseInorder(BSTNode root) {
		
		if (root == null) {
			return;
		}
		traverseInorder(root.left);
		System.out.print(root.data+" ");
		traverseInorder(root.right);
	}
	
	public void traversePreorder(BSTNode root) {

		if (root == null) {
			return;
		}
		System.out.print(root.data+" ");
		traversePreorder(root.left);
		traversePreorder(root.right);
	}
	
	public void traversePostorder(BSTNode root) {
		
		if(root == null) {
			return;
		}
		traversePostorder(root.left);
		traversePostorder(root.right);
		System.out.print(root.data+" ");
	}
	
	public int getSize(BSTNode root) {
		
		if(root == null) {
			return 0;
		}
		return (getSize(root.left) + getSize(root.right) + 1);
	}
	
	public int getHeightRec(BSTNode root) {
		
		if(root == null) {
			return 0;
		} 
		return Math.max(getHeightRec(root.left), getHeightRec(root.right) + 1);
	}
	
	/*
	 * Algorithm:
	 * 1. Traverse the tree level by leve by using queue and poushing the root node at first
	 * 2. At each level, get the count of the nodes/queue
	 * If the nodeCount at that level is 0
	 * 		Increment height
	 * 		Pop the node from the queue
	 * 		Enqueue its children
	 * 		Decrement the nodeCount
	 * Else
	 * 	return current height
	 */
	public int getHeightI(BSTNode root) {
		
		if(root == null) {
			return 0;
		}
		int maxHeight = 0;
		Queue<BSTNode> q = new LinkedList<BSTNode>();
		q.offer(root);
		while(true) {
			int nodeCount = q.size();
			if(nodeCount == 0) {
				return maxHeight;
			}
			
			maxHeight++;
			while(nodeCount > 0) {
				BSTNode node = q.poll();
				if(node.left != null) {
					q.offer(node.left);
				}
				if(node.right != null) {
					q.offer(node.right);
				}
				nodeCount--;
			}
		}
	}
	
//	

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insertR(1);
		tree.insertR(2);
		tree.insertR(3);
		tree.insertR(4);
		tree.insertR(5);
		tree.traverseInorder(tree.getRoot());
		tree.searchR(22);
		//System.out.println("Size:: "+tree.getSize(tree.getRoot()));
		System.out.println(tree.getHeightI(tree.getRoot()));
	}
}
