package com.lcf.pls.paymentengine.dto;

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

    private String getCustomerUrl;
    private int connTimeout;
    private int readTimeout;
    private String mid;
    private String midKey;


}
