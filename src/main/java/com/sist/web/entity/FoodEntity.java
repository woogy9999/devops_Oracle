package com.sist.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name="project_food")
@Data
public class FoodEntity {
	@Id
	private int fno;
	private String name,type,phone,address,theme,images,time,parking,content,price,poster;
	private double score;
}
