package com.santosh.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SubArraySumDivisibleByK {
	
	public static void main(String[] args) {
//		Input: arr[] = [4, 5, 0, -2, -3, 1], k = 5
//		Output: 7
//		Explanation: There are 7 subarrays whose sum is divisible by 5: [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3] and [-2, -3].
//
//		Input: arr[] = [2, 2, 2, 2, 2, 2], k = 2
//		Output: 21
//		Explanation: All subarray sums are divisible by 2.
		int[] array = {4, 5, 0, -2, -3, 1};
		int k = 5;
		List<int[]> resultList = subArraySumDivisibleByK(array,k);
		for(int[] a : resultList) {
			for(int i=0; i < a.length; i++) {
				System.out.print(a[i]+" ");
			}
			System.out.println("");
		}
		
	}
	
	
	// approach 2 nested for loops and calculating sum which is divisible by k
	// loop 1 -> i=0 to N
	// loop 2 -> j=i to N
	// calculate sum and add to result list using Arrays.copyOfRange
	
	// T(C) -> O(n ^ 2)
	// S(C) -> O(1)
	static List<int[]> subArraySumDivisibleByK(int[] array, int k){
		
		if(array == null || array.length == 0 ) {
			return Collections.emptyList();
		}
		
		List<int[]> resultList = new ArrayList<int[]>();
		int n = array.length;
		
		for(int i=0 ; i < n ; i++) {
			int sum = 0;
			for(int j=i; j < n ; j++) {
				sum = (sum + array[j]) % k;
				if(sum == 0) {
					int[] sub = Arrays.copyOfRange(array, i, j+1 );
                    resultList.add(sub);
				}
			}
		}
		
		return resultList;
	}

}
