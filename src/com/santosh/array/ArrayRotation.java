package com.santosh.array;

public class ArrayRotation {
	public static void main(String[] args) {
//		Input: arr[] = {1, 2, 3, 4, 5, 6}, d = 2
//		Output: {5, 6, 1, 2, 3, 4}
//		Explanation: After first right rotation, arr[] becomes {6, 1, 2, 3, 4, 5} 
//		and after the second rotation, arr[] becomes {5, 6, 1, 2, 3, 4}
		int[] array = {1, 2, 3, 4, 5, 6};
		arrayRotation(array, 2);
		System.out.println("\n---------------------------------------------------");
		int[] newArray = {1, 2, 3, 4, 5, 6};
		arrayRotationUsingExtraSpace(newArray, 2);
		System.out.println("\n---------------------------------------------------");
		int[] arr = {1, 2, 3, 4, 5, 6};
		rotateArray(arr, 2);
	}
	
	
	// use 2 loops.
	// first loop 0 to d times.
	// second loop from N-1 to 0 time. in this place j-1 element at j'th position.
	// place last element at first position
	// at each rotation shift elements by 1 position
	
	// T(C) -> O(n * d)
	// S(C) -> O(1)
	static void arrayRotation(int[] array, int d) {
		
		if(array == null || array.length == 0) {
			System.out.println("invalid input");
		}
		
		int n  = array.length;
		
		// edge case
		d = d % n;
				
		for(int i=0; i < d ; i++) {
			int last = array[n-1];
			
			for(int j= n-1 ;  j > 0 ; j--) {
				array[j] = array[j-1];
			}
			
			array[0] = last; 
		}
		
		System.out.println("array after "+d + " rotations : ");
		for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
	}
	
	
	// use 2 separate loops and one extra array of same size
	// first loop from 0 to d. copy elements at i'th position from N-d to temp array
	// second loop from 0 to N-d. copy elements at i+d'th position from i'th to temp array
	// at the end copy elements from temp array to main array
	
	// T(C) -> O(n)
	// S(C) -> O(n)
	static void arrayRotationUsingExtraSpace(int[] array, int d) {
		if(array == null || array.length == 0) {
			System.out.println("invalid input");
		}
		
		int n = array.length;
		int[] temp = new int[n];
		
		// edge case
		d = d % n;
		
		for(int i=0 ; i < d ; i++) {
			temp[i] = array[n-d + i];
		}
		
		for(int i= 0; i < n-d ; i++) {
			temp[i+d] = array[i];
		}
		
		for(int i=0 ; i < n; i++) {
			array[i] = temp[i];
		}
		
		System.out.println("array after "+d + " rotations using extra space : ");
		for (int i = 0; i < array.length; i++) {
			 System.out.print(array[i] + " ");
		}
	}
	
	
	
	// use reversing array logic
	// first reverse an entire array from 0 to N-1
	// reverse first d elements
	// reverse remaining n-d elements
	
	//T(C) -> O(n)
	//S(C) -> O(1)
	static void rotateArray(int[] array, int d) {
		
		if(array == null || array.length == 0) {
			System.out.println("invalid input");
		}
		
		int n = array.length;
		
		// edge case
		d = d % n;
		
		reverse(array, 0, n-1);
		
		reverse(array, 0, d-1);
		
		reverse(array, d, n-1);
		
		System.out.println("rotating array output : ");
		for (int i = 0; i < array.length; i++) {
			 System.out.print(array[i] + " ");
		}
	}
	
	static void reverse(int [] array, int start, int end) {
		while(start < end) {
			int temp = array[start];
			array[start] = array[end];
			array[end] = temp;
			start++;
			end--;
		}
	}
}
