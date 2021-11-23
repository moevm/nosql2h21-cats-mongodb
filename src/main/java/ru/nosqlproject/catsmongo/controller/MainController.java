package ru.nosqlproject.catsmongo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.nosqlproject.catsmongo.dto.CatBreedDto;
import ru.nosqlproject.catsmongo.service.CatBreedService;

/**
 * @author Kirill Mololkin Kirill-mol 10.09.2021
 */
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class MainController {

    private final CatBreedService catBreedService;

    @PostMapping("/breed")
    public ResponseEntity<?> addBread(@RequestBody @Valid CatBreedDto catBreed) {
        if (!catBreedService.addNewBreed(catBreed)) {
            return ResponseEntity.badRequest().body("Duplicate origin");
        } else {
            return ResponseEntity.accepted().build();
        }
    }

    @GetMapping("/breeds")
    public ResponseEntity<List<CatBreedDto>> getAllBreeds(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        List<CatBreedDto> res = catBreedService.findAllPagination(page, size);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/breed/{id}")
    public ResponseEntity<CatBreedDto> getBreedById(@PathVariable("id") String id) {
        return catBreedService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }


    @GetMapping("/breed")
    public ResponseEntity<List<CatBreedDto>> getAllBreedsByFilter(
            @RequestParam(required = false) Map<String, Object> params
    ) {
        if (params == null) {
            return ResponseEntity.ok().body(catBreedService.findAll());
        } else {
            List<CatBreedDto> res = catBreedService.findByFilters(params);

            return ResponseEntity.ok(res);
        }
    }


    @PostMapping("/breeds")
    public ResponseEntity<Map<String, Object>> loadNewDB(
            @RequestBody List<@Valid CatBreedDto> cats
    ) {
        try {
            Map<String, Object> response = catBreedService.loadDb(cats);

            return ResponseEntity.ok(response);
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
