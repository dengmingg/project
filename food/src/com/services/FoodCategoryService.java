package com.services;

import java.util.List;

import com.entity.FoodCategory;

public interface FoodCategoryService {

	public List<FoodCategory> getCategoryById(int id);
}
