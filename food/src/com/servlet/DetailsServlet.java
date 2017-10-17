package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Food;
import com.serviceImpl.FoodServiceImpl;
import com.services.FoodService;

public class DetailsServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		FoodService foodService = new FoodServiceImpl();
		Food food = foodService.getFoodById(id);
		request.setAttribute("food", food);
		
		request.getRequestDispatcher("/WEB-INF/details.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
