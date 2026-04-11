package com.santosh.array;

import java.util.Arrays;

public class ThreeSum {
	
	public static void main(String[] args) {
		
		//Given an array arr[] and an integer sum, 
		//check if there is a triplet in the array which sums up to the given target sum.
		
//		Input: arr[] = [1, 4, 45, 6, 10, 8], target = 13
//		Output: true
//		Explanation: The triplet [1, 4, 8] sums up to 13
		int[] array = new int[] {1, 4, 45, 6, 10, 8};
		int[] resultArray = tripletSum(array, 17);
		if(resultArray.length != 0) {
		System.out.println("Tripplet exists with values ");
		for(int num: resultArray) {
			System.out.print(" "+num);
		}
		}else {
			System.out.println("No triplet found");
		}
		
	}
	
	//Approach
//	1. First sort array
//	2. Loop every element from 0 to N-2 (N= length of array).
//	3. Use two pointer technique. Initialise pointer as left=i+1 and right=N-1
//	4. Substract array[i] from target. Compare resulted sum with left and right elements
//	5. if sum is equal L+R then return. else check if sum < L then  L++ otherwise R++
//	T(C) -> O(n^2) 
//	S(C) -> O(1)
	
	private static int[] tripletSum(int[] array, int target) {
		int[] resultArray = new int[3];
		Arrays.sort(array);
		for(int i = 0 ; i < array.length-2 ; i++) {
			int left = i+1;
			int right = array.length-1;
			
			int sum = target - array[i];
			
			while(left < right) {
				if(array[left]+ array[right] == sum)
				{
					resultArray[0] = left;
					resultArray[1] = array[left];
					resultArray[2] = array[right];
					return resultArray ;
				}
				else if( array[left]+ array[right] < sum)
					left++;
				else
					right--;
			}
		}
		return new int[] {};
	}

}
