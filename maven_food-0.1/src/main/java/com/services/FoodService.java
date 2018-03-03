package com.services;

import java.util.List;

import com.entity.Food;

public interface FoodService {

//	查询全部食物信息
	public List<Food> getFoodList();
//	分页获取食物信息
	public List<Food> getPageFoodList(int pageNo , int pageSize);
//	获取食物总数量
	public int getTotalCount();
//	获取特定ID的食物
	public Food getFoodById(int id);
//	分类查询食物信息
	public Food getFoodByCategory(int categoryId);
//	删除食物
	public boolean delete(Food food); 
//	根据ID查询食物类别
	public String getFoodCategoryById(int id);
//	根据食物类别查询食物
	public List<Food> getFoodByCategoryId(int categoryId);
//	添加食物
	public boolean addFood(Food food);
//	根据食物中文名称查询食物
	public Food getFoodByChineseName(String chineseName);
}
