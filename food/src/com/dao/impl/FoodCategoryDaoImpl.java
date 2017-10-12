package com.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.BaseDao;
import com.dao.FoodCategoryDao;
import com.entity.FoodCategory;

public class FoodCategoryDaoImpl extends BaseDao implements FoodCategoryDao{

//	根据ID获取食物类别
	public List<FoodCategory> getCategoryById(int id) {
		List<FoodCategory> list = new ArrayList<FoodCategory>();
		String sql = "SELECT name FROM category where id = ?";
		Object[] params = {id};
		rs = this.executeSQL(sql, params);
		try {
			while(rs.next()){
				String name = rs.getString("name");
				
				FoodCategory foodCategory = new FoodCategory();
				foodCategory.setName(name);
				
				list.add(foodCategory);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeResource();
		}
		return list;
	}

}
