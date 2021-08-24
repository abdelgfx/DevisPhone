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

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long idProduct;

	@Column(name = "image_path")
	private String imagePath;

	@Column(name = "phone_name")
	private String phoneName;

	@ManyToOne(cascade = CascadeType.ALL)
	private Brand brand;

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private Set<ProductIssue> productIssues = new HashSet<>();

	public Product(String phoneName, String image) {
		super();
		this.imagePath = image;
		this.phoneName = phoneName;
	}

	public Product(String phoneName, String image, Brand phoneBrand) {
		super();
		this.imagePath = image;
		this.phoneName = phoneName;
		this.brand = phoneBrand;
	}

	public Product() {
		super();
	}

	public Long getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(Long idProduct) {
		this.idProduct = idProduct;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public Brand getPhoneBrand() {
		return brand;
	}

	public void setPhoneBrand(Brand phoneBrand) {
		this.brand = phoneBrand;
	}

	public Set<ProductIssue> getProductIssues() {
		return productIssues;
	}

	public void setProductIssues(Set<ProductIssue> productIssues) {
		this.productIssues = productIssues;
	}

	public String getPhoneName() {
		return phoneName;
	}

	public void setPhoneName(String phoneName) {
		this.phoneName = phoneName;
	}
}
