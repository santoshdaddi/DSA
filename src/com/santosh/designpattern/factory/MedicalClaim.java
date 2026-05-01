package com.santosh.designpattern.factory;

public class MedicalClaim implements Claim{

	@Override
	public void processClaim() {
		System.out.println("processing medical claim");
	}

}
