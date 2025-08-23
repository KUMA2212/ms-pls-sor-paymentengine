package com.lcf.pls.paymentengine.service;

import com.lcf.pls.paymentengine.dto.PaymentPortalCreateOrderResponse;
import com.lcf.pls.paymentengine.manager.CustomerProfileManager;
import com.lcf.pls.paymentengine.dto.LCFCustomerProfileResponse;
import com.lcf.pls.paymentengine.dto.PaymentTransactionRequestResponse;
import com.lcf.pls.paymentengine.manager.DbPaymentTransactionManager;
import com.lcf.pls.paymentengine.manager.PaymentPortalManager;
import com.lcf.pls.paymentengine.models.CreatePaymentRequest;
import com.lcf.pls.paymentengine.utils.LCFRequestHeaders;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CommonTransactionService {

    private CustomerProfileManager customerProfileManager;
    private DbPaymentTransactionManager dbPaymentTransactionManager;
    private PaymentPortalManager paymentPortalManager;

    public LCFCustomerProfileResponse findCustomerProfile(String customerId, LCFRequestHeaders requestHeaders) {
        return customerProfileManager.getCustomerProfileData(customerId);
    }

    public PaymentTransactionRequestResponse insertPaymentOrderInDatabase(CreatePaymentRequest paymentRequest, LCFCustomerProfileResponse customerProfile, LCFRequestHeaders requestHeaders) {
        return dbPaymentTransactionManager.insertPaymentOrderDetailsInDatabase(paymentRequest, customerProfile, requestHeaders);
    }

    public PaymentPortalCreateOrderResponse createOrderInPaymentPortal(LCFRequestHeaders requestHeaders, CreatePaymentRequest paymentRequest, LCFCustomerProfileResponse customerProfile) {
        return paymentPortalManager.createOrderInPaymentPortal(requestHeaders, paymentRequest,
                customerProfile);
    }

}
