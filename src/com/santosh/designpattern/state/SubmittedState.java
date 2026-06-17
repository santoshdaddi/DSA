package com.santosh.designpattern.state;

public class SubmittedState implements ClaimState {

	@Override
	public void handleRequest() {
		System.out.println("Claim has been submitted...");
	}

}
