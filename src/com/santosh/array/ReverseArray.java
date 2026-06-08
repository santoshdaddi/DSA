package com.santosh.array;

import java.util.Arrays;

public class ReverseArray {
	
	public static void main(String[] args) {	
		int[] array = {1,2,3,4,5};
		reverseArrayUsing2Pointer(array);
		int[] newArray = {1,2,3,4,5};
		reverseArrayUsingAuxilarySpace(newArray);
	}
	
	// use 2 pointer approach
	// initialize left to 0 and right to N-1
	// run loop till L < R
	// swap element at L and R position
	// do L++ and R--
	
	// T(C) -> O(n)
	// S(C) -> O(1)
	static void reverseArrayUsing2Pointer(int[] array) {
		int left = 0;
		int right = array.length-1;
		
		while(left < right) {
			int temp = array[left];
			array[left] = array[right];
			array[right] = temp;
			left++;
			right--;
		}
		
		System.out.println("reversed : "+Arrays.toString(array));
	}
	
	
	// create an empty array of size of no of array elements
	// run for loop and copy elements from last to 0 into new array
	
	// T(C) -> O(n)
	// S(C) -> O(n)
	static void reverseArrayUsingAuxilarySpace(int[] array) {
		int[] reversedArray = new int[array.length];
		
		for(int i = 0 ; i < array.length ; i++) {
			reversedArray[i] = array[array.length -1- i];
		}
		
		System.out.println("reversedArray : "+Arrays.toString(reversedArray));
		
	}
	
}
