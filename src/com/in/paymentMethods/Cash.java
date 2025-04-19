package com.in.paymentMethods;

public class Cash extends PaymentMethod{

	@Override
	public boolean initiatePayment(int amount) {
		System.out.println("Making payment by cash of Rs. "+amount+"/-");
		return true;
	}

}
