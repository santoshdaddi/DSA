package com.santosh.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class QuadrupletsSum {
	
	public static void main(String[] args) {
		
//		Input: arr[] = [10, 2, 3, 4, 5, 7, 8], target = 23 
//		Output: [[2, 3, 8, 10], [2, 4, 7, 10], [3, 5, 7, 8]] 
		
		int[] array = new int[] {10, 2, 3, 4, 5, 7, 8};
		int target = 23;
		List<List<Integer>> result = fourSum(array,target);
		System.out.println("quadruples are :: ");
		for(List list : result) {
			System.out.println(list);
		}
		
		List<List<Integer>> output = fourSumOptimised(array,target);
		System.out.println("quadruples using optimization are :: ");
		for(List list : output) {
			System.out.println(list);
		}
	}
	
	
	// Approach
	// 1. generate all pairs and for every pair, we use hashing to find the remaining two pairs.
	// 2. use hashing at 2 places
	// 		i) for finding remaining two elements of quadruples
	//		ii) making sure that all quadruples are distinct
	
	// T(C) -> O(n ^ 3)
	// S(C) -> O(n)
	static List<List<Integer>> fourSum(int[] array, int target){
		int n = array.length;
		
		//used to avoid duplicate quadruples
		Set<List<Integer>> set = new HashSet<>(); 
		
		
		for(int i=0; i < n; i++) {
			for(int j=i+1; j <n ; j++) {
				
				Set<Integer> s = new HashSet<>();
				for(int k = j+1; k < n; k++) {
					int sum = array[i] + array[j] + array[k];
					int last = target - sum;
					
					if(s.contains(last)) {
						List<Integer> currentList = new ArrayList<>();
						currentList.add(array[i]);
						currentList.add(array[j]);
						currentList.add(array[k]);
						currentList.add(last);
						
						Collections.sort(currentList);
						
						set.add(currentList);
					}
					s.add(array[k]);
				}
			}
		}
		return new ArrayList<>(set);
	}

	
	// Approach 
	// 1. sort an array
	// 2. Generate all pairs. For every pair, find the remaining two elements using two pointer technique. 
	// 3. While generating pairs, we skip duplicates in both outer and inner loops by comparing with the previous element
	
	// T(C) -> O(n ^ 3)
	// S(C) -> O(1)
	static List<List<Integer>> fourSumOptimised(int[] array, int target) {
		List<List<Integer>> resultList = new ArrayList();
		int n = array.length;
		
		Arrays.sort(array);

		for (int i = 0; i < n; i++) {

			if (i > 0 && array[i] == array[i - 1]) {
				continue;
			}

			for (int j = i + 1; j < n; j++) {

				if (j > i + 1 && array[j] == array[j - 1]) {
					continue;
				}

				int k = j + 1;
				int l = n - 1;

				// use two pointer technique for remaining 2 elements
				while (k < l) {
					int sum = array[i] + array[j] + array[k] + array[l];
					if (sum == target) {
						ArrayList<Integer> quad = new ArrayList<>();
						quad.add(array[i]);
						quad.add(array[j]);
						quad.add(array[k]);
						quad.add(array[l]);
						resultList.add(quad);

						k++;
						l--;

						// skip duplicates for k

						while (k < l && array[k] == array[k - 1]) {
							k++;
						}

						// skip duplicates for l
						while (k < l && array[l] == array[l + 1]) {
							l--;
						}
					} else if (sum < target) {
						k++;
					} else {
						l--;
					}
				}
			}
		}
		return resultList;
	}
}
