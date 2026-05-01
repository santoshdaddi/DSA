package com.santosh.designpattern.factory;

public class FactoryDemo {

	public static void main(String[] args) {
		Claim medicalClaim = ClaimFactory.getClaim("medical");
		medicalClaim.processClaim();
		
		Claim dentalClaim = ClaimFactory.getClaim("dental");
		dentalClaim.processClaim();
		
		Claim newMedicalClaim = ClaimFactory.getClaim("medical");
		newMedicalClaim.processClaim();
	}

}
