package ru.nosqlproject.catsmongo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.nosqlproject.catsmongo.dto.CatBreedDto;
import ru.nosqlproject.catsmongo.entity.CatBreed;
import ru.nosqlproject.catsmongo.mapping.CatBreedMapper;
import ru.nosqlproject.catsmongo.repository.CatBreedRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
    public CatBreedDto findByName(String name) {
        return catBreedMapper.mapToDto(catBreedRepository.findByName(name));
    }

    @Override
    public List<CatBreedDto> findByLife(int from, int to) {
        List<CatBreed> res = catBreedRepository.findByAverageLifespanBetween(from, to);
        List<CatBreedDto> dtoRes = new ArrayList<CatBreedDto>();
        for (CatBreed val: res) {
            dtoRes.add(catBreedMapper.mapToDto(val));
        }
        return dtoRes;
    }

    @Override
    public CatBreedDto findById(String id) {
        Long _id;
        try{
            _id = Long.parseLong(id);
        } catch (Exception e){
            return null;
        }
        Optional<CatBreed> catBreed = catBreedRepository.findById(_id);
        if (catBreed.isPresent()){
            return catBreedMapper.mapToDto(catBreed.get());
        } else {
            return null;
        }
    }

    @Override
    public List<CatBreedDto> findBreedsByRegexpName(String reg) {
        List<CatBreedDto> dto = new ArrayList<CatBreedDto>();
        for (CatBreed val: catBreedRepository.findByRegexName(reg)) {
            dto.add(catBreedMapper.mapToDto(val));
        }
        return dto;
    }

    @Override
    public List<CatBreedDto> findGapLength(int len) {
        List<CatBreedDto> dto = new ArrayList<CatBreedDto>();
        for (CatBreed val: catBreedRepository.findGapLength(len)) {
            dto.add(catBreedMapper.mapToDto(val));
        }
        return dto;
    }

    @Override
    public List<CatBreedDto> findGapWeight(int w) {
        List<CatBreedDto> dto = new ArrayList<CatBreedDto>();
        for (CatBreed val: catBreedRepository.findGapWeight(w)) {
            dto.add(catBreedMapper.mapToDto(val));
        }
        return dto;
    }

    @Override
    public List<CatBreedDto> searchBreedByParams(Map<String, String> params) {
        return null;
    }

    @Override
    public List<CatBreedDto> findAll() {
        List<CatBreed> res = catBreedRepository.findAll();
        List<CatBreedDto> dtoRes = new ArrayList<CatBreedDto>();
        for (CatBreed val: res) {
            dtoRes.add(catBreedMapper.mapToDto(val));
        }
        return dtoRes;
    }

    @Override
    public List<CatBreed> importDB() {
        return null;
    }

}
