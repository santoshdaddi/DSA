package com.santosh.string;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ExpandString {
	
	public static void main(String[] args) {
		
		String input = "3a2b541T";
		//expected output aaabb44444T
		String output = expand(input);
		System.out.println("output = "+output);
	}
	
	// Approach
//	1. Initialize StringBuilder & i=0  and run loop from i to length
//	2. extract i'th character that should be number format. convert it to integer as count
//	3. increment i 
//	4. extract character it should be character format.
//	5. create an IntStream from 0 to count and create expanded string at that position
//	6. append count + expandedCharacter
	
	// T(C) -> O(n + k)
	// S(C) -> O(k)
	
	private static String expand(String str) {

		if (str == null || str.length() < 2) {
			return str;
		}

		StringBuilder sb = new StringBuilder();
		int i = 0;

		while (i < str.length()) {
			int count = str.charAt(i) - '0';
			i++;
			char ch = str.charAt(i);

			String expandedString = "";
			if (i < str.length()) {
				expandedString = IntStream.range(0, count)
										  .mapToObj(k -> String.valueOf(ch))
										  .collect(Collectors.joining());
			}
			sb.append(expandedString);
			i++;

		}
		return sb.toString();
	}

}
