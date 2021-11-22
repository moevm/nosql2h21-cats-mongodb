package ru.nosqlproject.catsmongo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ru.nosqlproject.catsmongo.entity.CatBreed;
import ru.nosqlproject.catsmongo.repository.CustomCatBreedRepository;

import java.util.List;
import java.util.Map;


@Repository
public class CustomCatBreedRepositoryImpl implements CustomCatBreedRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<CatBreed> CustomCatBreedMethod(Map<String, Object> param) {
        return null;
    }
}
