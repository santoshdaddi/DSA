package com.santosh.designpattern.state;

public class RejectedState implements ClaimState{

	@Override
	public void handleRequest() {
		System.out.println("Claim has been Rejected...");
		
	}

}
