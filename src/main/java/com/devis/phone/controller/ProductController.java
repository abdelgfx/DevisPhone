package com.devis.phone.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.devis.phone.model.Brand;
import com.devis.phone.model.Issue;
import com.devis.phone.model.Product;
import com.devis.phone.model.ProductIssue;
import com.devis.phone.service.BrandService;
import com.devis.phone.service.IssueService;
import com.devis.phone.service.ProductIssueService;
import com.devis.phone.service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")

public class ProductController {
	@Autowired
	private ProductService productService;
	@Autowired
	private BrandService brandService;
	@Autowired
	private ProductIssueService productIssueService;
	@Autowired
	private IssueService issueService;
	@Autowired
	ServletContext context;

	@GetMapping("/products")
	public List<Map<String, Object>> getAllProducts() {
		return productService.getAllProducts();
	}

	@GetMapping("/products/{id}")
	public Map<String, Object> getProductById(@PathVariable("id") Long id) {
		return productService.getProduct(id);
	}

	@GetMapping("/products/brand/{brandName}")
	public List<Map<String, Object>> getProductByBrandName(@PathVariable("brandName") String brandName) {
		return productService.getProductsByBrandName(brandName);
	}

	@GetMapping("/products/search/{productName}")
	public List<Map<String, Object>> getProductByBrandOrPhoneName(@PathVariable("productName") String productName) {
		return productService.getProductsByBrandOrPhoneName(productName);
	}

	@PostMapping("/products")
	public void setAllProducts(@RequestBody List<Product> products) {
		productService.addAllProducts(products);
	}

	@PostMapping("/product")
	public void setProduct(@RequestParam("phone_img") MultipartFile file, @RequestParam("phone_name") String phone_name,
			@RequestParam("phone_brand") String phone_brand, @RequestParam("phone_price") double phone_price,
			@RequestParam("phone_issues") String phone_issues) throws JsonMappingException, JsonProcessingException {

		boolean isExist = new File(context.getRealPath("/images/")).exists();
		String[] issues = phone_issues.split(",", -1);

		if (!isExist) {
			new File(context.getRealPath("/images/")).mkdir();
		}

		String fileName = file.getOriginalFilename();
		String newFileName = FilenameUtils.getBaseName(fileName) + "." + FilenameUtils.getExtension(fileName);
		File serverFile = new File(context.getRealPath("/images/" + File.separator + newFileName));

		List<Brand> brands = brandService.getAllBrands();
		Product p = new Product(phone_name, newFileName);

		for (Brand b : brands) {
			if (b.getIdBrand() == Long.valueOf(phone_brand)) {
				p.setPhoneBrand(b);
			}
		}

		try {
			FileUtils.writeByteArrayToFile(serverFile, file.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}

		p.setImagePath(newFileName);

		// Set<ProductIssue> listProductIssues = new HashSet<ProductIssue>();

		for (String i : issues) {

			Issue issue = issueService.getIssue(Long.valueOf(i));

			if (issue != null) {
				ProductIssue pi_ = new ProductIssue(p, issue, phone_price);
				productIssueService.addProductIssue(pi_);
			}

		}

		productService.addProduct(p);
	}

	@GetMapping("/product/image/{id}")
	public byte[] getProductImage(@PathVariable("id") Long id) throws IOException {
		return Files.readAllBytes(Paths.get(context.getRealPath("/images/") + productService.getProductImage(id)));
	}

	@PutMapping("/products/{id}")
	public void editProduct(@PathVariable("id") Long id, @RequestBody Product product) {
		product.setIdProduct(id);
		productService.addProduct(product);
	}

}
