package com.santosh.designpattern.strategy;

public class StrategyDemo {
	
	public static void main(String[] args) {
		
		ClaimProcessor claimProcessor = new ClaimProcessor();
		
		//Cashless claim 
		ClaimSettlementStrategy cashlessClaimSettlement =  new CashlessClaimSettlement();
		claimProcessor.setClaimSettlementStrategy(cashlessClaimSettlement);
		claimProcessor.processClaim(20000.00);
		
		
		//Reimbursment claim
		ClaimSettlementStrategy reimbursementSettlementStrategy = new ReimbursementClaimSettlement();
		claimProcessor.setClaimSettlementStrategy(reimbursementSettlementStrategy);
		claimProcessor.processClaim(20000.00);
		
	}

}
