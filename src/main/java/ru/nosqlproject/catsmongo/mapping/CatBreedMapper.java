package ru.nosqlproject.catsmongo.mapping;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import ru.nosqlproject.catsmongo.dto.CatBreedDto;
import ru.nosqlproject.catsmongo.entity.CatBreed;

/**
 * @author Kirill Mololkin 17.11.2021
 */
@Component
public class CatBreedMapper {

    public CatBreedDto fromEntity(CatBreed catBreed) {
        return CatBreedDto.builder()
                .name(catBreed.getName())
                .origin(catBreed.getOrigin())
                .averageLifespan(catBreed.getAverageLifespan())
                .weight(catBreed.getWeight())
                .length(catBreed.getLength())
                .characteristics(catBreed.getCharacteristics())
                .description(catBreed.getDescription())
                .images(catBreed.getImages())
                .build();
    }

    public CatBreed toEntity(CatBreedDto catBreedDto) {
        return CatBreed.builder()
                .name(catBreedDto.getName())
                .origin(catBreedDto.getOrigin())
                .averageLifespan(catBreedDto.getAverageLifespan())
                .weight(catBreedDto.getWeight())
                .length(catBreedDto.getLength())
                .characteristics(Optional.ofNullable(catBreedDto.getCharacteristics())
                        .orElse(Collections.emptyMap())
                )
                .description(Optional.ofNullable(catBreedDto.getDescription()).orElse(""))
                .images(Optional.ofNullable(catBreedDto.getImages())
                        .orElse(Collections.emptyList())
                )
                .build();
    }

    public List<CatBreedDto> fromEntityList(List<CatBreed> list) {
        return list.stream().map(this::fromEntity).collect(Collectors.toList());
    }

    public List<CatBreed> toEntityList(List<CatBreedDto> list) {
        return list.stream().map(this::toEntity).collect(Collectors.toList());
    }
}
