package com.lcf.pls.payment.dto;


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
public class Notification {

    @JsonProperty("sms")
    private Boolean sms;

    @JsonProperty("email")
    private Boolean email;

    @JsonProperty("whatsapp")
    private Boolean whatsapp;

    @JsonProperty("customerName")
    private String customerName;

    @JsonProperty("MobileNo")
    private String MobileNo;

    @JsonProperty("emailId")
    private String emailId;

    @JsonProperty("status")
    private String status;

    @JsonProperty("nextRetryDate")
    private String nextRetryDate;

    @JsonProperty("retryCount")
    private String retryCount;

}
