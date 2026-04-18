package com.santosh.array;

public class FindMajorityElement {
	
	public static void main(String[] args) {
//		Input: arr[] = [1, 1, 2, 1, 3, 5, 1]
//		Output: 1
//		Explanation: Element 1 appears 4 times. Since ⌊7/2⌋ = 3, and 4 > 3, it is the majority element.
		
		int[] array = {1, 1, 2, 1, 3, 5, 1};
		int result = majorityElement(array);
		System.out.println("result : "+result); //1
		
		int output = majorityElementOptimised(array);
		System.out.println("output : "+output);
	}
	
	// Approach
	// use 2 loops and compare elements.
	// if values are same then increment counter
	// if count > (n/2) then return i'th element
	static int majorityElement(int[] array) {
		
		if(array == null || array.length < 0) {
			System.out.println("invalid input");
			return -1;
		}
		
		int majorityElement = -1;
		int n = array.length;
		int count= 0;
		
		for(int i=0; i<n ; i++) {
			for(int j=0; j<n ; j++) {
				if(array[i] == array[j]) {
					count++;
				}
			}
			
			if(count > (n/2)) {
				return array[i];
			}
		}
		
		return majorityElement;
	}
	
	
	
	// Approach
	// traverse array and maintain candidate and vote count
	// candidate= -1 and count=0
	// if count=0 then candidate = number and reset the count to 1
	// check candidate == number then increment count otherwise decrement count
	// count the occurrences of candidate in array if it is more than n/2 then return that candidiate
	// otherwise return -1
	
	// T(C) -> O(n)
	// S(c) -> O(1)
	static int majorityElementOptimised(int[] array) {
		if (array == null || array.length < 0) {
			System.out.println("invalid input");
			return -1;
		}

		int n = array.length;
		int count = 0;
		int candidate = -1;

		for (Integer number : array) {
			if (count == 0) {
				candidate = number;
				count = 1;
			} else if (number == candidate) {
				count++;
			} else {
				count--;
			}
		}

		count =0;
		for (Integer num : array) {
			if(num == candidate) {
				count++;
			}
		}

		if (count > (n / 2)) {
			return candidate;
		} else {
			return -1;
		}
		
	}

}
