package ru.nosqlproject.catsmongo.mapping;

import org.springframework.stereotype.Component;
import ru.nosqlproject.catsmongo.dto.CatBreedDto;
import ru.nosqlproject.catsmongo.entity.CatBreed;

/**
 * @author Kirill Mololkin 17.11.2021
 */
@Component
public class CatBreedMapper {

    public CatBreedDto mapToDto(CatBreed catBreed) {
        return CatBreedDto.builder()
                .name(catBreed.getName())
                .origin(catBreed.getOrigin())
                .overageLifespan(catBreed.getOverageLifespan())
                .weight(catBreed.getWeight())
                .length(catBreed.getLength())
                .characteristics(catBreed.getCharacteristics())
                .description(catBreed.getDescription())
                .images(catBreed.getImages())
                .build();
    }

    public CatBreed mapToEntity(CatBreedDto catBreedDto) {
        return CatBreed.builder()
                .name(catBreedDto.getName())
                .origin(catBreedDto.getOrigin())
                .overageLifespan(catBreedDto.getOverageLifespan())
                .weight(catBreedDto.getWeight())
                .length(catBreedDto.getLength())
                .characteristics(catBreedDto.getCharacteristics())
                .description(catBreedDto.getDescription())
                .images(catBreedDto.getImages())
                .build();
    }
}
