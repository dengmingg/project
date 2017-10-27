package com.services.Impl;

import com.dao.FoodCategoryDao;
import com.dao.impl.FoodCategoryDaoImpl;
import com.entity.FoodCategory;
import com.services.FoodCategoryService;

public class FoodCategoryServiceImpl implements FoodCategoryService {

	FoodCategoryDao foodcategorydao = new FoodCategoryDaoImpl();
	
	public FoodCategory getCategoryById(int id) {
		
		return foodcategorydao.getCategoryById(id);
	}

}
