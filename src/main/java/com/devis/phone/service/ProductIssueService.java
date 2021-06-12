package com.devis.phone.service;

import java.util.List;

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

	public ProductIssue getProductIssue(Long id) {
		return productIssueRepository.getById(id);
	}

	public List<ProductIssue> getAllProductIssues() {
		return productIssueRepository.findAll();
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
