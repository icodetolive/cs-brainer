package com.icode.strings;

public class SentenceReverser {
	
	/*Testcases:
	1. empty array
	2. array with nothing but spaces
	3. array with one word only
	4. multiple spaces between words.
	*/
	
	/*Improvement/Enhancement:
	 * Using only one pointer in the reverse function instead of 2 pointers
	 */

	public static void main(String[] args) {
		
		char[] sentence = {' ',' ',' ','p', 'e', 'r', 'f', 'e', 'c', 't', ' ', 'm', 'a', 'k', 'e', 's', ' ', 'p', 'r', 'a', 'c', 't', 'i', 'c', 'e'};
		reverseSentence(sentence);
		//Print the reversed result
		System.out.println(sentence);
	}
	
	public static void reverseSentence(char[] s) {
		int length = s.length;
		
		//Null or empty array
		if(s == null || s.length == 0) {
			System.out.println("Array is empty");
			return;
		}
		//reverse array/characters
		//This will put the desired words in sequencebut in reverse fashion. 
		reverse(s, 0, length-1);
		
		//Now, reverse each of the words to get the appropriate order
		int wordStart = -1;
		for(int i = 0; i < length; i++) {
			if(s[i] == ' ') { //if a char = space
				if(wordStart != -1) { //a word is ready to be be processed
					reverse(s, wordStart, i - 1);
					wordStart = -1;
				}
				else { //case of string starting with space 
					
				}
			}
			else if(i == length-1) { //come to the end of array
				if(wordStart != -1) { //fetch the current word to be processed
					reverse(s, wordStart, i);
				}
				else {
					//only spaces
				}
			}
			else {
				if(wordStart == -1) {
					wordStart = i;
				}
			}
		}
	}
	
	private static void reverse(char[] arr, int start, int end) {
		char temp;
		while(start < end) {
			temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}
}


