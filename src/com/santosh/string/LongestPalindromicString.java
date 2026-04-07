package com.santosh.string;

public class LongestPalindromicString {
	
	public static void main(String[] args) {
		String longestPalindrome = longestPalindrome("Geeks");
		System.out.println("longestPalindrome = "+longestPalindrome); //ee
		
		longestPalindrome = longestPalindrome("babad");
		System.out.println("longestPalindrome = " +longestPalindrome);//aba
		
		longestPalindrome = longestPalindrome("abc");
		System.out.println("longestPalindrome = " +longestPalindrome); //c
		
	}
	
	
	
	// Approach
//	1. use two pointers as start and end
//	2. initialize pointers to 0
//	3. loop i=0 to length
//	4. expand from center. for odd length (i,i) and even length (i,i+1) 
//	5. find maximum length. either oddLength or evenLength
//	6. if maximum length is less than (right-left) then update start and end pointers
//	7. start -> i- (maxLength-1)/2
//	8. end -> i + maxLength/2
//	9. at the end return substring of start, end+1
	
	// T(C) -> O(n^2)
	// S(C) -> O(1)
	
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
	
	
//	1. use while loop and compare chars at left and right
//	2. if chars are same then increment left and decrement right
//	3. at the end return right-left-1
	private static int expandAroundCenter(String str, int left, int right) {
		//compare character at left and right position
		while(left >= 0 && right < str.length() && str.charAt(left)== str.charAt(right)) {
			left--;
			right++;
		}
		
		return right-left-1;
	}
	
	

}
