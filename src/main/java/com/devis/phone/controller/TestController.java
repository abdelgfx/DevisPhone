package com.devis.phone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.devis.phone.main.Data;
import com.devis.phone.service.BrandService;
import com.devis.phone.service.IssueService;
import com.devis.phone.service.ProductIssueService;
import com.devis.phone.service.ProductService;
import com.devis.phone.service.UserService;

@RestController
@RequestMapping("/api/v1/test")

public class TestController {
	@Autowired
	private ProductService productService;

	@Autowired
	private BrandService brandService;

	@Autowired
	private UserService userService;

	@Autowired
	private ProductIssueService productIssueService;

	@Autowired
	private IssueService issueService;

	private Data data;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public void setAllTestProducts() {
		data = new Data(10, 5, 3, 1);
		data.generateProducts(brandService, userService, issueService, productService, productIssueService);
	}
}
