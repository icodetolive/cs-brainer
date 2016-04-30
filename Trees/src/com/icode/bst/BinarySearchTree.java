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
			root.parent = root;
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
	
	public int getMaxHeightRec(BSTNode root) {
		
		if(root == null) {
			return 0;
		} 
		return Math.max(getMaxHeightRec(root.left), getMaxHeightRec(root.right)) + 1;
	}
	
	/*
	 * Algorithm:
	 * 1. Traverse the tree level by level by using queue and pushing the root node at first
	 * 2. At each level, get the count of the nodes/queue
	 * If the nodeCount at that level is 0
	 * 		Increment height
	 * 		Pop the node from the queue
	 * 		Enqueue its children
	 * 		Decrement the nodeCount
	 * Else
	 * 	return current height
	 */
	public int getMaxHeightI(BSTNode root) {
		
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
	
	public int getMinHeightRec(BSTNode root) {
		
		if(root == null) {
			return 0;
		}
		
		if(root.left == null) {
			return getMinHeightRec(root.right) + 1;
		}
		
		if(root.right == null) {
			return getMinHeightRec(root.left) + 1;
		}
		
		return Math.min(getMinHeightRec(root.left), getMinHeightRec(root.right)) + 1;
	}
	
	private static boolean isLeaf(BSTNode node) {
		return (node.left == null && node.right == null);
	}
	
	public int getMinHeightI(BSTNode root) {
		if(root == null) {
			return 0;
		}
		
		Queue<BSTNode> nodesQueue = new LinkedList<BSTNode>();
		Queue<Integer> depthOfCurrentNode = new LinkedList<Integer>();
		nodesQueue.offer(root);
		depthOfCurrentNode.offer(1);
		while(!nodesQueue.isEmpty()) {
			BSTNode currNode = nodesQueue.poll();
			int currDepth = depthOfCurrentNode.poll();
			
			if(isLeaf(currNode)) {
				return currDepth;
			}
			if(currNode.left != null) {
				nodesQueue.offer(currNode.left);
				depthOfCurrentNode.offer(currDepth+1);
			}
			if(currNode.right != null) {
				nodesQueue.offer(currNode.right);
				depthOfCurrentNode.offer(currDepth+1);
			}
		}
		
		return 0;
	}

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insertR(10);
		tree.insertR(8);
		tree.insertR(12);
		tree.insertR(4);
		tree.insertR(9);
		tree.traverseInorder(tree.getRoot());
		tree.searchR(22);
		//System.out.println("Size:: "+tree.getSize(tree.getRoot()));
		System.out.println(tree.getMaxHeightRec(tree.getRoot()));
	}
}
