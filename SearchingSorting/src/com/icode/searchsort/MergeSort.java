package com.icode.searchsort;
//For detailed demonstration refer: https://www.youtube.com/watch?v=TzeBrDU-JaY
/*
 * @Author Sugandha 
 */

public class MergeSort {
	
	public static void main(String[] args) {
		
		int[] arr = {2,4,1,6,8,5,3,7};
		int length = arr.length;
		mergeSort(arr);
		printArray(arr, length);
	}

	private static void printArray(int[] a, int len) {
		
		for(int i=0; i<len; i++) {
			System.out.print(a[i]+" ");
		}
	}
	
	private static void mergeSort(int[] a) {
		
		int len = a.length;
		if(len < 2) { //divide the sublists until there is nothing left to divide. i,e; only one element in the list
			return;
		}
		
		int i;
		int mid = len/2;
		int[] left = new int[mid];
		int[] right = new int[len - mid];
		
		for(i = 0; i < mid; i++) { //Copy one by one all the elements in left[] till mid position
			left[i] = a[i];
		}
		for(i = mid; i < len; i++) { //Copy rest of the elements in right[]
			right[i - mid] = a[i];
		}
		
		mergeSort(left); //divide the left sublist
		mergeSort(right); //divide the right sublist
		merge(a,left,right); //merge both the sorted sublists into original array
	}
	
	private static void merge(int[] a, int[] left, int[] right) {
		
		int leftLen = left.length;
		int rightLen = right.length;
		int i = 0; //index of smallest unpicked element in left array
		int j = 0; //index of smallest unpicked element in right array
		int k = 0; //index of the original array
		
		while(i < leftLen  && j < rightLen) {
			
			if(left[i] <= right[j]) {
				a[k] = left[i];
				i++;
			}
			else {
				a[k] = right[j];
				j++;
			}
			k++;
		}
		while(i < leftLen) { //remaining elements of left[]
			a[k] = left[i];
			i++;
			k++;
		}
		while(j < rightLen) { //remaining elements of right[]
			a[k] = right[j];
			j++;
			k++;
		}
	}
}
