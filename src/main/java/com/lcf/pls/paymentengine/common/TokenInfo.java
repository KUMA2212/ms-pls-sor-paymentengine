package com.lcf.pls.paymentengine.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder({
        "max_amount",
        "expire_at",
        "frequency",
        "recurring_value",
        "recurring_type",
})
public class TokenInfo {

    @JsonProperty("max_amount")
    private String max_amount;

    @JsonProperty("expire_at")
    private String expire_at;

    @JsonProperty("frequency")
    private String frequency;

    @JsonProperty("recurring_value")
    private String recurring_value;

    @JsonProperty("recurring_type")
    private String recurring_type;
}

