package com.elmercader.catalogov2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class Catalogov2Application {

	public static void main(String[] args) {
		SpringApplication.run(Catalogov2Application.class, args);
	}

}
