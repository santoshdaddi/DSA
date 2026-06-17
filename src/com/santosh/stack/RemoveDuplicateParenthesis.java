package com.santosh.stack;

import java.util.Stack;

public class RemoveDuplicateParenthesis {
	
	public static void main(String[] args) {
		String expr1 = "((a+b))";   // duplicate
        String expr2 = "(a+(b)/c)"; // no duplicate
	}
	
	
	// traverse expression character by character for loop
	// when ')' character encounters then do following
	//	1. pop all characters until '(' matches.
	//  2. If the popped content is empty (or only another parenthesis), skip adding this pair (duplicate).
	
	static String removeDuplicatesParenthesis(String expression) {
		StringBuilder result = new StringBuilder();
		Stack<Character> stack = new Stack<Character>();
		
		
		return result.toString();
	}

}
