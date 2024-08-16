package com.amaris.prueba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PruebaApplication {
	@Bean
	public RestTemplate getresttemplate() {
		return new RestTemplate();
	}
	public static void main(String[] args) {
		SpringApplication.run(PruebaApplication.class, args);
	}

}
