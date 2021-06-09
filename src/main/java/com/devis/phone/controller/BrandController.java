package com.devis.phone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devis.phone.model.Brand;
import com.devis.phone.repository.BrandRepository;

@RestController
@RequestMapping("/api/v1/")

public class BrandController {
	@Autowired
	private BrandRepository brandRepository;

	@GetMapping("/brands")
	public List<Brand> getAllBrands() {
		return brandRepository.findAll();
	}
}
