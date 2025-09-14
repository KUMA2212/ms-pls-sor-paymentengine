package com.lcf.pls.paymentengine.mapper;

import com.lcf.pls.paymentengine.common.ApplicationConstants;
import com.lcf.pls.paymentengine.config.RazorPayProperties;
import com.lcf.pls.paymentengine.dto.*;
import com.lcf.pls.paymentengine.schema.razorpay.request.*;
import org.springframework.util.ObjectUtils;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class PgManagementMapper {

    public static CustomerResponseDto setPgCustomerResponse(PgCustomerRequestResponse pgCustomerRequestResponse) {
        CustomerResponseDto response = null;
        if (!ObjectUtils.isEmpty(pgCustomerRequestResponse)) {
            response = new CustomerResponseDto();
            response.setCustomerId(pgCustomerRequestResponse.getId());
            response.setCustomerName(pgCustomerRequestResponse.getName());
            response.setEmailId(pgCustomerRequestResponse.getEmail());
            response.setContactNo(pgCustomerRequestResponse.getContact());
            response.setCreationDate(DateTimeFormatter.ISO_INSTANT.format(Instant.ofEpochSecond(pgCustomerRequestResponse.getCreatedAt())));
        }
        return response;
    }

    public static String createPgUrl(String pgId, String customerUrl, String name) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(customerUrl);
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put(name, pgId);
        URI uri = builder.buildAndExpand(queryParams).toUri();
        return uri.toString();
    }

    public static PgCustomerRequestResponse setPgCustomerRequest(CreateCustomerRequestDto requestDto) {
        PgCustomerRequestResponse request = new PgCustomerRequestResponse();
        request.setName(requestDto.getCustomerName());
        request.setEmail(requestDto.getEmailId());
        request.setContact(requestDto.getMobileNo());
        return request;
    }

    public static PgOrderRequestResponse setPgOrderRequest(CreateOrderRequestDto oderRequest) {
        PgOrderRequestResponse pgOrderRequest = new PgOrderRequestResponse();
        pgOrderRequest.setAmount(oderRequest.getAmount() * ApplicationConstants.PAISE_AMOUNT);
        pgOrderRequest.setCurrency(oderRequest.getCurrency());
        pgOrderRequest.setReceipt(oderRequest.getReceipt());
        return pgOrderRequest;
    }

    public static CreateOrderResponseDto setPgOrderResponse(PgOrderRequestResponse pgOrderResponse) {
        CreateOrderResponseDto responseDto = null;
        if (!ObjectUtils.isEmpty(pgOrderResponse)) {
            responseDto = new CreateOrderResponseDto();
            responseDto.setOrderId(pgOrderResponse.getId());

            responseDto.setAmount(String.valueOf(pgOrderResponse.getAmount() / ApplicationConstants.PAISE_AMOUNT));
            responseDto.setReceipt(String.valueOf(pgOrderResponse.getReceipt()));
            responseDto.setCurrency(pgOrderResponse.getCurrency());
            responseDto.setStatus(pgOrderResponse.getStatus().toUpperCase());
            responseDto.setCreationDate(DateTimeFormatter.ISO_INSTANT.format(Instant.ofEpochSecond(pgOrderResponse.getCreatedAt())));

        }
        return responseDto;
    }

    public static PgRefundRequestResponse setPgRefundRequest(CreateRefundReqResDto refundRequest) {
        PgRefundRequestResponse pgRefundRequest = new PgRefundRequestResponse();
        pgRefundRequest.setAmount(Integer.parseInt(refundRequest.getAmount()) * ApplicationConstants.PAISE_AMOUNT);
        return pgRefundRequest;

    }

    public static CreateRefundReqResDto setPgRefundResponse(PgRefundRequestResponse pgRefundResponse) {
        CreateRefundReqResDto responseDto = null;
        if (!ObjectUtils.isEmpty(pgRefundResponse)) {

            responseDto = new CreateRefundReqResDto();
            responseDto.setRefundId(pgRefundResponse.getId());
            responseDto.setPaymentId(pgRefundResponse.getPaymentId());
            responseDto.setAmount(String.valueOf(pgRefundResponse.getAmount() / ApplicationConstants.PAISE_AMOUNT));
            responseDto.setReceipt(String.valueOf(pgRefundResponse.getReceipt()));
            responseDto.setCurrency(pgRefundResponse.getCurrency());
            responseDto.setStatus(pgRefundResponse.getStatus().toUpperCase());
            responseDto.setEntity(pgRefundResponse.getEntity().toUpperCase());
            responseDto.setCreationDate(DateTimeFormatter.ISO_INSTANT.format(Instant.ofEpochSecond(pgRefundResponse.getCreatedAt())));

        }
        return responseDto;
    }

    public static PaymentResponseDto setPgPaymentResponse(PgPaymentResponse pgPaymentResponse) {
        PaymentResponseDto responseDto = null;
        if (!ObjectUtils.isEmpty(pgPaymentResponse)) {

            responseDto = new PaymentResponseDto();

            responseDto.setPaymentId(pgPaymentResponse.getId());
            responseDto.setOrderId(pgPaymentResponse.getOrderId());
            responseDto.setAmount(String.valueOf(pgPaymentResponse.getAmount() / ApplicationConstants.PAISE_AMOUNT));
            responseDto.setCurrency(pgPaymentResponse.getCurrency());
            responseDto.setPaymentMethod(pgPaymentResponse.getMethod().toUpperCase());
            responseDto.setStatus(pgPaymentResponse.getStatus().toUpperCase());
            responseDto.setVpa(pgPaymentResponse.getVpa());
            responseDto.setEntity(pgPaymentResponse.getEntity().toUpperCase());
            responseDto.setCreationDate(DateTimeFormatter.ISO_INSTANT.format(Instant.ofEpochSecond(pgPaymentResponse.getCreatedAt())));

        }
        return responseDto;
    }

    public static PgPaymentLinkRequestResponse setPgPaymentLinkRequest(CreatePaymentLinkReqResDto paymentRequestDto) {
        PgPaymentLinkRequestResponse linkRequest = new PgPaymentLinkRequestResponse();

        linkRequest.setAmount(paymentRequestDto.getAmount() * ApplicationConstants.PAISE_AMOUNT);
        linkRequest.setCurrency(paymentRequestDto.getCurrency());
        linkRequest.setAcceptPartial(paymentRequestDto.isAcceptPartialPayment());
        linkRequest.setExpireBy(Integer.parseInt(paymentRequestDto.getPLinkExpireDateTime()));
        linkRequest.setReferenceId(paymentRequestDto.getReferenceId());
        linkRequest.setDescription(paymentRequestDto.getDescription());
        linkRequest.setCallbackUrl(paymentRequestDto.getCallbackUrl());
        linkRequest.setCallbackMethod(paymentRequestDto.getCallbackMethod().toLowerCase());

        Notify notify = new Notify();

        notify.setSms(paymentRequestDto.getNotify().getSms());
        notify.setEmail(paymentRequestDto.getNotify().getEmail());
        notify.setWhatsapp(paymentRequestDto.getNotify().getWhatsapp());
        linkRequest.setNotify(notify);

        Customer customer = new Customer();
        customer.setName(paymentRequestDto.getCustomer().getName());
        customer.setEmail(paymentRequestDto.getCustomer().getEmail());
        customer.setContact(paymentRequestDto.getCustomer().getContact());
        linkRequest.setCustomer(customer);
        return linkRequest;
    }

    public static CreatePaymentLinkReqResDto setPgPaymentLinkResponse(PgPaymentLinkRequestResponse pgPaymentLinkResponse) {
        CreatePaymentLinkReqResDto linkResDto = null;

        if (!ObjectUtils.isEmpty(pgPaymentLinkResponse)) {

            linkResDto = new CreatePaymentLinkReqResDto();

            linkResDto.setAmount(pgPaymentLinkResponse.getAmount() / ApplicationConstants.PAISE_AMOUNT);
            linkResDto.setCurrency(pgPaymentLinkResponse.getCurrency());
            linkResDto.setPayLinkId(pgPaymentLinkResponse.getId());
            linkResDto.setReferenceId(pgPaymentLinkResponse.getReferenceId());
            linkResDto.setStatus(pgPaymentLinkResponse.getStatus().toUpperCase());
            linkResDto.setDescription(pgPaymentLinkResponse.getDescription());
            linkResDto.setCallbackUrl(pgPaymentLinkResponse.getCallbackUrl());
            linkResDto.setPaymentUrl(pgPaymentLinkResponse.getShortUrl());
            if (null != pgPaymentLinkResponse.getNotify()) {
                Notify notify = new Notify();

                notify.setSms(pgPaymentLinkResponse.getNotify().getSms());
                notify.setEmail(pgPaymentLinkResponse.getNotify().getEmail());
                notify.setWhatsapp(pgPaymentLinkResponse.getNotify().getWhatsapp());
                linkResDto.setNotify(notify);
            }

            if (null != pgPaymentLinkResponse.getCustomer()) {
                Customer customer = new Customer();

                customer.setName(pgPaymentLinkResponse.getCustomer().getName());
                customer.setEmail(pgPaymentLinkResponse.getCustomer().getEmail());
                customer.setContact(pgPaymentLinkResponse.getCustomer().getContact());
                linkResDto.setCustomer(customer);
            }
        }
        return linkResDto;
    }
}
