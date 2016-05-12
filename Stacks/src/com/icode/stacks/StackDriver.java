//Driver class to call all stack operations
package com.icode.stacks;

public class StackDriver {

	public static void main(String[] args) {
		
		StackUsingLL stack = new StackUsingLL();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
//		stack.pop();
		//the elements will be printed in reverse order as it is Last in First Out (LIFO)
		stack.print();
	}

}
