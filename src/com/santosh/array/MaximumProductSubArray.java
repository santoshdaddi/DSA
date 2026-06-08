package com.santosh.array;

public class MaximumProductSubArray {

    public static void main(String[] args) {
        //Input: arr[] = [-2, 6, -3, -10, 0, 2]
        //Output: 180
        //Explanation: The subarray with maximum product is [6, -3, -10] with product = 6 * (-3) * (-10) = 180.
        int[] array = new int[] {
            -2, 6, -3, -10, 0, 2
        };
        int product = maxiumProductSubArray(array);
        System.out.println("product = " + product);

        int maxProduct = maxProductSubArray(array);
        System.out.println("maxProduct : " + maxProduct);
    }

    // use of 2 nested for loops.
    // calculate product and find out maximum product

    // T(C) -> O(n ^ 2)
    // S(C) -> O(1)
    static int maxiumProductSubArray(int[] array) {

        //edge case
        if (array == null || array.length == 0) {
            return 0;
        }

        int maxProduct = 0;
        int n = array.length;

        for (int i = 0; i < n; i++) {
            int product = 1;
            for (int j = i; j < n; j++) {
                product = product * array[j];

                maxProduct = Math.max(maxProduct, product);
            }
        }
        return maxProduct;
    }

    // use only 1 for loop.
    // initialize maxProduct, currentMin and currentMax to a[0].
    // Loop i=1 to N. findout currentMin, currentMax and maxProduct at each iteration.
    // define max and min functions to identify min and max for passed 3 inputs. inputs passed to both functions are same

    // T(C) -> O(n)
    // S(C) -> O(1)
    static int maxProductSubArray(int[] array) {
        //edge case
        if (array == null || array.length == 0) {
            return 0;
        }

        int n = array.length;
        int maxProduct = array[0];
        int currentMax = array[0];
        int currentMin = array[0];

        for (int i = 1; i < n; i++) {
            int temp = max(array[i], array[i] * currentMax, array[i] * currentMin);

            currentMin = min(array[i], array[i] * currentMax, array[i] * currentMin);

            currentMax = temp;

            maxProduct = Math.max(maxProduct, temp);
        }

        return maxProduct;

    }

    static int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }


    static int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}