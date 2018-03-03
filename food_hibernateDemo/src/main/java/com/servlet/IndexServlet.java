package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.FoodDao;
import com.dao.NewsDao;
import com.dao.impl.FoodDaoImpl;
import com.dao.impl.NewsDaoImpl;
import com.entity.Food;
import com.entity.News;
@WebServlet(urlPatterns={"/Index"} ,name="IndexServlet")
public class IndexServlet  extends HttpServlet{
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
	
	 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FoodDao foodService = new FoodDaoImpl();
		NewsDao newsService = new NewsDaoImpl();
		List<Food> list = foodService.getFoodList();
		List<News> list1 = newsService.getNewsList();
		request.setAttribute("list",list);
		request.setAttribute("list1",list1);
		request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	}
}