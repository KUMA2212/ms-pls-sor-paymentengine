package com.lcf.pls.paymentengine.utils;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class RequestHeaders {

    private String authorization;
    private String contentType;
    private String channel;
    private String pinCodeID;
    private String serviceType;

}
