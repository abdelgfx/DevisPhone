package com.devis.phone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.devis.phone.model.ProductIssue;
import com.devis.phone.service.ProductIssueService;

@RestController
@RequestMapping("/api/v1/")

public class ProductIssueController {
	@Autowired
	private ProductIssueService productIssueService;

	@GetMapping("/product-issues")
	public List<ProductIssue> getAllProductIssues() {
		return productIssueService.getAllProductIssues();
	}

	@RequestMapping(value = "/product-issues", method = RequestMethod.POST)
	public void setAllProductIssues(@RequestBody List<ProductIssue> productIssues) {
		productIssueService.addAllProductIssues(productIssues);
	}
}
