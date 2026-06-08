package com.santosh.array;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithGivenSum {

    public static void main(String[] args) {
        //Input: arr[] = [10, 5, 2, 7, 1, -10], k = 15
        //Output: 6
        //Explanation: Subarrays with sum = 15 are [5, 2, 7, 1], [10, 5] and [10, 5, 2, 7, 1, -10]. The length of the longest subarray with a sum of 15 is 6.
    	int[] array = {10, 5, 2, 7, 1, -10};
        int target = 15;
        int longestSubArrayLength = longestSubArrayWithGivenSum(array, target);
        System.out.println("longestSubArrayLength " + longestSubArrayLength);
        int longSubArrayLength = longestSubArray(array, target);
        System.out.println("longSubArrayLength : " + longSubArrayLength);
    }

    // use 2 nested for loops and sum variable
    // loop 1 -> i=0 to N. initialize sum=0;
    // loop 2 -> j=i to N.
    // calculate sum.
    // check sum with target. if same then find maximum length.

    // T(C) -> O(n ^ 2)
    // S(C) -> O(1)
    static int longestSubArrayWithGivenSum(int[] array, int target) {
        //edge case
        if (array == null || array.length == 0) {
            return 0;
        }

        int result = 0;
        int n = array.length;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum = sum + array[j];

                if (sum == target) {
                    int sublength = j - i + 1;
                    result = Math.max(result, sublength);
                }
            }
        }

        return result;
    }


    // use map and prefixSum.
    // Use only one loop from i=0 to N and calculate prefixSum
    // use if to check prefixSum with target.
    // check if map contains prefixSum-target if yes then use Math.max function to check maximum of value and prefixSum
    // if map does not contains prefix sum then add entry to map.(prefixSum, i)

    // T(C) -> O(n)
    // S(C) -> O(n)
    static int longestSubArray(int[] array, int target) {
        //edge case
        if (array == null || array.length == 0) {
            return 0;
        }

        int result = 0;
        int n = array.length;
        int prefixSum = 0;
        Map < Integer, Integer > map = new HashMap < > ();

        for (int i = 0; i < n; i++) {
            prefixSum = prefixSum + array[i];

            if (prefixSum == target) {
                result = i + 1;
            }

            int requiredSum = prefixSum - target;
            if (map.containsKey(requiredSum)) {
                result = Math.max(result, map.get(requiredSum));
            }

            if (!map.containsKey(prefixSum)) {
                map.put(prefixSum, i);
            }
        }
        return result;
    }
}