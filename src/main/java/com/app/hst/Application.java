package com.app.hst;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		System.out.println("Hello, My Application!");
		SpringApplication.run(Application.class, args);
	}

}
