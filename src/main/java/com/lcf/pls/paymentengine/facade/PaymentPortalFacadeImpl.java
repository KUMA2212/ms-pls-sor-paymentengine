package com.lcf.pls.paymentengine.facade;

import com.lcf.pls.paymentengine.common.ApplicationConstants;
import com.lcf.pls.paymentengine.dto.PaymentPortalCreateOrderRequest;
import com.lcf.pls.paymentengine.dto.PaymentPortalCreateOrderResponse;
import com.lcf.pls.paymentengine.utils.LCFRequestHeaders;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class PaymentPortalFacadeImpl implements PaymentPortalFacade {
    private RestTemplate restTemplate;

    public PaymentPortalCreateOrderResponse createOrder(LCFRequestHeaders requestHeaders, PaymentPortalCreateOrderRequest createOrderRequest) {

        HttpHeaders headers =new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add(ApplicationConstants.HEADER_ACCEPT, MediaType.APPLICATION_JSON_VALUE);

        ResponseEntity<PaymentPortalCreateOrderResponse> response = restTemplate.postForEntity("http://localhost:8888/createOrder",headers,PaymentPortalCreateOrderResponse.class);
        return response.getBody();
    }

}
