package com.lcf.pls.paymentengine.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class PgCustomerResponse {

    @JsonProperty("customerId")
    private String customerId;

    @JsonProperty("emailId")
    private String emailId;

    @JsonProperty("customerName")
    private String customerName;

    @JsonProperty("contactNo")
    private String contactNo;

    @JsonProperty("customerCreationDate")
    private OffsetDateTime customerCreationDate;

    @JsonProperty("otherDetails")
    private List<Object> otherDetails =null;
}
