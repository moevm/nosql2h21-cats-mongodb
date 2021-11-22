package ru.nosqlproject.catsmongo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import ru.nosqlproject.catsmongo.dto.CatBreedDto;
import ru.nosqlproject.catsmongo.entity.CatBreed;
import ru.nosqlproject.catsmongo.service.CatBreedService;

import javax.validation.Valid;
import java.util.*;

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

	@GetMapping("/breedlife")
	public ResponseEntity<List<CatBreedDto>> getBreedByLifespan(@RequestParam("from") int from,
													  @RequestParam("to") int to){
		// from-1 to+1
		List<CatBreedDto> res = new ArrayList<CatBreedDto>();
		catBreedService.findByLife(from, to).forEach(res::add);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	/*
	@GetMapping("/breeds")
	public ResponseEntity<List<CatBreedDto>> getAllBreeds(){
		return new ResponseEntity<>(catBreedService.findAll(), HttpStatus.OK);
	} */

	@GetMapping("/breeds")
	public ResponseEntity<List<CatBreedDto>> getAllBreeds(@RequestParam(defaultValue = "0") int page,
														  @RequestParam(defaultValue = "5") int size){
		List<CatBreedDto> res = catBreedService.findAllPagination(page, size);
		if (res == null){
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} else{
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
	}


	@GetMapping("/breedid/{id}")
	public ResponseEntity<CatBreedDto> getBreedById(@PathVariable("id") String id){
		CatBreedDto catBreedDto = catBreedService.findById(id);
		if (catBreedDto == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else{
			return new ResponseEntity<>(catBreedDto, HttpStatus.OK);
		}
	}

	/*
	find by regex
	 */
	@GetMapping("/breeds/{like}")
	public ResponseEntity<List<CatBreedDto>> getBreedsLikeName(@PathVariable("like") String like){
		try{
			List<CatBreedDto> res = catBreedService.findBreedsByRegexpName(like+="*");
			return new ResponseEntity<>(res, HttpStatus.OK);
		}catch (Exception e){
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/*
	test method
	 */
	@GetMapping("/breeds/gaplen")
	public ResponseEntity<List<CatBreedDto>> getBreedsGapLength(@RequestParam(required = false) int len){
		return new ResponseEntity<>(catBreedService.findGapLength(len), HttpStatus.OK);
	}

	@GetMapping("/breeds/gapweight")
	public ResponseEntity<List<CatBreedDto>> getBreedsGapWeight(@RequestParam(required = false) int w){
		return new ResponseEntity<>(catBreedService.findGapWeight(w), HttpStatus.OK);
	}


	@GetMapping("/breed")
	public ResponseEntity<List<CatBreedDto>> getAllBreedsByFilter(@RequestParam(required = false) Map<String, Object> params) {
		List<CatBreedDto> res = catBreedService.findByFilters(params);
		if (res == null){
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(res, HttpStatus.OK);
		//return ResponseEntity.ok().body(List.of());
	}


	@PostMapping("/breeds")
	// @ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Map<String, Object>> loadNewDB(@RequestBody List<@Valid CatBreedDto> cats) {
		try{
			Map<String, Object> response = catBreedService.loadDb(cats);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e){
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/db")
	public List<CatBreedDto> exportDB() {
		return catBreedService.exportDB();
	}

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
