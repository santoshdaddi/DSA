package com.santosh.array;

public class MaximumSumOfKConsecutiveElements {
	
	public static void main(String[] args) {
//		inputArray = [2, 3, 5, 1, 6]
//		k = 2;
//		output -> 8
		int[] array = {2,3,5,1,6};
		int k =2;
		
		int maxSum = maximumSumOfKConsecutiveNumbers(array, k);
		System.out.println("maxSum : "+maxSum);
		
		int maximumSum = maximumSumOfKConsecutiveNumbersOptimised(array, k);
		System.out.println("maximumSum : "+maximumSum);
		
	}
	
	
	// using 2 nested loops and calculating max sum
	// loop 1: i=0 to n-k
	// loop 2: j=i to i+k
	
	// T(C) -> O(n * k)
	// S(C) -> O(1)
	static int maximumSumOfKConsecutiveNumbers(int[] array, int k) {
		if(array == null || array.length < 1 || k > array.length) {
			return -1;
		}
		
		int maxSum = 0;
		int n = array.length;
		
		for(int i=0 ; i <= n-k ; i++) {
			int sum = 0;
			for(int j=i; j < i+k; j++) {
				sum = sum + array[j];
				
				maxSum = Math.max(maxSum, sum);
			}
		}
		return maxSum;
	}
	
	

	// use sliding window technique
	// use 2 separate loops
	// loop 1: i=0 to k (calculate sum for first window)
	// loop 2: i=k to n (calculate sum and maxSum for rest of window)
	
	// T(C) -> O(n)
	// S(C) -> O(1)
	static int maximumSumOfKConsecutiveNumbersOptimised(int[] array, int k) {
		if(array == null || array.length < 1 || k > array.length) {
			return -1;
		}
		
		int maxSum = 0;
		int n = array.length;
		
		int windowSum = 0;
		
		for(int i=0 ; i < k ; i++) {
			windowSum = windowSum + array[i];
		}
		
		for(int i=k; i <n ; i++) {
			windowSum = windowSum + array[i] - array[i-k];
			maxSum = Math.max(maxSum, windowSum);
		}
		
		return maxSum;
	}
	


}
