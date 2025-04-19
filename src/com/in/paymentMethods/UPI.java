package com.in.paymentMethods;

import java.util.concurrent.atomic.AtomicInteger;

import com.in.enums.UPIProvider;

public class UPI extends PaymentMethod{

	private static final AtomicInteger counter = new AtomicInteger(1000);
	
	private String upiId;
	private UPIProvider provider;
	
	public UPI(String upiId, UPIProvider provider) {
		super();
		this.upiId = generateUPIId(provider);
		this.provider = provider;
	}
	
	private String generateUPIId(UPIProvider provider) {
		return "user"+counter.incrementAndGet()+"@"+provider.name().toLowerCase().replace("_", "");
	}

	@Override
	public boolean initiatePayment(int amount) {
		switch(provider) {
		case GOOGLE_PAY:
			System.out.println("Processing payment via Google_Pay for Rs. "+amount+"/- using UPI ID: "+upiId);
			break;
		case PHONE_PE:
			System.out.println("Processing payment via PhonePe for Rs. " + amount + "/- using UPI ID: " + upiId);
            break;
        case PAYTM:
            System.out.println("Processing payment via Paytm for Rs. " + amount + "/- using UPI ID: " + upiId);
            break;
        case AMAZON_PAY:
            System.out.println("Processing payment via Amazon Pay for Rs. " + amount + "/- using UPI ID: " + upiId);
            break;
        case CRED:
            System.out.println("Processing payment via CRED for Rs. " + amount + "/- using UPI ID: " + upiId);
            break;
        default:
            System.out.println("Unknown UPI Provider. Cannot proceed with payment.");
            return false;
		}
		return true;
	}
	
	public String getUpiId() {
		return upiId;
	}

	public UPIProvider getProvider() {
		return provider;
	}
}
