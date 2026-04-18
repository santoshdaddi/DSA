package com.santosh.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CountPairsWithGivenSum {
	
	public static void main(String[] args) {
		
//		Input: arr[] = [1, 5, 7, -1, 5], target = 6
//		Output:  3
//		Explanation: Pairs with sum 6 are (1, 5), (7, -1) & (1, 5).    
		int[] array = { 1, 5, 7, -1, 5 };
		int target = 6;
		List<List<Integer>> result = pairsWithGivenSum(array, target);
		System.out.println("result : "+result);
		
		List<List<Integer>> output = pairsWithSumOptimised(array, target);
		System.out.println("output : "+output);
		
	}
	
	
	// Approach
	// 1. use 2 for loops and check sum of i'th and j'th element is equal to target
	// 2. if equal then add that pair to list.
	
	// T(C) -> O(n ^ 2)
	// S(C) -> O(n ^ 2)
	static List<List<Integer>> pairsWithGivenSum(int[] array, int target){
		
		if(array.length < 0) {
			System.out.println("invalid input ");
			return Collections.emptyList();
		}
		
		List<List<Integer>> result = new ArrayList<>();
		int n = array.length;
		
		for(int i = 0; i<n ; i++) {
			for(int j = i+1; j<n ; j++) {
				if(array[i] + array[j] == target) {
					List<Integer> list = new ArrayList<>();
					list.add(array[i]);
					list.add(array[j]);
					result.add(list);
				}
			}
		}
		return result;
	}
	
	
	// Approach (sort array and use two pointer technique)
	// sort array
	// left=0 , right= N-1 , List<List<Integer>> to hold results
	// loop (L < R)
		//	calculate sum. compare sum with target
		//	sum < target then left++, sum > target then right--
		//	if sum == target then do following
		//	1. Handle same elements case
		//	2. count duplicates on left
		//	3. count duplicates on right
		//	4. Add all combinations to result list
	
	// T(C) -> O(n log n)
	// S(C) -> O(1)
	static List<List<Integer>> pairsWithSumOptimised(int[] array, int target) {
		if (array == null || array.length < 2) {
			return Collections.emptyList();
		}

		Arrays.sort(array);
		List<List<Integer>> result = new ArrayList<>();

		int left = 0, right = array.length - 1;

		while (left < right) {
			int sum = array[left] + array[right];
			if (sum < target) {
				left++;
			} else if (sum > target) {
				right--;
			} else if (sum == target) {

				// Case 1: same elements (e.g., [3,3,3,3], target = 6)
				if (array[left] == array[right]) {
					int n = right - left + 1;

					// add all combinations
					for (int i = 0; i < n * (n - 1) / 2; i++) {
						result.add(Arrays.asList(array[left], array[right]));
					}
					break;
				}

				// Count duplicates on left
				int leftVal = array[left];
				int leftCount = 0;
				while (left <= right && array[left] == leftVal) {
					left++;
					leftCount++;
				}

				// Count duplicates on right
				int rightVal = array[right];
				int rightCount = 0;
				while (right >= left && array[right] == rightVal) {
					right--;
					rightCount++;
				}

				// Add all combinations
				for (int i = 0; i < leftCount * rightCount; i++) {
					result.add(Arrays.asList(leftVal, rightVal));
				}

			}
		}

		return result;
	}

}
