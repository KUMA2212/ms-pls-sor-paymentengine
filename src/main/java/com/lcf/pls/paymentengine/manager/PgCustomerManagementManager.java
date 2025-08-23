package com.lcf.pls.paymentengine.manager;

import com.lcf.pls.paymentengine.common.ApplicationConstants;
import com.lcf.pls.paymentengine.dto.PgCustomerResponse;
import com.lcf.pls.paymentengine.dto.RazorPayProperties;
import com.lcf.pls.paymentengine.facade.PgCustomerManagementFacade;
import com.lcf.pls.paymentengine.mapper.PgCustomerManagementMapper;
import com.lcf.pls.paymentengine.schema.razorpay.request.PgCustomerRequestResponse;
import com.lcf.pls.paymentengine.utils.LCFRequestHeaders;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Base64;

@Service
@AllArgsConstructor
public class PgCustomerManagementManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(PgCustomerManagementManager.class);

    private PgCustomerManagementFacade pgCustomerManagementFacade;
    private RazorPayProperties  razorPayProperties;

    public PgCustomerResponse findPGCustomerById(String customerId ) {
        String encodedToken = validateAndGetEncodedToken();
        LOGGER.info("encodedToken ::{}",encodedToken);
        String url = PgCustomerManagementMapper.createPgCustomerUrl(customerId, razorPayProperties.getGetCustomerUrl());
        LOGGER.info("URL ::{}",url);
        PgCustomerRequestResponse pgCustomerRequestResponse = pgCustomerManagementFacade.getRpCustomer(url, razorPayProperties.getConnTimeout(), razorPayProperties.getReadTimeout(),encodedToken);
        return PgCustomerManagementMapper.setPgCustomerResponse(pgCustomerRequestResponse);
    }

    private String validateAndGetEncodedToken() {

        String mid = razorPayProperties.getMid();
        String midKey = razorPayProperties.getMidKey();

        if (!ObjectUtils.isEmpty(mid) && !ObjectUtils.isEmpty(midKey)) {
            String apiKey = mid + ":" + midKey;
            return ApplicationConstants.BASIC + Base64.getEncoder().encodeToString(apiKey.getBytes());
        } else {
          throw new RuntimeException("mid");
        }
    }
}
