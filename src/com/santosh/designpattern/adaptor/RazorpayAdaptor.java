package com.santosh.designpattern.adaptor;

public class RazorpayAdaptor implements PaymentProcessor {
	private RazorpayGateway razorpayGateway;
	
	public RazorpayAdaptor(RazorpayGateway razorpayGateway) {
		this.razorpayGateway = razorpayGateway;
	}

	@Override
	public String pay(double amount) {
		String response =  razorpayGateway.doPayment(amount);
		return response;
	}

}
