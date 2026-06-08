package com.santosh.array;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SmallestSubarraySum {

    public static void main(String[] args) {
        // Input: arr[] = {2, 4, 6, 10, 2, 1}, K = 12
        // Output: 2
        // Explanation: All possible subarrays with sum 12 are {2, 4, 6} and {10, 2}.

        int[] array = {2,4,6,10,2,1};
        int target = 12;

        int[] result = smallestSubArraySum(array, target);
        System.out.println("Subarray with sum " + target + ": " + Arrays.toString(result));

        int[] smallestSubArrayLength = smallestSubArraySumOptimised(array, target);
        System.out.println("smallestSubArray with sum " + target + ": " + Arrays.toString(smallestSubArrayLength));
    }


    // Use 2 nested for loops. initialize startIndex, endIndex as -1 & minLength as Integer.MaxValue.
    // calculate sum in loop and check with target element.
    // if sum is same with target then check i-j+1 is less than minLength
    // if yes then assign minLength as i-j+1 & startIndex as i and endIndex as j.
    // at the end return array using copyOfRange method of Arrays class.

    // T(C) -> O(n ^ 2)
    // S(C) -> O(1)
    static int[] smallestSubArraySum(int[] array, int target) {

        //edge case
        if (array == null || array.length == 0) {
            return new int[0];
        }

        int minLength = Integer.MAX_VALUE;
        int startIndex = -1;
        int endIndex = -1;
        int n = array.length;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum = sum + array[j];

                if (sum == target) {
                    if (j - i + 1 < minLength) {
                        minLength = j - i + 1;
                        startIndex = i;
                        endIndex = j;
                    }
                }
            }

            if (startIndex == -1) {
                return new int[0];
            }
        }
        return Arrays.copyOfRange(array, startIndex, endIndex + 1);
    }


    // Use only one for loop, use Map and prefixSum method.
    // initialize startIndex, endIndex to -1.
    // initialize minLength as Integer.MaxValue.
    // calculate prefixSum for 2 cases.
    // minimum subArray sum can be from 0 to i and someIndex to i.
    // at the end return array using copyOfRange method of Arrays class.

    // T(C) -> O(n)
    // S(C) -> O(n)
    static int[] smallestSubArraySumOptimised(int[] array, int target) {
        // edge case
        if (array == null || array.length == 0) {
            return new int[0];
        }

        int minLength = Integer.MAX_VALUE;
        int n = array.length;
        Map < Integer, Integer > map = new HashMap < > ();
        int prefixSum = 0;
        int startIndex = -1;
        int endIndex = -1;

        for (int i = 0; i < n; i++) {
            prefixSum = prefixSum + array[i];

            // Case 1: subarray from 0..i
            if (prefixSum == target) {
                if (i + 1 < minLength) {
                    startIndex = 0;
                    endIndex = i;
                    minLength = i + 1;
                }

            }

            // Case 2: subarray from some index+1..i
            int requiredPrefixSum = prefixSum - target;

            if (map.containsKey(requiredPrefixSum)) {
                int foundIndex = map.get(requiredPrefixSum);
                int currentLength = i - foundIndex;
                if (currentLength < minLength) {
                    minLength = currentLength;
                    startIndex = foundIndex + 1;
                    endIndex = i;
                }
            }

            map.put(prefixSum, i);

        }

        if (startIndex == -1) {
            return new int[0];
        }

        // Return the subarray slice
        return Arrays.copyOfRange(array, startIndex, endIndex + 1);

    }
}