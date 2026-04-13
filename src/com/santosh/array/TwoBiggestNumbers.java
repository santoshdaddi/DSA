package com.santosh.array;

public class TwoBiggestNumbers {

	public static void main(String[] args) {
		int[] array = new int[] {4,7,12,6,86,34,5};
		int[] result = findTwoBiggestNumbers(array);
		System.out.println("biggest number is : "+result[0]);
		System.out.println("second biggest number is : "+result[1]);
	}
	
	// Approach
	// initialize 1st element as smallest and 2nd as secondsmallest
	// if s < ss then swap
	// loop i=2 to N-1
	// if s < a[i] then ss -> s and s ->a[i]
	// else if ss < a[i] and a[i] != s then ss -> a[i]
	
	// T(C) -> O(n)
	// S(C) -> O(1)
	private static int[] findTwoBiggestNumbers(int [] array) {
		
		if(array == null || array.length < 2) {
			System.out.println("invalid input");
			return new int[] {};
		}
		
		int[] result = new int[2];
		
		int smallestNumber = array[0];
		int secondSmallestNumber = array[1];
		int temp = 0;
		
		if(smallestNumber < secondSmallestNumber) {
			temp = smallestNumber;
			smallestNumber = secondSmallestNumber;
			secondSmallestNumber = temp;
		}
		
		for(int i=2 ; i< array.length; i++) {
			if(smallestNumber < array[i] ) {
				secondSmallestNumber = smallestNumber;
				smallestNumber = array[i];
			}
			else if(secondSmallestNumber < array[i]  && array[i] != smallestNumber) {
				secondSmallestNumber = array[i];
			}
		}
				
		result[0] = smallestNumber;
		result[1] = secondSmallestNumber;
		
		return result;
	}

}
