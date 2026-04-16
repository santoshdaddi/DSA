package com.santosh.designpattern.adaptor;

public class PaypalAdaptor implements PaymentProcessor{

	PaypalGateway paypalGateway;
	
	public PaypalAdaptor(PaypalGateway paypalGateway) {
		this.paypalGateway = paypalGateway;
	}
	
	
	@Override
	public String pay(double amount) {
		String response = paypalGateway.makePayment(amount);
		return response;
	}

}
