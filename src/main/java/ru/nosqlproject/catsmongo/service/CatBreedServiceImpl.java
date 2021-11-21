package ru.nosqlproject.catsmongo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.nosqlproject.catsmongo.dto.CatBreedDto;
import ru.nosqlproject.catsmongo.entity.CatBreed;
import ru.nosqlproject.catsmongo.mapping.CatBreedMapper;
import ru.nosqlproject.catsmongo.repository.CatBreedRepository;

import java.util.List;
import java.util.Map;

@Service
public class CatBreedServiceImpl implements CatBreedService{

    private final CatBreedRepository catBreedRepository;
    private final CatBreedMapper catBreedMapper;

    @Autowired
    public CatBreedServiceImpl(CatBreedRepository catBreedRepository, CatBreedMapper catBreedMapper){
        this.catBreedRepository = catBreedRepository;
        this.catBreedMapper = catBreedMapper;
    }

    /*
    if duplicate? maybe return some response-exception
     */
    @Override
    public void addNewBreed(CatBreedDto catBreed) {
        /*
        CatBreed tmp = catBreedRepository.findByName(catBreed.getName());
        if (tmp != null){
            return new Exception();
        }
         */
        catBreedRepository.save(catBreedMapper.mapToEntity(catBreed));
    }

    @Override
    public List<CatBreedDto> searchBreedByParams(Map<String, String> params) {
        return null;
    }

    @Override
    public List<CatBreedDto> findAll() {
        return null;
    }

    @Override
    public List<CatBreed> importDB() {
        return null;
    }
}
