package com.santosh.designpattern.decorator;

public abstract class ClaimProcessorDecorator implements ClaimProcessor{
	
	protected ClaimProcessor processor;
	
	public ClaimProcessorDecorator(ClaimProcessor claimProcessor) {
		this.processor = claimProcessor;
	}

	@Override
	public void processClaim(String claimId) {
		processor.processClaim(claimId);
		
	}

}
