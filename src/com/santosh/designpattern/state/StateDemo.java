package com.santosh.designpattern.state;

public class StateDemo {
	
	public static void main(String[] args) {
		
		// creating claim context
		ClaimContext claim = new ClaimContext();
		
		claim.setState(new SubmittedState());
		claim.processRequest();
		
		claim.setState(new ApprovedState());
		claim.processRequest();
		
		claim.setState(new RejectedState());
		claim.processRequest();
	}

}
