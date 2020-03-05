package com.mrp.utility;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.mrp.Dao.ProductServiceResponse;
import com.mrp.constants.GlobalConstants;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class RestUtility {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${product.service.url}")
	private String productServiceUrl;

	public ProductServiceResponse getProductDetails(Long id) throws URISyntaxException {

		log.info("getting details from product service for the id : {}", id);
		final String baseUrl = productServiceUrl + "/" + id + GlobalConstants.PRODUCTFILTER;
		URI uri = new URI(baseUrl);
		ProductServiceResponse result = restTemplate.getForObject(uri, ProductServiceResponse.class);
		log.info("got details from product service");
		return result;

	}

	public String getProductName(Long id) {
		log.info("getting product name for : {}", id);
		ProductServiceResponse psr = null;
		try {
			psr = getProductDetails(id);
		} catch (URISyntaxException e) {
			log.error("error while calling product service : {}", e);
		}
		if (psr != null && psr.getProduct() != null && psr.getProduct().getItem() != null
				&& psr.getProduct().getItem().getProductDescription() != null
				&& psr.getProduct().getItem().getProductDescription().getTitle() != null)
			return psr.getProduct().getItem().getProductDescription().getTitle();
		else
			return null;
	}

}
