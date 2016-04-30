//Reverse an array
/*
 * @Author Sugandha Naolekar
 */
package com.icode.arrays;

public class ArrayReverser {

	public static void main(String[] args) {
		
		ArrayReverser array = new ArrayReverser();
		int[] arr = {1,2,3,4,5,6};
		
		/*array.reverseI(arr);
		System.out.println("Reversed array is:");
		array.print(arr);*/
		
		array.reverseRec(arr);
		System.out.println("Reversed array is:");
		array.print(arr);
	}

	public void reverseI(int[] a) {
		
		int start = 0, end = a.length - 1;
		while(start < end) {
			swap(start, end, a);
			start++;
			end--;
		}
	}
	
	private void swap(int i, int j, int[] a) {
		
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public void reverseRec(int[] a) {
		
		int start = 0;
		int end = a.length - 1;
		reverseR(start, end, a);
	}
	
	private void reverseR(int start, int end, int[] a) {
		if(start >= end) {
			return;
		}
		swap(start, end, a);
		reverseR(start+1, end-1, a);
	}
	
	public void print(int[] a) {
		
		for(int i = 0; i<a.length; i++) {
			System.out.print(a[i]);
		}
	}
	
}
