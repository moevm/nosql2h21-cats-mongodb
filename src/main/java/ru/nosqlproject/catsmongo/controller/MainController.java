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

    private final CatBreedService catBreedService;

    @PostMapping("/breed")
    //@ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<?> addBread(@RequestBody @Valid CatBreedDto catBreed) {
        if (!catBreedService.addNewBreed(catBreed)){
            return ResponseEntity.badRequest().build();
        } else{
            return ResponseEntity.ok().build();
        }

    }

	/*
	@GetMapping("/breeds")
	public ResponseEntity<List<CatBreedDto>> getAllBreeds(){
		return new ResponseEntity<>(catBreedService.findAll(), HttpStatus.OK);
	} */

    @GetMapping("/breeds")
    public ResponseEntity<List<CatBreedDto>> getAllBreeds(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        List<CatBreedDto> res = catBreedService.findAllPagination(page, size);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/breed/{id}")
    public ResponseEntity<CatBreedDto> getBreedById(@PathVariable("id") String id) {
        return catBreedService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }


    @GetMapping("/breed")
    public ResponseEntity<List<CatBreedDto>> getAllBreedsByFilter(
            @RequestParam(required = false) Map<String, Object> params) {
        List<CatBreedDto> res = catBreedService.findByFilters(params);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }


    @PostMapping("/breeds")
    public ResponseEntity<Map<String, Object>> loadNewDB(
            @RequestBody List<@Valid CatBreedDto> cats) {
        try {
            Map<String, Object> response = catBreedService.loadDb(cats);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
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
