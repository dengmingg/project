package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Food;
import com.serviceImpl.FoodServiceImpl;
import com.services.FoodService;

public class ProductCategoryListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FoodService foodService = new FoodServiceImpl();
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
       	List<Food> list = foodService.getFoodByCategoryId(categoryId);
       	request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/productCategoryList.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
