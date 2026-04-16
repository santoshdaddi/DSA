package com.santosh.designpattern.strategy;

public class CashlessClaimSettlement implements ClaimSettlementStrategy{

	@Override
	public double settleClaim(double amount) {
		return amount;
	}

}
