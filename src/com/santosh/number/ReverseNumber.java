package com.santosh.number;

public class ReverseNumber {
	public static void main(String[] args) {
		int output = reverseNumber(-12345);
		System.out.println("output : "+output);
	}
	
	// T(C) -> O(d) / O(log n)
	// S(C) -> O(1)
	static int reverseNumber(int number) {
		
		// Edge Case 1: Zero
		if (number == 0) {
            return 0;
        }
		
		// Edge Case 2: Negative numbers → work with absolute value
		number = Math.abs(number);
		
		int reversedNumber = 0;
		boolean isNegative = number < 0;
		
		while(number != 0) {
			int digit = number % 10;
			
			// Check for overflow before multiplying
            if (reversedNumber > (Integer.MAX_VALUE - digit) / 10) {
                System.out.println("Overflow detected!");
                return 0; // or throw an exception
            }
			
			reversedNumber = reversedNumber * 10 + digit;
			number = number /10;
		}
		return isNegative ? -reversedNumber : reversedNumber;
	}

}
