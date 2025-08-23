package com.lcf.pls.paymentengine.facade;

import com.lcf.pls.paymentengine.schema.razorpay.request.PgCustomerRequestResponse;
import com.lcf.pls.paymentengine.utils.LCFRequestHeaders;

public interface PgCustomerManagementFacade {
     PgCustomerRequestResponse getCustomer(String url, LCFRequestHeaders requestHeaders ,int connTimeOut,int readTimeOut ,String encodedToken);

}
