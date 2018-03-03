package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.FoodDao;
import com.dao.impl.FoodDaoImpl;
import com.entity.Food;
@WebServlet(urlPatterns={"/FoodsCategoryList"} ,name="FoodsCategoryListServlet")
public class FoodsCategoryListServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FoodDao foodService = new FoodDaoImpl();
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
