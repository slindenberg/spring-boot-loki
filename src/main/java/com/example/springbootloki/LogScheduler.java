package com.example.springbootloki;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@Slf4j
public class LogScheduler {

	private static final Random random = new Random();

	private final Throwable exception = new Throwable("Sample Exception!", new Throwable("Sample Cause!"));

	public enum Levels {
		TRACE, DEBUG, INFO, WARN, ERROR;

		public static Levels getByRandom() {
			return values()[random.nextInt(values().length)];
		}
	}

	@Scheduled(fixedDelay = 2000)
	public void createLogs() {

		switch (Levels.getByRandom()) {
			case Levels.TRACE -> log.trace("Sample trace log ...");
			case Levels.DEBUG -> log.debug("Sample debug log ...");
			case Levels.INFO -> log.info("Sample info log ...");
			case Levels.WARN -> log.warn("Sample warn log ...");
			case Levels.ERROR -> log.error("Sample error log ...", exception);
		}
	}
}
