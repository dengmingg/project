package com.dao;

import java.util.List;

import com.entity.Food;

public interface FoodDao {
	
//	���ʳ��
	public boolean addFood(Food food);
//	�޸�ʳ��
	public boolean update(Food food);
//	ɾ��ʳ��
	public boolean delete(Food food);
//	��ѯȫ��ʳ����Ϣ
	public List<Food> getFoodList();
//	��ȡʳ��������
	public int getTotalCount();
//	��ҳ��ȡʳ���б�
	public List<Food> getPageFoodList(int pageNo , int pageSize);
//	��ѯ�ض�ʳ����Ϣ
	public Food getFoodById(int id);
//	�����ѯʳ����Ϣ
	public Food getFoodByCategory(int categoryId);
//	����ID��ѯʳ�����
	public String getFoodCategoryById(int id);
//	����ʳ������ѯʳ��
	public List<Food> getFoodByCategoryId(int categoryId);
//	����ʳ���������Ʋ�ѯʳ��
	public Food getFoodByChineseName(String chineseName);
	
}
