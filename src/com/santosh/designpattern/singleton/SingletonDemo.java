package com.santosh.designpattern.singleton;

public class SingletonDemo {

	public static void main(String[] args) {
		
		Runnable task = () ->{
			PolicyRules policyRules = PolicyRules.getPolicyRulesInstance();
			System.out.println("policyRules instance created by Thread : "+Thread.currentThread().getName() +" has hashCode value : "+policyRules.hashCode());
		};
		
		Thread t1 = new Thread(task,"T1");
		Thread t2 = new Thread(task,"T2");
		
		t1.start();
		t2.start();
		
		PolicyRules policyRules1 = PolicyRules.getPolicyRulesInstance();
		
		PolicyRules policyRules2 = PolicyRules.getPolicyRulesInstance();
		
		System.out.println(policyRules1 == policyRules2); // true
		System.out.println(policyRules1.equals(policyRules2)); //true
		
	}

}
