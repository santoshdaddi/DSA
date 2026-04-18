package com.santosh.array;

import java.util.HashSet;
import java.util.Set;

public class MissingAndRepeatingElement {
	
	public static void main(String[] args) {
//		Input: arr[] = [4, 3, 6, 2, 1, 1]
//		Output: [1, 5]
//		Explanation: 1 is occurs twice and 5 is missing.
		int[] array = new int[] {4, 3, 6, 2, 1, 1};
		missingAndRepeating(array);
	}

	
	// Approach
	// 1. The idea is to use a frequency array to keep track of how many times each number appears in the original array. 
	// 2. any number appearing twice is our repeating number.
	// 3. any number with zero frequency is our missing number.
	
	// T(C) -> O(n)
	// S(C) -> O(n)
	static void missingAndRepeating(int[] array) {
	
		int n = array.length;
		
		int[] freq = new int[n + 1];
		Set<Integer> missingList = new HashSet<>();
		Set<Integer> repeatingList = new HashSet<>();
		
		// count frequency of each element
		for(int i = 0; i <n ; i++) {
			freq[array[i]]++;
		}
		
		// identify missing and repating element
		for(int i=1; i <= n; i++) {
			if(freq[i] == 0) {
				missingList.add(i);
			}
			else if(freq[i] == 2) {
				repeatingList.add(i);
			}
		}
		
		System.out.println("missing : "+missingList);
		System.out.println("repeating : "+repeatingList);
		
	}
	
}
