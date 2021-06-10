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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long idProduct;

	@Column(name = "image_path")
	private String imagePath;

	@ManyToOne
	private Brand brand;

	@ManyToOne
	private User user;

	public Product(String image) {
		super();
		this.imagePath = image;
	}

	public Product() {
		super();
	}

	public Long getIdProduct() {
		return idProduct;
	}

	public String getImage() {
		return imagePath;
	}

	public void setImage(String image) {
		this.imagePath = image;
	}
}
