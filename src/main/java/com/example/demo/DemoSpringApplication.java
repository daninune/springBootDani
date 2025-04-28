package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class DemoSpringApplication extends SpringBootServletInitializer implements CommandLineRunner {
	@Override
	public void run(String... args) throws Exception {
		System.out.println("asssssssssssssaaaad");
		System.out.println("tarea111aaaaaaaaaaaaaaaaaaaaaaaaaaa");
		System.out.println("tarea122");
		System.out.println("cambaaaaaa");
	}


	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DemoSpringApplication.class);
	}


	public static void main(String[] args) {
		SpringApplication.run(DemoSpringApplication.class, args);
	}

}
