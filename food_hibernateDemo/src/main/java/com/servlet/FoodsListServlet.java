package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.dao.CategoryDao;
import com.dao.FoodDao;
import com.dao.HibernateUtil;
import com.dao.impl.CategoryDaoImpl;
import com.dao.impl.FoodDaoImpl;
import com.entity.Food;
import com.entity.Category;
@WebServlet(urlPatterns={"/FoodsList"} ,name="FoodsListServlet")
public class FoodsListServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Session sess = HibernateUtil.openSession();
		FoodDao foodService = new FoodDaoImpl();
		List<Food> list = foodService.getFoodList();
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/admin/foodsList.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
