package com.dao;

import java.util.List;

import com.entity.FoodCategory;

public interface FoodCategoryDao {

//	����ID��ȡʳ�����
	public List<FoodCategory> getCategoryById(int id);
}
