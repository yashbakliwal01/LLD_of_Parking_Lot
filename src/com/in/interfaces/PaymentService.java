package com.in.interfaces;

import com.in.enums.UPIProvider;

public interface PaymentService {

	void acceptCash(int amount);
	void acceptCreditCard(String cardNumber, int cvv, int amount);
	void aceptUPI(String upiId, UPIProvider provider, int amount);;
}
