package com.devis.phone.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Product")

public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idProduct")
	private int idProduct;
	@Column(name = "imagePath")
	private String imagePath;

	@ManyToOne
	@Column(name = "brand")
	private Brand brand;
	
	@ManyToOne
	private String user;

	public Product(String image) {
		super();
		this.imagePath = image;
	}

	public Product() {
		super();
	}

	public int getIdProduct() {
		return idProduct;
	}

	public String getImage() {
		return imagePath;
	}

	public void setImage(String image) {
		this.imagePath = image;
	}
}
