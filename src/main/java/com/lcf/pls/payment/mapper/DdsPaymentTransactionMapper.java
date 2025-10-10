package com.lcf.pls.payment.mapper;

import com.lcf.pls.payment.common.ApplicationConstants;
import com.lcf.pls.payment.dto.*;
import com.lcf.pls.payment.schema.razorpay.request.*;
import org.springframework.util.ObjectUtils;

import java.time.Instant;

public class DdsPaymentTransactionMapper {

    public static DdsPaymentTransactionReqResDto setDdsPaymentLinkRequest(CreatePaymentLinkReqResDto paymentRequestDto) {
        DdsPaymentTransactionReqResDto request =null;

        if (!ObjectUtils.isEmpty(paymentRequestDto)) {

            request = new DdsPaymentTransactionReqResDto();

            request.setAmount(paymentRequestDto.getAmount());
            request.setCurrency(paymentRequestDto.getCurrency());
            request.setPayLinkId(paymentRequestDto.getPayLinkId());
            request.setReferenceId(paymentRequestDto.getReferenceId());
            request.setStatus(paymentRequestDto.getStatus().toUpperCase());
            request.setDescription(paymentRequestDto.getDescription());
            request.setCallbackUrl(paymentRequestDto.getCallbackUrl());
            request.setPaymentUrl(paymentRequestDto.getPaymentUrl());

            if (null != paymentRequestDto.getNotify() && null != paymentRequestDto.getCustomer()) {

                Notification notification = new Notification();

                notification.setSms(paymentRequestDto.getNotify().getSms());
                notification.setEmail(paymentRequestDto.getNotify().getEmail());
                notification.setWhatsapp(paymentRequestDto.getNotify().getWhatsapp());

                notification.setEmailId(paymentRequestDto.getCustomer().getEmail());
                notification.setCustomerName(paymentRequestDto.getCustomer().getName());
                notification.setMobileNo(paymentRequestDto.getCustomer().getContact());

                notification.setStatus(ApplicationConstants.NOTIFICATION_STATUS_PENDING);
                notification.setNextRetryDate(Instant.now().toString());
                notification.setRetryCount("0");
                request.setNotify(notification);
            }
        }
        return request;

    }
}
