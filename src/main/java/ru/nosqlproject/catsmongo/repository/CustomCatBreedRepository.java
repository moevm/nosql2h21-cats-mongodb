package ru.nosqlproject.catsmongo.repository;

import org.springframework.stereotype.Service;
import ru.nosqlproject.catsmongo.entity.CatBreed;

import java.util.List;
import java.util.Map;

@Service
public interface CustomCatBreedRepository {
    List<CatBreed> CustomCatBreedMethod(Map<String, Object> param);
}
