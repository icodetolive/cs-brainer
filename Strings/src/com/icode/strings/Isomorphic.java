package com.icode.strings;

import java.util.HashMap;
import java.util.Map;

public class Isomorphic {

	public static void main(String[] args) {
		
		String s = "eg";
		String t = "add";
		
		Isomorphic strings = new Isomorphic();
		boolean result = strings.areIsomorphic(s, t);
		if(result) {
			System.out.println("Strings are isomorphic");
		}
		else {
			System.out.println("Strings are not isomorphic");
		}
	}
		
		
    public boolean areIsomorphic(String s, String t) {
        if((s == null && t == null) || (s.length() == 0 && t.length() == 0 )) {
            return true;
        }
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
            
            Character key = getKey(map, c2);
            if(key != null && key != c1) {
                return false;
            }
            else if(map.containsKey(c1)) {
                if(map.get(c1) != c2) {
                    return false;
                }
            }
            else {
                map.put(c1, c2);
            }
        }
		return true;
    }
		    
    public Character getKey(HashMap<Character, Character> map, char target) {
        for(Map.Entry entry: map.entrySet()) {
            if(entry.getValue().equals(target)) {
                return (Character)entry.getKey();
            }
        }
        return null;
    }
}

