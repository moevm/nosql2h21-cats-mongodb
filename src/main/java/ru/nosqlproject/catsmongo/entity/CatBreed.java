package ru.nosqlproject.catsmongo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;
import java.util.Map;

/**
 * @author Kirill Mololkin Kirill-mol 11.09.2021
 */
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document("CatBreed")
public class CatBreed {

	@Id
	private String id;

	@Indexed(unique = true)
	private String name;

	private String origin;

	private int averageLifespan;

	private Map<String, Integer> weight;

	private Map<String, Integer> length;

	private Map<String, Integer> characteristics;

	private String description;

	private List<String> images;
}
