package com.santosh.threads;

public class ProducerConsumerDemo {
	
	public static void main(String[] args) {
		ProducerConsumerExample producerConsumer = new ProducerConsumerExample();
		
		Thread producerThread = new Thread( () -> {
			for(int i =0; i < 5; i++) {
				producerConsumer.produce(i);
			}
		}, "ProducerThread");
		
		Thread consumerThread = new Thread( () -> {
			for(int i =0; i < 5; i++) {
				producerConsumer.consumeData();
			}
		}, "ConsumerThread");
		
		producerThread.start();
		consumerThread.start();
 	}

}
