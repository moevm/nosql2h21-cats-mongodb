package ru.nosqlproject.catsmongo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.nosqlproject.catsmongo.dto.CatBreedDto;
import ru.nosqlproject.catsmongo.entity.CatBreed;
import ru.nosqlproject.catsmongo.service.CatBreedService;

import java.util.List;
import java.util.Map;

/**
 * @author Kirill Mololkin Kirill-mol 10.09.2021
 */
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class MainController {

	private final CatBreedService catBreedService;

	@PostMapping("/bread")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void addBread(@RequestBody CatBreedDto catBreed) {
		catBreedService.addNewBreed(new CatBreedDto());
	}

	@GetMapping("/breed")
	public ResponseEntity<List<?>> getAllBreedsByFilter(@RequestParam(required = false) Map<String, Object> params) {
		System.out.println(params);
		return ResponseEntity.ok().body(List.of());
	}

	@PostMapping("/breeds")
	@ResponseStatus(HttpStatus.OK)
	public void loadNewDB(@RequestBody List<CatBreedDto> cats) {

	}

	@GetMapping("/db")
	public List<CatBreed> importDB() {
		return catBreedService.importDB();
	}
}
