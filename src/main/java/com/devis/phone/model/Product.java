package com.devis.phone.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Product")

public class Product implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long idProduct;

	@Column(name = "image_path")
	private String imagePath;

	@ManyToOne(cascade = CascadeType.ALL)
	private Brand brand;

	@ManyToOne(cascade = CascadeType.ALL)
	private User user;

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private Set<ProductIssue> productIssues = new HashSet<>();

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

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<ProductIssue> getProductIssues() {
		return productIssues;
	}

	public void setProductIssues(Set<ProductIssue> productIssues) {
		this.productIssues = productIssues;
	}
}
