package com.devis.phone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.devis.phone.main.Data;
import com.devis.phone.model.Product;
import com.devis.phone.service.ProductService;

@RestController
@RequestMapping("/api/v1/")

public class ProductController {
	@Autowired
	private ProductService productService;
	private Data data;

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	@RequestMapping(value = "/products/addAll", method = RequestMethod.POST)
	public void setAllProducts() {
		System.out.println("OK ! URL Detected >> /api/v1/products/addAll");
		data = new Data(10, 5, 3, 1);
		List<Product> testProducts = data.generateProducts();
		productService.addAllProducts(testProducts);
	}
}
