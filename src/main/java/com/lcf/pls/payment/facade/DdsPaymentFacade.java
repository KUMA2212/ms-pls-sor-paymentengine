package com.lcf.pls.payment.facade;

import com.lcf.pls.payment.dto.DdsPaymentTransactionReqResDto;

public interface DdsPaymentFacade {
    DdsPaymentTransactionReqResDto savePaymentTransLinkDetailsInDds(String url, int connTimeOut, int readTimeOut, DdsPaymentTransactionReqResDto request);

}