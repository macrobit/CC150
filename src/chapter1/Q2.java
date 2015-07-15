package chapter1;

import java.lang.String;

//Implement a function void reverse(String str)

public class Q2 {

	public void reverse(String str) {
		char[] char_array = str.toCharArray();
		int length = str.length();
		for(int i = 0; i < length/2; i++) {
			char temp = char_array[i];
			char_array[i] = char_array[length-1-i];
			char_array[length-1-i] = temp;		
		}
		System.out.println("" + new String(char_array));
	}
	
	public static void main(String[] args) {
		Q2 test = new Q2();
		String input = "";
		test.reverse(input);
	}
}
