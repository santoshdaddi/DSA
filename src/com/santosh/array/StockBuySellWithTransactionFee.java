package com.santosh.array;

public class StockBuySellWithTransactionFee {
	
	public static void main(String[] args) {
//		Input: arr[] = [6, 1, 7, 2, 8, 4], k = 2
//		Output: 8
//		Explanation:
//		Buy the stock on day 2 and sell it on day 3 => 7 – 1 -2 = 4
//		Buy the stock on day 4 and sell it on day 5 => 8 – 2 - 2 = 4
//		Maximum Profit  = 4 + 4 = 8
		int[] array = {6, 1, 7, 2, 8, 4};
		int k =2;
		
		int profit = maxProfit(array, k);
		System.out.println("profit : "+profit);
	}
	
	
	// approach observe each day's profit depends only on next day's state.
	// use two variables
	// noStock -> profit when no stock is holding
	// inHand -> profit when holding a stock
	// loop i=N-1 to 0
	// To Buy -> newNoStock = max(noStock, inHand - a[i])
	// To Sell -> newInHand = max(inHand, a[i] - k + noStock) 
	
	// T(C) -> O(n)
	// S(C) -> O(1)
	static int maxProfit(int[] array, int k) {
		if(array == null || array.length ==0) {
			return 0;
		}
		
		int n = array.length;
		int noStock = 0;
		int inHand = 0;
		
		for(int i = n-1 ; i >= 0 ; i-- ) {
			int newInStock = Math.max(noStock, inHand-array[i]);
			
			int newInHand = Math.max(inHand, array[i] - k + noStock);
			
			noStock = newInStock;
			inHand = newInHand;
		}
		
		return noStock;
	}
}
