package com.lcf.pls.paymentengine.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Setter
@Getter
@ToString
public class CreateRefundReqResDto {

    @JsonProperty("paymentId")
    public String paymentId;

    @JsonProperty("entity")
    public String entity;

    @JsonProperty("refundId")
    public String refundId;

    @JsonProperty("orderId")
    public String orderId;

    @JsonProperty("amount")
    public String amount;

    @JsonProperty("currency")
    public String currency;

    @JsonProperty("status")
    public String status;

    @JsonProperty("creationDate")
    public String creationDate;

    @JsonProperty("receipt")
    public String receipt;


}
