package com.santosh.array;

public class StockBuySellMultipleTransaction {
	
	public static void main(String[] args) {
//		Input: prices[] = [100, 180, 260, 310, 40, 535, 695]
//		Output: 865
//		Explanation: Buy the stock on day 0 and sell it on day 3 = 310 - 100 = 210 
//					 and Buy the stock on day 4 and sell it on day 6 = 695 - 40 = 655 
//					 so the Maximum Profit  is = 210 + 655 = 865.
		int[] prices = { 100, 180, 260, 310, 40, 535, 695 };
		int maxProfit = stocksBuySellMultipleTimes(prices);
        System.out.println("maxProfit : "+maxProfit);
	}
	
	// approach sell stock if price is higher on next day and add the profit to result
	// use for loop and calculate price is higher or not.( a[i] > a[i-1])
	// loop i=1 to N
	
	// T(C) -> O(n)
	// S(C) -> O(1)
	static int stocksBuySellMultipleTimes(int[] array) {
		if(array == null || array.length ==0) {
			return 0;
		}
		
		int maxProfit = 0;
		int n = array.length;
		
		for(int i=1 ; i < n ; i++) {
			if(array[i] > array[i-1]) {
				maxProfit = maxProfit + (array[i]- array[i-1]);
			}
		}
		return maxProfit;
	}
}
