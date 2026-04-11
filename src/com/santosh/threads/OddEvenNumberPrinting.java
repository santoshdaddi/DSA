package com.santosh.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OddEvenNumberPrinting {
	
	volatile int counter = 1;
	
	private synchronized void  printEven() throws InterruptedException {
		while(counter < 10) {
			if(counter %2 == 0)
			wait();
			System.out.println("Odd = "+counter++);
			notify();
		}
	}
	
	
	private synchronized void  printOdd() throws InterruptedException {
		while(counter < 10) {
			if(counter %2 != 0)
			wait();
			System.out.println("Even = "+counter++);
			notify();
		}
	}
	
	
	public static void main(String[] args) {
		OddEvenNumberPrinting numberPrinting = new OddEvenNumberPrinting();
		
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		
		executorService.submit( () -> {
			try {
				numberPrinting.printOdd();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
		executorService.submit( () -> {
			try {
				numberPrinting.printEven();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
		executorService.shutdown();
	}
	

}
