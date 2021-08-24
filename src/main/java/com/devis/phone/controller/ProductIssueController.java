package com.devis.phone.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devis.phone.model.ProductIssue;
import com.devis.phone.service.ProductIssueService;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")

public class ProductIssueController {
	@Autowired
	private ProductIssueService productIssueService;

	@GetMapping("/product-issues")
	public List<Map<String, Object>> getAllProductIssues() {
		return productIssueService.getAllProductIssues();
	}

	@GetMapping("/product-issues/{id}")
	public Map<String, Object> getProductIssueById(@PathVariable("id") Long id) {
		return productIssueService.getProductIssue(id);
	}

	@GetMapping("/product-issue-price")
	public Map<String, Object> getProductIssuePrice(@RequestBody Map<String, String> brandIssueName) {
		return productIssueService.getProductIssuePrice(brandIssueName.get("brandName"),
				brandIssueName.get("issueName"));
	}

	@GetMapping("/product-issues/product/{id}")
	public List<Map<String, Object>> getIssuesByProductId(@PathVariable("id") Long id) {
		return productIssueService.getIssuesByProductId(id);
	}

	@PostMapping("/product-issues")
	public void setAllProductIssues(@RequestBody List<ProductIssue> productIssues) {
		productIssueService.addAllProductIssues(productIssues);
	}

	@PostMapping("/product-issue")
	public void setProductIssue(@RequestBody ProductIssue productIssue) {
		productIssueService.addProductIssue(productIssue);
	}

	@PutMapping("/product-issues/{id}")
	public void editProductIssue(@PathVariable("id") Long id, @RequestBody ProductIssue productIssue) {
		productIssue.setProductIssueId(id);
		productIssueService.addProductIssue(productIssue);
	}
}
