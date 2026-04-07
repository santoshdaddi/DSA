package com.santosh.string;

public class LongestPalindromicString {
	
	public static void main(String[] args) {
		String longestPalindrome = longestPalindrome("Geeks");
		System.out.println("longestPalindrome = "+longestPalindrome);
		
		longestPalindrome = longestPalindrome("babad");
		System.out.println("longestPalindrome = " +longestPalindrome);
		
		longestPalindrome = longestPalindrome("abc");
		System.out.println("longestPalindrome = " +longestPalindrome);
		
	}
	
	
	
	
	private static String longestPalindrome(String str) {
		if(str == null || str.length() < 1) {
			return "";
		}

		int start=0;
		int end=0;
		
		//expand given string around the center
		for(int i=0; i < str.length(); i++) {
			
			int oddLength = expandAroundCenter(str, i, i);
			int evenLength = expandAroundCenter(str, i, i+1);
			
			//find maximum length
			int length = Math.max(oddLength, evenLength);
			
			if(  length > (end - start)) {
				start =  i - (length -1) /2;
				end = i + length/2;
			}
			
		}
		return (end >= start) ? str.substring(start, end + 1) : "";
	}
	
	
	private static int expandAroundCenter(String str, int left, int right) {
		//compare character at left and right position
		while(left >= 0 && right < str.length() && str.charAt(left)== str.charAt(right)) {
			left--;
			right++;
		}
		
		return right-left-1;
	}
	
	

}
