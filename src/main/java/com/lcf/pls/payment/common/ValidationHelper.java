package com.lcf.pls.payment.common;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;


@Component
public class ValidationHelper {

    public static void validateRequestParameter(String pgId) {
        if (StringUtils.isEmpty(pgId)) {
            throw new RuntimeException("Request Parameter Cannot be empty or null");
        }
    }
}
