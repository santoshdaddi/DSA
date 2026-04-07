package com.santosh.string;

public class CompressString {

	public static void main(String[] args) {
		String str = "aaabbc111155ddd";
		//expected output -> 3a2b1c41253d
		String result = compressString(str);
		System.out.println("result = "+result); //3a2b1c41253d
	}
	
	// Approach
//	1. initialize counter and string builder
//	2. use for loop from i=1 to length and compare i with i-1
//	3. use if statement to check character at i'th position and i-1'th position.
//	4. if it is same then increment counter
//	5. otherwise append character to StringBuilder and reinitialize counter=1
	
	// T(C) -> O(n)
	// S(C) -> O(n)
	
	private static String compressString(String str) {
		
		if(str == null || str.length() < 2) {
			return str;
		}
		
		StringBuilder sb = new StringBuilder();
		int counter=1;
		
		for(int i=1; i <= str.length() ; i++) {
			if(i < str.length() && str.charAt(i) == str.charAt(i-1)) {
				counter++;
			}
			else {
				sb.append(counter).append(str.charAt(i-1));
				counter=1;
			}
		}
		
		return sb.toString();
	}
}
