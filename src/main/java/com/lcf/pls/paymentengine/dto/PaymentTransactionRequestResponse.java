package com.lcf.pls.paymentengine.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lcf.pls.paymentengine.models.AmountType;
import lombok.*;

import java.time.OffsetDateTime;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class PaymentTransactionRequestResponse {

    @JsonProperty("customer_id")
    private String customer_id;

    @JsonProperty("birthDate")
    private String birthDate;

    @JsonProperty("insertedRecordDate")
    private OffsetDateTime insertedRecordDate;

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("middleName")
    private String middleName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("billCycleDate")
    private OffsetDateTime billCycleDate;

    @JsonProperty("channel")
    private String channel;

    @JsonProperty("pinCodeID")
    private String pinCodeID;

    @JsonProperty("serviceType")
    private String serviceType;

    @JsonProperty("mobile")
    private String mobile;

    @JsonProperty("totalAmount")
    private AmountType totalAmount;

    @JsonProperty("paymentDate")
    private OffsetDateTime paymentDate;

    @JsonProperty("description")
    private String description;

    @JsonProperty("paymentGateway")
    private String paymentGateway;

    @JsonProperty("paymentGatewayId")
    private String paymentGatewayId;

    @JsonProperty("billDate")
    private String billDate;

    @JsonProperty("nextBillDate")
    private String nextBillDate;

    @JsonProperty("transactionType")
    private String transactionType;

    @JsonProperty("amount")
    private String amount;

    @JsonProperty("pgTransactionStatus")
    private String pgTransactionStatus;

    @JsonProperty("pgOrderCreationDate")
    private String pgOrderCreationDate;

    @JsonProperty("pgOrderId")
    private String pgOrderId;

}
