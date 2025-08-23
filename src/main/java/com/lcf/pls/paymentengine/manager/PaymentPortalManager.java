package com.lcf.pls.paymentengine.manager;

import com.lcf.pls.paymentengine.dto.LCFCustomerProfileResponse;
import com.lcf.pls.paymentengine.dto.PaymentPortalCreateOrderRequest;
import com.lcf.pls.paymentengine.dto.PaymentPortalCreateOrderResponse;
import com.lcf.pls.paymentengine.facade.PaymentPortalFacade;
import com.lcf.pls.paymentengine.mapper.OrderMapper;
import com.lcf.pls.paymentengine.models.CreatePaymentRequest;
import com.lcf.pls.paymentengine.utils.LCFRequestHeaders;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PaymentPortalManager {
    private PaymentPortalFacade paymentPortalFacade;

    public PaymentPortalCreateOrderResponse createOrderInPaymentPortal(LCFRequestHeaders requestHeaders, CreatePaymentRequest paymentRequest, LCFCustomerProfileResponse customerProfile) {
        PaymentPortalCreateOrderRequest request= OrderMapper.createOrderRequest(requestHeaders,paymentRequest,customerProfile);
        return paymentPortalFacade.createOrder(requestHeaders,request);

    }
}
