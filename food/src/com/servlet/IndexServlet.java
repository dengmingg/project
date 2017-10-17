package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Food;
import com.entity.News;
import com.serviceImpl.FoodServiceImpl;
import com.serviceImpl.NewsServiceImpl;
import com.services.FoodService;
import com.services.NewsService;

public class IndexServlet  extends HttpServlet{
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
	
	 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FoodService foodService = new FoodServiceImpl();
		NewsService newsService = new NewsServiceImpl();
		List<Food> list = foodService.getFoodList();
		List<News> list1 = newsService.getNewsList();
		request.setAttribute("list",list);
		request.setAttribute("list1",list1);
		request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	}
}