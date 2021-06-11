package com.devis.phone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devis.phone.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
