package com.lcf.pls.payment.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Setter
@Getter
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties("dds.properties")
public class DdsPaymentProperties {

    private int connTimeout;
    private int readTimeout;

    private String createPaymentLinkUrl;
    private String paymentLinkUrl;

}
