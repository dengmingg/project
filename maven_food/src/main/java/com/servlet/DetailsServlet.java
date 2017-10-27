package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Food;
import com.services.FoodService;
import com.services.Impl.FoodServiceImpl;
@WebServlet(urlPatterns={"/Details"} ,name="DetailsServlet")
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
