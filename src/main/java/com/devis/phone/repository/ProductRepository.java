package com.devis.phone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devis.phone.model.Product;

@Repository

public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query(value = "SELECT id, imagePath, brand_id, user_id FROM Product")
	List<Product> getAllProducts();

}
