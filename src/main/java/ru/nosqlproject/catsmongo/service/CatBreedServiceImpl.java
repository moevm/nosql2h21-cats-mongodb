package ru.nosqlproject.catsmongo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nosqlproject.catsmongo.dto.CatBreedDto;
import ru.nosqlproject.catsmongo.entity.CatBreed;
import ru.nosqlproject.catsmongo.repository.CatBreedRepository;

import java.util.List;
import java.util.Map;

@Service
public class CatBreedServiceImpl implements CatBreedService{

    private CatBreedRepository catBreedRepository;

    @Autowired
    public CatBreedServiceImpl(CatBreedRepository catBreedRepository){
        this.catBreedRepository = catBreedRepository;
    }

    @Override
    public void addNewBreed(CatBreedDto catBreed) {

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
