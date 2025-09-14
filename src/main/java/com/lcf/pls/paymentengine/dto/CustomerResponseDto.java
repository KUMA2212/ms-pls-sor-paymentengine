package com.lcf.pls.paymentengine.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class CustomerResponseDto {

    @JsonProperty("customerId")
    private String customerId;

    @JsonProperty("emailId")
    private String emailId;

    @JsonProperty("customerName")
    private String customerName;

    @JsonProperty("contactNo")
    private String contactNo;

    @JsonProperty("creationDate")
    private String creationDate;

}
