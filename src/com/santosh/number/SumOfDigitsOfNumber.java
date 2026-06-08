package com.santosh.number;

public class SumOfDigitsOfNumber {
	public static void main(String[] args) {
		int number = -12345;
		int sum = sumOfDigitsOfNumber(number);
		System.out.println("sum : "+sum);
	}
	
	// T(C) -> O(d) / O(log n)
	// S(C) -> O(1)
	static int sumOfDigitsOfNumber(int number) {

		// Edge Case 1: Zero
		if (number == 0) {
			return 0;
		}

		// Edge Case 2: Negative numbers → work with absolute value
		number = Math.abs(number);
		int sum = 0;

		while (number != 0) {
			int digit = number % 10;
			sum = sum + digit;
			number = number / 10;
		}

		return sum;
	}
}
