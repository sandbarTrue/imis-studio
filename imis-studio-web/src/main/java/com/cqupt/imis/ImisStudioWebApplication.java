package com.cqupt.imis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class 	ImisStudioWebApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ImisStudioWebApplication.class, args);
	}

	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(ImisStudioWebApplication.class);
	}
}
