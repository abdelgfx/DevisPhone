package com.devis.phone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devis.phone.model.Issue;
import com.devis.phone.repository.IssueRepository;

@Service
public class IssueService {

	@Autowired
	private IssueRepository issueRepository;

	public void addIssue(Issue issue) {
		issueRepository.save(issue);
	}

	public Issue getIssue(Long id) {
		return issueRepository.getById(id);
	}

	public List<Issue> getAllIssues() {
		return issueRepository.findAll();
	}

	public void deleteIssue(Long id) {
		issueRepository.deleteById(id);
	}

	public void deleteAllIssues() {
		issueRepository.deleteAll();
	}

	public Issue updateIssue(Issue issue) {
		// TODO

		return null;
	}
}
