package com.devis.phone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devis.phone.model.Product;
import com.devis.phone.repository.ProductRepository;

@RestController
@RequestMapping("/api/v1/")
public class ProductController {
	@Autowired
	private ProductRepository productRepository;

	@GetMapping("/products")
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}
}
