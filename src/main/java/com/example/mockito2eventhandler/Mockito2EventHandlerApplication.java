package com.example.mockito2eventhandler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableJpaRepositories
@EnableSpringDataWebSupport
public class Mockito2EventHandlerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Mockito2EventHandlerApplication.class, args);
	}
}
