
//Determine if any permutation of a given string is a palindrome
//For detailed explanation, please refer: http://buttercola.blogspot.com/2015/08/leetcode-palindrome-permutation.html
/*
 * @Author Sugandha Naolekar
 */
package com.icode.strings;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PalindromicPermutation {

	public static void main(String[] args) {
		
		PalindromicPermutation str = new PalindromicPermutation();
		boolean result = str.canPermutePalindrome("ivicc");
		System.out.println(result);
	}
	
	public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return true;
        }
         
        Map<Character, Integer> map = new HashMap<Character, Integer>();
         
        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
             
            if (map.containsKey(letter)) {
                int count = map.get(letter) + 1;
                map.put(letter, count);
            } else {
                map.put(letter, 1);
            }
        }
         
        int tolerance = 0;
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
             
            if ((int) pair.getValue() % 2 != 0) {
                tolerance++;
            }
        }
         
        if (s.length() % 2 == 0) {
            return tolerance == 0;
        } else {
            return tolerance == 1;
        }
    }

}
