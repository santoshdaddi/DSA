package com.santosh.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CountPairsWithGivenSum {
	
	public static void main(String[] args) {
		
//		Input: arr[] = [1, 5, 7, -1, 5], target = 6
//		Output:  3
//		Explanation: Pairs with sum 6 are (1, 5), (7, -1) & (1, 5).    
		int[] array = { 1, 5, 7, -1, 5 };
		int target = 6;
		List<List<Integer>> result = pairsWithGivenSum(array, target);
		System.out.println("result : "+result);
	}
	
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

}
