package chapter1;
/*
 * Implement a method to perform basic string compression using the counts
 * of repeated characters.
 * If the "compressed" string would not become smaller than the original 
 * string, your method should return the original string.
*/


public class Q5 {
	public String compress1(String str){
		System.out.println("Method 1 is being used.");
		//If the compressed string is longer, no need to compress it.
		int compression_size = countCompression(str);
		if (compression_size >= str.length()) return str;
		
		StringBuffer myString = new StringBuffer();
		int count = 1; // the count of a character.
		char last = str.charAt(0); 
		for(int i = 1; i < str.length(); i++) {
		/*	If the character is different form the last, update the last 
			and count. */
			if(str.charAt(i) != last) {
				myString.append(last);
				myString.append(count);
				last = str.charAt(i);
				count = 1;
			} else {
				count++;
			}
		}
		/* Don't forget the last character! */
		myString.append(last);
		myString.append(count);
		return myString.toString();
	}
	
// Method 2: use a char[], because we can know the size of the compressed string.
	public String compress2(String str) {
		System.out.println("Method 2 is being used.");
		int size = countCompression(str);
		if(size >= str.length()) {
			return str;
		}
		
		char[] compressedStr = new char[size];
		int index = 0;
		char last = str.charAt(0);
		int count = 1;
		for(int i = 1; i < str.length(); i++) {
			if(str.charAt(i) == last) {
				count ++;
			} else {
				index = setChar(compressedStr, last, count, index);
				last = str.charAt(i);
				count = 1;
			}
		}
		index = setChar(compressedStr, last, count, index);
		System.out.println("Current index is: " + index);
		return new String(compressedStr);
	}
	
	public int setChar(char[] array, char ch, int count, int index) {
		char[] cnt = String.valueOf(count).toCharArray();
		array[index++] = ch;
		for(char c : cnt) {
			array[index++] = c;
		}
		return index;
	}
	
	public int countCompression(String str) {
		if(str == null || str.isEmpty()) {
			return 0;
		}
		char last = str.charAt(0);
		int count = 1;
		int size = 0;
		for(int i = 1; i < str.length(); i++) {
			if(str.charAt(i) == last) {
				count++;
			} else {
				size = size + String.valueOf(count).length() + 1;
				last = str.charAt(i);
				count = 1;
			}
		}
		size += String.valueOf(count).length() + 1;
		return size;
	}
	public static void main(String[] args) {
		Q5 test = new Q5();
		String input = "aaabbccccdddfffffee";
		System.out.printf("The length of compression is %d. \n", test.countCompression(input));
		System.out.println("" + test.compress2(input));
	}
}
