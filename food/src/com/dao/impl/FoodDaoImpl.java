package com.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.BaseDao;
import com.dao.FoodDao;
import com.entity.Food;

public class FoodDaoImpl extends BaseDao implements FoodDao {

	
//	获取食物总数量
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
//	分页获取食物列表
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
//	插入食物
	public boolean addFood(Food food) {
		boolean flag = false;
		String sql = "insert into foods(chineseName,englishName,categoryId,description) values(?,?,?,?)";
		Object[] params ={food.getChineseName(),food.getEnglishName(),food.getCategoryId(),food.getDescription()};
		int i = this.executeupdate(sql, params);
		if(i>0){
			System.out.println("插入食物成功！");
			flag = true;
		}	
		return flag;
	}
//  修改食物
	public boolean update(Food food) {
		boolean flag = false;
		String sql = "update foods set chineseName=?,englishName=?,categoryId=?,description=? where id=?";
		Object[] params = {food.getChineseName(),food.getEnglishName(),food.getCategoryId(),food.getDescription(),food.getId()};
		int i = this.executeupdate(sql, params);
		if (i > 0) {
			System.out.println("修改食物成功！");
			flag = true;
		}
		return flag;
	}
//  删除食物
	public boolean delete(Food food) {
		boolean flag = false;
		String sql = "delete  from foods where id=?";
		Object[] params ={food.getId()};
		int i = this.executeupdate(sql,params);
		if (i > 0) {
			System.out.println("删除食物成功！");
			flag = true;
		}
		return flag;
	}
//  查询全部食物
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
//	查询特定食物信息
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
//	分类查询食物信息
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
	
//	根据ID查询食物类别
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
	
//	根据食物类别查询食物
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
//	根据食物中文名称查询食物
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
