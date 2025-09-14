package com.lcf.pls.paymentengine.facade;

import com.lcf.pls.paymentengine.schema.razorpay.request.*;

public interface PgManagementFacade {

    PgCustomerRequestResponse getRpCustomer(String url, int connTimeOut, int readTimeOut, String encodedToken);

    PgCustomerRequestResponse createRpCustomer(String url, int connTimeOut, int readTimeOut, String encodedToken, PgCustomerRequestResponse request);

    PgOrderRequestResponse createPGOrder(String url, int connTimeOut, int readTimeOut, String encodedToken, PgOrderRequestResponse request);

    PgRefundRequestResponse createPgRefundByPaymentId(String url, int connTimeOut, int readTimeOut, String encodedToken, PgRefundRequestResponse request);

    PgRefundRequestResponse findPGRefundById(String url, int connTimeOut, int readTimeOut, String encodedToken);

    PgPaymentResponse findPGPaymentById(String url, int connTimeOut, int readTimeOut, String encodedToken);

    PgOrderRequestResponse findPGOrderById(String url, int connTimeOut, int readTimeOut, String encodedToken);

    PgPaymentLinkRequestResponse createPgPaymentLink(String url, int connTimeOut, int readTimeOut, String encodedToken, PgPaymentLinkRequestResponse request);

    PgPaymentLinkRequestResponse findPaymentByPayLinkId(String url, int connTimeOut, int readTimeOut, String encodedToken);

}