package com.devis.phone.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Issue")

public class Issue {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long idIssue;

	@Column(name = "issue_name")
	private String issueName;

	public String getIssueName() {
		return issueName;
	}

	public void setIssueName(String issueName) {
		this.issueName = issueName;
	}

	public long getIdissue() {
		return idIssue;
	}

	public Issue(String issueName) {
		super();
		this.issueName = issueName;
	}

	public Issue() {
		super();
		// TODO Auto-generated constructor stub
	}

}
