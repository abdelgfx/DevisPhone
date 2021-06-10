package com.devis.phone.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.devis.phone.model"})  // scan JPA entities

public class DevisPhoneApp {

	public static void main(String[] args) {
		SpringApplication.run(DevisPhoneApp.class, args);
	}

}
