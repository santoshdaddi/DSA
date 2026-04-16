package com.santosh.designpattern.strategy;

public class ReimbursementClaimSettlement implements ClaimSettlementStrategy{

	@Override
	public double settleClaim(double amount) {
		return amount * 0.80;
	}

}
