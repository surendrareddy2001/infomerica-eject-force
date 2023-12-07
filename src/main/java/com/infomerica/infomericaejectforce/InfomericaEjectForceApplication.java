package com.infomerica.infomericaejectforce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class InfomericaEjectForceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfomericaEjectForceApplication.class, args);
	}
}

