package com.scaler.paymentservice.gateway;

import org.springframework.stereotype.Service;

@Service
public class PaymentGatewaySelector {

    private StripeGateway stripeGateway;

    private RazorpayGateway razorpayGateway;

    public PaymentGatewaySelector(StripeGateway stripeGateway,RazorpayGateway razorpayGateway ) {
        this.razorpayGateway=razorpayGateway;
        this.stripeGateway=stripeGateway;
    }

    public PaymentGateway getPaymentGateway() {

        //some logic to choose correct payment gateway
        return stripeGateway;
    }
}
