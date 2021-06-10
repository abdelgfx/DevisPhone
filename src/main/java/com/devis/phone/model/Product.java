package com.devis.phone.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Product")

public class Product {
	@Id
	@GeneratedValue
	@ManyToMany
	private int idProduct;
	private String image;

	@ManyToOne
	private Brand brand;
	
	@ManyToOne
	private String user;

	public Product(int idProduct, String image) {
		super();
		this.idProduct = idProduct;
		this.image = image;
	}

	public Product() {
		super();
	}

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
