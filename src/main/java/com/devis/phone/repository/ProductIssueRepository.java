package com.devis.phone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devis.phone.model.ProductIssue;

@Repository
public interface ProductIssueRepository extends JpaRepository<ProductIssue, Long> {

}
