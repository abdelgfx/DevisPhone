package com.devis.phone.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devis.phone.model.ProductIssue;
import com.devis.phone.repository.ProductIssueRepository;

@Service
public class ProductIssueService {
	@Autowired
	private ProductIssueRepository productIssueRepository;

	public void addProductIssue(ProductIssue productIssue) {
		productIssueRepository.save(productIssue);
	}

	public void addAllProductIssues(List<ProductIssue> productIssues) {
		for (ProductIssue productIssue : productIssues)
			productIssueRepository.save(productIssue);
	}

	public Map<String, Object> getProductIssue(Long id) {
		return productIssueRepository.getProductIssueById(id);
	}

	public List<Map<String, Object>> getAllProductIssues() {
		return productIssueRepository.getAllProductIssues();
	}

	public Map<String, Object> getProductIssuePrice(String brandName, String issueName) {
		return productIssueRepository.getProductIssuePrice(brandName, issueName);
	}
	
	public List<Map<String, Object>> getIssuesByProductId(Long productId) {
		return productIssueRepository.getIssuesByProductId(productId);
	}

	public void deleteProductIssue(Long id) {
		productIssueRepository.deleteById(id);
	}

	public void deleteAllProductIssues() {
		productIssueRepository.deleteAll();
	}

	public ProductIssue updateProductIssue(ProductIssue productIssue) {
		// TODO

		return null;
	}
}
