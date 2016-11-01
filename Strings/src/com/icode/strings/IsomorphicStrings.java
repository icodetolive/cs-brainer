package com.icode.strings;

/*
 * @Author Sugandha
 * 
 */

import java.util.HashMap;

public class IsomorphicStrings {

	public static void main(String[] args) {
		
		String s = "xxy";
		String t = "aab";
		
		//not isomorphic are: xyz and aab
		
		IsomorphicStrings strings = new IsomorphicStrings();
		boolean result = strings.areIsomorphic(s, t);
		if(result) {
			System.out.println("Strings are isomorphic");
		}
		else {
			System.out.println("Strings are not isomorphic");
		}
	}
		
		
    public boolean areIsomorphic(String s, String t) {
       
        if(s == null || t == null) {
            return false;
        }
        
        if(s.length() != t.length()) {
            return false;
        }
        
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        for(int i = 0; i< s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
          
           // Check if the value of this key = current char of string2(t)
           if(map.containsKey(c1)) {
            	char temp = map.get(c1);
                if(temp != c2) {
                    return false;
                }
            }
           //check if the value of this key is also not present already
            else {
            	if(map.containsValue(c2)) {
            		return false;
            	}
            	else {
            		//both key-value characters are unique. Hence, insert and map them
            		map.put(c1, c2);
            	}
            }
        }
		return true;
    }
}

