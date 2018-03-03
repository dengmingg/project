package com;

import org.hibernate.Session;
import com.dao.FoodDao;
import com.dao.HibernateUtil;
import com.dao.impl.FoodDaoImpl;
import com.entity.Food;

public class Test {
	
	public static void main(String[] args) {
		
		Session sess = HibernateUtil.openSession();
		FoodDao fooddao = new FoodDaoImpl();
		for(Food food: fooddao.getPageFoodList(3, 5)){
			System.out.println(food.getChineseName()+","+food.getEnglishName());
		}
		
		
		
	}
}
	
