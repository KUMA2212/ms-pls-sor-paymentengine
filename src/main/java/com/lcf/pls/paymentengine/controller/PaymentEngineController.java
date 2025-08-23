package com.lcf.pls.paymentengine.controller;

import com.lcf.pls.paymentengine.dto.PgCustomerResponse;
import com.lcf.pls.paymentengine.factory.PaymentApiFactoryBuilder;
import com.lcf.pls.paymentengine.service.PgCustomerManagementService;
import com.lcf.pls.paymentengine.utils.LCFRequestHeaders;
import com.lcf.pls.paymentengine.utils.MasterUtils;
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
public class PaymentEngineController {

    private final PaymentApiFactoryBuilder paymentApiFactoryBuilder;
    private MasterUtils masterUtils;
    private PgCustomerManagementService pgCustomerManagementService;

    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentEngineController.class);
    @GetMapping(value = "/v1/payment/getPgCustomer/{customerId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<PgCustomerResponse> findPGCustomerById(@RequestHeader Map<String, String> headers, @PathVariable String customerId) {

        LOGGER.info("customerId : {} ", customerId);
        MasterUtils.validateCustomerId(customerId);
        LCFRequestHeaders lcfHeaders = masterUtils.validateAndSetHeaders(headers);
        PgCustomerResponse response = pgCustomerManagementService.findPGCustomerById(customerId, lcfHeaders);
        return ResponseEntity.ok().body(response);
    }
}
