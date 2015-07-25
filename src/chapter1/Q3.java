package chapter1;

//Given two strings, write a method to decide if one is a permutation of the other.
/*Points:
	1. Case sensitive.
	2. Whitespace*/
/*If two strings are permutation, they must have the same number of characters (not including whitespace)
**and same types of characters. There maybe two methods:
**	1. Sort two strings' characters and compare the sorted string.
**	2. Check if the two strings have identical character counts.*/

import java.util.Arrays;

import java.lang.Character;

public class Q3 {
	// Bubble sort 
	public String sort(String s) {
		char[] content = s.toLowerCase().toCharArray(); //case insensitive!!!
		int len = content.length;
		boolean swap;
		do {
			swap = false;
			int newLen = 0;
			for(int i = 0; i < len-1; i++) {
				if(content[i] > content[i+1]) {
					char tmp = content[i];
					content[i] = content[i+1];
					content[i+1] = tmp;
					swap = true;
					newLen = i+1; // the position of the last swap
				}			
			}
			len = newLen; // len should be changed outside of the for loop
		}  while(swap) ;
		
//		return Arrays.toString(content);	
		return new String(content);
	}
	
	public boolean permutation1(String s, String t) {
		if(s.length() != t.length()) {
			return false;
		}
		return sort(s).equals(sort(t));
	}
	
// Method 2	: time O(1). This method is better to deal with whitespace omission.
/*	1. Iterate one string to count the characters in it and store the result in an int array.
	2. Use this array to check the other string.*/
	
	public int[] count(String n) {
		int[] count_array = new int[256];
		System.out.println("" + Arrays.toString(count_array));
		char[] char_array = n.toLowerCase().toCharArray();
		
		// count the appearance of each character.
		for(char c : char_array) {
			count_array[c]++;
		}
		
		return count_array;
	}
	
	public boolean permutation2(String s, char[] t){
		if(s.length() != t.length) return false;
		
		int[] letters = count(s);
		
		for(int i = 0; i < t.length; i++) {
			int c = Character.toLowerCase(t[i]);
			if(--letters[c] < 0) {
				return false;
			}
		}
		
/*		for(char c : t) {
			char n = Character.toLowerCase(c);
			if(--letters[n] < 0) {
				return false;
			}
		}*/
		
		return true;
	}
	public static void main(String[] args) {
		Q3 test = new Q3();
		String s = "God bless you!";
		String t = "god Bless You!";
		System.out.println(""+ test.permutation2(s,t.toCharArray()));
	}
}
