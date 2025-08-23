package com.lcf.pls.paymentengine.mapper;

import com.lcf.pls.paymentengine.dto.PgCustomerResponse;
import com.lcf.pls.paymentengine.schema.razorpay.request.PgCustomerRequestResponse;
import org.springframework.util.ObjectUtils;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;

public class PgCustomerManagementMapper {

    public static PgCustomerResponse setPgCustomerResponse(PgCustomerRequestResponse pgCustomerRequestResponse) {
        PgCustomerResponse response = null;
        if (!ObjectUtils.isEmpty(pgCustomerRequestResponse)) {
            response = new PgCustomerResponse();
            response.setCustomerId(pgCustomerRequestResponse.getId());
            response.setCustomerName(pgCustomerRequestResponse.getName());
            response.setEmailId(pgCustomerRequestResponse.getEmail());
            response.setContactNo(pgCustomerRequestResponse.getContact());
            response.setCustomerCreationDate(OffsetDateTime.now());
        }
        return response;
    }

    public static String createPgCustomerUrl(String customerId, String customerUrl) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(customerUrl);
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("customerId", customerId);
        URI uri = builder.buildAndExpand(queryParams).toUri();
        return uri.toString();
    }
}
