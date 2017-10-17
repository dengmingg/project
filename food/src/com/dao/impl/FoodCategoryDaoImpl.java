package com.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.BaseDao;
import com.dao.FoodCategoryDao;
import com.entity.FoodCategory;

public class FoodCategoryDaoImpl extends BaseDao implements FoodCategoryDao{

//	根据ID获取食物类别
	public FoodCategory getCategoryById(int id) {
		FoodCategory foodCategory = new FoodCategory();
		String sql = "SELECT name FROM category where id = ?";
		Object[] params = {id};
		rs = this.executeSQL(sql, params);
		try {
			while(rs.next()){
				String name = rs.getString("name");
				foodCategory.setName(name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			this.closeResource();
		}
		return foodCategory;
	}

}
