package com.devis.phone.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devis.phone.model.Product;

@Repository

public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query(value = "SELECT P.id AS product_id, P.image_path, B.brand_name FROM Product P JOIN Brand B ON brand_id = B.id ORDER BY product_id", nativeQuery = true)
	List<Map<String, Object>> getAllProducts();
	
	@Query(value = "SELECT P.id AS product_id, P.image_path, B.brand_name FROM Product P JOIN Brand B ON brand_id = B.id WHERE P.id = :idProduct ORDER BY product_id", nativeQuery = true)
	Map<String, Object> getProductById(Long idProduct);

}
