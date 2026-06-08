package com.santosh.array;

public class MaximumSubArraySumWithGivenSizeK {

    public static void main(String[] args) {
        // Input  : arr[] = [1, 4, 2, 10, 23, 3, 1, 0, 20], k = 4
        // Output : 39
        // Explanation: We get maximum sum by adding subarray [4, 2, 10, 23] of size 4
        int[] array = { 1, 4, 2, 10, 23, 3, 1, 0, 20};
        int k = 4;
        int maxSum = maxSubArraySumWithGivenSize(array, k);
        System.out.println("maxSum : " + maxSum);
        
        int maxSumUsingSlidingWindow = maxSubArraySumWithSizeKUsingSlidingWindow(array, k);
        System.out.println("maxSumUsingSlidingWindow : "+maxSumUsingSlidingWindow);
    }

    // approach
    // using 2 nested for loop and calculate sum at every iteration.
    // use sum and maxSum variables.
    // loop 1: from i=0 to N-k
    // loop 2 : j=0 to k. calculate sum -> a[i+j]
    // find out maximum sum using Math.max function.  
    
    // T(C) -> O( n * k)
    // S(C) -> O(1)
    static int maxSubArraySumWithGivenSize(int[] array, int k) {
        // edge case
        if (array == null || array.length == 0) {
            return -1;
        }

        int n = array.length;
        int maxSum = 0;

        for (int i = 0; i <= n - k; i++) {

            int sum = 0;

            for (int j = 0; j < k; j++) {
                sum = sum + array[i + j];

                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;

    }
    
    
    // using 1 for loop 2 times first time for first window and secondly for other windows.
    // use sum and maxSum variables
    // calculate sum of first window
    // calculate sum of other windows and find out maximum sum 
    
    // T(C) -> O(n)
    // S(C) -> O(1)
    static int maxSubArraySumWithSizeKUsingSlidingWindow(int[] array, int k) {
    	
    	// edge case
        if (array == null || array.length == 0) {
            return -1;
        }

        int n = array.length;
        int maxSum = 0;
        int sum=0;
        
        // Compute sum of first window
        for(int i=0; i < k ; i++) {
        	sum = sum + array[i];
        }
        
        maxSum = sum;
        
        // Slide the window   
       for(int i=k; i < n; i++) {
    	   sum = sum + array[i]- array[i-k];
    	   maxSum = Math.max(maxSum, sum);
       }
        
   
        return maxSum;
    }
}