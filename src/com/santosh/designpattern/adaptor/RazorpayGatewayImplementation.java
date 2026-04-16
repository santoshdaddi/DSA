package com.santosh.designpattern.adaptor;

public class RazorpayGatewayImplementation implements RazorpayGateway{

	@Override
	public String doPayment(double amount) {
		System.out.println("payment with amount "+amount +" has made through Razorpay Gateway");
		return "SUCCESS";
	}

}
