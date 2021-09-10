package ru.nosqlproject.catsmongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "ru.nosqlproject.catsmongo.repository")
public class CatsmongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatsmongoApplication.class, args);
	}

}
