package com.devis.phone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devis.phone.main.Data;
import com.devis.phone.model.Issue;
import com.devis.phone.service.IssueService;

@RestController
@RequestMapping("/api/v1/")

public class IssueController {
	@Autowired
	private IssueService issueService;
	private Data data;

	@GetMapping("/issues")
	public List<Issue> getAllIssues() {
		return issueService.getAllIssues();
	}

	@PostMapping("/issues/addAll")
	public void setAllIssues() {
		data = new Data(10, 5, 3, 1);
		List<Issue> testIssues = data.generateIssues();
		issueService.addAllIssues(testIssues);
	}
}
