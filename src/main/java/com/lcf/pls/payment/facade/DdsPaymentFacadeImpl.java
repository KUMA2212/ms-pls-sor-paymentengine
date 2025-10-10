package com.lcf.pls.payment.facade;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lcf.pls.payment.common.ApplicationConstants;
import com.lcf.pls.payment.dto.DdsPaymentTransactionReqResDto;
import com.lcf.pls.paymentengine.utils.MasterUtils;
import com.lcf.pls.paymentengine.utils.RestCallChecker;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class DdsPaymentFacadeImpl implements DdsPaymentFacade {
    private RestTemplate restTemplate;


    @Override
    public DdsPaymentTransactionReqResDto savePaymentTransLinkDetailsInDds(String url, int connTimeOut, int readTimeOut, DdsPaymentTransactionReqResDto request) {
        String response = null;
        DdsPaymentTransactionReqResDto requestResponse = null;
        try {

            HttpHeaders headers = new HttpHeaders();
            headers.add(ApplicationConstants.HEADER_ACCEPT, MediaType.APPLICATION_JSON_VALUE);

            response = (String) RestCallChecker.callRestPostService(url,
                    MasterUtils.createRequest(request, headers), String.class, restTemplate, connTimeOut, readTimeOut);

            requestResponse = new ObjectMapper().readValue(response, DdsPaymentTransactionReqResDto.class);
            return requestResponse;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return requestResponse;
    }
}
