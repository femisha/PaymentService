package com.scaler.paymentservice.gateway;

import org.springframework.stereotype.Service;

@Service
public class RazorpayGateway implements  PaymentGateway{
    @Override
    public String generatePaymentLink() {
        return "";
    }
}
