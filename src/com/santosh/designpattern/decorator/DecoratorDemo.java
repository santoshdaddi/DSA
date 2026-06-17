package com.santosh.designpattern.decorator;

public class DecoratorDemo {

	public static void main(String[] args) {
		ClaimProcessor claimProcessor = new CashlessClaimProcessor();
		
		ClaimProcessor processor = new NotificationDecorator(claimProcessor);
		processor.processClaim("claim123");
	}
}
