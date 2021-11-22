package ru.nosqlproject.catsmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import ru.nosqlproject.catsmongo.entity.CatBreed;

import java.util.List;
import java.util.Optional;

/**
 * @author Kirill Mololkin Kirill-mol 10.09.2021
 */
public interface CatBreedRepository extends MongoRepository<CatBreed, Long> {

    CatBreed findByName(final String name);

    List<CatBreed> findByAverageLifespanBetween(int from, int to);

    @Query("{'name': {$regex: ?0 , $options: 'i'} }")
    List<CatBreed> findByRegexName(String reg);
}
