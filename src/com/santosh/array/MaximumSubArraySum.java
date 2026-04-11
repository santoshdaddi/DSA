package com.santosh.array;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class MaximumSubArraySum {

	public static void main(String[] args) {

//		Input: arr[] = [2, 3, -8, 7, -1, 2, 3]
//		Output: 11
//		Explanation: The subarray [7, -1, 2, 3] has the largest sum 11.
		int[] array = new int[] {2, 3, -8, 7, -1, 2, 3};
		int maxLength = maxSubArrayLength(array);
		System.out.println("maxLength = "+maxLength);
		System.out.println("--------------------------------");
		int max = findMaxSubArrayLength(array);
		System.out.println("max length using Kanade's algo = "+max);
		System.out.println("--------------------------------");
		int maxLenUsingJava8 = maxSubArrayUsingJava8(array);
		System.out.println("max length using java 8 = "+maxLenUsingJava8);
	}
	
	// Brute force technique
	// T(C) -> O(n^2)
	// S(C) -> O(1)
	private static int maxSubArrayLength(int[] array) {
		int maxSum = array[0];
		
		for(int i = 0 ; i< array.length;i++) {
			int currentSum = 0;
			for(int j=i ; j < array.length; j++) {
				currentSum = currentSum + array[j]; 
			}
			
			maxSum = Math.max(maxSum, currentSum);
		}
		
		return maxSum;
	}
	
	
	// loop over the array 
	// find maximum sum of all subarray ending that element 
	// max will be the result
	// sum = array[0]; maxLength = array[0]
	// T(C) -> O(n)
	// S(C) -> O(1)
	private static int findMaxSubArrayLength(int[] array) {
		int sum =0;
		int maxLength = 0;
		
		for(int i=0 ; i < array.length; i++) {
			sum = Math.max(sum + array[i], array[i]);
			
			maxLength = Math.max(maxLength, sum);
		}
		
		return maxLength;
		
	}
	
	
	// using java 8
	// T(C) -> O(n)
	// S(C) -> O(1)
	private static int maxSubArrayUsingJava8(int[] array) {
		
		if(array.length == 0) {
			return 0;
		}
		AtomicInteger currentLength = new AtomicInteger(array[0]);
		AtomicInteger maxLength = new AtomicInteger(array[0]);
		
		Arrays.stream(array).forEach(n -> {
			currentLength.set(Math.max(currentLength.get()+n, n));
			maxLength.set(Math.max(maxLength.get(), currentLength.get()));
		});
		
		
		return maxLength.get();
	}
}
