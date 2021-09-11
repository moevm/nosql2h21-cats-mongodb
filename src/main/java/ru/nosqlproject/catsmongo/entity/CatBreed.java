package ru.nosqlproject.catsmongo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author Kirill Mololkin Kirill-mol 11.09.2021
 */

@Document("CatBreed")
public class CatBreed {

	@Id
	private String id;

	@Field("Name")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return "CatBreed{" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				'}';
	}
}
