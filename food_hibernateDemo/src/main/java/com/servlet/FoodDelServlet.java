package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.dao.FoodDao;
import com.dao.HibernateUtil;
import com.dao.impl.FoodDaoImpl;
import com.entity.Food;
@WebServlet(urlPatterns={"/FoodDel"} ,name="FoodDelServlet")
public class FoodDelServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Session sess = HibernateUtil.openSession();
		int id = Integer.parseInt(request.getParameter("id"));
	    FoodDao foodService = new FoodDaoImpl();
	    String flag = "failed";
	    if(foodService.delete(id)){
	    	flag = "success";
	    }
	    response.sendRedirect("/WEB-INF/admin/foodsList.jsp?flag="+flag);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
