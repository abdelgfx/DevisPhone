package com.devis.phone.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Brand")

public class Brand {
	private int idBrand;
	private String brandName;

	@OneToMany(mappedBy = "brand")
	private List<Product> products;

	public Brand() {
		super();
	}

	public Brand(int idBrand, String brandName) {
		super();
		this.idBrand = idBrand;
		this.brandName = brandName;
	}

	public int getIdBrand() {
		return idBrand;
	}

	public void setIdBrand(int idBrand) {
		this.idBrand = idBrand;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
}
