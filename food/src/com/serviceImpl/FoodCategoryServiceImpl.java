package com.serviceImpl;

import java.util.List;

import com.dao.FoodCategoryDao;
import com.dao.impl.FoodCategoryDaoImpl;
import com.entity.FoodCategory;
import com.services.FoodCategoryService;

public class FoodCategoryServiceImpl implements FoodCategoryService {

	FoodCategoryDao foodcategorydao = new FoodCategoryDaoImpl();
	
	public List<FoodCategory> getCategoryById(int id) {
		
		return foodcategorydao.getCategoryById(id);
	}

}
