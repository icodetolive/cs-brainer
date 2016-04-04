package com.icode.bst;
/*
 * @Author Sugandha
 */
public class BSTNode {

	int data;
	BSTNode left, right;
	BSTNode parent;
	
	public BSTNode(int data) {
		this.data = data;
		this.left = this.right = null;
	}
}
