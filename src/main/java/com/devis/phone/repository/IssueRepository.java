package com.devis.phone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devis.phone.model.Issue;

@Repository

public interface IssueRepository extends JpaRepository<Issue, Long> {

}
