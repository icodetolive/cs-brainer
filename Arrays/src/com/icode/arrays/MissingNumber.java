/*
 * @Author Sugandha Naolekar
 */
package com.icode.arrays;

import java.util.HashSet;

public class MissingNumber {

	public static void main(String[] args) {
		
		//The given array contains elements between range min - max and in unsorted fashion.
//		Find the missing element in array.
		//Assumptions: 
		//    a. There is only one element that is missing. 
		int[] inputArray = {9,-1,3,2,-4,5,0};
		int min = -10;
		int max = 10;
		int result = findMissingNumber(inputArray, min, max);
		System.out.println("The missing number is: "+result);
	}

	public static int findMissingNumber(int[] a, int min, int max) {
		HashSet<Integer> set = new HashSet<Integer>();
		int result = 0;
		for(int i = 0; i< a.length; i++) {
			set.add(a[i]);
		}
		
		for(int i = min; i <= max; i++) {
			System.out.println(i);
			if(!set.contains(i)) {
				result = i;
				break;
			}
		}
		return result;
	}
}
