package com.santosh.designpattern.decorator;

public class CashlessClaimProcessor implements ClaimProcessor{

	@Override
	public void processClaim(String claimId) {
		System.out.println("Processing cashless claim for claimId : "+claimId);
	}

}
