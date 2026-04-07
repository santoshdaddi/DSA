package com.santosh.string;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacter {
	
	public static void main(String[] args) {
		
		System.out.println("Output = "+longestStringOptimised("babad")); //bad
		System.out.println("Output =" + longestStringOptimised("bbbbb")); //b
		
//		Time Complexity: O(n)
//		Space Complexity: O(min(n, character set size))
		
	}

	
	private static String longestStringOptimised(String str) {
	    if (str == null || str.isEmpty()) {
	        return "";
	    }

	    Map<Character, Integer> map = new HashMap<>();
	    int left = 0;
	    int maxLength = 0;
	    int startIndex = 0;

	    for (int right = 0; right < str.length(); right++) {
	        char ch = str.charAt(right);

	        if (map.containsKey(ch)) {
	            left = Math.max(left, map.get(ch) + 1);
	        }

	        map.put(ch, right);

	        if (right - left + 1 > maxLength) {
	            maxLength = right - left + 1;
	            startIndex = left;
	        }
	    }

	    return str.substring(startIndex, startIndex + maxLength);
	}
	
	
}
