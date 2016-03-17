package com.icode.searchsort;


public class InsertionSort {

	public static void main(String[] args) {
		
		int[] arr = {2,4,1,6,8,5,3,7};
		int length = arr.length;
		insertionSort(arr, length);
		printArray(arr, length);
	}

	private static void insertionSort(int[] a, int length) {
		
		for(int i = 1; i < length; i++) { //start with ith position assuming the 0th position element is sorted 
			int value = a[i];
			int place = i;
			while(place > 0 && a[place -1] > value) { 
				a[place] = a[place-1];
				place--;
			}
			a[place] = value;
		}
	}

	private static void printArray(int[] a, int len) {
		
		for(int i=0; i<len; i++) {
			System.out.print(a[i]+" ");
		}
	}
}
