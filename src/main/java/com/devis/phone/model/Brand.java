package com.devis.phone.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Brand")

public class Brand {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idBrand")
	private int idBrand;
	@Column(name = "brandName")
	private String brandName;

	@OneToMany(mappedBy = "brand")
	@Column(name = "products")
	private List<Product> products;

	public Brand() {
		super();
	}

	public Brand(String brandName) {
		super();
		this.brandName = brandName;
	}

	public int getIdBrand() {
		return idBrand;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
}
