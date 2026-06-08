package com.santosh.array;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class MaxSubArrayOfSizeK {

	public static void main(String[] args) {
//		Input: arr[] = [1, 2, 3, 1, 4, 5, 2, 3, 6], k = 3
//		Output: [3, 3, 4, 5, 5, 5, 6] 
		int[] array = {1, 2, 3, 1, 4, 5, 2, 3, 6};
		int k =3;
		
		List<Integer> output = maxSubarrayOfSizeK(array, k);
		System.out.println("output : "+output);
		System.out.println("-------------------------------------------------");
		int[] newArray = {1, 2, 3, 1, 4, 5, 2, 3, 6};
		List<Integer> result =maxSlidingWindow(newArray, k);
		System.out.println("result : "+result);
	}
	
	
	// use nested loops.
	// outer loop from 0 to N-k. initialize max=a[i]
	// inner loop from 1 to k. find maximum. 
	
	// T(C) -> O(n * k)
	// S(C) -> O(1)
	static List<Integer> maxSubarrayOfSizeK(int[] array, int k){
		
		if(array == null || array.length == 0 || k <= 0) {
			System.out.println("invalid input");
			return Collections.emptyList();
		}
		
		List<Integer> list = new ArrayList<Integer>();
		int n = array.length;
		
		for(int i=0 ; i <= n-k ; i++) {
			int max = array[i];
			
			for(int j=1; j < k ; j++) {
				if(array[i + j] > max) {
					max = array[i + j];
				}
			}
			list.add(max);
		}
		
		return list;
	}
	
	
	static List<Integer> maxSlidingWindow(int[] array, int k) {
		if(array == null || array.length == 0 || k <= 0) {
			System.out.println("invalid input");
			return Collections.emptyList();
		}
		
		int n = array.length;
		List<Integer> result = new ArrayList<Integer>();
		Deque<Integer> deque = new ArrayDeque<Integer>();
		
		// Process first k (or first window) elements of array
		for(int i =0 ;i <k ; i++) {
			// For every element, the previous smaller elements 
            // are useless so remove them from dq
			while(!deque.isEmpty() && array[i] >= array[deque.peekLast()]) {
				// Remove from rear
				deque.pollLast();
			}
			
			// Add new element at rear of queue
            deque.addLast(i);
		}
		
		// now process the rest of elements i.e k to N
		for(int j = k ; j < n ; j++) {
			// The element at the front of the queue is the largest 
            // element of previous window, so store it
            result.add(array[deque.peekFirst()]);
            
            // Remove all elements smaller than the currently being 
            // added element (remove useless elements)
            while(!deque.isEmpty() && j-k >= array[deque.peekFirst()]) {
            	deque.pollFirst();
            }
            
            while(!deque.isEmpty() && array[j] >= array[deque.peekLast()]) {
            	deque.pollLast();
            }
            
         // Add new element at rear of queue
            deque.addLast(j);
		}
		
		 // store the maximum element of last window
        result.add(array[deque.peekFirst()]);
		
		return result;
	}
	
}
