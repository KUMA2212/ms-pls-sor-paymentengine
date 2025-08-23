package com.lcf.pls.paymentengine.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Setter
@Getter
@ToString
public class PaymentPortalCreateOrderResponse {



	@JsonProperty("id")
	public String id;

	@JsonProperty("entity")
	public String entity;

	@JsonProperty("amount_paid")
	public String amount_paid;

	@JsonProperty("amount_due")
	public String amount_due;

	@JsonProperty("amount")
	public String amount;

	@JsonProperty("currency")
	public String currency;

	@JsonProperty("status")
	public String status;

	@JsonProperty("attempts")
	public String attempts;

	@JsonProperty("created_at")
	public String created_at;

}
