package ru.nosqlproject.catsmongo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * @author Kirill Mololkin 17.11.2021
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CatBreedDto {
    private String name;

    private String origin;

    private int overageLifespan;

    private Map<String, Integer> weight;

    private Map<String, Integer> length;

    private Map<String, Integer> characteristics;

    private String description;

    private List<String> images;
}
