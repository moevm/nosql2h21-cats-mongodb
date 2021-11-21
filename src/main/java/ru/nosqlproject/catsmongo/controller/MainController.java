package ru.nosqlproject.catsmongo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
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

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Kirill Mololkin Kirill-mol 10.09.2021
 */
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class MainController {

	@Autowired
	private final CatBreedService catBreedService;

	@PostMapping("/breed")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void addBread(@RequestBody @Valid CatBreedDto catBreed) {
		/*
			maybe some response if exception
		 */
		/*
		try{
			catBreedService.addNewBreed(catBreed);
			return new ResponseEntity(catBreed, HttpStatus.CREATED);
		} catch (Exception e){
			return new ResponseEntity<>(catBreed, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		 */
		catBreedService.addNewBreed(catBreed);
		//System.out.println("Breed is ok");
	}

	/*
	test map method
	 */
	@GetMapping("/breedname")
	public ResponseEntity<CatBreedDto> getBreedByName(@RequestParam(required = false) String name){
		return new ResponseEntity<CatBreedDto>(catBreedService.findByName(name), HttpStatus.OK);
	}

	@GetMapping("/breed")
	public ResponseEntity<List<?>> getAllBreedsByFilter(@RequestParam(required = false) Map<String, Object> params) {
		System.out.println(params);
		return ResponseEntity.ok().body(List.of());
	}

	@PostMapping("/breeds")
	@ResponseStatus(HttpStatus.OK)
	public void loadNewDB(@RequestBody List<@Valid CatBreedDto> cats) {

	}

/*	@GetMapping("/db")
	public List<CatBreed> importDB() {
		return catBreedService.importDB();
	}*/

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> handleException(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return ResponseEntity.badRequest().body(errors);
	}
}
