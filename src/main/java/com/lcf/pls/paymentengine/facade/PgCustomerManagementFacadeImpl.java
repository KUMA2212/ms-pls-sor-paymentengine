package com.lcf.pls.paymentengine.facade;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lcf.pls.paymentengine.common.ApplicationConstants;
import com.lcf.pls.paymentengine.dto.LCFCustomerProfileResponse;
import com.lcf.pls.paymentengine.schema.razorpay.request.PgCustomerRequestResponse;
import com.lcf.pls.paymentengine.utils.LCFRequestHeaders;
import com.lcf.pls.paymentengine.utils.MasterUtils;
import com.lcf.pls.paymentengine.utils.RestCallChecker;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class PgCustomerManagementFacadeImpl implements PgCustomerManagementFacade{
    private RestTemplate restTemplate;

   public PgCustomerRequestResponse getRpCustomer(String url,int connTimeOut,int readTimeOut,String encodedToken){
      String response =null;
       PgCustomerRequestResponse pgCustomerRequestResponse =null;
       try {

           HttpHeaders headers = new HttpHeaders();
           headers.add(ApplicationConstants.HEADER_ACCEPT, MediaType.APPLICATION_JSON_VALUE);
           headers.add(ApplicationConstants.AUTHORIZATION, encodedToken);

           response = (String) RestCallChecker.callRestGetDataService(url,
                   MasterUtils.createRequest("getRazorPayCustomerDetails", headers), String.class, restTemplate, connTimeOut, readTimeOut);

           pgCustomerRequestResponse =  new ObjectMapper().readValue(response, PgCustomerRequestResponse.class);
           return pgCustomerRequestResponse;

       } catch (Exception e) {
           System.out.println(e.getMessage());
       }
       return pgCustomerRequestResponse;
    }

}
