package com.example.springbootloki;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBootLokiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLokiApplication.class, args);
	}
}
