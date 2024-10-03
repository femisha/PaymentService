package com.scaler.paymentservice.gateway;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentLink;
import com.stripe.model.Price;
import com.stripe.param.PaymentLinkCreateParams;
import com.stripe.param.PriceCreateParams;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class StripeGateway implements  PaymentGateway{

    public String api_key="sk_test_51Q4xHdP0rxBGL52z1wmGcbkEFUEOzANlMwn1a2PuuT6VI36yYAarA1Y0A6qE2FNPSMepKnr3RX2IKgjIuzfrud7L00tpGC2WJQ";
    @Override
    public String generatePaymentLink() throws Exception {
        Stripe.apiKey=this.api_key;
        Price price=getPrice();

        PaymentLinkCreateParams params=PaymentLinkCreateParams.builder()
                                             .addLineItem(PaymentLinkCreateParams.LineItem.builder()
                                                                                           .setPrice(price.getId())
                                                                                           .setQuantity(1L)
                                                                                           .build()
                                              ).setAfterCompletion(PaymentLinkCreateParams.AfterCompletion.builder()
                                                                                                  .setType(PaymentLinkCreateParams.AfterCompletion.Type.REDIRECT)
                                                                                                  .setRedirect(PaymentLinkCreateParams.AfterCompletion.Redirect.builder()
                                                                                                  .setUrl("https://www.google.com?ref_id=154")
                                                                                                          .build()).build())
                                             .build();
        PaymentLink paymentLink=PaymentLink.create(params);

        return paymentLink.getUrl();
    }

    private Price getPrice() throws StripeException{
        Price price=null;
        try{
            PriceCreateParams params=PriceCreateParams.builder()
                                                       .setCurrency("inr")
                                                       .setUnitAmount(10000L)
                                                       .setProductData(
                                                                PriceCreateParams.ProductData
                                                                        .builder()
                                                                        .setName("PSS").build()
                                                       )
                                                       .build();
             price=Price.create(params);
            return price;

        }catch (StripeException e){
            System.out.println(e.getMessage());
        }
        return price;
    }
}
