package chapter1;
// Replace all spaces in a string with '%20'. 
// You can use extra space.
import java.lang.StringBuffer;

public class Q4 {
	public void replaceSpaces(char[] str, int length) {
		int spaceCount = 0, newLen;
		for(int i = 0; i < length; i++) {
			if(str[i] == ' ') {
				spaceCount++;
			}
		}
		
		newLen = length + spaceCount*2;
		System.out.println(newLen);
		str[newLen] = '\0';
		for(int i = length-1; i >= 0; i--){
			if(str[i] == ' ') {
				str[newLen-1] = '0';
				str[newLen-2] = '2';
				str[newLen-3] = '%';
				newLen = newLen-3;
			} else {
				str[newLen - 1] = str[i];
				newLen--;
			}
		}
	}

// Method 2: use StringBuffer	
	public String replaceSpaces2(String s) {
		StringBuffer str = new StringBuffer(s);
		int index = str.indexOf(" "); //find the first whitespace.
		while(index != -1){
			str.replace(index, index+1, "%20");// replace the whitespace with "%20".
			index = str.indexOf(" ", index); //find the next whitespace behind current index.
		}
		
		return str.toString();

	}
	
	public static void main(String[] args) {
		char[] input = new char[30];
		String a = "Smith heaven mall is comming ?";
		for(int i = 0; i < a.length(); i++){
			input[i] = a.charAt(i);
		}
		System.out.println(""+ new String(input));
		Q4 test = new Q4();
		String output = test.replaceSpaces2(a);
		System.out.println("" + output);
	}
}
