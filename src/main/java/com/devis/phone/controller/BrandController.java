package com.devis.phone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devis.phone.main.Data;
import com.devis.phone.model.Brand;
import com.devis.phone.service.BrandService;

@RestController
@RequestMapping("/api/v1/")

public class BrandController {
	@Autowired
	private BrandService brandService;
	private Data data;

	@GetMapping("/brands")
	public List<Brand> getAllBrands() {
		data = new Data();
		return brandService.getAllBrands();
	}

	@PostMapping("/brands/addAll")
	public void setAllBrands() {
		data = new Data(10, 5, 3, 1);
		List<Brand> testBrands = data.generateBrands();
		brandService.addAllBrands(testBrands);
	}
}
