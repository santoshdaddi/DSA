package com.santosh.array;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

public class KthLargestElement {

	public static void main(String[] args) {
		// Input:  [1, 23, 12, 9, 30, 2, 50], K = 3
		// Output: 23
		int [] array = new int[] {1, 23, 12, 9, 30, 2, 50};
		int k = 3;
		int kthLargestElement = kthLargestElement(array, k);
		System.out.println("kthLargestElement = "+kthLargestElement);
		
		System.out.println("---------------------------------------");
		
		int kthLargestNumber = findKthLargestElement(array, k);
		System.out.println("kthLargestNumber = "+kthLargestNumber);
	}
	
	// use treeset
	// convert to list
	// return size-k
	// T(C) -> O(n log n)
	// S(C) -> O(n)
	static int kthLargestElement(int[] array, int k) {
		if(array.length == 0 || k <= 0) {
			throw new IllegalArgumentException("Invalid input");
		}
		
		
		Set<Integer> set = new TreeSet<Integer>();
		for(Integer num : array) {
			set.add(num);
		}
		
		if(k > set.size()) {
			throw new IllegalArgumentException("k is larger than unique elements");
		}
		
		List<Integer> numbers = new ArrayList<>(set);
		
		return numbers.get(numbers.size()-k);
		
	}
	
	
	// use priorityQueue of size k while iterating over an array. 
	// This approach ensures heap always contains k largest elements encountered so far. add elements to queue 
	// if heap size > k then remove smallest element
	// by at the end of it top element will be k'th largest element
	// T(C) -> O(n log k)
	// S(C) -> O(k)
	private static int findKthLargestElement(int[] array, int k) {
		
		if(array.length == 0 || k <= 0) {
			throw new IllegalArgumentException("Invalid input");
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(Integer num : array) {
			pq.add(num);
			
			if(pq.size() > k) {
				pq.poll();
			}
		}
		return pq.peek();
	}
}
