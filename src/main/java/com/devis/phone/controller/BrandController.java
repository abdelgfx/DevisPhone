package com.devis.phone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devis.phone.model.Brand;
import com.devis.phone.service.BrandService;

@RestController
@RequestMapping("/api/v1/")

public class BrandController {
	@Autowired
	private BrandService brandService;

	@GetMapping("/brands")
	public List<Brand> getAllBrands() {
		return brandService.getAllBrands();
	}

	@GetMapping("/brands/{id}")
	public Brand getBrandById(@PathVariable("id") Long id) {
		return brandService.getBrand(id);
	}

	@PostMapping("/brands")
	public void setAllBrands(@RequestBody List<Brand> brands) {
		brandService.addAllBrands(brands);
	}

	@PostMapping("/brand")
	public void setBrand(@RequestBody Brand brand) {
		brandService.addBrand(brand);
	}

	@PutMapping("/brands/{id}")
	public void editBrand(@PathVariable Long id, @RequestBody Brand brand) {
		brand.setIdBrand(id);
		brandService.addBrand(brand);
	}

}
