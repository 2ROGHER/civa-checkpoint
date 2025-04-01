package com.example.buses_ms;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Objects;
import java.util.logging.Logger;

@SpringBootApplication
public class BusesMsApplication {
	public static final Logger logger = Logger.getLogger(BusesMsApplication.class.toString());
	public static void main(String[] args) {
		// 1. Add [environment variables]
		Dotenv dotenv = Dotenv.load();
		System.setProperty("DB_HOST", Objects.requireNonNull(dotenv.get("DB_HOST")));
		System.setProperty("DB_NAME", Objects.requireNonNull(dotenv.get("DB_NAME")));
		System.setProperty("DB_PORT", Objects.requireNonNull(dotenv.get("DB_PORT")));
		System.setProperty("DB_USER", Objects.requireNonNull(dotenv.get("DB_USER")));
		System.setProperty("DB_PASSWORD", Objects.requireNonNull(dotenv.get("DB_PASSWORD")));

		SpringApplication.run(BusesMsApplication.class, args);

		logger.info("Server started and running on port [" + dotenv.get("SERVER_PORT") + "]");
	}

}
