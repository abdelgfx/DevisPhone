package com.devis.phone.model;

import java.io.Serializable;

import javax.persistence.Entity;


@Entity
public class ProductIssue implements Serializable{
	
	private long idProduct ;
	private long idIssue;
	private double price;
	
	public ProductIssue() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductIssue(long idProduct, long idIssue, double price) {
		super();
		this.idProduct = idProduct;
		this.idIssue = idIssue;
		this.price = price;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	
}
