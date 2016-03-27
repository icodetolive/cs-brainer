package com.icode.searchsort;
//For detailed demonstration refer: https://www.youtube.com/watch?v=COk73cpQbFQ
/*
 * @Author Sugandha 
 
 ---Psuedo-code
/* quickSort(int[] A, int start, int end)
 * 
 * 	if start < end 
 * 		pIndex = partition(A, start, end)
 * 		quickSort(A,0,pIndex-1)
 * 		quickSort(A,pIndex+1,end)
 * 
 * partition():
 * 	Selects the pivot. Executes the partition() which returns the pivotIndex - ideally where the pivot element should be placed.
 *  In this case, the last element of the array is the pivot.
 *  After the partition(), pivot is placed in its desired position.
 *  And then quicksort is run to place elements > pivot on right side and elements < pivot on left side.
 *  
 * partition(A, start, end)
 * 	pivot = A[end] 
 *  pIndex = start
 *  
 *  for i = 0 to end - 1
 *  	if A[i] <= pivot
 *  		swap(A[i],A[pIndex]
 *  		pIndex++
 *  swap(A[pIndex],pivot)
 *  return pIndex
 * 
 * 
 */

public class QuickSort {

	public static void main(String[] args) {
		
		int[] arr = {10,7,8,9,1,5};
		int length = arr.length;
		quickSort(arr,0,length-1);
		printArray(arr,length);
	}

	private static void printArray(int[] a, int len) {
		
		for(int i=0; i<len; i++) {
			System.out.print(a[i]+" ");
		}
	}

	private static void quickSort(int[] a, int start, int end) {
		
		if(a == null || a.length == 0) {
			return;
		}
		
		if(start < end) {
			int pIndex = partition(a,start,end);
			quickSort(a,0,pIndex-1);
			quickSort(a,pIndex+1,end);
		}
	}
	
	private static int partition(int[] a, int start, int end) {
		
		int pivot = a[end]; //Selects the last element as pivot
		int partitionIndex = start;
		for(int i = start; i< end; i++) { //We continue the loop till end - 1 Thereby, we skip the pivot element as a part of the loop
			if(a[i] <= pivot) {
				swap(a,i, partitionIndex);
				partitionIndex++;
			}
		}
		swap(a, partitionIndex, end);//swap pivot with element at partition index
		return partitionIndex;
	}

	private static void swap(int[] a, int x, int y) {
		
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}
}
