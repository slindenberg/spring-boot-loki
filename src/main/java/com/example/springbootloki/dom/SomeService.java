package com.example.springbootloki.dom;

import com.example.springbootloki.dao.SomeEntityRepository;
import com.example.springbootloki.dom.model.SomeEntity;
import io.micrometer.tracing.SpanName;
import io.micrometer.tracing.annotation.SpanTag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@SpanName("SomeService")
@Transactional
public class SomeService {

	private final SomeEntityRepository database;

	public void add(@SpanTag final SomeEntity data) {
		log.info("Adding data: {}", data);
		database.save(data);
	}

	@Transactional(readOnly = true)
	@SpanName("list")
	public List<SomeEntity> list() {
		log.info("Listing data");

		for (int i = 0; i < 1000; i++) {
			byte[] bytes = new byte[1024 * 1024 * 10];
		}

		return database.findAll();
	}

	public void delete(final SomeEntity entity) {
		log.info("Deleting data with id: {}", entity.getId());
		database.delete(entity);
	}
}
