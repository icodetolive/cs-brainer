package com.icode.searchsort;
/*
 * @Author Sugandha 
 */

public class BubbleSort {

	public static void main(String[] args) {
		
		int[] arr = {2,4,1,6,8,5,3,7};
		int length = arr.length;
		bubbleSort(arr);
		printArray(arr, length);
	}
	
	private static void printArray(int[] a, int len) {
		
		for(int i=0; i<len; i++) {
			System.out.print(a[i]+" ");
		}
	}
	
	private static void bubbleSort(int[] a) {
		
		int len = a.length;
		boolean swapped; 
		
		for (int k = 0; k < len - 1; k++) { //to avoid arrayindexoutofbounds exception  
			swapped = false;
			for(int i = 0; i < len-k-1; i++) { //last k elements are already in place
				if(a[i] > a[i+1]) {
					swap(a, i, i+1);
					swapped = true;
				}
			}
			if(swapped == false) { //IF no two elements were swapped by inner loop, then break the outer loop
				break;
			}
		}
	}

	private static void swap(int[] a, int x, int y) {
		
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}
	
}

/*
 * 
 * Best case:O(n) if the array is already sorted
 * Average and worst case: O(n^2)
 * 
 */
