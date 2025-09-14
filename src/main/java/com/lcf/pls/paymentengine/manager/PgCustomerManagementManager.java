package com.lcf.pls.paymentengine.manager;


import com.lcf.pls.paymentengine.common.ApplicationConstants;
import com.lcf.pls.paymentengine.common.ValidationHelper;
import com.lcf.pls.paymentengine.dto.*;
import com.lcf.pls.paymentengine.config.RazorPayProperties;
import com.lcf.pls.paymentengine.facade.PgManagementFacade;
import com.lcf.pls.paymentengine.mapper.PgManagementMapper;
import com.lcf.pls.paymentengine.schema.razorpay.request.*;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PgCustomerManagementManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(PgCustomerManagementManager.class);

    private PgManagementFacade pgCustomerManagementFacade;
    private RazorPayProperties razorPayProperties;

    public CustomerResponseDto findPGCustomerById(String customerId) {

        String encodedToken = ValidationHelper.validateAndGetEncodedToken(razorPayProperties.getMid(), razorPayProperties.getMidKey());
        String baseUrl = razorPayProperties.getUrl().concat(razorPayProperties.getGetPgCustomerUrl());
        String pgCustomerUrl = PgManagementMapper.createPgUrl(customerId, baseUrl, ApplicationConstants.CUSTOMER_ID);
        PgCustomerRequestResponse pgCustomerRequestResponse = pgCustomerManagementFacade.getRpCustomer(pgCustomerUrl, razorPayProperties.getConnTimeout(), razorPayProperties.getReadTimeout(), encodedToken);

        return PgManagementMapper.setPgCustomerResponse(pgCustomerRequestResponse);
    }

    public CustomerResponseDto createPGCustomer(CreateCustomerRequestDto customerRequest) {
        String encodedToken = ValidationHelper.validateAndGetEncodedToken(razorPayProperties.getMid(), razorPayProperties.getMidKey());
        LOGGER.info("encodedToken ::{}", encodedToken);

        String baseUrl = razorPayProperties.getUrl().concat(razorPayProperties.getCreatePgCustomerUrl());
        PgCustomerRequestResponse request = PgManagementMapper.setPgCustomerRequest(customerRequest);

        PgCustomerRequestResponse response = pgCustomerManagementFacade.createRpCustomer(baseUrl, razorPayProperties.getConnTimeout(), razorPayProperties.getReadTimeout(), encodedToken, request);
        return PgManagementMapper.setPgCustomerResponse(response);
    }

    public CreateOrderResponseDto createPGOrder(CreateOrderRequestDto orderRequest) {
        String encodedToken = ValidationHelper.validateAndGetEncodedToken(razorPayProperties.getMid(), razorPayProperties.getMidKey());
        LOGGER.info("encodedToken ::{}", encodedToken);

        String baseUrl = razorPayProperties.getUrl().concat(razorPayProperties.getCreatePgOrderUrl());
        PgOrderRequestResponse request = PgManagementMapper.setPgOrderRequest(orderRequest);

        PgOrderRequestResponse response = pgCustomerManagementFacade.createPGOrder(baseUrl, razorPayProperties.getConnTimeout(), razorPayProperties.getReadTimeout(), encodedToken, request);
        return PgManagementMapper.setPgOrderResponse(response);
    }

    public CreateRefundReqResDto createPgRefundByPaymentId(CreateRefundReqResDto refundRequest) {

        String encodedToken = ValidationHelper.validateAndGetEncodedToken(razorPayProperties.getMid(), razorPayProperties.getMidKey());
        String baseUrl = razorPayProperties.getUrl().concat(razorPayProperties.getCreateRefundUrl());
        String pgRefundUrl = PgManagementMapper.createPgUrl(refundRequest.getPaymentId(), baseUrl, ApplicationConstants.PAYMENT_ID);

        PgRefundRequestResponse pgRequest = PgManagementMapper.setPgRefundRequest(refundRequest);

        PgRefundRequestResponse pgResponse = pgCustomerManagementFacade.createPgRefundByPaymentId(pgRefundUrl, razorPayProperties.getConnTimeout(), razorPayProperties.getReadTimeout(), encodedToken, pgRequest);
        return PgManagementMapper.setPgRefundResponse(pgResponse);
    }

    public CreateRefundReqResDto findPGRefundById(String refundId) {

        String encodedToken = ValidationHelper.validateAndGetEncodedToken(razorPayProperties.getMid(), razorPayProperties.getMidKey());
        String baseUrl = razorPayProperties.getUrl().concat(razorPayProperties.getGetPgRefundUrl());

        String pgRefundUrl = PgManagementMapper.createPgUrl(refundId, baseUrl, ApplicationConstants.REFUND_ID);
        PgRefundRequestResponse pgResponse = pgCustomerManagementFacade.findPGRefundById(pgRefundUrl, razorPayProperties.getConnTimeout(), razorPayProperties.getReadTimeout(), encodedToken);

        return PgManagementMapper.setPgRefundResponse(pgResponse);
    }

    public PaymentResponseDto findPGPaymentById(String paymentId) {

        String encodedToken = ValidationHelper.validateAndGetEncodedToken(razorPayProperties.getMid(), razorPayProperties.getMidKey());
        String baseUrl = razorPayProperties.getUrl().concat(razorPayProperties.getGetPgPaymentUrl());

        String pgPaymentUrl = PgManagementMapper.createPgUrl(paymentId, baseUrl, ApplicationConstants.PAYMENT_ID);
        PgPaymentResponse pgResponse = pgCustomerManagementFacade.findPGPaymentById(pgPaymentUrl, razorPayProperties.getConnTimeout(), razorPayProperties.getReadTimeout(), encodedToken);

        return PgManagementMapper.setPgPaymentResponse(pgResponse);
    }

    public CreateOrderResponseDto findPGOrderById(String orderId) {

        String encodedToken = ValidationHelper.validateAndGetEncodedToken(razorPayProperties.getMid(), razorPayProperties.getMidKey());
        String baseUrl = razorPayProperties.getUrl().concat(razorPayProperties.getGetPgOrderUrl());

        String pgOrderUrl = PgManagementMapper.createPgUrl(orderId, baseUrl, ApplicationConstants.ORDER_ID);
        PgOrderRequestResponse pgResponse = pgCustomerManagementFacade.findPGOrderById(pgOrderUrl, razorPayProperties.getConnTimeout(), razorPayProperties.getReadTimeout(), encodedToken);

        return PgManagementMapper.setPgOrderResponse(pgResponse);
    }

    public CreatePaymentLinkReqResDto createPgPaymentLink(CreatePaymentLinkReqResDto paymentRequest) {

        String encodedToken = ValidationHelper.validateAndGetEncodedToken(razorPayProperties.getMid(), razorPayProperties.getMidKey());
        String baseUrl = razorPayProperties.getUrl().concat(razorPayProperties.getCreatePaymentLinkUrl());

        PgPaymentLinkRequestResponse request = PgManagementMapper.setPgPaymentLinkRequest(paymentRequest);

        PgPaymentLinkRequestResponse response = pgCustomerManagementFacade.createPgPaymentLink(baseUrl, razorPayProperties.getConnTimeout(), razorPayProperties.getReadTimeout(), encodedToken, request);

        return PgManagementMapper.setPgPaymentLinkResponse(response);

    }

    public CreatePaymentLinkReqResDto findPaymentByPayLinkId(String payLinkId) {

        String encodedToken = ValidationHelper.validateAndGetEncodedToken(razorPayProperties.getMid(), razorPayProperties.getMidKey());
        String baseUrl = razorPayProperties.getUrl().concat(razorPayProperties.getGetPgPaymentLinkUrl());

        String pgOrderUrl = PgManagementMapper.createPgUrl(payLinkId, baseUrl, ApplicationConstants.PAYMENT_LINK_ID);
        PgPaymentLinkRequestResponse pgResponse = pgCustomerManagementFacade.findPaymentByPayLinkId(pgOrderUrl, razorPayProperties.getConnTimeout(), razorPayProperties.getReadTimeout(), encodedToken);

        return PgManagementMapper.setPgPaymentLinkResponse(pgResponse);
    }
}
