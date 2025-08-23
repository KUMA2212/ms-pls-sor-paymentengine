package com.lcf.pls.paymentengine.facade;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lcf.pls.paymentengine.common.ApplicationConstants;
import com.lcf.pls.paymentengine.dto.LCFCustomerProfileResponse;
import com.lcf.pls.paymentengine.utils.MasterUtils;
import com.lcf.pls.paymentengine.utils.RestCallChecker;
import lombok.AllArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerProfileFacadeImpl implements CustomerProfileFacade {

    private RestTemplate restTemplate;

    public LCFCustomerProfileResponse getCustomerProfieData(String customerId) {
        LCFCustomerProfileResponse customerProfileResponse = null;

        String response = null;
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.add(ApplicationConstants.HEADER_ACCEPT, MediaType.APPLICATION_JSON_VALUE);
            headers.add(ApplicationConstants.SORNAME, "LCF");

            response = (String) RestCallChecker.callRestGetDataService("", MasterUtils.createRequest("get", headers), String.class, restTemplate, 10, 10);
            customerProfileResponse =  new ObjectMapper().readValue(response, LCFCustomerProfileResponse.class);

            return customerProfileResponse;

        } catch (Exception e) {

        }
        return customerProfileResponse;

    }
}

