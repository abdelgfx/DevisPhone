package com.devis.phone.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.devis.phone.model") // Scan JPA entities
@EnableJpaRepositories(basePackages = "com.devis.phone.repository") // Scan JPA repositories
@ComponentScan(basePackages = { "com.devis.phone.controller", // Scan JPA controllers &
								"com.devis.phone.service" }) // services

public class DevisPhoneApp {

	public static void main(String[] args) {
		SpringApplication.run(DevisPhoneApp.class, args);
	}

}
