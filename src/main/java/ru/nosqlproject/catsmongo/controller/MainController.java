package ru.nosqlproject.catsmongo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.nosqlproject.catsmongo.entity.CatBreed;
import ru.nosqlproject.catsmongo.repository.CatBreadRepository;

import java.util.List;

/**
 * @author Kirill Mololkin Kirill-mol 10.09.2021
 */
@RestController
@RequiredArgsConstructor
public class MainController {

	private final CatBreadRepository catBreadRepository;

	@GetMapping("/")
	public String greeting() {
		return "Hello World!";
	}

	@GetMapping("/hello")
	public String greeting1() {
		return "Hello World!";
	}

	@GetMapping("/bread")
	public ResponseEntity<List<CatBreed>> getAllBreeds() {
		return ResponseEntity.ok().body(catBreadRepository.findAll());
	}

	@PostMapping("/bread")
	public ResponseEntity<CatBreed> addBread(@RequestBody CatBreed catBreed) {
		return ResponseEntity.ok().body(catBreadRepository.insert(catBreed));
	}
}
