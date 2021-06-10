package com.devis.phone.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Product")

public class Product {
	@Id
	<<<<<<< HEAD
	@GeneratedValue
	@ManyToMany
	private int idProduct;
	private String image;
=======
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long idProduct;
	
	@Column(name = "image_path")
	private String imagePath;
>>>>>>> 64b377e48f65aad128753b5bc9b7e80e8d825260

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
