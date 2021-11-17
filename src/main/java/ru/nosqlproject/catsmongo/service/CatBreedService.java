package ru.nosqlproject.catsmongo.service;

import ru.nosqlproject.catsmongo.dto.CatBreedDto;
import ru.nosqlproject.catsmongo.entity.CatBreed;

import java.util.List;
import java.util.Map;

public interface CatBreedService {

    void addNewBreed(CatBreedDto catBreed);

    List<CatBreedDto> searchBreedByParams(Map<String, String> params);

    List<CatBreedDto> findAll();

    List<CatBreed> importDB();
}
