package com.services.Impl;

import java.util.List;

import com.dao.FoodDao;
import com.dao.impl.FoodDaoImpl;
import com.entity.Food;
import com.services.FoodService;

public class FoodServiceImpl implements FoodService {
	FoodDao foodDao = new FoodDaoImpl();
//	��ѯȫ��ʳ����Ϣ
	public List<Food> getFoodList() {
		
		return foodDao.getFoodList();
	}
//	��ҳ��ȡʳ����Ϣ
	public List<Food> getPageFoodList(int pageNo, int pageSize) {
		return foodDao.getPageFoodList(pageNo, pageSize);
	}
//  ��ȡʳ��������
	public int getTotalCount(){
		return foodDao.getTotalCount();
	}
//	����ID��ѯ�ض�ʳ��
	public Food getFoodById(int id) {
		
		return foodDao.getFoodById(id);
	}
	
	public Food getFoodByCategory(int categoryId){
		
		return foodDao.getFoodByCategory(categoryId);
	}
//	ɾ��ʳ��
	public boolean delete(Food food) {
		return foodDao.delete(food);
	}
//	����ID��ѯʳ�����
	public String getFoodCategoryById(int id){
		return foodDao.getFoodCategoryById(id);
	}
//	����ʳ������ѯʳ��
	public List<Food> getFoodByCategoryId(int categoryId){
		
		return foodDao.getFoodByCategoryId(categoryId);
	}
//	���ʳ��
	public boolean addFood(Food food) {
		
		return foodDao.addFood(food);
	}
//	����ʳ���������Ʋ�ѯʳ��
	public Food getFoodByChineseName(String chineseName){
		return foodDao.getFoodByChineseName(chineseName);
	}
	 

}
