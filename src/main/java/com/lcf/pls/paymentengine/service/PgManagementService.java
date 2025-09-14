package com.lcf.pls.paymentengine.service;

import com.lcf.pls.paymentengine.dto.*;
import com.lcf.pls.paymentengine.manager.PgCustomerManagementManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PgManagementService {
    private PgCustomerManagementManager pgCustomerManagementManager;

    public CustomerResponseDto findPGCustomerById(String customerId) {

        return pgCustomerManagementManager.findPGCustomerById(customerId);
    }

    public CustomerResponseDto createPGCustomer(CreateCustomerRequestDto createCustomerRequest) {

        return pgCustomerManagementManager.createPGCustomer(createCustomerRequest);
    }

    public CreateOrderResponseDto createPGOrder(CreateOrderRequestDto createOrderRequest) {

        return pgCustomerManagementManager.createPGOrder(createOrderRequest);
    }

    public CreateRefundReqResDto createPgRefundByPaymentId(CreateRefundReqResDto refundRequest) {

        return pgCustomerManagementManager.createPgRefundByPaymentId(refundRequest);
    }

    public CreateRefundReqResDto findPGRefundById(String refundId) {

        return pgCustomerManagementManager.findPGRefundById(refundId);
    }

    public PaymentResponseDto findPGPaymentById(String paymentId) {

        return pgCustomerManagementManager.findPGPaymentById(paymentId);
    }

    public CreateOrderResponseDto findPGOrderById(String orderId) {

        return pgCustomerManagementManager.findPGOrderById(orderId);
    }

    public CreatePaymentLinkReqResDto createPgPaymentLink(CreatePaymentLinkReqResDto request) {

        return pgCustomerManagementManager.createPgPaymentLink(request);
    }

    public CreatePaymentLinkReqResDto findPaymentByPayLinkId(String payLinkId) {

        return pgCustomerManagementManager.findPaymentByPayLinkId(payLinkId);
    }

}
