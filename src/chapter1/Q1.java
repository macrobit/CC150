package chapter1;

/*Implement an algorithm to determine if a string has all unique characters. 
What if you cannot use additional data structures?*/

public class Q1 {
	public boolean isUniqueChars2(String str) {
		int max = 256;
		
		if(str.length() > max) return false;
		
		boolean[] char_set = new boolean[256];
		for(int i = 0; i < str.length(); i++) {
			int char_index = (int)str.charAt(i);
			if(char_set[char_index]) {
				return false;
			} else {
				char_set[char_index] = true;
			}
		}
		
		return true;
		
	}
	
	
	
/*	public static void main(String[] args) {
		Q1 test = new Q1();
		String input = "asdfghjkl;";
		System.out.printf("Does the input have all unique characters? %s \n",test.isUniqueChars2(input));
	}*/
}

/*Other methods:
	1. Compare every character of the string to every other character of the string. O(n^2) time and O(1) space.
	2. Sort the input string in O(n log(n)) time and then linearly check the string for neighboring characters that are identical.
*/