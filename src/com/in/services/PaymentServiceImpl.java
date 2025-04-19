package com.in.services;

import com.in.enums.UPIProvider;
import com.in.interfaces.PaymentService;
import com.in.paymentMethods.Cash;
import com.in.paymentMethods.CreditCard;
import com.in.paymentMethods.PaymentMethod;
import com.in.paymentMethods.UPI;

public class PaymentServiceImpl  implements PaymentService {

	@Override
	public void acceptCash(int amount) {
		PaymentMethod cash = new Cash();
		cash.initiatePayment(amount);
	}

	@Override
	public void acceptCreditCard(String cardNumber, int cvv, int amount) {
		PaymentMethod creditCard = new CreditCard(cardNumber, cvv);
		creditCard.initiatePayment(amount);
	}

	@Override
	public void aceptUPI(String upiId, UPIProvider provider, int amount) {
		PaymentMethod upi = new UPI(upiId, provider);
		upi.initiatePayment(amount);
	}

}
