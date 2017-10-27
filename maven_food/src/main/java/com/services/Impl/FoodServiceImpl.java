package com.services.Impl;

import java.util.List;

import com.dao.FoodDao;
import com.dao.impl.FoodDaoImpl;
import com.entity.Food;
import com.services.FoodService;

public class FoodServiceImpl implements FoodService {
	FoodDao foodDao = new FoodDaoImpl();
//	查询全部食物信息
	public List<Food> getFoodList() {
		
		return foodDao.getFoodList();
	}
//	分页获取食物信息
	public List<Food> getPageFoodList(int pageNo, int pageSize) {
		return foodDao.getPageFoodList(pageNo, pageSize);
	}
//  获取食物总数量
	public int getTotalCount(){
		return foodDao.getTotalCount();
	}
//	根据ID查询特定食物
	public Food getFoodById(int id) {
		
		return foodDao.getFoodById(id);
	}
	
	public Food getFoodByCategory(int categoryId){
		
		return foodDao.getFoodByCategory(categoryId);
	}
//	删除食物
	public boolean delete(Food food) {
		return foodDao.delete(food);
	}
//	根据ID查询食物类别
	public String getFoodCategoryById(int id){
		return foodDao.getFoodCategoryById(id);
	}
//	根据食物类别查询食物
	public List<Food> getFoodByCategoryId(int categoryId){
		
		return foodDao.getFoodByCategoryId(categoryId);
	}
//	添加食物
	public boolean addFood(Food food) {
		
		return foodDao.addFood(food);
	}
//	根据食物中文名称查询食物
	public Food getFoodByChineseName(String chineseName){
		return foodDao.getFoodByChineseName(chineseName);
	}
	 

}
