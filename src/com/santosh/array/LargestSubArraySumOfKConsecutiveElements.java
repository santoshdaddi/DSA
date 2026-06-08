package com.santosh.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LargestSubArraySumOfKConsecutiveElements {

	public static void main(String[] args) {
//		Input: arr[] = {10, 12, 9, 8, 10, 15, 1, 3, 2}, K = 3
//		Output: 27
//		Explanation:
//		The subarray having K (= 3) consecutive elements is {9, 8, 10} whose sum of elements is 9 + 8 + 10 = 27, which is maximum.
		int[] array = {10, 12, 9, 8, 10, 15, 1, 3, 2};
		int k=3;
		int output = largestSubArraySumOfConsecutiveKElements(array, k);
		System.out.println("output : "+output);
		int maxSum = largestSubArraySumOfKConsecutive(array, k);
		System.out.println("maxSum : "+maxSum);
	}
	
	// check the every continuous window of size K
	// for each window sort the elements and verify for consecutive integers
	// compute the windowSum and track the maximum
	// loop i=0 to N-K
	// 	loop j=0 to j < K -> compute sum
	//	  sort the window
	// 	  loop t=1 to t < K -> check for consecutive 
	
	// T(C) -> O (N * K log K)
	// S(C) -> O (K)
	static int largestSubArraySumOfConsecutiveKElements(int[] array, int k) {
		if(array == null || array.length == 0) {
			return 0;
		}
		
		
		int maxSum = Integer.MIN_VALUE;
		int n = array.length;
		
		if (k > n || k <= 0) return -1;
		
		for(int i=0; i < n-k ; i++) {
			int[] window = new int[k];
			int sum = 0;
				for(int j=0; j < k; j++) {
					window[j] = array[i+j];
					sum = sum + window[j];
				}
			Arrays.sort(window);
			boolean consecutive = true;
			for(int t=1 ; t < k; t++) {
				if(window[t]- window[t-1] != 1) {
					consecutive = false;
					break;
				}
			}
			
			if(consecutive) {
				maxSum = Math.max(maxSum, sum);
			}
		}
		
		return (maxSum == Integer.MIN_VALUE) ? -1 : maxSum;
	}
	
	
	// approach 2: Hashset , 2 loops and min/max per window
	// loop 1 i=0 to N-K
	// loop 2 j=i to i+k
	// insert elements into set while tracking min and max
	// if set size == k then no duplicates
	// if max-min = k-1 the windows contains k consecutive integers
	// compute sum and update maxSum
	
	// T(C) -> O(N * K)
	// S(C) -> O(K)
	
	static int largestSubArraySumOfKConsecutive(int[] array, int k) {
		if(array == null || array.length == 0) {
			return 0;
		}
		
		
		int maxSum = Integer.MIN_VALUE;
		int n = array.length;
		
		if (k > n || k <= 0) return -1;
		
		for(int i=0 ; i < n-k ; i++) {
			Set<Integer> set = new HashSet<Integer>();
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			int sum = 0;
			boolean duplicate = false;
			
			for(int j = i; j < i+k ; j++) {
				
				// duplicate condition check
				if(!set.add(array[j])) {
					duplicate = true;
					break;
				}
				
				sum = sum + array[i];
				
				if(array[j] < min) {
					min = array[j];
				}
				
				if(array[j] > max) {
					max = array[j];
				}
				
				if( !duplicate && (max-min == k-1)) {
					maxSum = Math.max(maxSum, sum);
				}
			}
			
		}
		
		return (maxSum == Integer.MIN_VALUE) ? -1 : maxSum;
	}
}
