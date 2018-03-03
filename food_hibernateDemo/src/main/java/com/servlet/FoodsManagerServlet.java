package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.FoodDao;
import com.dao.impl.FoodDaoImpl;
import com.entity.Food;
@WebServlet(urlPatterns={"/FoodsManager"} ,name="FoodsManagerServlet")
public class FoodsManagerServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FoodDao foodService = new FoodDaoImpl();
		if(request.getParameter("id")!=null){
			int id = Integer.parseInt(request.getParameter("id"));
		    Food food = new Food();
		    food = foodService.getFoodById(id);
		    food.setId(id);
		    request.setAttribute("food",food);
		    request.getRequestDispatcher("/WEB-INF/admin/foodsManager.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/WEB-INF/admin/foodsManager.jsp").forward(request, response);
		 }
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
