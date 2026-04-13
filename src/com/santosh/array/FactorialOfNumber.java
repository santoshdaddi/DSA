package com.santosh.array;

public class FactorialOfNumber {
	
	public static void main(String[] args) {
		int result = factorial(5);
		System.out.println("result = "+result);
	}
	
	// Approach 
	// initialize result field to hold the output
	// loop from 2 to number
	// in each iteration perform multiplication of result with number. store output in result field
	// return result
	
	// T(C) -> O(n)
	// S(C) -> O(1)
	private static int factorial(int number) {
		
		if(number < 1) {
			System.out.println("invalid input");
		}
		int result = 1;
		for(int i =2; i <= number; i++) {
			result = result * i;
		}
		
		return result;
	}

}
