package com.devis.phone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devis.phone.model.Product;

@Repository

public interface ProductRepository extends JpaRepository<Product, Long> {

}
