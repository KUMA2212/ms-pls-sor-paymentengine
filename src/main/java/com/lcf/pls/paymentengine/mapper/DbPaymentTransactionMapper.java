package com.lcf.pls.paymentengine.mapper;

import com.lcf.pls.paymentengine.common.ApplicationConstants;
import com.lcf.pls.paymentengine.dto.LCFCustomerProfileResponse;
import com.lcf.pls.paymentengine.dto.PaymentTransactionRequestResponse;
import com.lcf.pls.paymentengine.models.CreatePaymentRequest;
import com.lcf.pls.paymentengine.utils.LCFRequestHeaders;

import java.time.LocalDateTime;


public class DbPaymentTransactionMapper {

    public static PaymentTransactionRequestResponse setRequestForPaymentTransactionInsertIntoDatabase(CreatePaymentRequest createPaymentRequest, LCFCustomerProfileResponse customerProfile, LCFRequestHeaders requestHeaders) {

        PaymentTransactionRequestResponse request =new PaymentTransactionRequestResponse();

        //set basic details
        request.setTransactionType(createPaymentRequest.getTransactionType().name());
        request.setMobile(createPaymentRequest.getMobile().toString());
        request.setCustomer_id(createPaymentRequest.getCustomer_id());
        request.setChannel(requestHeaders.getChannel());
        request.setServiceType(requestHeaders.getServiceType());
        request.setPinCodeID(requestHeaders.getPinCodeID());
        request.setFirstName(customerProfile.getFirstName());
        request.setMiddleName(customerProfile.getMiddleName());
        request.setLastName(customerProfile.getLastName());

        //
        request.setPgTransactionStatus(ApplicationConstants.DB_PG_TRANSACTION_PENDING);
        request.setPgOrderCreationDate(LocalDateTime.now().toString());
        request.setAmount(createPaymentRequest.getTotalAmount().getAmount().toString());
        request.setPgOrderId("MON202507271234567");
        System.out.println("PaymentTransactionRequest::"+request);
        return request;
    }
}
