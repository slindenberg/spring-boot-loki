package com.example.springbootloki.dom;

import com.example.springbootloki.dao.SomeEntityRepository;
import com.example.springbootloki.dom.model.SomeEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class SomeService {

	private final SomeEntityRepository database;

	public void add(final SomeEntity data) {
		log.info("Adding data: {}", data);
		database.save(data);
	}

	public List<SomeEntity> list() {
		log.info("Listing data");
		return database.findAll();
	}

	public void delete(final SomeEntity entity) {
		log.info("Deleting data with id: {}", entity.getId());
		database.delete(entity);
	}
}
