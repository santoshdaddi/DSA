package com.santosh.threads;

public class ProducerConsumerExample {
	
	private int data;
	private boolean isDataAvailable;
	
	//it will produce the data 
	public synchronized void produce(int data) {
		while(isDataAvailable) {
			try {
				wait(); //waits till consumer consumes data
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		isDataAvailable = true;
		this.data = data;
		System.out.println("produced data is "+data);
		notify(); // notifies once data is produced
	}
	
	//it will consume produced data 
	public synchronized void consumeData() {
		while(!isDataAvailable) {
			try {
				wait(); // waits till producer produces the data
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		isDataAvailable = false;
		System.out.println("consumed data is "+data);
		notify(); // notifies once data is consumed
		
	}
	
	

}
