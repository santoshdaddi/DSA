package com.santosh.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicatesUsingHashSet {
	
	public static void main(String[] args) {
		List<Integer> duplicates = duplicateElements(new int[] {1,4,5,87,12,5,3,4});
		System.out.println("duplicates are : "+duplicates);
	}
	
	// Approach
	// 1. create HashSet and add elements in set by iterating over an array
	// 2. before adding to set first check it is already present or not.
	// 3. if already present then add to resultList
	// 4. otherwise add it to set
	
	// T(C) -> O(n)
	// S(C) -> O(n)
	static List<Integer> duplicateElements(int[] array){
		List<Integer> duplicates = new ArrayList<>();
		Set<Integer> set = new HashSet<>();
		
		for(Integer number : array) {
			if(set.contains(number)) {
				duplicates.add(number);
			}else {
				set.add(number);
			}
		}
		
		return duplicates;
	}

}
