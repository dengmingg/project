package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.FoodCategoryDao;
import com.dao.impl.FoodCategoryDaoImpl;
import com.entity.Food;
import com.entity.FoodCategory;
import com.serviceImpl.FoodServiceImpl;
import com.services.FoodService;

public class FoodsListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FoodService foodService = new FoodServiceImpl();
		List<Food> list = foodService.getFoodList();
		List<FoodCategory> list1 = new ArrayList<FoodCategory>();
		FoodCategoryDao foodCagegoryDao = new FoodCategoryDaoImpl();
		FoodCategory foodCategory = new FoodCategory();
		for(Food food :list){
			foodCategory = foodCagegoryDao.getCategoryById(food.getCategoryId());	
				 list1.add(foodCategory);
		}
		
		request.setAttribute("list", list);
		request.setAttribute("list1", list1);
		request.getRequestDispatcher("/WEB-INF/admin/foodsList.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
