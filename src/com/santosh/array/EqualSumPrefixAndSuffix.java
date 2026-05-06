package com.santosh.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EqualSumPrefixAndSuffix {

	public static void main(String[] args) {
//		Input: arr = [9, 0, 0, -1, 11, -1]
//		Output: 2
//		Explanation:  The indices up to which prefix and suffix sum are equal are given below:
//		At index 1 prefix and suffix sum are 9
//		At index 2 prefix and suffix sum are 9
		int[] array = {9, 0, 0, -1, 11, -1};
		equalSumPrefixAndSuffix(array);
		
		int[] newArray = {5, 0, 4, -1, -3, 0,2, -2, 0, 3, 2};
		List<Integer> indexes =equalSumPrefixAndSuffixOptimised(newArray);
		System.out.println("indexes are :: "+indexes);
	}
	
	
	// use 3 loops. initialise sum1 and sum2 to 0
	// outer loop from 0 to N.
	// inner loop from 0 to i and calculate sum (sum1) till j'th element  
	// inner loop from i+1 to N and calculate sum (sum2) till k'th element
	// compare sum if equal then that index is has equal prefix and suffix
	
	// T(C) -> O(n ^ 2)
	// S(C) -> O(1)
	static List<Integer> equalSumPrefixAndSuffix(int [] array) {
		List<Integer> indexes = new ArrayList<Integer>();
		
		if(array == null || array.length == 0) {
			System.out.println("invalid input");
			return Collections.emptyList();
		}
		
		int n = array.length;
		
		for(int i=0 ; i <n; i++) {
			
			int sum1= 0;
			int sum2=0;
			
			for(int j=0; j < i; j++) {
				sum1 = sum1 + array[j];
			}
			
			for(int k=i+1; k < n; k++) {
				sum2 = sum2 + array[k];
			}
			
			if(sum1 == sum2) {
				System.out.println("index  = "+i);
				indexes.add(i);
			}
		}
		return indexes;
	}
	
	
	// use 2 separate for loop. initialize prefixSum and suffixSum to 0
	// first loop to calculate suffix sum.
	// second loop to calculate prefix sum. in this loop check prefixSum and suffixSum are equal if yes then add to result 
	// recalculate suffix sum by subtracting j'th element
	
	//T(C) -> O(n)
	//S(C) -> O(1)
	static List<Integer> equalSumPrefixAndSuffixOptimised(int [] array) {
		List<Integer> indexes = new ArrayList<Integer>();
		
		if(array == null || array.length == 0) {
			System.out.println("invalid input");
			return Collections.emptyList();
		}
		
		int prefixSum = 0;
		int suffixSum = 0;
		int n = array.length;
		
		for(int i = n-1 ; i >= 0 ; i--) {
			suffixSum = suffixSum + array[i];
		}
		
		for(int j=0; j < n; j++) {
			prefixSum = prefixSum +  array[j];
			
			if(prefixSum == suffixSum) {
				indexes.add(j);
			}
			
			suffixSum = suffixSum -  array[j];
		}
		
		return indexes;
	}
}
