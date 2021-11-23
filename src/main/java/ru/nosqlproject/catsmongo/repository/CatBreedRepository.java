package ru.nosqlproject.catsmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ru.nosqlproject.catsmongo.entity.CatBreed;

import java.util.List;
import java.util.Optional;

public interface CatBreedRepository extends MongoRepository<CatBreed, Long>, CustomCatBreedRepository {

}
