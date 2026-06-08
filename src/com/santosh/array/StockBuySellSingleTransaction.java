package com.santosh.array;

public class StockBuySellSingleTransaction {

	public static void main(String[] args) {
		
//		Input: prices[] = [7, 10, 1, 3, 6, 9, 2]
//		Output: 8
//		Explanation: Buy for price 1 and sell for price 9. 
				
		int[] array = {7, 6, 4, 3, 10};
		int highestProfit = maxProfit(array);
		System.out.println("highestProfit : "+highestProfit);
		
		int maxProfit = maxProfitOptimised(array);
		System.out.println("maxProfit : "+maxProfit);
	}

	// approach 2 nested for loops and calculating max profit at each iteration
	
	// TC -> O(n ^ 2)
	// SC -> O(1)
	static int maxProfit(int[] array) {
		if(array == null || array.length ==0) {
			return 0;
		}
		
		int maxProfit = 0;
		int n = array.length;
		
		for(int i=0; i < n; i++) {
			for(int j=i; j <n ; j++) {
				maxProfit = Math.max(maxProfit, array[j]-array[i]);
			}
		}
		
		return maxProfit;
	}
	
	
	// approach use only 1 for loop.
	// initialize minimumValue=a[0]
	// loop i=1 to N. 
	// calculate minimumValue and maxProfit at each iteration
	
	// T(C) -> O(n)
	// S(C) -> O(1)
	static int maxProfitOptimised(int[] array) {
		if(array == null || array.length ==0) {
			return 0;
		}
		
		int maxProfit = 0;
		int n = array.length;
		int minimumValue = array[0];
		
		for(int i=1; i < n; i++) {
			
			// find out minimum value
			minimumValue = Math.min(minimumValue, array[i]);
			
			maxProfit = Math.max(maxProfit, array[i]-minimumValue);
		}
		
		return maxProfit;
	}
}
