package com.santosh.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TopKFrequentElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Input → nums = [1,1,1,2,2,3], k = 2  
//		Output → [1,2]
		int[] array = {1,1,1,2,2,3};
		int k =2;
		List<Integer> resultList =  topKFrequentElement(array, k);
		System.out.println("resultList = "+resultList);
		topKFrequentElementsUsingJava8(array,k);
	}
	
	
	// Use frequency map to calculate frequency of elements
	// create buckets (list<Integer>[]) for the elements present in frequencyMap
	// iterate over keyset of frequencyMap and add to buckets. use enhanced for loop
	// collect top k buckets from high freq to low.
	// loop i= buckets.length-1 to >= 1
	
	// T(C) -> O(n)
	// S(C) -> O(n)
	static List<Integer> topKFrequentElement(int[] array, int k){
		
		// Edge case
		if(array == null || array.length < 1 || k > array.length) {
			return Collections.emptyList();
		}
		
		List<Integer> result  = new ArrayList<Integer>();
		
		// frequency of elements
		Map<Integer, Integer> frequencyMap = new HashMap<>();
		for(Integer number : array) {
			frequencyMap.put(number, frequencyMap.getOrDefault(number, 0) +1 );
		}
		
		// create buckets for elements in frequencyMap
		List<Integer>[] buckets = new List[array.length + 1];
		for(Integer key : frequencyMap.keySet()) {
			int frequency = frequencyMap.get(key);
			if(buckets[frequency] == null) {
				buckets[frequency] = new ArrayList<Integer>(); 
			}
			buckets[frequency].add(key);
		}
		
		// collect top k buckets from high freq to low
		for(int i = buckets.length-1 ; i >= 1 && result.size() < k ; i--) {
			if(buckets[i] != null) {
				result.addAll(buckets[i]);
			}
		}
		
		return result;
	}
	
	
	static List<Integer> topKFrequentElementsUsingJava8(int[] array, int k){
		// Edge case
				if(array == null || array.length < 1 || k > array.length) {
					return Collections.emptyList();
				}
				
				List<Integer> result  = new ArrayList<Integer>();
				
				Map<Integer, Long> frequencyMap = Arrays.stream(array).boxed().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
				
				System.out.println("frequencyMap : "+frequencyMap);
				
				List<Integer> list =  frequencyMap.entrySet().stream()
				.sorted((a,b) -> Long.compare(b.getValue(), a.getValue()))
				.limit(k)
				.map(Map.Entry::getKey)
				.collect(Collectors.toList());
				
				System.out.println("list is "+list);
				
			return result;	
	}

}
