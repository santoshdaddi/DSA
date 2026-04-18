package com.santosh.array;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class GroupElementsByFrequency {

	public static void main(String[] args) {
		int[] array = {10, 20, 10, 5, 20};
		Map<Integer,Integer> freq = groupElementsByFreq(array);
		System.out.println("freq = "+freq);
		
		Map<Integer,Integer> freqMap = groupElementsByFreqOptimised(array);
		System.out.println("freqMap : "+freqMap);
	}
	
	
	// T(C) -> O(n ^ 2)
	// S(C) -> O(n)
	static Map<Integer,Integer> groupElementsByFreq(int[] array){
		
		if(array == null || array.length < 0) {
			System.out.println("invalid input");
			return Collections.emptyMap();
		}
		
		Map<Integer,Integer> map = new HashMap<Integer, Integer>();
		int n = array.length;
		
		for(int i=0 ; i< n; i++) {
			int count = 0;
			for(int j=0 ; j< n; j++) {
				
				if(array[i] == array[j]) {
					count++;
					map.put(array[i], count);
				}
			}
		}
		return map;
	}
	
	
	// Approach
	// Use map interface methods.
	// put method to add element to map
	// use getOrDefault(key, value) method to update value in map if key exists
	
	// T(C) -> O(n)
	// S(C) -> O(n)
	static Map<Integer, Integer> groupElementsByFreqOptimised(int[] array){
		if(array == null || array.length < 0) {
			System.out.println("invalid input");
			return Collections.emptyMap();
		}
		
		Map<Integer,Integer> map = new HashMap<Integer, Integer>();
		
		for(Integer number : array) {
			map.put(number, map.getOrDefault(number, 0) +1 );
		}
		return map;
	}
}
