package com.mrp.Dao;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Item {

	@JsonProperty("product_description")
	private ProductDescription productDescription;

}
