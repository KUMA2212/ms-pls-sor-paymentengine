package com.lcf.pls.paymentengine.controller;

import com.lcf.pls.paymentengine.common.ValidationHelper;
import com.lcf.pls.paymentengine.dto.*;
import com.lcf.pls.paymentengine.service.PgManagementService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/pls/sor/paymentengine")
public class PaymentGatewayController {

    private PgManagementService pgCustomerManagementService;

    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentGatewayController.class);

    @PostMapping(value = "/v1/gateway/createPgCustomer", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CustomerResponseDto> validateAndCreateCustomer(@RequestHeader Map<String, String> headers, @RequestBody CreateCustomerRequestDto customerRequest) {
        ValidationHelper.validateCreateCustomerRequestBody(customerRequest);
        CustomerResponseDto response = pgCustomerManagementService.createPGCustomer(customerRequest);
        return ResponseEntity.ok().body(response);

    }

    @GetMapping(value = "/v1/gateway/getPgCustomer/{customerId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CustomerResponseDto> findPGCustomerById(@RequestHeader Map<String, String> headers, @PathVariable String customerId) {
        LOGGER.info("customerId : {} ", customerId);
        ValidationHelper.validateRequestParameter(customerId);
        CustomerResponseDto response = pgCustomerManagementService.findPGCustomerById(customerId);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping(value = "/v1/gateway/createPgOrder", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CreateOrderResponseDto> createPgOrder(@RequestHeader Map<String, String> headers, @RequestBody CreateOrderRequestDto createOrderRequest) {
        ValidationHelper.validateCreateOrderRequestBody(createOrderRequest);
        CreateOrderResponseDto response = pgCustomerManagementService.createPGOrder(createOrderRequest);
        return ResponseEntity.ok().body(response);

    }

    @GetMapping(value = "/v1/gateway/getPgOrder/{orderId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CreateOrderResponseDto> findPGOrderById(@RequestHeader Map<String, String> headers, @PathVariable String orderId) {
        LOGGER.info("orderId : {} ", orderId);
        ValidationHelper.validateRequestParameter(orderId);
        CreateOrderResponseDto response = pgCustomerManagementService.findPGOrderById(orderId);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping(value = "/v1/gateway/createPgRefund", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CreateRefundReqResDto> createPgRefundByPaymentId(@RequestHeader Map<String, String> headers, @RequestBody CreateRefundReqResDto refundRequest) {
        LOGGER.info("paymentId : {} ", refundRequest.getPaymentId());
        ValidationHelper.validateRequestParameter(refundRequest.getPaymentId());
        CreateRefundReqResDto response = pgCustomerManagementService.createPgRefundByPaymentId(refundRequest);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping(value = "/v1/gateway/getPgRefund/{refundId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CreateRefundReqResDto> findPGRefundById(@RequestHeader Map<String, String> headers, @PathVariable String refundId) {
        LOGGER.info("refundId : {} ", refundId);
        ValidationHelper.validateRequestParameter(refundId);
        CreateRefundReqResDto response = pgCustomerManagementService.findPGRefundById(refundId);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping(value = "/v1/gateway/getPgPayment/{paymentId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<PaymentResponseDto> findPGPaymentById(@RequestHeader Map<String, String> headers, @PathVariable String paymentId) {
        LOGGER.info("paymentId : {} ", paymentId);

        ValidationHelper.validateRequestParameter(paymentId);
        PaymentResponseDto response = pgCustomerManagementService.findPGPaymentById(paymentId);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping(value = "/v1/gateway/createPgPaymentLink", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CreatePaymentLinkReqResDto> createPgPaymentLink(@RequestHeader Map<String, String> headers, @RequestBody CreatePaymentLinkReqResDto request) {
        CreatePaymentLinkReqResDto response = pgCustomerManagementService.createPgPaymentLink(request);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping(value = "/v1/gateway/getPgPaymentLink/{paymentLinkId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CreatePaymentLinkReqResDto> findPaymentByPayLinkId(@RequestHeader Map<String, String> headers, @PathVariable String paymentLinkId) {
        LOGGER.info("paymentLinkId : {} ", paymentLinkId);

        ValidationHelper.validateRequestParameter(paymentLinkId);
        CreatePaymentLinkReqResDto response = pgCustomerManagementService.findPaymentByPayLinkId(paymentLinkId);
        return ResponseEntity.ok().body(response);
    }

}
