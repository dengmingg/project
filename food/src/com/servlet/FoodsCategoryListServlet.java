package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Food;
import com.serviceImpl.FoodServiceImpl;
import com.services.FoodService;

public class FoodsCategoryListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FoodService foodService = new FoodServiceImpl();
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		List<Food> list = new ArrayList<Food>();
		String chineseName = request.getParameter("chineseName");
		if(chineseName!=""){
			Food food = foodService.getFoodByChineseName(chineseName);
			list.add(food);
			request.setAttribute("list", list);
		}else {
			list = foodService.getFoodByCategoryId(categoryId);
			request.setAttribute("list", list);
		}
		request.getRequestDispatcher("/WEB-INF/admin/foodsCategoryList.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
