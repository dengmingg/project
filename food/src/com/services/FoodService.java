package com.services;

import java.util.List;

import com.entity.Food;

public interface FoodService {

//	��ѯȫ��ʳ����Ϣ
	public List<Food> getFoodList();
//	��ҳ��ȡʳ����Ϣ
	public List<Food> getPageFoodList(int pageNo , int pageSize);
//	��ȡʳ��������
	public int getTotalCount();
//	��ȡ�ض�ID��ʳ��
	public Food getFoodById(int id);
//	�����ѯʳ����Ϣ
	public Food getFoodByCategory(int categoryId);
//	ɾ��ʳ��
	public boolean delete(Food food); 
//	����ID��ѯʳ�����
	public String getFoodCategoryById(int id);
//	����ʳ������ѯʳ��
	public List<Food> getFoodByCategoryId(int categoryId);
//	���ʳ��
	public boolean addFood(Food food);
//	����ʳ���������Ʋ�ѯʳ��
	public Food getFoodByChineseName(String chineseName);
}
