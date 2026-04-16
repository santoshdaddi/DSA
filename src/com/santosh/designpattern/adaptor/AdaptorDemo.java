package com.santosh.designpattern.adaptor;

public class AdaptorDemo {
	public static void main(String[] args) {
		
		PaypalGateway paypalGateway =  new PaypalGatewayImplementation();
		paypalGateway.makePayment(1000.00);
		
		RazorpayGateway razorpayGateway = new RazorpayGatewayImplementation();
		PaymentProcessor razorpayProcessor = new RazorpayAdaptor(razorpayGateway);
		razorpayProcessor.pay(2000.00);
		
		PaymentProcessor paypalProcessor = new PaypalAdaptor(paypalGateway);
		paypalProcessor.pay(23800.00);
		
		// Output
		
//		payment with amount 1000.0 has made through Paypal Gateway
//		payment with amount 2000.0 has made through Razorpay Gateway
//		payment with amount 23800.0 has made through Paypal Gateway
		
		// Advantages
		// 1. Can support multiple payment gateways
		// 2. Plug-And-Play feature :  any number of payment methods can be added without touching existing logic.
		// 3. Maintainability becomes easier 

	}

}
