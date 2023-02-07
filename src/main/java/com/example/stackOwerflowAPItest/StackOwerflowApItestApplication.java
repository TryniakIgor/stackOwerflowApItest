package com.example.stackOwerflowAPItest;

import com.example.stackOwerflowAPItest.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StackOwerflowApItestApplication {

	public static void main(String[] args) {
		SpringApplication.run(StackOwerflowApItestApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.result().forEach(System.out::println);
			/**
			*for test comment previous and uncomment next line
			 **/
			//userService.testResult().forEach(System.out::println);
		};
	}
}
