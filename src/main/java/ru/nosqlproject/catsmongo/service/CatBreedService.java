package ru.nosqlproject.catsmongo.service;

import ru.nosqlproject.catsmongo.dto.CatBreedDto;
import ru.nosqlproject.catsmongo.entity.CatBreed;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface CatBreedService {

    void addNewBreed(CatBreedDto catBreed);

    List<CatBreedDto> searchBreedByParams(Map<String, String> params);

    List<CatBreedDto> findAll();

    List<CatBreed> importDB();

    CatBreedDto findByName(String name);

    List<CatBreedDto> findByLife(int from, int to);

    CatBreedDto findById(String id);

    List<CatBreedDto> findBreedsByRegexpName(String reg);

    List<CatBreedDto> findGapLength(int len);

    List<CatBreedDto> findGapWeight(int weight);

    Map<String, Object> loadDb(List<CatBreedDto> breeds);

    List<CatBreedDto> exportDB();
}
