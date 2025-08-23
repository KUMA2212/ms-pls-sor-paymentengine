package com.lcf.pls.paymentengine.common;

import com.lcf.pls.paymentengine.models.CreatePaymentRequest;
import com.lcf.pls.paymentengine.schema.razorpay.request.PgCustomerRequestResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;


@Component
public class ValidationHelper {

    public static CreatePaymentRequest requestBodyValidation(CreatePaymentRequest createPaymentRequest) {
        System.out.println("Inside ValidationHelper::->");
        return createPaymentRequest;
    }
    public static void validateRequestBody(PgCustomerRequestResponse request) {

        if (StringUtils.isEmpty(request.getEmail())|| StringUtils.isEmpty(request.getName()) ||StringUtils.isEmpty(request.getContact())) {
           throw new RuntimeException("Request can not be null");
        }

    }
}
