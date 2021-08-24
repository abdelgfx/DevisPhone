package com.devis.phone.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.devis.phone.model.Brand;
import com.devis.phone.model.Issue;
import com.devis.phone.model.Product;
import com.devis.phone.model.ProductIssue;
import com.devis.phone.model.User;
import com.devis.phone.service.BrandService;
import com.devis.phone.service.IssueService;
import com.devis.phone.service.ProductIssueService;
import com.devis.phone.service.ProductService;
import com.devis.phone.service.UserService;

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

	public void generateProducts(BrandService brandService, UserService userService, IssueService issueService,
			ProductService productService, ProductIssueService productIssueService) {

		Random random = new Random();
		int randomBrandIndex, randomIssueIndex;
		int maxBrands, maxIssues, min = 0;
		int numberOfProducts = this.numberOfProducts, productNumber = 1;
		double randomPrice, minPrice = 449.99, maxPrice = 1129.99;

		List<Product> products = new ArrayList<Product>();
		List<Brand> brands = generateBrands();
		List<User> users = generateUsers();
		List<Issue> issues = generateIssues();

		maxBrands = brands.size() - 1;

		brandService.addAllBrands(brands);
		userService.addAllUser(users);
		issueService.addAllIssues(issues);

		while (numberOfProducts > 0) {
			randomBrandIndex = random.nextInt((maxBrands - min) + 1) + min;

			Product p = new Product("Phone " + productNumber, "https://image-path-" + productNumber + ".com");

			p.setPhoneBrand(brands.get(randomBrandIndex));
			products.add(p);

			numberOfProducts--;
			productNumber++;
		}

		maxIssues = issues.size() - 1;

		productService.addAllProducts(products);

		for (int i = 0; i < products.size(); i++) {
			randomPrice = minPrice + (maxPrice - minPrice) * random.nextDouble();
			randomIssueIndex = random.nextInt((maxIssues - min) + 1) + min;

			ProductIssue pi = new ProductIssue(products.get(i), issues.get(randomIssueIndex),
					Math.floor(randomPrice * 100) / 100);
			productIssueService.addProductIssue(pi);
		}

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
			brands.add(new Brand("BRAND-XZ-00" + brandNumber, "https://brand-path-" + brandNumber + ".com"));
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
