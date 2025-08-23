package com.lcf.pls.paymentengine.facade;

import com.lcf.pls.paymentengine.dto.PaymentTransactionRequestResponse;
import com.lcf.pls.paymentengine.utils.LCFRequestHeaders;

public interface DbPaymentTransactionFacade {

    PaymentTransactionRequestResponse insertPaymentOrderDetailsInDatabase(PaymentTransactionRequestResponse PaymentRequest, LCFRequestHeaders requestHeaders);
}
