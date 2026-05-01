package com.santosh.designpattern.factory;

public class ClaimFactory {
	
	// method which returns object based on input
	public static Claim getClaim(String claimType) {

		if (claimType == null) {
			throw new IllegalArgumentException("Claim type cannot be null");
        }

		return switch(claimType.toLowerCase()) {
			case "medical"  -> new MedicalClaim();
			case "dental"   -> new DentalClaim();
			default 		-> throw new IllegalArgumentException("invalid claim type provided "+claimType); 		
		};
	}

}
