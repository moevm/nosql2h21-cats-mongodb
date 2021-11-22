package ru.nosqlproject.catsmongo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.nosqlproject.catsmongo.dto.CatBreedDto;
import ru.nosqlproject.catsmongo.entity.CatBreed;
import ru.nosqlproject.catsmongo.mapping.CatBreedMapper;
import ru.nosqlproject.catsmongo.repository.CatBreedRepository;

import java.util.*;

@Service
public class CatBreedServiceImpl implements CatBreedService{

    private final CatBreedRepository catBreedRepository;
    private final CatBreedMapper catBreedMapper;

    @Autowired
    public CatBreedServiceImpl(CatBreedRepository catBreedRepository, CatBreedMapper catBreedMapper){
        this.catBreedRepository = catBreedRepository;
        this.catBreedMapper = catBreedMapper;
    }

    private List<CatBreedDto> catBreedDtoListFromBreed(List<CatBreed> catBreeds){
        List<CatBreedDto> dtoRes = new ArrayList<CatBreedDto>();
        for (CatBreed val: catBreeds) {
            dtoRes.add(catBreedMapper.mapToDto(val));
        }
        return dtoRes;
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
        CatBreed catBreed = catBreedRepository.findByName(name);
        try{
            CatBreedDto catBreedDto = catBreedMapper.mapToDto(catBreed);
            return catBreedDto;
        } catch (Exception e){
            return null;
        }
    }

    @Override
    public List<CatBreedDto> findByLife(int from, int to) {
        List<CatBreed> res = catBreedRepository.findByAverageLifespanBetween(from, to);
        return catBreedDtoListFromBreed(res);
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
        return catBreedDtoListFromBreed(catBreedRepository.findGapLength(len));
    }

    @Override
    public List<CatBreedDto> findGapWeight(int w) {
        return catBreedDtoListFromBreed(catBreedRepository.findGapWeight(w));
    }

    @Override
    public Map<String, Object> loadDb(List<CatBreedDto> breeds) {
        long before = catBreedRepository.count();
        Map<String, Object> response = new HashMap<>();
        List<CatBreed> catBreeds = new ArrayList<CatBreed>();
        for (CatBreedDto val:breeds) {
            catBreeds.add(catBreedMapper.mapToEntity(val));
        }
        catBreedRepository.saveAll(catBreeds);
        long after = catBreedRepository.count();
        response.put("size_before", before);
        response.put("size_after", after);
        response.put("add", after-before);
        return response;
    }

    @Override
    public List<CatBreedDto> searchBreedByParams(Map<String, String> params) {
        return null;
    }

    @Override
    public List<CatBreedDto> findAll() {
        return catBreedDtoListFromBreed(catBreedRepository.findAll());
    }

    @Override
    public List<CatBreed> importDB() {
        return null;
    }

}
