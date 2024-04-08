package com.example.springbootloki;

import com.example.springbootloki.dao.SomeEntityRepository;
import com.example.springbootloki.dom.model.SomeEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@Slf4j
@RequiredArgsConstructor
@EnableScheduling
public class SpringBootLokiApplication implements ApplicationListener<ApplicationReadyEvent> {

	private final SomeEntityRepository database;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLokiApplication.class, args);
	}

	@Override
	public void onApplicationEvent(final ApplicationReadyEvent event) {
		log.info("Adding test data ...");
		database.save(SomeEntity.builder().data("Some Data").build());
		database.save(SomeEntity.builder().data("Some Data").build());
		database.save(SomeEntity.builder().data("Some Data").build());
		database.save(SomeEntity.builder().data("Some Data").build());
		database.save(SomeEntity.builder().data("Some Data").build());
		log.info("Application started.");
	}
}
