package com.devis.phone.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devis.phone.model.Product;

@Repository

public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query(value = "SELECT P.id AS product_id, P.phone_name, P.image_path, B.brand_name FROM Product P JOIN Brand B ON brand_id = B.id ORDER BY product_id", nativeQuery = true)
	List<Map<String, Object>> getAllProducts();

	@Query(value = "SELECT P.id AS product_id, P.phone_name, P.image_path, B.brand_name FROM Product P JOIN Brand B ON brand_id = B.id WHERE P.id = :idProduct ORDER BY product_id", nativeQuery = true)
	Map<String, Object> getProductById(Long idProduct);

	@Query(value = "SELECT P.id AS product_id, P.phone_name, P.image_path, B.brand_name FROM Product P JOIN Brand B ON brand_id = B.id WHERE B.brand_name = :brandName ORDER BY product_id", nativeQuery = true)
	List<Map<String, Object>> getProductsByBrandName(String brandName);

	@Query(value = "SELECT P.id AS product_id, P.phone_name, P.image_path, B.brand_name FROM Product P JOIN Brand B ON brand_id = B.id WHERE P.phone_name LIKE %:name% OR B.brand_name LIKE %:name% ORDER BY product_id", nativeQuery = true)
	List<Map<String, Object>> getProductsByBrandOrPhoneName(String name);

	@Query(value = "SELECT image_path FROM Product WHERE id = :id", nativeQuery = true)
	String getProductImage(Long id);

}
