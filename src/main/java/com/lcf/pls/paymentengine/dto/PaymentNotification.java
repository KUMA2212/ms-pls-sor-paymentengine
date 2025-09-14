package com.lcf.pls.paymentengine.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class PaymentNotification {

    @JsonProperty("sms")
    private boolean sms;

    @JsonProperty("email")
    private boolean email;

    @JsonProperty("whatsapp")
    private boolean whatsapp;
}
