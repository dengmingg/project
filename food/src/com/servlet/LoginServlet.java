package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import com.entity.User;

public class LoginServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		UserDao userDao = new UserDaoImpl();
		User loginUser = new User();
		loginUser.setUserName(userName);
		loginUser.setPassword(password);
		boolean flag = userDao.checkLogin(userName, password);
		if(flag){
			request.getSession().setAttribute("user", loginUser);
			response.sendRedirect("/WEB-INF/login-success.jsp");
		}else{
			request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
		}
	}

}
