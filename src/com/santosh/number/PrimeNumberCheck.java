package com.santosh.number;

public class PrimeNumberCheck {
	
	public static void main(String[] args) {
		System.out.println(isPrime(29)); // true
		System.out.println(isPrime(30)); // false
		System.out.println(isPrime(3)); // true
		System.out.println(isPrime(9)); // false
	}
	
	
	
	// T(C) -> O(√n)
	// S(C) -> O(1)
	static boolean isPrime(int number) {
		// Edge cases 
		
		// 0, 1, and negatives are not prime
		if(number <= 1)
			return false;
		
		// 2 is prime number
		if(number == 2)
			return true;
		
		// Even numbers > 2 are not prime
		if(number % 2 == 0)
			return false;
		
		// check divisibility up to sqrt(number)
		for(int i=3 ; i<= Math.sqrt(number) ; i++) {
			if(number % i == 0) {
				return false;
			}
		}
		return true;
		
	}

}
