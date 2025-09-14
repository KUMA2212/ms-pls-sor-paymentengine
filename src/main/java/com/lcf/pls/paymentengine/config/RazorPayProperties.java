package com.lcf.pls.paymentengine.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Setter
@Getter
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties("razorpay.properties")
public class RazorPayProperties {

    private String mid;
    private String midKey;
    private String url;

    private int connTimeout;
    private int readTimeout;
    private String getPgCustomerUrl;
    private String createPgCustomerUrl;
    private String createPgOrderUrl;
    private String createRefundUrl;
    private String getPgRefundUrl;
    private String getPgPaymentUrl;
    private String getPgOrderUrl;
    private String createPaymentLinkUrl;
    private String getPgPaymentLinkUrl;
}
