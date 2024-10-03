package com.scaler.paymentservice.controller;

import com.scaler.paymentservice.service.PaymentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    private PaymentService paymentService;

    PaymentController(PaymentService paymentService){
        this.paymentService=paymentService;
    }

    @PostMapping("/payment")
    public String initiatePayment() throws Exception {

        return paymentService.initiatePayment();
    }
}
