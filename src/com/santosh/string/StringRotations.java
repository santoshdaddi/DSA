package com.santosh.string;

import java.util.stream.IntStream;

public class StringRotations {

	public static void main(String[] args) {
		// Input: s1= abcd, s2 = bcda
		// output: true
		String s1 = "abcd";
		String s2 = "bcda";
		int noOfRotations = stringRotationsOfEachOther(s1, s2);
		
		if(noOfRotations != -1) {
			System.out.println("string s2 is rotated at left "+noOfRotations + " times");
		}else {
			System.out.println("strings are not rotations");
		}
		System.out.println("------------------------------------");
		stringRotationsUsingJava8(s1, s2);
		
	}
	
	// approach
	// concatenate source string with itself.
	// use index of target string on concatenated string
	// if index is -1 then both are not rotations of each other
	// otherwise both are rotations and index value specifies no of rotation times 
	// T(C) -> O(n)
	// S(C) -> O(n)
	static int stringRotationsOfEachOther(String s1, String s2) {
		
		if(s1 == null || s2 == null || s1.length() != s2.length()) {
			return -1;
		}
		
		String s3 = s1+s1;
		int noOfRotations = -1;
		
		int index = s3.indexOf(s2);
		
		if(index == -1) {
			return noOfRotations;
		}else {
			 noOfRotations = index;
			
		}
		return noOfRotations;
	}
	
	
	static void stringRotationsUsingJava8(String s1, String s2) {
		
		if(s1 == null || s2 == null || s1.length() != s2.length()) {
			return ;
		}
		

		boolean isMatch = IntStream.range(0, s1.length())
		.boxed()
		.anyMatch(i -> (s1.substring(i)+s1.substring(0,i)).equals(s2));
		
		if(isMatch) {
			System.out.println("strings are rotations of each other");
		}else {
			System.out.println("strings are NOT rotations of each other");
		}
	}
}
