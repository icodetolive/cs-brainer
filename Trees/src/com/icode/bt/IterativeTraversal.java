package com.icode.bt;

public class IterativeTraversal {

	public static void main(String[] args) {
		
//		public void traverseInorderI(BSTNode root) {
//			
//			if(root == null) {
//				return;
//			}
//			BSTNode curr = root;
//			Stack<BSTNode> s = new Stack<BSTNode>();
//			while(true) {
//				while(curr != null) {
//					s.push(curr);
//					curr = curr.left;
//				}
//				if(s.isEmpty()) {
//					break;
//				}
//				curr = s.pop();
//				System.out.print(curr.data+" ");
//				curr = curr.right;
//			}
//		}
	//	
//		public void traversePreorderI(BSTNode root) {
//			
//			if(root == null) { //tree is empty
//				return;
//			}
//			Stack<BSTNode> s = new Stack<BSTNode>();
//			s.push(root);
//			BSTNode curr;
//			while(!s.isEmpty()) {
//				curr = s.pop();
//				System.out.println(curr.data);
//				if(curr.right != null) {
//					s.push(curr.right);
//				}
//				if(curr.left != null) {
//					s.push(curr.left);
//				}
//			}
//			
//		}
		
		
		
//		public void traversePostorderI(BSTNode root) {
//			
//			if(root == null) {
//				return;
//			}
//			Stack<BSTNode> s1 = new Stack<BSTNode>();
//			Stack<BSTNode> s2 = new Stack<BSTNode>();
//			s1.push(root);
//			BSTNode curr;
//			while(!s1.isEmpty()) {
//				curr = s1.pop();
//				s2.push(curr);
//				if(curr.left != null) {
//					s1.push(curr.left);
//				}
//				if(curr.right != null) {
//					s1.push(curr.right);
//				}
//			}
//			while(!s2.isEmpty()) {
//				curr = s2.pop();
//				System.out.println(curr.data);
//			}
//		}
		
		BTNode root = new BTNode('a');
		root.left = new BTNode('b');
		root.right = new BTNode('c');
		root.left.left = new BTNode('d');
		root.left.right = new BTNode('e');
		root.right.right = new BTNode('f');
	}

}
