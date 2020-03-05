package com.mrp.utility;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

import com.mrp.Dao.Price;
import com.mrp.Dao.Product;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class PriceServiceUtility {

	private Random random = new Random();

	private ConcurrentHashMap<Long, Map<String, Float>> priceDetails = new ConcurrentHashMap<>();

	public Price getPriceDetails(Long id, String currency) {

		log.info("getting product price details from price service for the id : {}", id);
		Price price = new Price();
		price.setCurrencyCode(currency);

		if (priceDetails.get(id) == null) {

			// setting price for the first time
			Map<String, Float> pri = new HashMap<>();
			Float value = getFloatPrice();
			pri.put(currency, value);
			priceDetails.put(id, pri);

			// setting value for return object
			price.setValue(value);
		} else {
			Map<String, Float> pri = priceDetails.get(id);

			// checking for that currency, price data available
			if (pri.get(currency) == null) {

				// setting price for the currency for the first time
				Float value = getFloatPrice();
				pri.put(currency, value);

				// setting value for return object
				price.setValue(value);
			} else {
				price.setValue(pri.get(currency));
			}
		}

		return price;
	}

	public boolean addOrUpdatePrice(Product product) {
		Long id = product.getId();
		Price price = product.getCurrentPrice();

		if (priceDetails.get(id) == null) {
			// add operation
			// setting price for the first time
			Map<String, Float> pri = new HashMap<>();
			pri.put(price.getCurrencyCode(), price.getValue());
			priceDetails.put(id, pri);

		} else {
			// update operation
			Map<String, Float> pri = priceDetails.get(id);
			pri.put(price.getCurrencyCode(), price.getValue());
		}

		return true;
	}

	public boolean updatePrice(Product product) {
		Long id = product.getId();
		Price price = product.getCurrentPrice();

		if (priceDetails.get(id) == null) {
			return false;

		} else {
			// update operation
			Map<String, Float> pri = priceDetails.get(id);
			pri.put(price.getCurrencyCode(), price.getValue());
		}

		return true;
	}

	private Float getFloatPrice() {
		return (float) (Math.round(random.nextFloat() * 100.00) / 100.0);
	}

}
