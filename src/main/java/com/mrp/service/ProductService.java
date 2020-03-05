package com.mrp.service;

import com.mrp.Dao.Product;

public interface ProductService {

	Product getDetails(Long id);

	boolean addOrUpdateDetails(Product product);

	boolean updateDetails(Product product);

}
