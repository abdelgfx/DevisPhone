package com.devis.phone.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devis.phone.model.Issue;
import com.devis.phone.service.IssueService;

@RestController
@RequestMapping("/api/v1/")

public class IssueController {
	private IssueService issueService;

	@GetMapping("/issues")
	public List<Issue> getAllIssues() {
		return issueService.getAllIssues();
	}
}
