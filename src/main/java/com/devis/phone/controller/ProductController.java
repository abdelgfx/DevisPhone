package com.devis.phone.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devis.phone.model.Product;
import com.devis.phone.service.ProductService;

@RestController
@RequestMapping("/api/v1/")

public class ProductController {
	@Autowired
	private ProductService productService;

	@GetMapping("/products")
	public List<Map<String, Object>> getAllProducts() {
		return productService.getAllProducts();
	}

	@GetMapping("/products/{id}")
	public Map<String, Object> getProductById(@PathVariable("id") Long id) {
		return productService.getProduct(id);
	}

	@PostMapping("/products")
	public void setAllProducts(@RequestBody List<Product> products) {
		productService.addAllProducts(products);
	}

	@PostMapping("/product")
	public void setProduct(@RequestBody Product product) {
		productService.addProduct(product);
	}

	@PutMapping("/products/{id}")
	public void editProduct(@PathVariable("id") Long id, @RequestBody Product product) {
		product.setIdProduct(id);
		productService.addProduct(product);
	}

}
