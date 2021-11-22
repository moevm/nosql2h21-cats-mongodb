package ru.nosqlproject.catsmongo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
//
// import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ru.nosqlproject.catsmongo.entity.CatBreed;
import ru.nosqlproject.catsmongo.repository.CustomCatBreedRepository;

import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.query.Query;

@Repository
public class CustomCatBreedRepositoryImpl implements CustomCatBreedRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<CatBreed> CustomCatBreedMethod(Map<String, Object> param) {
        Query query = new Query();
        if (param.containsKey("name")){
            query.addCriteria(Criteria.where("name").regex(param.get("name").toString(), "i"));
        }
        if (param.containsKey("origin")){
            query.addCriteria(Criteria.where("origin").regex(param.get("origin").toString(), "i"));
        }
        if (param.containsKey("averageLifespanFrom") && param.containsKey("averageLifespanTo")){
            query.addCriteria(Criteria.where("averageLifespan").lte(Integer.parseInt(param.get("averageLifespanTo").toString()))
                    .gte(Integer.parseInt(param.get("averageLifespanFrom").toString())));
        }
        if (param.containsKey("lengthFrom") && param.containsKey("lengthTo")){
            query.addCriteria(Criteria.where("length.from").is(Integer.parseInt(param.get("lengthFrom").toString())));
            query.addCriteria(Criteria.where("length.to").is(Integer.parseInt(param.get("lengthTo").toString())));

            //query.addCriteria(Criteria.where("length.to").lte(Integer.parseInt(param.get("lengthTo").toString())));
            //query.addCriteria(Criteria.where("length.from").gte(Integer.parseInt(param.get("lengthFrom").toString())));
        }
        if (param.containsKey("weightFrom") && param.containsKey("weightTo")){
            query.addCriteria(Criteria.where("weight.from").is(Integer.parseInt(param.get("weightFrom").toString())));
            query.addCriteria(Criteria.where("weight.to").is(Integer.parseInt(param.get("weightTo").toString())));
        }
        if (param.containsKey("gentlenessFrom") && param.containsKey("gentlenessTo")){
            query.addCriteria(Criteria.where("characteristics.gentleness").lte(Integer.parseInt(param.get("gentlenessTo").toString()))
                    .gte(Integer.parseInt(param.get("gentlenessFrom").toString())));
        }
        if (param.containsKey("immunityFrom") && param.containsKey("immunityTo")){
            query.addCriteria(Criteria.where("characteristics.immunity").lte(Integer.parseInt(param.get("immunityTo").toString()))
                    .gte(Integer.parseInt(param.get("immunityFrom").toString())));
        }
        if (param.containsKey("playfulnessFrom") && param.containsKey("playfulnessTo")){
            query.addCriteria(Criteria.where("characteristics.playfulness").lte(Integer.parseInt(param.get("playfulnessTo").toString()))
                    .gte(Integer.parseInt(param.get("playfulnessFrom").toString())));
        }
        if (param.containsKey("moltFrom") && param.containsKey("moltTo")){
            query.addCriteria(Criteria.where("characteristics.molt").lte(Integer.parseInt(param.get("moltTo").toString()))
                    .gte(Integer.parseInt(param.get("moltFrom").toString())));
        }
        if (param.containsKey("careFrom") && param.containsKey("careTo")){
            query.addCriteria(Criteria.where("characteristics.care").lte(Integer.parseInt(param.get("careTo").toString()))
                    .gte(Integer.parseInt(param.get("careFrom").toString())));
        }
        if (param.containsKey("intelligenceFrom") && param.containsKey("intelligenceTo")){
            query.addCriteria(Criteria.where("characteristics.intelligence").lte(Integer.parseInt(param.get("intelligenceTo").toString()))
                    .gte(Integer.parseInt(param.get("intelligenceFrom").toString())));
        }
        if (param.containsKey("childFriendslinessFrom") && param.containsKey("childFriendslinessTo")){
            query.addCriteria(Criteria.where("characteristics.childFriendsliness").lte(Integer.parseInt(param.get("childFriendslinessTo").toString()))
                    .gte(Integer.parseInt(param.get("childFriendslinessFrom").toString())));
        }
        if (param.containsKey("petFriendlinessFrom") && param.containsKey("petFriendlinessTo")){
            query.addCriteria(Criteria.where("characteristics.petFriendliness").lte(Integer.parseInt(param.get("petFriendlinessTo").toString()))
                    .gte(Integer.parseInt(param.get("petFriendlinessFrom").toString())));
        }
        return mongoTemplate.find(query, CatBreed.class);
    }
}
