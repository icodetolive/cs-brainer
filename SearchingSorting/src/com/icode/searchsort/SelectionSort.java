package com.icode.searchsort;
/*
 * @Author Sugandha 
 */

public class SelectionSort {

	public static void main(String[] args) {
		
		int[] arr = {2,4,1,6,8,5,3,7};
		int length = arr.length;
		selectionSort(arr, length);
		printArray(arr, length);
	}
	
	private static void selectionSort(int[] a, int len) {
		
		for(int i = 0; i < len-1; i++) { //The minimum no. will be always placed in its apt position
										// Basically, one number will already be sorted
			int min = i;
			for(int j = i+1; j<len; j++) { //Ignore the ith, element. Since, that is the sorted elt.
				if(a[j] < a[min]) {
					min = j; //update the index of minimum element
				}
			}
			//swap the minimum element with the one at ith position
			int temp = a[i];
			a[i] = a[min];
			a[min] = temp;
		}
	}

	private static void printArray(int[] a, int len) {
		
		for(int i=0; i<len; i++) {
			System.out.print(a[i]+" ");
		}
	}

}
