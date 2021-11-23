package ru.nosqlproject.catsmongo.repository;

import ru.nosqlproject.catsmongo.entity.CatBreed;

import java.util.List;
import java.util.Map;

public interface CustomCatBreedRepository {

    List<CatBreed> CustomCatBreedMethod(Map<String, Object> param);
}
