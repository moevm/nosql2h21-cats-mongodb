package ru.nosqlproject.catsmongo.service;

import ru.nosqlproject.catsmongo.dto.CatBreedDto;
import ru.nosqlproject.catsmongo.entity.CatBreed;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface CatBreedService {

    List<CatBreedDto> findByFilters(Map<String, Object> param);

    void addNewBreed(CatBreedDto catBreed);

    List<CatBreedDto> findAll();

    List<CatBreedDto> findAllPagination(int page, int size);

    Optional<CatBreedDto> findById(String id);

    Map<String, Object> loadDb(List<CatBreedDto> breeds);

    List<CatBreedDto> exportDB();
}
