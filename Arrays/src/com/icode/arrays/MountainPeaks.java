/*
 * @Author Sugandha Naolekar
 */
package com.icode.arrays;

import java.util.Stack;

public class MountainPeaks {
/*
 * Given mountain peaks with numbers, find out the peaks that will have water filled up to their brim
 *Since there is going to be continuous rain
 * 				_
	  _     _  | |
	 | |  _| | | |
	 | |_|   |_| |
	 
	 
	 
	 */
	public static void main(String[] args) {
		//positive non zero integers representing peaks
		int[] mountainPeaks = {3,1,2};
		int[] result = new int[mountainPeaks.length];
		result = findWaterFilledPeaks(mountainPeaks);
		printWaterFilledPeaks(result, mountainPeaks); 
	}
	
	public static int[] findWaterFilledPeaks(int[] peaks) {
		
		if(peaks == null || peaks.length <= 1) {
			return null;
		}
		
		int[] result = new int[peaks.length];
		int top = 0;
		boolean waterFilled = false;
		Stack<Integer> stack = new Stack<Integer>();
		//Push the 0th index initially in the stack
		stack.push(0);
		for(int i = 1; i < peaks.length; i++) {
			while(peaks[i] >= peaks[stack.peek()]) { //keep popping while array element is >= array[stack.top]
				top = stack.pop();
				if(!stack.isEmpty()) {
					if(peaks[i] > peaks[top]) {
						result[top] = 1; //mark the value with relevant index
						if(!waterFilled) {
							waterFilled = true;
						}
					}
					else { 
						stack.push(top); //push back the popped element
						break; //To avoid infinite loop
					}
				}
				else { //Means, the array element is less than array[stack.top]
					break; // Ignore the popped element  
				}
			}
			stack.push(i);
		}
		
		if(waterFilled) {
			return result;
		}
		return null;
	}
	
	public static void printWaterFilledPeaks(int[] result, int[] peaks) {
		if(result == null) {
			System.out.println("No water filled peaks exist");
		}
		else {
			int i = 0;
			while(i < result.length) {
				if(result[i] == 1) {
					System.out.print(peaks[i]+" ");
				}
				i++;
			}
		}
	}
}
