package com.icode.arrays;

import java.util.HashMap;

/*
 * @Author Sugandha
 * 
 * Algorithm:
 * initialize left to the starting of array, left = 0
 * Initialize right to the end of the array, right = a.length - 1
 * while left < right
 * 	if a[left] == 0 
 * 		increment left
 * 	else
 * 		if a[right] == 1 decrement right
 * 		else swap
 * 
 */
public class Sort01Array {

	public static void main(String[] args) {
		
		int[] a = {0, 1, 0, 1, 1, 1,0,0};
		sort(a, a.length);
		print(a);
	}
	public static void sort(int[] a, int length) {
		
		if(a == null || a.length <= 1) {
			return;
		}
		
		int left = 0; 
		int right = length - 1;
		while(left < right) {
			if(a[left] == 0) { //Increment left index if we see 0 in the left
				left++;
			}
			else {
				if(a[right] == 0) { //swap the elements at positions left and right 
					swap(left,right,a);
				}
				else {
					right--; //Decrement right index if we see 1 in the right
				}
			}
		}
		
		//An alternate way to code the solution
		/*
		 * while(left < right) {
			while(a[left] == 0) {
				left++;
			}
			
			while(a[right] == 1) {
				right--;
			}
			
			if(left < right) {
				swap(left, right, a);
			}
		}
		*/
	}
	
	private static void swap(int a, int b, int[] arr) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	public static void print(int[] a) {
		for(int i = 0; i< a.length; i++) {
			System.out.print(a[i]+" ");
		}
	}
}

/*
 * Testcases:
 * 	1. if array is null or empty
 * 	2. if the array will have only 0 and 1 values 
 * 		if not, then those values need to be ignored or an error should be flashed
 */ 
