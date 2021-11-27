package ru.nosqlproject.catsmongo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;
import ru.nosqlproject.catsmongo.validation.FromToMapsCustomValidate;
import ru.nosqlproject.catsmongo.validation.MapIntegerValueValidate;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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

    @NotNull(message = "Name is required")
    @Length(min = 3, max = 100, message = "Name length must be from 3 to 100")
    private String name;

    @NotNull(message = "Origin is required")
    @Length(min = 5, max = 100, message = "Origin length must be from 3 to 100")
    private String origin;

    @NotNull(message = "Average lifespan is required")
    @Min(value = 1, message = "Cats don't leave less than 1 year")
    @Max(value = 40, message = "Cats don't leave more than 40 years")
    private Integer averageLifespan;

    @NotNull(message = "Weight is required")
    @NotEmpty(message = "Weight is empty")
    @FromToMapsCustomValidate(message = "Weight is wrong")
    private Map<String, Integer> weight;

    @NotNull(message = "Length is required")
    @NotEmpty(message = "Length is empty")
    @FromToMapsCustomValidate(message = "Length is wrong")
    private Map<String, Integer> length;

    @MapIntegerValueValidate(message = "Each characteristic must be from 0 to 10")
    private Map<String, Integer> characteristics;

    private String description;

    private List<@URL String> images;
}
