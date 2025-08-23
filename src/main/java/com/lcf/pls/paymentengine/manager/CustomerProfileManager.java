package com.lcf.pls.paymentengine.manager;

import com.lcf.pls.paymentengine.dto.LCFCustomerProfileResponse;
import com.lcf.pls.paymentengine.facade.CustomerProfileFacade;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerProfileManager {
    private CustomerProfileFacade customerProfileFacade;

    public LCFCustomerProfileResponse getCustomerProfileData(String customerId) {
        return customerProfileFacade.getCustomerProfieData(customerId);
    }

}
