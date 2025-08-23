package com.lcf.pls.paymentengine.facade;

import com.lcf.pls.paymentengine.dto.PaymentTransactionRequestResponse;
import com.lcf.pls.paymentengine.utils.LCFRequestHeaders;
import org.springframework.stereotype.Service;

@Service
public class DbPaymentTransactionFacadeImpl implements DbPaymentTransactionFacade{

   public PaymentTransactionRequestResponse insertPaymentOrderDetailsInDatabase(PaymentTransactionRequestResponse request, LCFRequestHeaders requestHeaders){
        return request;
    }

}
