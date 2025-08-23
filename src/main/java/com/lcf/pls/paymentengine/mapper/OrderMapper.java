package com.lcf.pls.paymentengine.mapper;

import com.lcf.pls.paymentengine.common.ApplicationConstants;
import com.lcf.pls.paymentengine.common.TokenInfo;
import com.lcf.pls.paymentengine.dto.LCFCustomerProfileResponse;
import com.lcf.pls.paymentengine.dto.PaymentPortalCreateOrderRequest;
import com.lcf.pls.paymentengine.models.CreatePaymentRequest;
import com.lcf.pls.paymentengine.utils.LCFRequestHeaders;

public class OrderMapper {
    public static PaymentPortalCreateOrderRequest createOrderRequest(LCFRequestHeaders requestHeaders, CreatePaymentRequest paymentRequest, LCFCustomerProfileResponse customerProfile){

        PaymentPortalCreateOrderRequest orderRequest= new PaymentPortalCreateOrderRequest();

        orderRequest.setAmount(paymentRequest.getAmount());
        orderRequest.setCurrency(paymentRequest.getTotalAmount().getUnits());
        orderRequest.setCustomer_id(customerProfile.getCustomer_id());
        orderRequest.setMethod(ApplicationConstants.PAYMENT_METHOD_UPI);

        TokenInfo tokenInfo =new TokenInfo();
        tokenInfo.setMax_amount(ApplicationConstants.TOKEN_MAX_AMOUNT);
        tokenInfo.setExpire_at("2709971120");
        tokenInfo.setFrequency(ApplicationConstants.FREQUENCY_MONTHLY);
        tokenInfo.setRecurring_type("25");
        tokenInfo.setRecurring_type("on");
        orderRequest.setToken(tokenInfo);

        return orderRequest;
    }
}
