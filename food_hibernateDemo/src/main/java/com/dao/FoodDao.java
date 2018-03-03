package com.dao;

import java.util.List;

import com.entity.Food;

public interface FoodDao {
	
//	���ʳ��
	public boolean addFood(Food food);
//	�޸�ʳ��
	public boolean update(Food food);
//	ɾ��ʳ��
	public boolean delete(int id);
//	��ѯȫ��ʳ����Ϣ
	public List<Food> getFoodList();
//	��ȡʳ��������
	public int getTotalCount();
//	��ҳ��ȡʳ���б�
	public List<Food> getPageFoodList(int pageNo , int pageSize);
//	��ѯ�ض�ʳ����Ϣ
	public Food getFoodById(int id);
//	����ʳ������ѯʳ��
	public List<Food> getFoodByCategoryId(int category);
//	����ʳ���������Ʋ�ѯʳ��
	public Food getFoodByChineseName(String chineseName);
	
	
	
}
