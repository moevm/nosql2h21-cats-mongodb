package ru.nosqlproject.catsmongo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.nosqlproject.catsmongo.dto.CatBreedDto;
import ru.nosqlproject.catsmongo.entity.CatBreed;
import ru.nosqlproject.catsmongo.mapping.CatBreedMapper;
import ru.nosqlproject.catsmongo.repository.CatBreedRepository;

//import java.awt.print.Pageable;
import java.util.*;

@Service
@RequiredArgsConstructor
public class CatBreedServiceImpl implements CatBreedService {

    private final CatBreedRepository catBreedRepository;
    private final CatBreedMapper catBreedMapper;

    private List<CatBreedDto> catBreedDtoListFromBreed(List<CatBreed> catBreeds) {
        List<CatBreedDto> dtoRes = new ArrayList<>();
        for (CatBreed val : catBreeds) {
            dtoRes.add(catBreedMapper.mapToDto(val));
        }
        return dtoRes;
    }

    @Override
    public List<CatBreedDto> findByFilters(Map<String, Object> param) {
        try {
            List<CatBreed> catBreeds = catBreedRepository.CustomCatBreedMethod(param);
            return catBreedDtoListFromBreed(catBreeds);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
    }

    /*
        if duplicate? maybe return some response-exception
         */
    @Override
    public boolean addNewBreed(CatBreedDto catBreed) {
        CatBreed tmp = catBreedRepository.findCatBreedByName(catBreed.getName());
        if (tmp != null){
            return false;
        }
        catBreedRepository.save(catBreedMapper.mapToEntity(catBreed));
        return true;
    }

    @Override
    public Optional<CatBreedDto> findById(String id) {
        try {
            return catBreedRepository.findById(
                    Long.parseLong(id)).map(catBreedMapper::mapToDto);

        } catch (NumberFormatException ex) {
            return Optional.empty();
        }
    }


    @Override
    public Map<String, Object> loadDb(List<CatBreedDto> breeds) {
        long before = catBreedRepository.count();
        Map<String, Object> response = new HashMap<>();
        List<CatBreed> catBreeds = new ArrayList<CatBreed>();
        for (CatBreedDto val : breeds) {
            catBreeds.add(catBreedMapper.mapToEntity(val));
        }
        catBreedRepository.saveAll(catBreeds);
        long after = catBreedRepository.count();
        response.put("size_before", before);
        response.put("size_after", after);
        response.put("add", after - before);
        return response;
    }

    @Override
    public List<CatBreedDto> exportDB() {
        List<CatBreed> catBreeds = catBreedRepository.findAll();
        List<CatBreedDto> catBreedDtoList = new ArrayList<>();
        for (CatBreed val : catBreeds) {
            catBreedDtoList.add(catBreedMapper.mapToDto(val));
        }
        return catBreedDtoList;
    }

    @Override
    public List<CatBreedDto> findAll() {
        return catBreedDtoListFromBreed(catBreedRepository.findAll());
    }

    /*
    find by pages (not get all db to user)
     */
    @Override
    public List<CatBreedDto> findAllPagination(int page, int size) {
        try {
            Pageable paging = PageRequest.of(page, size);
            Page<CatBreed> catBreedPage;
            catBreedPage = catBreedRepository.findAll(paging);
            return catBreedDtoListFromBreed(catBreedPage.getContent());
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

}
