package com.lcf.pls.paymentengine.common;

import com.lcf.pls.paymentengine.dto.CreateCustomerRequestDto;
import com.lcf.pls.paymentengine.dto.CreateOrderRequestDto;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.Base64;


@Component
public class ValidationHelper {


    public static String validateAndGetEncodedToken(String mid, String midKey) {
        if (!ObjectUtils.isEmpty(mid) && !ObjectUtils.isEmpty(midKey)) {
            String apiKey = mid + ":" + midKey;
            return ApplicationConstants.BASIC + Base64.getEncoder().encodeToString(apiKey.getBytes());
        } else {
            throw new RuntimeException("mid");
        }
    }

    public static void validateCreateCustomerRequestBody(CreateCustomerRequestDto customerRequestType) {

        if (ObjectUtils.isEmpty(customerRequestType) || StringUtils.isEmpty(customerRequestType.getCustomerName())) {

            throw new RuntimeException("Invalid Request Parameters");
        }
    }
    public static void validateRequestParameter(String pgId) {
        if (StringUtils.isEmpty(pgId)) {
            throw new RuntimeException("Request Parameter Cannot be empty or null");
        }
    }
    public static void validateCreateOrderRequestBody(CreateOrderRequestDto customerRequestType) {

        if (ObjectUtils.isEmpty(customerRequestType) || StringUtils.isEmpty(customerRequestType.getCurrency()) || StringUtils.isEmpty(customerRequestType.getAmount())) {

            throw new RuntimeException("Invalid Request Parameters");
        }
    }
}
