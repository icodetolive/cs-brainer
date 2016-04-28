//For details, please refer: http://www.cnblogs.com/jcliBlogger/p/4882201.html
/*
 * @Author Sugandha Naolekar
 */
package com.icode.strings;

import java.util.ArrayList;
import java.util.List;

public class FlipGame {

	public static void main(String[] args) {
		
		FlipGame game = new FlipGame();
		List<String> result = game.play("--+-");
		System.out.println(result);
	}
	
	public ArrayList<String> play(String s) {
		
		ArrayList<String> list = new ArrayList<String>();
		for(int i = 0; i < s.length() - 1; i++) {
			if(s.charAt(i) == '+' && s.charAt(i+1) == '+') { 
		    // OR if(s.substring(i,i+2).equals("++")) { //Check substring() for clarity
				list.add(s.substring(0, i)+"--"+s.substring(i+2));
			}
		}
		return list;
	}

}
