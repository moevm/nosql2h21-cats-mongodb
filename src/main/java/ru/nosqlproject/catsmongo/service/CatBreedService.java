package ru.nosqlproject.catsmongo.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import ru.nosqlproject.catsmongo.dto.CatBreedDto;

public interface CatBreedService {

    List<CatBreedDto> findByFilters(Map<String, Object> param);

    boolean addNewBreed(CatBreedDto catBreed);

    List<CatBreedDto> findAll();

    List<CatBreedDto> findAllPagination(int page, int size);

    Optional<CatBreedDto> findById(String id);

    Map<String, Object> loadDb(List<CatBreedDto> breeds);

    List<CatBreedDto> exportDB();

    Optional<CatBreedDto> findByName(String name);
}
