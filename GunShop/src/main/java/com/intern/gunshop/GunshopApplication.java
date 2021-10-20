package com.intern.gunshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;


@SpringBootApplication(scanBasePackages = "com.intern.gunshop")
@OpenAPIDefinition(info = @Info(title = "Gun Shop Api", version = "1.0.0", description = "Api for gun shop services", 
contact = @Contact(email = "phathuuho@Gmail.com",name = "Ho Huu Phat")))
public class GunshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(GunshopApplication.class, args);
	}

}
