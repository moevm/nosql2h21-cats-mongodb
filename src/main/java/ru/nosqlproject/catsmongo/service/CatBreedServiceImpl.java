package ru.nosqlproject.catsmongo.service;

import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
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

    @Override
    public List<CatBreedDto> findByFilters(Map<String, Object> param) {
        try {
            List<CatBreed> catBreeds = catBreedRepository.CustomCatBreedMethod(param);
            return catBreedMapper.fromEntityList(catBreeds);

        } catch (Exception e) {

            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
    }


    @Override
    public boolean addNewBreed(CatBreedDto catBreed) {
        Optional<CatBreed> tmp = catBreedRepository.findCatBreedByName(catBreed.getName());

        if (tmp.isEmpty()) {
            return false;
        }

        catBreedRepository.save(catBreedMapper.toEntity(catBreed));

        return true;

    }

    @Override
    public Optional<CatBreedDto> findById(String id) {
        try {
            return catBreedRepository.findById(Long.parseLong(id)).map(catBreedMapper::fromEntity);

        } catch (NumberFormatException ex) {
            return Optional.empty();
        }
    }


    @Override
    public Map<String, Object> loadDb(List<CatBreedDto> breeds) {
        long before = catBreedRepository.count();

        long after = catBreedRepository.saveAll(catBreedMapper.toEntityList(breeds)).size();

        Map<String, Object> response = new HashMap<>();

        response.put("size_before", before);
        response.put("size_after", after);
        response.put("add", after - before);

        return response;
    }

    @Override
    public List<CatBreedDto> exportDB() {
        return catBreedRepository.findAll().stream()
                .map(catBreedMapper::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<CatBreedDto> findAll() {
        return catBreedMapper.fromEntityList(catBreedRepository.findAll());
    }

    /**
     * Find by pages (not get all db to user)
     */
    @Override
    public List<CatBreedDto> findAllPagination(int page, int size) {
        try {
            Pageable paging = PageRequest.of(page, size);
            Page<CatBreed> catBreedPage = catBreedRepository.findAll(paging);

            return catBreedMapper.fromEntityList(catBreedPage.getContent());

        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

}
