package ru.nosqlproject.catsmongo.repository;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import ru.nosqlproject.catsmongo.entity.CatBreed;

public interface CatBreedRepository extends MongoRepository<CatBreed, Long>, CustomCatBreedRepository {

    Optional<CatBreed> findCatBreedByName(String name);
}
