package com.dao;

import java.util.List;

import com.entity.Food;

public interface FoodDao {
	
//	添加食物
	public boolean addFood(Food food);
//	修改食物
	public boolean update(Food food);
//	删除食物
	public boolean delete(int id);
//	查询全部食物信息
	public List<Food> getFoodList();
//	获取食物总数量
	public int getTotalCount();
//	分页获取食物列表
	public List<Food> getPageFoodList(int pageNo , int pageSize);
//	查询特定食物信息
	public Food getFoodById(int id);
//	根据食物类别查询食物
	public List<Food> getFoodByCategoryId(int category);
//	根据食物中文名称查询食物
	public Food getFoodByChineseName(String chineseName);
	
	
	
}
