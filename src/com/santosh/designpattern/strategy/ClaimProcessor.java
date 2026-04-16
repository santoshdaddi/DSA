package com.santosh.designpattern.strategy;

public class ClaimProcessor {
	
	private ClaimSettlementStrategy claimSettlementStrategy;

	public void setClaimSettlementStrategy(ClaimSettlementStrategy strategy) {
		this.claimSettlementStrategy = strategy;
	}
	
	public void processClaim(double billAmount) {
		double settledAmount = claimSettlementStrategy.settleClaim(billAmount);
		System.out.println("claim has been processed with Settled Amount: ₹" + settledAmount);

	}
	

}
