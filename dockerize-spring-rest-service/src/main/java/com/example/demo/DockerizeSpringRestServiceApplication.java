package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.Doctor;

@SpringBootApplication
public class DockerizeSpringRestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DockerizeSpringRestServiceApplication.class, args);
	}

	
	@Bean
	public Doctor doctor() {
		
		return new Doctor(1010,"Ramesh Khanna");
	}
}
