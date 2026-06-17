package com.santosh.designpattern.state;

public class ApprovedState implements ClaimState {

	@Override
	public void handleRequest() {
		System.out.println("Claim has been approved....");
	}

}
