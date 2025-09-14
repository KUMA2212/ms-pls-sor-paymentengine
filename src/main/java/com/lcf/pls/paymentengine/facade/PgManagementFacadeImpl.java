package com.lcf.pls.paymentengine.facade;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lcf.pls.paymentengine.common.ApplicationConstants;
import com.lcf.pls.paymentengine.schema.razorpay.request.*;
import com.lcf.pls.paymentengine.utils.MasterUtils;
import com.lcf.pls.paymentengine.utils.RestCallChecker;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class PgManagementFacadeImpl implements PgManagementFacade {
    private RestTemplate restTemplate;

    public PgCustomerRequestResponse getRpCustomer(String url, int connTimeOut, int readTimeOut, String encodedToken) {
        String response = null;
        PgCustomerRequestResponse pgCustomerRequestResponse = null;
        try {

            HttpHeaders headers = new HttpHeaders();
            headers.add(ApplicationConstants.HEADER_ACCEPT, MediaType.APPLICATION_JSON_VALUE);
            headers.add(ApplicationConstants.AUTHORIZATION, encodedToken);

            response = (String) RestCallChecker.callRestGetService(url,
                    MasterUtils.createRequest("getRazorPayCustomerDetails", headers), String.class, restTemplate, connTimeOut, readTimeOut);

            pgCustomerRequestResponse = new ObjectMapper().readValue(response, PgCustomerRequestResponse.class);
            return pgCustomerRequestResponse;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return pgCustomerRequestResponse;
    }

    public PgCustomerRequestResponse createRpCustomer(String url, int connTimeOut, int readTimeOut, String encodedToken, PgCustomerRequestResponse request) {
        String response = null;
        PgCustomerRequestResponse pgCustomerRequestResponse = null;
        try {

            HttpHeaders headers = new HttpHeaders();
            headers.add(ApplicationConstants.HEADER_ACCEPT, MediaType.APPLICATION_JSON_VALUE);
            headers.add(ApplicationConstants.AUTHORIZATION, encodedToken);

            response = (String) RestCallChecker.callRestPostService(url,
                    MasterUtils.createRequest(request, headers), String.class, restTemplate, connTimeOut, readTimeOut);

            pgCustomerRequestResponse = new ObjectMapper().readValue(response, PgCustomerRequestResponse.class);
            return pgCustomerRequestResponse;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return pgCustomerRequestResponse;
    }

    @Override
    public PgOrderRequestResponse createPGOrder(String url, int connTimeOut, int readTimeOut, String encodedToken, PgOrderRequestResponse request) {
        String response = null;
        PgOrderRequestResponse pgOrderRequestResponse = null;
        try {

            HttpHeaders headers = new HttpHeaders();
            headers.add(ApplicationConstants.HEADER_ACCEPT, MediaType.APPLICATION_JSON_VALUE);
            headers.add(ApplicationConstants.AUTHORIZATION, encodedToken);

            response = (String) RestCallChecker.callRestPostService(url,
                    MasterUtils.createRequest(request, headers), String.class, restTemplate, connTimeOut, readTimeOut);

            pgOrderRequestResponse = new ObjectMapper().readValue(response, PgOrderRequestResponse.class);
            return pgOrderRequestResponse;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return pgOrderRequestResponse;
    }

    @Override
    public PgRefundRequestResponse createPgRefundByPaymentId(String url, int connTimeOut, int readTimeOut, String encodedToken, PgRefundRequestResponse request) {

        String response = null;
        PgRefundRequestResponse pgResponse = null;
        try {

            HttpHeaders headers = new HttpHeaders();
            headers.add(ApplicationConstants.HEADER_ACCEPT, MediaType.APPLICATION_JSON_VALUE);
            headers.add(ApplicationConstants.AUTHORIZATION, encodedToken);

            response = (String) RestCallChecker.callRestPostService(url,
                    MasterUtils.createRequest(request, headers), String.class, restTemplate, connTimeOut, readTimeOut);

            pgResponse = new ObjectMapper().readValue(response, PgRefundRequestResponse.class);
            return pgResponse;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return pgResponse;
    }

    @Override
    public PgRefundRequestResponse findPGRefundById(String url, int connTimeOut, int readTimeOut, String encodedToken) {
        String response = null;
        PgRefundRequestResponse pgResponse = null;
        try {

            HttpHeaders headers = new HttpHeaders();
            headers.add(ApplicationConstants.HEADER_ACCEPT, MediaType.APPLICATION_JSON_VALUE);
            headers.add(ApplicationConstants.AUTHORIZATION, encodedToken);

            response = (String) RestCallChecker.callRestGetService(url,
                    MasterUtils.createRequest("getRazorPayRefundDetails", headers), String.class, restTemplate, connTimeOut, readTimeOut);

            pgResponse = new ObjectMapper().readValue(response, PgRefundRequestResponse.class);
            return pgResponse;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return pgResponse;
    }

    @Override
    public PgPaymentResponse findPGPaymentById(String url, int connTimeOut, int readTimeOut, String encodedToken) {
        String response = null;
        PgPaymentResponse pgResponse = null;
        try {

            HttpHeaders headers = new HttpHeaders();
            headers.add(ApplicationConstants.HEADER_ACCEPT, MediaType.APPLICATION_JSON_VALUE);
            headers.add(ApplicationConstants.AUTHORIZATION, encodedToken);

            response = (String) RestCallChecker.callRestGetService(url,
                    MasterUtils.createRequest("getRazorPayPaymentDetails", headers), String.class, restTemplate, connTimeOut, readTimeOut);

            pgResponse = new ObjectMapper().readValue(response, PgPaymentResponse.class);
            return pgResponse;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return pgResponse;
    }

    @Override
    public PgOrderRequestResponse findPGOrderById(String url, int connTimeOut, int readTimeOut, String encodedToken) {
        String response = null;
        PgOrderRequestResponse pgResponse = null;
        try {

            HttpHeaders headers = new HttpHeaders();
            headers.add(ApplicationConstants.HEADER_ACCEPT, MediaType.APPLICATION_JSON_VALUE);
            headers.add(ApplicationConstants.AUTHORIZATION, encodedToken);

            response = (String) RestCallChecker.callRestGetService(url,
                    MasterUtils.createRequest("getRazorPayOrderDetails", headers), String.class, restTemplate, connTimeOut, readTimeOut);

            pgResponse = new ObjectMapper().readValue(response, PgOrderRequestResponse.class);
            return pgResponse;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return pgResponse;
    }

    @Override
    public PgPaymentLinkRequestResponse createPgPaymentLink(String url, int connTimeOut, int readTimeOut, String encodedToken, PgPaymentLinkRequestResponse request) {
        String response = null;
        PgPaymentLinkRequestResponse requestResponse = null;
        try {

            HttpHeaders headers = new HttpHeaders();
            headers.add(ApplicationConstants.HEADER_ACCEPT, MediaType.APPLICATION_JSON_VALUE);
            headers.add(ApplicationConstants.AUTHORIZATION, encodedToken);

            response = (String) RestCallChecker.callRestPostService(url,
                    MasterUtils.createRequest(request, headers), String.class, restTemplate, connTimeOut, readTimeOut);

            requestResponse = new ObjectMapper().readValue(response, PgPaymentLinkRequestResponse.class);
            return requestResponse;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return requestResponse;
    }

    @Override
    public PgPaymentLinkRequestResponse findPaymentByPayLinkId(String url, int connTimeOut, int readTimeOut, String encodedToken) {
        String response = null;
        PgPaymentLinkRequestResponse pgResponse = null;
        try {

            HttpHeaders headers = new HttpHeaders();
            headers.add(ApplicationConstants.HEADER_ACCEPT, MediaType.APPLICATION_JSON_VALUE);
            headers.add(ApplicationConstants.AUTHORIZATION, encodedToken);

            response = (String) RestCallChecker.callRestGetService(url,
                    MasterUtils.createRequest("getRazorPayPaymentLinkDetails", headers), String.class, restTemplate, connTimeOut, readTimeOut);

            pgResponse = new ObjectMapper().readValue(response, PgPaymentLinkRequestResponse.class);
            return pgResponse;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return pgResponse;
    }
}
