package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoSpringApplication implements CommandLineRunner {
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello Wkmorld");
		System.out.println("Hello World");
		System.out.println("Hello World");
		System.out.println("Hello World118556weesz");
	}


	public static void main(String[] args) {
		SpringApplication.run(DemoSpringApplication.class, args);
	}

}
