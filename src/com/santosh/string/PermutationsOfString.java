package com.santosh.string;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PermutationsOfString {
	
	public static void main(String[] args) {
		List<String> resultList = findPermutations("ABC");
		System.out.println("resultList = "+resultList);
	}
	
	
	// Approach
	// create IntStream, used boxed (to convert to IntStream)
	// use flatmap method..inside this extract char at i'th position and remaining characters
	// recursively call same method with remaining characters
	
	// T(C) -> O(n * n!)
	// S(C) -> O(n * n!)
	private static List<String> findPermutations(String str){
		
		if (str.isEmpty()) {
			 return List.of("");
			 }
		
		List<String> resultList = IntStream.range(0, str.length())
		.boxed()
		.flatMap(i ->{
			char ch = str.charAt(i);
			String remainingChars = str.substring(0,i)+str.substring(i+1);
			return findPermutations(remainingChars).stream().map(p -> p+ch);
		})
		.collect(Collectors.toList());
		return resultList;
	}
	
	
	

}
