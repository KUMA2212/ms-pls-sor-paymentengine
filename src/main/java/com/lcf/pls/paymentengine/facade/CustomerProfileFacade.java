package com.lcf.pls.paymentengine.facade;

import com.lcf.pls.paymentengine.dto.LCFCustomerProfileResponse;

public interface CustomerProfileFacade {
    LCFCustomerProfileResponse getCustomerProfieData(String customerId);

}
