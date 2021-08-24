package com.devis.phone.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devis.phone.model.ProductIssue;

@Repository

public interface ProductIssueRepository extends JpaRepository<ProductIssue, Long> {

	@Query(value = "SELECT P.id AS product_id, brand_name, P.image_path, issue_name, price FROM Product_Issue PI JOIN Issue I ON PI.issue_id = I.id JOIN Product P ON PI.product_id = P.id JOIN Brand B ON B.id = P.brand_id ORDER BY product_id", nativeQuery = true)
	List<Map<String, Object>> getAllProductIssues();

	@Query(value = "SELECT P.id AS product_id, brand_name, P.image_path, issue_name, price FROM Product_Issue PI JOIN Issue I ON PI.issue_id = I.id JOIN Product P ON PI.product_id = P.id JOIN Brand B ON B.id = P.brand_id WHERE PI.id = :idProductIssue ORDER BY product_id", nativeQuery = true)
	Map<String, Object> getProductIssueById(Long idProductIssue);

	@Query(value = "SELECT brand_name, issue_name, P.image_path, price FROM Product_Issue PI JOIN Product P ON PI.product_id = P.id JOIN Issue I ON I.id = PI.issue_id JOIN Brand B ON P.brand_id = B.id WHERE B.brand_name = :brandName AND I.issue_name = :issueName", nativeQuery = true)
	Map<String, Object> getProductIssuePrice(String brandName, String issueName);

	@Query(value = "SELECT P.id AS product_id, brand_name, issue_name, price FROM Product_Issue PI JOIN Issue I ON PI.issue_id = I.id JOIN Product P ON PI.product_id = P.id JOIN Brand B ON B.id = P.brand_id WHERE P.id = :productId ORDER BY product_id", nativeQuery = true)
	List<Map<String, Object>> getIssuesByProductId(Long productId);

}
