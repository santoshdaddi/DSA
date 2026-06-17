package com.santosh.array;

public class RotateArrayLeftByNTimes {
	
	public static void main(String[] args) {
//		Input:  -> [1, 2, 3, 4, 5, 6, 7], d = 2
//		Output: -> (left rotation): [3, 4, 5, 6, 7, 1, 2]
		int[] array = {1,2,3,4,5,6,7};
		int d = 2;
		rotateByNtimes(array, d);
		System.out.println("Elements after rotation");
		for(Integer element: array) {
			System.out.print(element + " ");
		}
		int[] newArray = {1,2,3,4,5,6,7};
		rotateArray(newArray, d);
		System.out.println("");
		System.out.println("Elements after rotation using optimised approach");
		for(Integer element: newArray) {
			System.out.print(element + " ");
		}
	}
	
	
	// approach : For each rotation, shift all elements one by one
	// use 2 nested for loops
	// loop 1: i=0 to d. store first element in temp variable 
	// 		loop 2: j=0 to N-1. 
	// 	store temp element at N-1 position
	
	// T(C) -> O(n * d)
	// S(C) -> O(1)
	static void rotateByNtimes(int[] array, int d) {
		if(array == null || array.length < 1 ) {
			return ;
		}
		
		int n = array.length;
		
		if(d > n) {
			d = d % n;
		}
		
		for(int i=0 ; i < d; i++) {
			int temp = array[0];
			
			for(int j=0; j < n-1 ; j++) {
				array[j] = array[j+1];
			}
			
			array[n-1] = temp;
		}
		
	}
	
	
	// approach:  reverse parts of array to achieve rotation
	// rotate 3 times. use start and end pointers
	// first time (d elements) 0 to d-1
	// second time (n-d elements) d to N-1
	// third time (all elements) 0 to N-1 
	// use while loop to reverse array elements
	
	// T(C) -> O(n)
	// S(C) -> O(1)
	
	static void rotateArray(int[] array, int d) {
		if(array == null || array.length < 1 ) {
			return ;
		}
		
		int n = array.length;
		
		if(d > n) {
			d = d % n;
		}
		
		rotate(array, 0, d-1);
		rotate(array, d, n-1);
		rotate(array, 0, n-1);
	}
	
	static void rotate(int[] array, int start, int end) {
		while(start < end) {
			int temp = array[start];
			array[start] = array[end];
			array[end] = temp;
			start++;
			end--;
		}
		
	}
	

}
