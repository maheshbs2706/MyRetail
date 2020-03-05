package com.mrp.Dao;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Price {

	private Float value;

	@JsonProperty("currency_code")
	private String currencyCode;

}
