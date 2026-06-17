package com.santosh.designpattern.state;

public class ClaimContext {
	
	private ClaimState state;
	
	public void setState(ClaimState claimState) {
		this.state = claimState;
	}


	public void processRequest() {
		if(state != null) {
			state.handleRequest();
		}else {
			System.out.println("No state assigned to claim");
		}
	}

}
