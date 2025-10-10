package com.lcf.pls.payment.manager;


import com.lcf.pls.payment.config.PaymentGatewayProperties;
import com.lcf.pls.payment.dto.CreatePaymentLinkReqResDto;
import com.lcf.pls.payment.dto.DdsPaymentTransactionReqResDto;
import com.lcf.pls.payment.facade.DdsPaymentFacade;
import com.lcf.pls.payment.mapper.DdsPaymentTransactionMapper;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DdsPaymentTransactionManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(DdsPaymentTransactionManager.class);

    private DdsPaymentFacade ddsPaymentFacade;
    private PaymentGatewayProperties DdsPaymentProperties;

    public DdsPaymentTransactionReqResDto savePaymentLinkDetailsInDds(CreatePaymentLinkReqResDto response) {

        System.out.println("response ::1");
        DdsPaymentTransactionReqResDto request = DdsPaymentTransactionMapper.setDdsPaymentLinkRequest(response);
        System.out.println("response ::2");
      return ddsPaymentFacade.savePaymentTransLinkDetailsInDds(DdsPaymentProperties.getPaymentLinkUrl(), DdsPaymentProperties.getConnTimeout(), DdsPaymentProperties.getReadTimeout(), request);
    }
}
