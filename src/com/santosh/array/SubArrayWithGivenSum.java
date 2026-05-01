package com.santosh.array;

import java.util.ArrayList;
import java.util.List;

public class SubArrayWithGivenSum {

	public static void main(String[] args) {
//		Input: arr[] = [15, 2, 4, 8, 9, 5, 10, 23], target = 23
//		Output: [2, 5]
//		Explanation: Sum of subarray arr[2...5] is 2 + 4 + 8 + 9 = 23.

//		Input: arr[] = [1, 10, 4, 0, 3, 5], target = 7
//		Output: [3, 5]
//		Explanation: Sum of subarray arr[3...5] is 4 + 0 + 3 = 7.
		
		int[] array = {15, 2, 4, 8, 9, 5, 10, 23};
		int target = 23;
		List<Integer> indexRange = subArrayWithGivenSum(array, target);
		System.out.println("indexRange = "+indexRange);
		System.out.println("--------------------------------------------");
		List<Integer> output = subArrayWithGivenSumOptimised(array, target);
		System.out.println("output = "+output);
	}
	
	
	// Approach
	// use 2 for loops
	// use sum variable to hold result.
	// compare sum with target. if equal then return their index
	
	// T(C) -> O(n ^ 2)
	// S(C) -> O(1)
	static List<Integer> subArrayWithGivenSum(int[] array, int target){
		
		if(array == null || array.length == 0) {
			System.out.println("invalid input ");
			return List.of(-1);
		}
		
		List<Integer> result = new ArrayList<>();
		int n = array.length;
		
		for(int i=0; i <n ; i++) {
			int sum = 0;
			for(int j=i; j <n ; j++) {
				sum = sum + array[j];
				if(sum == target) {
					result.add(i+1);
					result.add(j+1);
					return result;
				}
			}
		}
		result.add(-1);
		return result;
	}
	
	
	// Approach
	// use sliding window approach.
	// use for loop. initialize sum =0 and calculate sum
	// if sum < target then expand window
	// if sum > target then shrink window
	// if sum == target then return
	
	// T(C) -> O(n)
	// S(C) -> O(1)
	
	static List<Integer> subArrayWithGivenSumOptimised(int[] array, int target){
		if(array == null || array.length == 0) {
			System.out.println("invalid input ");
			return List.of(-1);
		}
		
		List<Integer> result = new ArrayList<>();
		int n = array.length;
		int start=0;
		int end = 0;
		
		int sum = 0;
		for(int i=0 ; i < n; i++) {
			sum = sum + array[i];
			
			if(sum >= target) {
				end = i;
			}
			
			while(sum > target && start < end) {
				sum = sum - array[start];
				++start;
			}
			
			if(sum == target) {
				result.add(start + 1);
				result.add(end + 1);
				return result;
			}
		}
		result.add(-1);
		return result;
	}

}
