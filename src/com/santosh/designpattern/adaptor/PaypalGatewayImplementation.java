package com.santosh.designpattern.adaptor;

public class PaypalGatewayImplementation implements PaypalGateway{

	@Override
	public String makePayment(double amount) {
		System.out.println("payment with amount "+amount +" has made through Paypal Gateway");
		return "SUCCESS";
	}

}
