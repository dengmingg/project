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

public class FoodDelServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
	    Food food = new Food();
	    FoodService foodService = new FoodServiceImpl();
	    food.setId(id);
	    request.setAttribute("food",food);
	    String flag = "failed";
	    if(foodService.delete(food)){
	    	flag = "success";
	    }
	    response.sendRedirect("foodsList.jsp?flag="+flag);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
