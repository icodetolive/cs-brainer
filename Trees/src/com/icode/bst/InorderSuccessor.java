package com.icode.bst;
/*
 * @Author Sugandha
 */

public class InorderSuccessor {

	public static void main(String[] args) {
		
		InorderSuccessor bst = new InorderSuccessor();
		BinarySearchTree tree = new BinarySearchTree();
		tree.insertR(20);
		tree.insertR(8);
		tree.insertR(22);
		tree.insertR(4);
		tree.insertR(12);
		tree.insertR(10);
		tree.insertR(14);
		System.out.println("Inorder traversal: ");
		tree.traverseInorder(tree.getRoot());
		BSTNode temp = tree.getRoot().left.right.right;
		
		//Uses parent pointer technique
		//BSTNode succ = bst.findInorderSuccessor1(temp);
		
		BSTNode succ = bst.findInorderSuccessor2(tree.getRoot(), temp);
		if(succ != null) {
			System.out.println("Successor of "+temp.data+" is: "+succ.data);
		}
		else {
			System.out.println("Successor of "+temp.data+" is: "+null);
		}
	}    
	
	public BSTNode findInorderSuccessor1(BSTNode node) {
		BSTNode parent, child;
		
		if(node.right != null) {
			return findMinValue(node.right);
		}
		
		 parent = node.parent;
		 child = node;
		 while(parent != null && parent.right == child) {
			 child = parent;
			 parent = parent.parent;
		 }
		return parent;
	}
	
	public BSTNode findInorderSuccessor2(BSTNode root, BSTNode node) {
		BSTNode succ = null;
		if(node.right != null) {
			return findMinValue(node.right);
		}
		
		while(root != null) {
			if(root.data > node.data) {
				succ = root;
				root = root.left;
			}
			else if(root.data < node.data) {
				root = root.right;
			}
			else {
				break;
			}
		}
		return succ;
	}
	
	private BSTNode findMinValue(BSTNode node) {
		while(node.left != null) {
			node = node.left;
		}
		return node;
	}
}
