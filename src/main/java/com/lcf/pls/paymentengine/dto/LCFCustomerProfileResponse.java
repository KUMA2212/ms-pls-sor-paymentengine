package com.lcf.pls.paymentengine.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.OffsetDateTime;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class LCFCustomerProfileResponse {
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

}
