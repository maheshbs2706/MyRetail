package com.mrp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mrp.Dao.Product;
import com.mrp.constants.GlobalConstants;
import com.mrp.utility.PriceServiceUtility;
import com.mrp.utility.RestUtility;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ProductServiceImpl implements ProductService {

	@Autowired
	private RestUtility restUtility;

	@Autowired
	PriceServiceUtility priceServiceUtility;

	@Override
	public Product getDetails(Long id) {
		log.info("collecting all the info for the product id : {}", id);
		Product product = new Product();
		product.setId(id);
		product.setName(restUtility.getProductName(id));
		product.setCurrentPrice(priceServiceUtility.getPriceDetails(id, GlobalConstants.DEFAULTCURRENCY));
		log.info("returning details for the product id : {}", id);
		return product;
	}

	@Override
	public boolean addOrUpdateDetails(Product product) {
		log.info("add or updating price info for the product id : {}", product.getId());
		return priceServiceUtility.addOrUpdatePrice(product);
	}

	@Override
	public boolean updateDetails(Product product) {
		log.info("updating price info for the product id : {}", product.getId());
		return priceServiceUtility.updatePrice(product);
	}

}
