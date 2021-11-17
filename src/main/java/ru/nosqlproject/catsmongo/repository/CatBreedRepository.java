package ru.nosqlproject.catsmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.nosqlproject.catsmongo.entity.CatBreed;

/**
 * @author Kirill Mololkin Kirill-mol 10.09.2021
 */
public interface CatBreedRepository extends MongoRepository<CatBreed, Long> {
}
