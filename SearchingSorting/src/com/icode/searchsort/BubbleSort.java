package com.icode.searchsort;
/*
 * For demonstration purposes refer: https://www.youtube.com/watch?v=Jdtq5uKz-w4 
 * @Author Sugandha 
 */

/*
 * Algorithm:
 * 1. In every pass, every element is compared to its adjacent and swapped if the current is > than adjacent element
 * In every pass, the highest element is placed at its apr. postion.
 * Since, n-1 passes are required to sort n elements, (if the elements are completely in reverse order;). 
 * 	We write the outer loop as: 0 - n-2 or 1 - n-1
 * 	The outer loop refers no. of passes and the inner loop refers to comparisons. Here, n-1 comparisons will have to be done
 * Hence, 0 - n-2 or 1 - n-1. But, in every pass, one element is sorted and placed in its correct position. 
 * Hence, the loops are as follows:
 * for i = 0 to n-2 or i = 0; i < len-1
 *  for j = 0 to len-i-2 or j = 0; j < len-i-1
 * 
 * Every pass has n-1 comparisons and every array will have n-1 passes. Although, to avoid the unnecessary passes
 * after the array is sorted, set a flag; 
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
		
		//outer loop can also be written as: for(i = 0; i <= len-2; i++)
		for (int k = 0; k < len - 1; k++) { 
			swapped = false;
			//can also be written as : for (j = 0; j <= len-i-2; j++)
			for(int i = 0; i < len-k-1; i++) { //last k elements are already in place. Hence, len-k-1. 
												//to avoid array outofboundsexception
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
