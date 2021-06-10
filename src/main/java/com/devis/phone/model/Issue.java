package com.devis.phone.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table (name = "Issue")
public class Issue {
@Id
@GeneratedValue
	private long idissue;
@ManyToMany

	private String issueName;
	
	public String getIssueName() {
		return issueName;
	}
	
	public void setIssueName(String issueName) {
		this.issueName = issueName;
	}
	
	public long getIdissue() {
		return idissue;
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
