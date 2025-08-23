package com.lcf.pls.paymentengine.service;

import com.lcf.pls.paymentengine.dto.PgCustomerResponse;
import com.lcf.pls.paymentengine.manager.PgCustomerManagementManager;
import com.lcf.pls.paymentengine.utils.LCFRequestHeaders;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PgCustomerManagementService {
private PgCustomerManagementManager pgCustomerManagementManager;

    public PgCustomerResponse findPGCustomerById(String customerId) {
        return  pgCustomerManagementManager.findPGCustomerById(customerId);
    }
}
