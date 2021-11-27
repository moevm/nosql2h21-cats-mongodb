package ru.nosqlproject.catsmongo.repository;

import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class CustomCatBreedRepositoryImpl implements CustomCatBreedRepository {

    private final MongoTemplate mongoTemplate;

    @Override
    public List<CatBreed> CustomCatBreedMethod(Map<String, Object> param) {
        Query query = new Query();

        if (param.containsKey("name")) {
            query.addCriteria(Criteria.where("name")
                    .regex(param.get("name").toString(), "i"));
        }

        if (param.containsKey("origin")) {
            query.addCriteria(Criteria.where("origin")
                    .regex(param.get("origin").toString(), "i"));
        }


        if (param.containsKey("averageLifespanFrom")) {
            query.addCriteria(Criteria.where("averageLifespan")
                    .gte(Integer.parseInt(param.get("averageLifespanFrom").toString())));
        }

        if (param.containsKey("averageLifespanTo")) {
            query.addCriteria(Criteria.where("averageLifespan")
                    .lte(Integer.parseInt(param.get("averageLifespanTo").toString())));
        }

        if (param.containsKey("lengthFrom") && param.containsKey("lengthTo")){
            query.addCriteria(new Criteria().orOperator(Criteria.where("length.from")
                    .lte(Integer.parseInt(param.get("lengthTo").toString())),
                    Criteria.where("length.to")
                            .gte(Integer.parseInt(param.get("lengthFrom").toString()))));

        } else if (param.containsKey("lengthTo")){
            query.addCriteria(new Criteria().andOperator(
                    Criteria.where("length.from").lte(Integer.parseInt(param.get("lengthTo").toString())),
                    Criteria.where("length.to").gte(Integer.parseInt(param.get("lengthTo").toString()))
            ));
        } else if (param.containsKey("lengthFrom")){
            query.addCriteria(Criteria.where("length.to")
                    .gte(Integer.parseInt(param.get("lengthFrom").toString())));
        }
/*
        if (param.containsKey("lengthFrom")) {
            query.addCriteria(Criteria.where("length.from")
                    .gte(Integer.parseInt(param.get("lengthFrom").toString())));
        }

        if (param.containsKey("lengthTo")) {
            query.addCriteria(Criteria.where("length.to")
                    .lte(Integer.parseInt(param.get("lengthTo").toString())));
        }
*/
        if (param.containsKey("weightFrom")) {
            query.addCriteria(Criteria.where("weight.from")
                    .gte(Integer.parseInt(param.get("weightFrom").toString())));
        }

        if (param.containsKey("weightTo")) {
            query.addCriteria(Criteria.where("weight.to")
                    .lte(Integer.parseInt(param.get("weightTo").toString())));
        }

        if (param.containsKey("gentlenessTo")) {
            query.addCriteria(Criteria.where("characteristics.gentleness")
                    .lte(Integer.parseInt(param.get("gentlenessTo").toString())));
        }

        if (param.containsKey("gentlenessFrom")) {
            query.addCriteria(Criteria.where("characteristics.gentleness")
                    .gte(Integer.parseInt(param.get("gentlenessFrom").toString())));
        }

        if (param.containsKey("immunityTo")) {
            query.addCriteria(Criteria.where("characteristics.immunity")
                    .lte(Integer.parseInt(param.get("immunityTo").toString())));
        }

        if (param.containsKey("immunityFrom")) {
            query.addCriteria(Criteria.where("characteristics.immunity")
                    .gte(Integer.parseInt(param.get("immunityFrom").toString())));
        }

        if (param.containsKey("playfulnessTo")) {
            query.addCriteria(Criteria.where("characteristics.playfulness")
                    .lte(Integer.parseInt(param.get("playfulnessTo").toString())));
        }

        if (param.containsKey("playfulnessFrom")) {
            query.addCriteria(Criteria.where("characteristics.playfulness")
                    .gte(Integer.parseInt(param.get("playfulnessFrom").toString())));
        }

        if (param.containsKey("moltTo")) {
            query.addCriteria(Criteria.where("characteristics.molt")
                    .lte(Integer.parseInt(param.get("moltTo").toString())));
        }

        if (param.containsKey("moltFrom")) {
            query.addCriteria(Criteria.where("characteristics.molt")
                    .gte(Integer.parseInt(param.get("moltFrom").toString())));
        }

        if (param.containsKey("careTo")) {
            query.addCriteria(Criteria.where("characteristics.care")
                    .lte(Integer.parseInt(param.get("careTo").toString())));
        }

        if (param.containsKey("careFrom")) {
            query.addCriteria(Criteria.where("characteristics.care")
                    .gte(Integer.parseInt(param.get("careFrom").toString())));
        }

        if (param.containsKey("intelligenceTo")) {
            query.addCriteria(Criteria.where("characteristics.intelligence")
                    .lte(Integer.parseInt(param.get("intelligenceTo").toString())));
        }

        if (param.containsKey("intelligenceFrom")) {
            query.addCriteria(Criteria.where("characteristics.intelligence")
                    .gte(Integer.parseInt(param.get("intelligenceFrom").toString())));
        }

        if (param.containsKey("childFriendslinessTo")) {
            query.addCriteria(Criteria.where("characteristics.childFriendsliness")
                    .lte(Integer.parseInt(param.get("childFriendslinessTo").toString())));
        }

        if (param.containsKey("childFriendslinessFrom")) {
            query.addCriteria(Criteria.where("characteristics.childFriendsliness")
                    .gte(Integer.parseInt(param.get("childFriendslinessFrom").toString())));
        }

        if (param.containsKey("petFriendlinessTo")) {
            query.addCriteria(Criteria.where("characteristics.petFriendliness")
                    .lte(Integer.parseInt(param.get("petFriendlinessTo").toString())));
        }

        if (param.containsKey("petFriendlinessFrom")) {
            query.addCriteria(Criteria.where("characteristics.petFriendliness")
                    .gte(Integer.parseInt(param.get("petFriendlinessFrom").toString())));
        }

        return mongoTemplate.find(query, CatBreed.class);
    }
}
