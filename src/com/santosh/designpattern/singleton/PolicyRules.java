package com.santosh.designpattern.singleton;

public class PolicyRules {
	
	public static volatile PolicyRules policyRules;
	
	private PolicyRules() {
		System.out.println("PolicyRules initialized...");
	}
	
	public static PolicyRules getPolicyRulesInstance() {
		if(policyRules == null) {
			synchronized (PolicyRules.class) {
				if(policyRules == null) {
					policyRules = new PolicyRules();
				}
			}
		}
		return policyRules;
	}
	
}
