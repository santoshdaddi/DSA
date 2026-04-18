package com.santosh.array;

import java.util.Arrays;

public class TwoSum {
	
	public static void main(String[] args) {
		//Given an array arr[] of n integers and a target value, check if there exists a pair whose sum equals the target
//		Input: arr[] = [0, -1, 2, -3, 1], target = -2
//		Output: true
		
		int [] array = new int[] {-3,-1,0,1,2};
		
		int[] outputArray = twoSum(array, -2);
		System.out.println("outputArray is = "+outputArray[0] + ", "+outputArray[1]);
		
		int[] resultArray = twoSumOptimised(array, -2);
		System.out.println("result is = "+resultArray[0] + ", "+resultArray[1]);
		
	}
	
	// Approach
	// use 2 for loop and compare the sum of i'th element and j'th with target value.
	// if sum is equal to target value then those numbers at (i and j) position are the results 
	
	// T(C) -> O(n ^ 2)
	// S(C) -> O(1)
	static int[] twoSum(int[] array, int target) {
		int[] resultArray = new int[] {-1,-1};
		int n = array.length;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(array[i] + array[j] == target) {
					resultArray[0] = array[i];
					resultArray[1] = array[j];
				}
			}
		}
		return resultArray;
	}
	
	//Approach
	//	1. first will sort an array
	//	2. will use two pointers as left and right. left pointer at 0 and right pointer at length-1
	//	3. will iterate over loop and add elements of left side and right side and try to match with given target value
	//	4. if sum is matched with left and right then those left and right will be the pair which we are looking
	//	5. if sum is less than target then increment left pointer
	//	6. if sum is greater than target then decrement right pointer
	//	T(C) -> O(n log n)
	//	S(C) -> O(1)
	
	static int[] twoSumOptimised(int[] array, int target) {
		int[] resultArray = new int[2];
		Arrays.sort(array);
		
		int left = 0; 
		int right = array.length-1;
		
		while(left < right) {
			int sum = array[left]+array[right];
			
			if(sum == target) {
				resultArray[0]= array[left];
				resultArray[1]= array[right];
				return resultArray;
			}
			else if (sum < target)
				left++;
			else
				right--;
		}
		return resultArray;
	}
	
	

}
