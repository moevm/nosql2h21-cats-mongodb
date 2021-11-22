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

    @Query(fields = "{'_id': 0}")
    CatBreed findByName(final String name);

    List<CatBreed> findByAverageLifespanBetween(int from, int to);

    @Query(value = "{'name': {$regex: ?0 , $options: 'i'} }", fields = "{'_id': 0}")
    List<CatBreed> findByRegexName(String reg);

    @Query("{$and: [{'length.from': {$lte: ?0} }, {'length.to': {$gte: ?0} }] }")
    List<CatBreed> findGapLength(int len);

    @Query("{$and: [{'weight.from': {$lte: ?0} }, {'weight.to': {$gte: ?0} }] }")
    List<CatBreed> findGapWeight(int w);
}
