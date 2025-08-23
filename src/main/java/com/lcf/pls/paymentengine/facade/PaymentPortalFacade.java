package com.lcf.pls.paymentengine.facade;

import com.lcf.pls.paymentengine.dto.PaymentPortalCreateOrderRequest;
import com.lcf.pls.paymentengine.dto.PaymentPortalCreateOrderResponse;
import com.lcf.pls.paymentengine.utils.LCFRequestHeaders;

public interface PaymentPortalFacade {
    PaymentPortalCreateOrderResponse createOrder(LCFRequestHeaders requestHeaders, PaymentPortalCreateOrderRequest createOrderRequest);
}
