package com.lcf.pls.paymentengine.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class AmountType implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("amount")
    private Double amount;

    @JsonProperty("units")
    private String units;

}
