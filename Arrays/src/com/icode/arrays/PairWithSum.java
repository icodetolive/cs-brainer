package com.icode.arrays;
/*
 * @Author Sugandha
 * 
 * Return Indices of the pair(elements) found.
 */

import java.util.HashMap;

public class PairWithSum {

	public static void main(String[] args) {
		
		int[] arr = {7,3,8,2,4};
		int weightLimit = 11;
		Pair p = findPairWithSum(arr, weightLimit);
		if(p.x == p.y && p.x == -1) {
			System.out.println("Pair not found");
		}
		else {
			System.out.println("Pair:: "+p.x + " "+p.y);
		}
	}

	public static Pair findPairWithSum(int[] a, int sum) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i< a.length; i++) {
			boolean hasKey = map.containsKey(sum - a[i]);
			if(hasKey) {
				return new Pair (map.get(sum - a[i]), i);
				//Returns pair elements
				//return new Pair(sum - a[i], a[i]); 
			}
			else {
				map.put(a[i], i);
				//In case of returning pair elements, we can use boolean/binary hashmap
				//map.put(a[i], true);
			}
		}
		return new Pair(-1,-1);
	}
}

class Pair {
	
	int x, y;
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
