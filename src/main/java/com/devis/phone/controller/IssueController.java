package com.devis.phone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devis.phone.model.Issue;
import com.devis.phone.service.IssueService;

@RestController
@RequestMapping("/api/v1/")

public class IssueController {
	@Autowired
	private IssueService issueService;

	@GetMapping("/issues")
	public List<Issue> getAllIssues() {
		return issueService.getAllIssues();
	}

	@GetMapping("/issues/{id}")
	public Issue getIssueById(@PathVariable("id") Long id) {
		return issueService.getIssue(id);
	}

	@PostMapping("/issues")
	public void setAllIssues(@RequestBody List<Issue> issues) {
		issueService.addAllIssues(issues);
	}

	@PostMapping("/issue")
	public void setIssue(@RequestBody Issue issue) {
		issueService.addIssue(issue);
	}

	@PutMapping("/issues/{id}")
	public void editIssue(@PathVariable("id") Long id, @RequestBody Issue issue) {
		issue.setIdIssue(id);
		issueService.addIssue(issue);
	}

}
