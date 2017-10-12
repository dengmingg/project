package com.dao;

import java.util.List;

import com.entity.FoodCategory;

public interface FoodCategoryDao {

//	根据ID获取食物类别
	public List<FoodCategory> getCategoryById(int id);
}
