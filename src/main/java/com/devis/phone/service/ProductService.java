package com.devis.phone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devis.phone.model.Product;
import com.devis.phone.repository.ProductRepository;

@Service

public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public void addProduct(Product product) {
		productRepository.save(product);
	}

	public void addAllProducts(List<Product> products) {
		for (Product product : products)
			productRepository.save(product);
	}

	public Product getProduct(Long id) {
		return productRepository.getById(id);
	}

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}

	public void deleteAllProducts() {
		productRepository.deleteAll();
	}

	public Product updateProduct(Product product) {
		// TODO

		return null;
	}

}
