package com.devis.phone.main;

import java.util.ArrayList;
import java.util.List;

import com.devis.phone.model.Brand;
import com.devis.phone.model.Issue;
import com.devis.phone.model.Product;
import com.devis.phone.model.User;

public class Data {

	private int numberOfProducts, numberOfIssues, numberOfBrands, numberOfUsers;

	public Data(int numberOfProducts, int numberOfIssues, int numberOfBrands, int numberOfUsers) {
		super();
		this.numberOfProducts = numberOfProducts;
		this.numberOfIssues = numberOfIssues;
		this.numberOfBrands = numberOfBrands;
		this.numberOfUsers = numberOfUsers;
	}

	public Data() {
		super();
	}

	public List<Product> generateProducts() {
		List<Product> products = new ArrayList<Product>();
		int numberOfProducts = this.numberOfProducts;
		int productNumber = 1;

		while (numberOfProducts > 0) {
			products.add(new Product("https://image-path-" + productNumber + ".com"));
			numberOfProducts--;
			productNumber++;
		}

		return products;
	}

	public List<Issue> generateIssues() {
		List<Issue> issues = new ArrayList<Issue>();
		int numberOfIssues = this.numberOfIssues;
		int issueNumber = 1;

		while (numberOfIssues > 0) {
			issues.add(new Issue("Product issue number " + issueNumber));
			numberOfIssues--;
			issueNumber++;
		}

		return issues;
	}

	public List<Brand> generateBrands() {
		List<Brand> brands = new ArrayList<Brand>();
		int numberOfBrands = this.numberOfBrands;
		int brandNumber = 1;

		while (numberOfBrands > 0) {
			brands.add(new Brand("BRAND-XZ-00" + brandNumber));
			numberOfBrands--;
			brandNumber++;
		}

		return brands;
	}

	public List<User> generateUsers() {
		List<User> users = new ArrayList<User>();
		int numberOfUsers = this.numberOfUsers;
		int userNumber = 1;

		while (numberOfUsers > 0) {
			users.add(new User("Said_" + userNumber, "BGD_" + userNumber, "Said" + userNumber + "@BGD.xx",
					"Azsvg@/74oi_'(+"));
			numberOfUsers--;
			userNumber++;
		}

		return users;
	}

}
