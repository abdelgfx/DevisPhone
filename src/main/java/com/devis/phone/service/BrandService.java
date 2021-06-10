package com.devis.phone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devis.phone.model.Brand;
import com.devis.phone.model.Product;
import com.devis.phone.repository.BrandRepository;

@Service
public class BrandService {

	@Autowired
	private BrandRepository brandRepository;

	public void addBrand(Brand brand) {
		brandRepository.save(brand);
	}

	public void addAllBrands(List<Brand> brands) {
		for (Brand brand : brands)
			brandRepository.save(brand);
	}

	public Brand getBrand(Long id) {
		return brandRepository.getById(id);
	}

	public List<Brand> getAllBrands() {
		return brandRepository.findAll();
	}

	public void deleteBrand(Long id) {
		brandRepository.deleteById(id);
	}

	public void deleteAllBrands() {
		brandRepository.deleteAll();
	}

	public Brand updateBrand(Brand brand) {
		// TODO

		return null;
	}
}
