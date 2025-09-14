package com.lcf.pls.paymentengine.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lcf.pls.paymentengine.schema.razorpay.request.Customer;
import com.lcf.pls.paymentengine.schema.razorpay.request.Notify;
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
public class CreatePaymentLinkReqResDto {

    @JsonProperty("amount")
    private Integer amount;

    @JsonProperty("currency")
    private String currency;

    @JsonProperty("receipt")
    private String receipt;

    @JsonProperty("acceptPartialPayment")
    private boolean acceptPartialPayment;

    @JsonProperty("minPartialAmount")
    private Integer minPartialAmount;

    @JsonProperty("PLinkExpireDateTime")
    private String PLinkExpireDateTime;

    @JsonProperty("referenceId")
    private String referenceId;

    @JsonProperty("description")
    private String description;

    @JsonProperty("callbackUrl")
    private String callbackUrl;

    @JsonProperty("callbackMethod")
    private String callbackMethod;

    @JsonProperty("customer")
    private Customer customer;

    @JsonProperty("notify")
    private Notify notify;

    @JsonProperty("amountPaid")
    private String amountPaid;

    @JsonProperty("payLinkCreationDateTime")
    private String payLinkCreationDateTime;

    @JsonProperty("payLinkId")
    private String payLinkId;

    @JsonProperty("status")
    private String status;

    @JsonProperty("paymentUrl")
    private String paymentUrl;
}
