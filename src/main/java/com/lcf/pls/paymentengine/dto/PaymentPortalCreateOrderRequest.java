package com.lcf.pls.paymentengine.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lcf.pls.paymentengine.common.TokenInfo;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Setter
@Getter
public class PaymentPortalCreateOrderRequest {

	@JsonProperty("amount")
	public String amount;

	@JsonProperty("currency")
	public String currency;

	@JsonProperty("customer_id")
	public String customer_id;

	@JsonProperty("method")
	public String method;

	@JsonProperty("token")
	public TokenInfo token;

	@JsonProperty("phoneNumber")
	public String phoneNumber;

}
