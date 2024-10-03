package com.scaler.paymentservice.gateway;

public interface PaymentGateway {

    String generatePaymentLink() throws Exception;
}
