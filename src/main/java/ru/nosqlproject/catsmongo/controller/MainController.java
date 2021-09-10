package ru.nosqlproject.catsmongo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nosqlproject.catsmongo.entity.Cat;
import ru.nosqlproject.catsmongo.repository.CatRepository;

/**
 * @author Kirill Mololkin Kirill-mol 10.09.2021
 */
@RestController
@RequiredArgsConstructor
public class MainController {

	private final CatRepository catRepository;
	private final MongoTemplate mongoTemplate;

	@GetMapping("/")
	public String greeting() {
		Cat british = new Cat("British");

		mongoTemplate.insert(british, "cat");

		return "Hello World!";
	}

	@GetMapping("/hello")
	public String greeting1() {
		Cat british = new Cat("British");

		mongoTemplate.insert(british, "cat");

		return "Hello World!";
	}
}
