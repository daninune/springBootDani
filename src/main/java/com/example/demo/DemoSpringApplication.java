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
		System.out.println("Hello 5RTWkñ`pmorld");
		System.out.println("cambio1111");
		System.out.println("cambio1");
		System.out.println("cambio22szeeeeeeee");
	}


	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DemoSpringApplication.class);
	}


	public static void main(String[] args) {
		SpringApplication.run(DemoSpringApplication.class, args);
	}

}
