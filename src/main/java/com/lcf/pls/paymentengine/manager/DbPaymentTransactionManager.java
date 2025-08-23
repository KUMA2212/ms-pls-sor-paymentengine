package com.lcf.pls.paymentengine.manager;

import com.lcf.pls.paymentengine.dto.LCFCustomerProfileResponse;
import com.lcf.pls.paymentengine.dto.PaymentTransactionRequestResponse;
import com.lcf.pls.paymentengine.facade.DbPaymentTransactionFacade;
import com.lcf.pls.paymentengine.mapper.DbPaymentTransactionMapper;
import com.lcf.pls.paymentengine.models.CreatePaymentRequest;
import com.lcf.pls.paymentengine.utils.LCFRequestHeaders;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DbPaymentTransactionManager {

    private DbPaymentTransactionFacade dbPaymentTransactionFacade;

    public PaymentTransactionRequestResponse insertPaymentOrderDetailsInDatabase(CreatePaymentRequest PaymentRequest, LCFCustomerProfileResponse customerProfile, LCFRequestHeaders requestHeaders) {

        PaymentTransactionRequestResponse request = DbPaymentTransactionMapper.setRequestForPaymentTransactionInsertIntoDatabase(PaymentRequest, customerProfile,requestHeaders);

        return dbPaymentTransactionFacade.insertPaymentOrderDetailsInDatabase(request, requestHeaders);
    }
}
