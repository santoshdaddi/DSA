package com.santosh.array;

import java.util.Arrays;

public class Sort012 {
	public static void main(String[] args) {
//		Input: arr[] = [0, 1, 2, 0, 1, 2]
//		Output: [0, 0, 1, 1, 2, 2]
//		Explanation: [0, 0, 1, 1, 2, 2] has all 0s first, then all 1s and all 2s in last.
		
		int[] array = {0, 1, 2, 0, 1, 2};
		sort012(array);
		System.out.println("\n---------------------------------");
		sort012Optimised(array);
	}
	
	
	// use sorting which will place elements in natural order
	// T(C) -> O( n log n)
	// S(C) -> O(1)
	static void sort012(int[] array) {
		if(array == null || array.length == 0 ) {
			System.out.println("invalid input");
		}
		
		Arrays.sort(array);
		
		System.out.println("output after sorting is :");
		for(Integer number: array) {
			System.out.print(" "+number);
		}
	}
	
	
	// sort array of size n using 3 pointers. low, mid and high
	// low, mid = 0
	// high = N-1
	// use while loop
	// All 0's will be placed from -> 0 to low-1
	// All 1's will be placed from -> low to mid-1
	// unprocessed elements will be at -> mid to high
	// All 2's will be placed at -> high+1 to n-1
	
	// T(C) -> O(n)
	// S(C) -> O(1)
	static void sort012Optimised(int[] array) {
		
		if(array == null || array.length == 0 ) {
			System.out.println("invalid input");
		}
		
		int n = array.length;
		int low = 0;
		int mid = 0;
		int high = n-1;
		
		while(mid <= high) {
			
			// condition to check 0
			if(array[mid] == 0) {
				int temp = array[low];
				array[low++] = array[mid];
				array[mid++] = temp;
			}
			// condition to check 1
			else if(array[mid] == 1) {
				mid++;
			}
			else {
				int temp = array[mid];
				array[mid] = array[high];
				array[high--] = temp;
			}
		}
		
		System.out.println("sorted elements using optimised approach");
		for(Integer num: array) {
			System.out.print(" "+num);
		}
	}
}
