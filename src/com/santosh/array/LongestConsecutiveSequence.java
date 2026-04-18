package com.santosh.array;

import java.util.Arrays;

public class LongestConsecutiveSequence {
	
	public static void main(String[] args) {
//		Input: arr[] = [2, 6, 1, 9, 4, 5, 3]
//		Output: 6
//		Explanation:  The longest consecutive subsequence [2, 6, 1, 4, 5, 3].
		
//		Input: arr[] = [1,1,1,2,2,3]
//		Output: 3
//		Explanation: The subsequence [1, 2,3] 
		
		int[] array = new int[] {1,1,1,2,2,3};
		longestConsecutiveSeq(array);
		
	}
	
	
	// Approach
	// 1. sort array
	// 2. remove duplicates
	// 3. initialize result=1, count =1 fields.
	// 4. initialize start and bestStart with a[0]
	// 5. compare current array element with previous + 1 (to check current number is exactly greater than 1). If equal then increment count.
	// 6. otherwise reset count=1 and start=a[i]
	// 7. if count > result then reassign result=count and bestStart=start
	// 8. print consecutive elements using result.
	
	// T(C) -> O( n log n)
	// S(C) -> O(1)
	static void longestConsecutiveSeq(int[] array) {
        int n = array.length;
        if (n <= 0) {
            System.out.println("No elements");
            return;
        }

        Arrays.sort(array);

        int result = 1; // length of longest sequence found so far
        int count = 1;  // length of current sequence
        int start = array[0]; // start of the current sequence
        int bestStart = array[0]; // Starting number of the longest streak

        for (int i = 1; i < n; i++) {
            if (array[i] == array[i - 1]) {
                // skip duplicates entirely
                continue;
            }

            if (array[i] == array[i - 1] + 1) {
                count++;
            } else {
                count = 1;
                start = array[i]; // reset start of new sequence
            }

            if (count > result) {
                result = count;
                bestStart = start;
            }
        }

        // Print the longest consecutive sequence
        System.out.print("Longest consecutive sequence: ");
        for (int i = 0; i < result ; i++) {
            System.out.print((bestStart + i)+ " ");
        }
        System.out.println("\nLength: " + result);
    }
	

}
