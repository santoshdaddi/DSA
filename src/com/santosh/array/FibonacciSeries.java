package com.santosh.array;

public class FibonacciSeries {
	
	public static void main(String[] args) {
		printFibonacciSeries(5);
	}
	
	
	// Approach
	// initialize previous fields as prev1=1 and prev2=0
	// print prev2 and prev1
	// loop i=3 to number. store addition of prev1 and prev2 into current variable
	// reassign prev2 to prev1. 
	// reassign prev1 to current
	// print current 
	
	// T(C) -> O(n)
	// S(C) -> O(1)
	static void printFibonacciSeries(int number) {
		
		if(number < 1) {
			System.out.println("Invalid Number of terms");
            return;
		}
		
		if(number == 1) {
			return;
		}
		
		int prev1 = 1;
		int prev2 = 0;
		
		
		
		System.out.print(prev2+" ");
		System.out.print(prev1+" ");
		
		
		//iterate from 3rd number till number
		for(int i = 3; i <= number; i++) {
			int current = prev1 + prev2;
			prev2 = prev1;
			prev1 = current;
			System.out.print(current + " ");
		}
		
		
	}
	

}
