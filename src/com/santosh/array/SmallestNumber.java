package com.santosh.array;

public class SmallestNumber {
	
	public static void main(String[] args) {
		int[] array = new int [] {3,7,78,12,98,2,56};
		int smallestNumber = smallestNumber(array);
		System.out.println("smallestNumber : "+smallestNumber);
	}
	
	// Approach
	// initialize min=a[0]
	// loop till end. check min is greater than number. if yes then assign min -> number
	
	// T(C) -> O(n)
	// S(C) -> O(1)
	static int smallestNumber(int[] array) {
		if(array == null || array.length == 0) {
			System.out.println("invalid input");
			return -1;
		}
		
		
		int min = array[0];
		
		for(Integer num: array) {
			if(min > num) {
				min = num;
			}
		}
		
		return min;
	}

}
