package com.devis.phone.service;

import java.util.List;
import java.util.Map;

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

	public Map<String, Object> getProduct(Long id) {
		return productRepository.getProductById(id);
	}
	
	public String getProductImage(Long id) {
		return productRepository.getProductImage(id);
	}

	public List<Map<String, Object>> getAllProducts() {
		return productRepository.getAllProducts();
	}

	public List<Map<String, Object>> getProductsByBrandName(String brandName) {
		return productRepository.getProductsByBrandName(brandName);
	}

	public List<Map<String, Object>> getProductsByBrandOrPhoneName(String name) {
		return productRepository.getProductsByBrandOrPhoneName(name);
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
