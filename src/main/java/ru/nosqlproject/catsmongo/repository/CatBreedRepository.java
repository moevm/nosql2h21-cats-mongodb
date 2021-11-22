package ru.nosqlproject.catsmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ru.nosqlproject.catsmongo.entity.CatBreed;

import java.util.List;
import java.util.Optional;

/**
 * @author Kirill Mololkin Kirill-mol 10.09.2021
 */
//, CustomCatBreedRepository
public interface CatBreedRepository extends MongoRepository<CatBreed, Long> {

}
