package br.com.johnsquispe.thechess.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication (scanBasePackages = "br.com.johnsquispe.thechess.*")
public class TheChessApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TheChessApiApplication.class, args);
	}

}
