package com.santosh.designpattern.decorator;

public class NotificationDecorator extends ClaimProcessorDecorator{
	
	public NotificationDecorator(ClaimProcessor processor) {
		super(processor);
	}
	
	@Override
	public void processClaim(String claimId) {
		super.processClaim(claimId);
		System.out.println("Notification sent for claimId: " + claimId);
	}
}
