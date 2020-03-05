package com.mrp.Dao;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {

	private Long id;
	private String name;

	@JsonProperty("current_price")
	private Price currentPrice;

}
