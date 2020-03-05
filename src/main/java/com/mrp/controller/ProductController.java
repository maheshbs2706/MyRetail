package com.mrp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mrp.Dao.Product;
import com.mrp.constants.GlobalConstants;
import com.mrp.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/products")
@Slf4j
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping(value = "/{id}", produces = "application/json")
	public Product getDetails(@PathVariable("id") Long id) {
		log.info("Getting product Details for id : {}", id);
		return productService.getDetails(id);
	}

	@PostMapping(value = "/{id}")
	public ResponseEntity<String> addDetails(@PathVariable("id") Long id, @RequestBody Product product) {
		log.info("adding product Details for id : {}", id);
		product.setId(id);
		if (productService.addOrUpdateDetails(product))
			return new ResponseEntity<String>(GlobalConstants.SUCCESSADD, HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<String>(GlobalConstants.FAILEDADD, HttpStatus.BAD_REQUEST);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> updateDetails(@PathVariable("id") Long id, @RequestBody Product product) {
		log.info("updating product Details for id : {}", id);
		product.setId(id);
		if (productService.updateDetails(product))
			return new ResponseEntity<String>(GlobalConstants.SUCCESSUPDATE, HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<String>(GlobalConstants.FAILEDUPDATE, HttpStatus.BAD_REQUEST);
	}

}
