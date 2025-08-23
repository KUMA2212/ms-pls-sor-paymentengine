package com.lcf.pls.paymentengine.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.OffsetDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class CreatePaymentRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("mobile")
    private Long mobile;

    @JsonProperty("customer_id")
    private String customer_id;

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("email")
    private String email;

    @JsonProperty("transactionType")
    private TransactionTypeEnum transactionType;

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

    @JsonProperty("amount")
    private String amount;

    public enum TransactionTypeEnum {
        MONTHLY("MONTHLY"),

        QUARTERLY("QUARTERLY"),

        ANNUAL("ANNUAL");
        private String value;

        TransactionTypeEnum(String value) {
            this.value = value;
        }
    }
}
