package com.devis.phone.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devis.phone.model.ProductIssue;
import com.devis.phone.service.ProductIssueService;

@RestController
@RequestMapping("/api/v1/")

public class ProductIssueController {
	@Autowired
	private ProductIssueService productIssueService;

	@GetMapping("/product-issues")
	public List<Map<String, Object>> getAllProductIssues() {
		return productIssueService.getAllProductIssues();
	}

	@GetMapping("/product-issues/{idProductIssue}")
	public Map<String, Object> getProductIssueById(@PathVariable("idProductIssue") Long id) {
		return productIssueService.getProductIssue(id);
	}

	@PostMapping("/product-issues")
	public void setAllProductIssues(@RequestBody List<ProductIssue> productIssues) {
		productIssueService.addAllProductIssues(productIssues);
	}

	@PostMapping("/product-issue")
	public void setProductIssue(@RequestBody ProductIssue productIssue) {
		productIssueService.addProductIssue(productIssue);
	}
}
