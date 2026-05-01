package com.santosh.designpattern.factory;

public class DentalClaim implements Claim {

	@Override
	public void processClaim() {
		System.out.println("processing Dental claim");
	}

}
