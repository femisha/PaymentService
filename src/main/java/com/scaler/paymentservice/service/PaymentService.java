package com.scaler.paymentservice.service;

import com.scaler.paymentservice.gateway.PaymentGatewaySelector;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private PaymentGatewaySelector gatewaySelector;

    public PaymentService(PaymentGatewaySelector gatewaySelector){
        this.gatewaySelector=gatewaySelector;
    }

    public String initiatePayment() throws Exception {

        //gateway selector will give the correct payment gateway to initiate payment through that gateway
        return gatewaySelector
                .getPaymentGateway()
                .generatePaymentLink();
    }
}
