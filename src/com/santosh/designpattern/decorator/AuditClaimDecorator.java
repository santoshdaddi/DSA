package com.santosh.designpattern.decorator;

public class AuditClaimDecorator extends ClaimProcessorDecorator {

	public AuditClaimDecorator(ClaimProcessor claimProcessor) {
		super(claimProcessor);
	}
	
	@Override
	public void processClaim(String claimId) {
		super.processClaim(claimId);
		System.out.println("Audit done for claimId : " + claimId);
	}

}
