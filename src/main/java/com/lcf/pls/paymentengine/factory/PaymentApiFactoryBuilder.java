package com.lcf.pls.paymentengine.factory;

import com.lcf.pls.paymentengine.common.ValidationHelper;
import com.lcf.pls.paymentengine.common.ApplicationConstants;
import com.lcf.pls.paymentengine.dto.LCFCustomerProfileResponse;
import com.lcf.pls.paymentengine.dto.PaymentPortalCreateOrderResponse;
import com.lcf.pls.paymentengine.dto.PaymentTransactionRequestResponse;
import com.lcf.pls.paymentengine.service.CommonTransactionService;
import com.lcf.pls.paymentengine.utils.LCFRequestHeaders;
import lombok.AllArgsConstructor;
import com.lcf.pls.paymentengine.models.CreatePaymentRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PaymentApiFactoryBuilder {
    private CommonTransactionService commonTransactionService;

    public ResponseEntity<Object> createPaymentSignature(CreatePaymentRequest paymentRequest, LCFRequestHeaders requestHeaders) {
        System.out.println("Inside PaymentApiFactoryBuilder::->");
        LCFCustomerProfileResponse customerProfileResponse = null;

        // To Validate request  body
        ValidationHelper.requestBodyValidation(paymentRequest);

        // To Validate request for different txns
        checkPaymentInitiationRequest(paymentRequest);

        // To find the TransactionSetting

        // Get Customer profile data
        customerProfileResponse = commonTransactionService.findCustomerProfile(paymentRequest.getCustomer_id(), requestHeaders);
        System.out.println("Customer Profile Response::" + customerProfileResponse);

        // Insert data into Database
        PaymentTransactionRequestResponse paymentTransactionResponse =
                commonTransactionService.insertPaymentOrderInDatabase(paymentRequest, customerProfileResponse, requestHeaders);

        System.out.println("DataBase OrderID ::" + paymentTransactionResponse.getPgOrderId());
        // Create Order at razorpay end
        PaymentPortalCreateOrderResponse orderResponse =commonTransactionService.createOrderInPaymentPortal(requestHeaders,paymentRequest,customerProfileResponse);
        System.out.println("Order Response::" + orderResponse);

        return ResponseEntity.ok(orderResponse.getId());
    }

    public void checkPaymentInitiationRequest(CreatePaymentRequest paymentRequest) {

        switch (paymentRequest.getTransactionType().name()) {

            case ApplicationConstants.TRANSACTION_TYPE_EMI_MONTH:
                break;

            case ApplicationConstants.TRANSACTION_TYPE_EMI_YEAR:
                break;
        }
    }
}
