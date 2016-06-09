package com.icode.bt;

public class BinaryTree {
	
	public static void main(String[] args) {
		
		BinaryTree tree = new BinaryTree();
		BTNode root = new BTNode('a');
		root.left = new BTNode('b');
		root.right = new BTNode('c');
		root.left.right = new BTNode('d');
		root.right.left = new BTNode('e');
		root.right.right = new BTNode('f');
	}
}
     