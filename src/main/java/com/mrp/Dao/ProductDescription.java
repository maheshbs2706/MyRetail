package com.mrp.Dao;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDescription {

	private String title;

	@JsonProperty("downstream_description")
	private String downstreamDescription;

}
