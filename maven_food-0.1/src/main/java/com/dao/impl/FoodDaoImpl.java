package com.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.BaseDao;
import com.dao.FoodDao;
import com.entity.Food;

public class FoodDaoImpl extends BaseDao implements FoodDao {

	
//	��ȡʳ��������
	public int getTotalCount(){
		int total = 0;
		String  sql ="SELECT COUNT(1) FROM foods";
		Object[] params={};
		ResultSet rs = this.executeSQL(sql, params);
		try {
			while(rs.next()){
				total = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return total;
		
	}
//	��ҳ��ȡʳ���б�
	public List<Food> getPageFoodList(int pageNo , int pageSize){
		List<Food> list = new ArrayList<Food>();
		String sql = "SELECT id,chineseName ,englishName,categoryId,description FROM foods WHERE 1=1 order by id LIMIT ?,?";
		Object[] params = {(pageNo-1)*pageSize, pageSize};
		ResultSet rs =this.executeSQL(sql, params);

			try {
				while(rs.next()){
					int id = rs.getInt("id");
					String chineseName = rs.getString("chineseName");
					String englishName = rs.getString("englishName");
					int categoryId = rs.getInt("categoryId");
					String description = rs.getString("description");
					
					Food food = new Food();
					food.setId(id);
					food.setChineseName(chineseName);
					food.setEnglishName(englishName);
					food.setCategoryId(categoryId);
					food.setDescription(description);
					
					list.add(food);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return list;
		
	}
//	����ʳ��
	public boolean addFood(Food food) {
		boolean flag = false;
		String sql = "insert into foods(chineseName,englishName,categoryId,description) values(?,?,?,?)";
		Object[] params ={food.getChineseName(),food.getEnglishName(),food.getCategoryId(),food.getDescription()};
		int i = this.executeupdate(sql, params);
		if(i>0){
			System.out.println("����ʳ��ɹ���");
			flag = true;
		}	
		return flag;
	}
//  �޸�ʳ��
	public boolean update(Food food) {
		boolean flag = false;
		String sql = "update foods set chineseName=?,englishName=?,categoryId=?,description=? where id=?";
		Object[] params = {food.getChineseName(),food.getEnglishName(),food.getCategoryId(),food.getDescription(),food.getId()};
		int i = this.executeupdate(sql, params);
		if (i > 0) {
			System.out.println("�޸�ʳ��ɹ���");
			flag = true;
		}
		return flag;
	}
//  ɾ��ʳ��
	public boolean delete(Food food) {
		boolean flag = false;
		String sql = "delete  from foods where id=?";
		Object[] params ={food.getId()};
		int i = this.executeupdate(sql,params);
		if (i > 0) {
			System.out.println("ɾ��ʳ��ɹ���");
			flag = true;
		}
		return flag;
	}
//  ��ѯȫ��ʳ��
	public List<Food> getFoodList() {
		List<Food> list = new ArrayList<Food>();
		String sql ="select * from foods ";
		Object[] params = {};
		rs = this.executeSQL(sql, params);
		try {
			while(rs.next()){
				int id = rs.getInt("id");
				String chineseName = rs.getString("chineseName");
				String englishName = rs.getString("englishName");
				int categoryId = rs.getInt("categoryId");
				String description = rs.getString("description");
				
				Food food = new Food();
				food.setId(id);
				food.setChineseName(chineseName);
				food.setEnglishName(englishName);
				food.setCategoryId(categoryId);
				food.setDescription(description);
				
				list.add(food);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.closeResource();
		}
		
		return list;
	}
//	��ѯ�ض�ʳ����Ϣ
	public Food getFoodById(int id) {

		Food food = new Food();
		String sql = "SELECT chineseName,englishName,categoryId,description FROM foods where id = ?";
		Object[] params = {id};
		rs = this.executeSQL(sql, params);
		try{
		while(rs.next()){
			String chineseName = rs.getString("chineseName");
			String englishName = rs.getString("englishName");
			int categoryId = rs.getInt("categoryId");
			String description = rs.getString("description");
			
			food.setChineseName(chineseName);
			food.setEnglishName(englishName);
			food.setCategoryId(categoryId);
			food.setDescription(description);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.closeResource();
		}
			
		return food;
	}
//	�����ѯʳ����Ϣ
	public Food getFoodByCategory(int categoryId) {
		Food food = new Food();
		String sql = "SELECT id,chineseName,englishName,description FROM foods where categoryId = ?";
		Object[] params = {categoryId};
		rs = this.executeSQL(sql, params);
		try {
			while(rs.next()){
				String chineseName = rs.getString("chineseName");
				String englishName = rs.getString("englishName");
				int id = rs.getInt("id");
				String description = rs.getString("description");
				
				food.setChineseName(chineseName);
				food.setEnglishName(englishName);
				food.setId(id);
				food.setDescription(description);
			}
							
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeResource();
		}
		return food;
	}
	
//	����ID��ѯʳ�����
	public String getFoodCategoryById(int id) {
		String name = null;
		String sql = "SELECT name FROM category where id =?";
		Object[] params ={id};
		rs = this.executeSQL(sql, params);
		try {
			while(rs.next()){
				 name = rs.getString("name");
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return name;
	}
	
//	����ʳ������ѯʳ��
	public List<Food> getFoodByCategoryId(int categoryId) {
		List<Food> list = new ArrayList<Food>();
		String sql = "SELECT id,chineseName ,englishName,description FROM foods where categoryId = ?";
		Object[] params = {categoryId};
		rs = this.executeSQL(sql, params);
		try {
			while(rs.next()){
				int id = rs.getInt("id");
				String chineseName = rs.getString("chineseName");
				String englishName = rs.getString("englishName");
				String description = rs.getString("description");
				
				Food food = new Food();
				food.setId(id);
				food.setChineseName(chineseName);
				food.setEnglishName(englishName);
				food.setDescription(description);
				
				list.add(food);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeResource();
		}
		return list;
	}
//	����ʳ���������Ʋ�ѯʳ��
	public Food getFoodByChineseName(String chineseName) {
		Food food = new Food();
		String sql = "SELECT id,englishName,categoryId,description FROM foods where chineseName = ?";
		Object[] params = {chineseName};
		rs = this.executeSQL(sql, params);
		try {
			while(rs.next()){
				int categoryId = rs.getInt("categoryId");
				String englishName = rs.getString("englishName");
				int id = rs.getInt("id");
				String description = rs.getString("description");
				
				
				food.setCategoryId(categoryId);
				food.setEnglishName(englishName);
				food.setId(id);
				food.setDescription(description);
				food.setChineseName(chineseName);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeResource();
		}
		return food;
	}


}
