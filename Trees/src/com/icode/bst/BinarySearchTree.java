package com.icode.bst;
/*
 * @Author Sugandha
 * 
 * Includes basic operations like: 
 * 1. Insert, Search - (Iterative and Recursive) 
 * 2. Recursive DFS traversals 
 * 3. Height of the tree(recursive)
 * 4. Size of the tree(recursive)
 * 
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
		}
		else if(root.data < key) {
			root.right = insertRec(root.right, key);
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
		System.out.println(root.data);
		traverseInorder(root.right);
	}
	
	public void traversePreorder(BSTNode root) {

		if (root == null) {
			return;
		}
		System.out.println(root.data);
		traversePreorder(root.left);
		traversePreorder(root.right);
	}
	
	public void traversePostorder(BSTNode root) {
		
		if(root == null) {
			return;
		}
		traversePostorder(root.left);
		traversePostorder(root.right);
		System.out.println(root.data);
	}
	
	public int getSize(BSTNode root) {
		
		if(root == null) {
			return 0;
		}
		return (getSize(root.left) + getSize(root.right) + 1);
	}
	
	public int getHeight(BSTNode root) {
		
		if(root == null) {
			return 0;
		} 
		return Math.max(getHeight(root.left), getHeight(root.right) + 1);
	}
	
//	

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insertR(1);
		tree.insertR(5);
		tree.insertR(2);
		tree.insertR(7);
		tree.insertR(4);
		tree.traverseInorder(tree.getRoot());
		tree.searchR(22);
		System.out.println("Size:: "+tree.getSize(tree.getRoot()));
		System.out.println(tree.getHeight(tree.getRoot()));
	}
}
