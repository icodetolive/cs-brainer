package com.icode.strings;

public class StringReverser {

	public static void main(String[] args) {
		
		StringReverser str = new StringReverser();
		String s = "Hello";
		String result = str.reverse(s);
		System.out.println("Reversed string is: "+result);
	}
	
	public String reverse(String s) {
		if(s == null || s.length() == 0) {
			return null;
		}
		
		StringBuilder sb = new StringBuilder(s.length());
		for(int i = s.length() - 1; i>= 0; i--) {
			sb.append(s.charAt(i));
		}
		return sb.toString();
	}
}
