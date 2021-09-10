package ru.nosqlproject.catsmongo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author Kirill Mololkin Kirill-mol 10.09.2021
 */
@Document(collection = "Cat")
public class Cat {

	@Id
	private String id;

	@Indexed
	@Field(value = "Cat_No")
	private String catNo;

	@Field(value = "Cat_Type")
	private String catType;

	public Cat(String catType) {
		this.catType = catType;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCatNo() {
		return catNo;
	}

	public void setCatNo(String catNo) {
		this.catNo = catNo;
	}

	public String getCatType() {
		return catType;
	}

	public void setCatType(String catType) {
		this.catType = catType;
	}

	@Override
	public String toString() {
		return "Cat{" +
				"id=" + id +
				", catNo='" + catNo + '\'' +
				", catType='" + catType + '\'' +
				'}';
	}
}
